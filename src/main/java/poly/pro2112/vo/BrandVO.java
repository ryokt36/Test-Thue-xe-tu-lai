package poly.pro2112.vo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poly.pro2112.entities.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String brand_name;
    private List<ModelVO> modelVOS = new ArrayList<>();

}
