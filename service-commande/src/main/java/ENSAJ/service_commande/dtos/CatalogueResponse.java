package ENSAJ.service_commande.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatalogueResponse {
    private String skuCode;
    private Boolean estEnStock;
}
