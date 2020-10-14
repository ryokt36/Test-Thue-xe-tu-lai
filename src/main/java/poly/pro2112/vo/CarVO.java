package poly.pro2112.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String category_car;
    private String image;
    private Float rent_cost;
    private String license_plates;
    private String description;
    private String status;
    private Boolean isdelete;
    private List<ContractVO> contracts = new ArrayList<>();
    private CustomerVO customer;
    private RegisterVO register;
    private RegistryVO registry;
    private ModelVO model;
    private List<FeatureVO> features = new ArrayList<>();
    private List<InvoiceVO> invoices = new ArrayList<>();
}
