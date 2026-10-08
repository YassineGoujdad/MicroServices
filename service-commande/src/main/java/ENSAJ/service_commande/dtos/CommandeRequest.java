package ENSAJ.service_commande.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeRequest {

    private List<ArticleLigneCommandeDto> articleLigneCommandeDtos;
}
