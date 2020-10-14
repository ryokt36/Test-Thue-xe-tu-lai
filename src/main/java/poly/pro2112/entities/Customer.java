package poly.pro2112.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String house_hold;
    private Boolean isdelete;

    // lien ket
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Car> cars = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Invoice> invoices = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "people_id", insertable=false, updatable=false)
    private Citizenidentity citizenidentity;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "driver_license_id", insertable=false, updatable=false)
    private Driverlicense driverlicense;
}
