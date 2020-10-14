package poly.pro2112.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Date create_date;
    private Float total_money;
    private List<CarVO> carVOS = new ArrayList<>();
    private CustomerVO customer;
}
