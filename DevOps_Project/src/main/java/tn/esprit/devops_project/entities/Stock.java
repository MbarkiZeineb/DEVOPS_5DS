package tn.esprit.devops_project.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idStock;
    String title;
    @OneToMany(mappedBy = "stock")
    Set<Product> products;

    public Stock(Long idStock, String title) {
        this.idStock=idStock;
        this.title=title;
    }
}
