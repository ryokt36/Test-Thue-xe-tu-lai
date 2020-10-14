package poly.pro2112.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import poly.pro2112.security.services.UserDetailsImpl;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    // Khai bao 1 doan Jwt bi mat
    private final String JWT_SECRET = "poly";
    // Set thoi gian ton tai cua chuoi Jwt
    private final Long JWT_EXPIRATION = 604800000L;

    /*
        * Ham nay de Tao chuoi JWT Token cho Admin
     */
    public String generateJwtToken(Authentication authentication){

        UserDetailsImpl usePrincipal = (UserDetailsImpl) authentication.getPrincipal();
        // Ngay het han cua chuoi JWT
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        // Tao JWT tu thong tin cua AdminUserDetails
        return Jwts.builder()
                        .setSubject(usePrincipal.getUsername())
                        .setIssuedAt(now)
                        .setExpiration(expiryDate)
                        .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                        .compact();
    }

    public String generateTokenForClient(){ return null; }

    /*
     * Ham nay de lay Id cua User qua JWT Token
     */
    public Integer getUserIdFromJWT(String token){
        // Lay no ra
        Claims claims = Jwts.parser()
                                .setSigningKey(JWT_SECRET)
                                .parseClaimsJws(token)
                                .getBody();

        System.out.println(claims.getSubject());
        // Tra ve Id cua User
        return Integer.parseInt(claims.getSubject());
    }

    public String getUsernameFromJWT(String token){
        // Lay no ra
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        System.out.println(claims.getSubject());
        // Tra ve Id cua User
        return claims.getSubject();
    }

    /*
     * Ham nay de xac thuc chuoi JWT Token
     */
    public boolean validateToken(String authToken){
        try {
            // Neu no ton tai thi return true con khong thi se ban ra Exception
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
