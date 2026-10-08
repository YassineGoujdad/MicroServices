package ENSAJ.service_commande.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "t_article_commande")
@Data
public class ArticleLigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String skuCode;

    private BigDecimal prix;
    private Integer quantite;
}
