package ENSAJ.service_catalogue.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="t_catalogue")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String skuCode;

    private Integer quantite;

}
