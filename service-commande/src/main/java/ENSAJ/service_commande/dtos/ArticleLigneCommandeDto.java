package ENSAJ.service_commande.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleLigneCommandeDto {

    private Long id;
    private String skucode;
    private BigDecimal prix;
    private Integer quantite;
}
