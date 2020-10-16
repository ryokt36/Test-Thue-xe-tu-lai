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
public class HangxeVO implements Serializable {
    private static final long serialVersionUID = 4463785394657003476L;
    private Integer id;
    private String tenhang;
    private List<MauxeVO> mauxeVOS = new ArrayList<>();
}
