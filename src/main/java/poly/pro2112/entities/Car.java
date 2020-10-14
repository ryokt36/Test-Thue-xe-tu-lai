package poly.pro2112.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poly.pro2112.vo.ContractVO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category_car;
    private String image;
    private Float rent_cost;
    private String license_plates;
    private String description;
    private String status;
    private Boolean isdelete;

    //Lien ket
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private List<Contract> contracts = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cus_id")
    private Customer customer;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "register_id")
    private Register register;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "registry_id")
    private Registry registry;

    @OneToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToMany
    @JoinTable(name = "car_feature",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private Set<Feature> features;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "invoicedetail",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "invoice_id")
    )
    private Set<Invoice> invoices;
}
