package poly.pro2112.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class XeVO implements Serializable {
    private static final long serialVersionUID = 6800997737473596229L;
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
    private MauxeVO mauxe;
    private List<TinhnangVO> tinhnangVOS = new ArrayList<>();
}
