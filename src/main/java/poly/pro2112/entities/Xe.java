package poly.pro2112.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Xe implements Serializable{

    private static final long serialVersionUID = 84428740832357717L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sokhung;
    private String loaixe;
    private String anh;
    private Float giathue;
    private String biensoxe;
    private String loainhienlieu;
    private Float muctieuthu;
    private String bodandong;
    private String loaihopso;
    private String dangky;
    private String dangkiem;
    private String mota;
    private String trangthai;
    private Boolean isdelete;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_mauxe")
    private Mauxe mauxe;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tinhnangxe",
            joinColumns = @JoinColumn(name = "id_xe"),
            inverseJoinColumns = @JoinColumn(name = "id_tinhnang")
    )
    private List<Tinhnang> tinhnangs = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hoadonchitiet",
            joinColumns = @JoinColumn(name = "id_xe"),
            inverseJoinColumns = @JoinColumn(name = "id_hoadon")
    )
    private List<Hoadon> hoadons = new ArrayList<>();

}
