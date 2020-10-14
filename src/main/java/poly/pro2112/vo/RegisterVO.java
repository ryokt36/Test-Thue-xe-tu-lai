package poly.pro2112.vo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String number;
    private String native_place;
    private Date date_issue;
    private Date first_register;
    private String owner;
    private String address;
    private String image;
}
