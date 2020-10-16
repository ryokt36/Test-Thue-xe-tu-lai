package poly.pro2112.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tinhnang implements Serializable {

    private static final long serialVersionUID = 4858253777727730125L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tentinhnang;

    // lien ket
    @ManyToMany(mappedBy = "tinhnangs", cascade = CascadeType.ALL)
    private List<Xe> xes = new ArrayList<>();
}
