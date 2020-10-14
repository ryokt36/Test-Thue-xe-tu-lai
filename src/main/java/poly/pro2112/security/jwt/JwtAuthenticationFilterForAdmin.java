package poly.pro2112.security.jwt;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import poly.pro2112.security.services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthenticationFilterForAdmin extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            // Lay Jwt tu Request
            String jwt = getJwtFromRequest(httpServletRequest);

            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                // Lay id cua chuoi Jwt
//                Integer id = tokenProvider.getUserIdFromJWT(jwt);
                // Lay thong tin cuar
//                UserDetails userDetails = adminSv.loadUserById(id);
                UserDetails userDetails =userService.loadUserByUsername(tokenProvider.getUsernameFromJWT(jwt));
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken
                            authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception ex) {
            log.error("fail on set user authentication", ex);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        // Kiem tra header Author co chua thong tin Jwt khong
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }
}
