package poly.pro2112.security.payload;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignupRequest implements Serializable {
    private static final long serialVersionUID = 5802837029870546902L;
    private String hoten;
    private String gioitinh;
    private String taikhoan;
    private String matkhau;
    private String email;
    private String chucvu;
}
