package poly.pro2112.vo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverlicenseVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String rank;
    private String duration;
    private String image;
}
