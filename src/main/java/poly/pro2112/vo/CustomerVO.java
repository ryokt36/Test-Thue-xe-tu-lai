package poly.pro2112.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String email;
    private CitizenidentityVO citizenidentity;
    private DriverlicenseVO driverlicense;
    private String house_hold;
    private Boolean isdelete;
    private List<CarVO> carVOS = new ArrayList<>();
    private List<InvoiceVO> invoiceVOS = new ArrayList<>();
}
