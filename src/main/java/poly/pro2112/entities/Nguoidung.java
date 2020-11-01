package poly.pro2112.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nguoidung implements Serializable {
    private static final long serialVersionUID = -7036233769307294365L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String taikhoan;
    private String matkhau;
    private String hoten;
    private String gioitinh;
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

    // lien ket
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidung")
    private List<Hoadon> hoadons = new ArrayList<>();
}
