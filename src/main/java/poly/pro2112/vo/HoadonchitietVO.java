package poly.pro2112.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoadonchitietVO implements Serializable {
    private static final long serialVersionUID = -5309826455736502624L;

    private Pk pk;
    private Date ngaybatdau;
    private Date ngayketthuc;
    private Float tongtien;
    private String ghichu;
    private Boolean isdelete;

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
