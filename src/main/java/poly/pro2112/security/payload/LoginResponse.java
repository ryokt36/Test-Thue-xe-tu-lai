package poly.pro2112.security.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable {
    private static final long serialVersionUID = -5616176897013108345L;
    private String accessToken;
    private String tokenType = "Bearer ";
    private String username;
    private Collection role;

    public LoginResponse(String accessToken, String us){
        this.accessToken = accessToken;
    }

    public LoginResponse(String accessToken, String username, Collection<? extends GrantedAuthority> authorities) {
        this.accessToken = accessToken;
        this.username = username;
        this.role = authorities;
    }
}
