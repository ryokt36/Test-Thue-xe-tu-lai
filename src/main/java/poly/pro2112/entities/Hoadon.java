package poly.pro2112.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hoadon implements Serializable {
    private static final long serialVersionUID = 9104903738702995814L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date ngaytao;
    private Float tongtien;

    //Lien ket
    @ManyToOne
    @JoinColumn(name = "id_nguoidung")
    private Nguoidung nguoidung;

    @ManyToMany(mappedBy = "hoadons", cascade = CascadeType.ALL)
    private List<Xe> xes = new ArrayList<>();


}
