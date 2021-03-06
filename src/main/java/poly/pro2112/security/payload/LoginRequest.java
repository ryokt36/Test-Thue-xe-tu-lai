package poly.pro2112.security.payload;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginRequest implements Serializable {
    private static final long serialVersionUID = -7631778035091507280L;
    private String username;
    private String password;
}
