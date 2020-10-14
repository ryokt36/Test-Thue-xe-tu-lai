package poly.pro2112.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import poly.pro2112.security.jwt.JwtTokenProvider;
import poly.pro2112.security.payload.LoginRequest;
import poly.pro2112.security.payload.LoginResponse;
import poly.pro2112.security.services.UserDetailsImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HomeController {


}
