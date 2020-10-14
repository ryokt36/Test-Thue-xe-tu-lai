package poly.pro2112.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nguoidung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String taikhoan;
    private String matkhau;
    private String hoten;
    private String hokhau;
    private String anhdaidien;
    private String sdt;
    private String diachi;
    private String email;
    private Integer id_cccd;
    private String blx;
    private String chucvu;
    private Boolean isdelete;

    public Nguoidung(String username, String hoten, String password, String email) {
        this.taikhoan = username;
        this.hoten = hoten;
        this.matkhau = password;
        this.email = email;
    }
}
