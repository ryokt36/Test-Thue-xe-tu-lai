package poly.pro2112.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hoadonchitiet implements Serializable {
    private static final long serialVersionUID = -7636487767923835289L;

    @EmbeddedId
    private Pk pk;

    private Date ngaybatdau;
    private Date ngayketthuc;
    private Float tongtien;
    private String ghichu;
    private Boolean isdelete;

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Pk implements Serializable {
        private static final long serialVersionUID = 3354598078945587326L;
        @Column(name = "id_hoadon")
        private Integer id_hoadon;
        @Column(name = "id_xe")
        private Integer id_xe;
    }
}
