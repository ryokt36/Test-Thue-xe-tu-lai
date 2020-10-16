package poly.pro2112.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import poly.pro2112.entities.Nguoidung;
import poly.pro2112.repository.NguoidungRepository;
import poly.pro2112.security.jwt.JwtTokenProvider;
import poly.pro2112.security.payload.LoginRequest;
import poly.pro2112.security.payload.LoginResponse;
import poly.pro2112.security.error.MessageResponse;
import poly.pro2112.security.payload.SignupRequest;
import poly.pro2112.security.services.UserDetailsImpl;
import poly.pro2112.security.error.AuthenticationException;

import java.util.Objects;


@CrossOrigin(origins = "${crossOrigin}")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    NguoidungRepository nguoidungRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest login) throws AuthenticationException {
        System.out.println(login.getUsername());
        System.out.println(passwordEncoder.encode(login.getPassword()));

        // Xác thực từ username và password.
        Authentication authentication = authenticate(login.getUsername(), login.getPassword());

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String token = tokenProvider.generateJwtToken(authentication);
        System.out.println(token);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(new LoginResponse(
                token,
                userDetails.getUsername(),
                userDetails.getAuthorities())
        );
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signUpRequest) {
        if (nguoidungRepository.existsNguoidungByTaikhoan(signUpRequest.getTaikhoan())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (nguoidungRepository.existsNguoidungByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Nguoidung nguoidung = new Nguoidung(
                signUpRequest.getTaikhoan(),
                signUpRequest.getHoten(),
                passwordEncoder.encode(signUpRequest.getMatkhau()),
                signUpRequest.getEmail());

        nguoidung.setChucvu(signUpRequest.getChucvu());
        nguoidung.setGioitinh(signUpRequest.getGioitinh());
        Nguoidung check = nguoidungRepository.save(nguoidung);
        if(check != null){
            Authentication authentication = authenticate(signUpRequest.getTaikhoan(), signUpRequest.getMatkhau());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = tokenProvider.generateJwtToken(authentication);
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            return ResponseEntity.ok(new LoginResponse(
                    token,
                    userDetails.getUsername(),
                    userDetails.getAuthorities()
            ));
        }
        else {
            return ResponseEntity.ok(new MessageResponse("Lỗi khi tạo token"));
        }
    }


    @ExceptionHandler({ AuthenticationException.class })
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    private Authentication authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("INVALID_CREDENTIALS", e);
        }
    }
}
