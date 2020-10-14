package poly.pro2112.security.payload;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignupRequest implements Serializable {
    private static final long serialVersionUID = -5616176897013108345L;
    private String username;
    private String password;
    private String email;
}
