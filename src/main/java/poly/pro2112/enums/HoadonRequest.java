package poly.pro2112.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poly.pro2112.vo.HoadonVO;
import poly.pro2112.vo.HoadonchitietVO;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoadonRequest extends HoadonVO {
    private Date ngaybatdau;
    private Date ngayketthuc;
    private Float tongtienhdct;
    private String ghichu;
    private Boolean isdelete;

}
