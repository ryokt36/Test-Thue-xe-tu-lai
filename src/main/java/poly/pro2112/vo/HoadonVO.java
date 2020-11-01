package poly.pro2112.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poly.pro2112.entities.Nguoidung;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoadonVO implements Serializable {
    private static final long serialVersionUID = -8846046760551167310L;

    private Integer id;
    private Date ngaytao;
    private Float tongtien;
    private Nguoidung nguoidung;
    private List<XeVO> xeVOS = new ArrayList<>();
}
