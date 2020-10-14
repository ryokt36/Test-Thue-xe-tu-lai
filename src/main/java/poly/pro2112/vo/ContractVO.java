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
public class ContractVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String renter;
    private String contract_name;
    private String link_contract;
    private CarVO carVO;
}
