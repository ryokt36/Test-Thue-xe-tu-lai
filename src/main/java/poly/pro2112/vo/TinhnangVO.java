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
public class TinhnangVO implements Serializable {
    private static final long serialVersionUID = 7810407294846564758L;
    private Integer id;
    private String tentinhnag;
    private List<XeVO> xeVOS = new ArrayList<>();
}
