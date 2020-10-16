package poly.pro2112.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MauxeVO implements Serializable {
    private static final long serialVersionUID = 5214676163487840341L;
    private Integer id;
    private String tenmau;
    private HangxeVO hangxe;
}
