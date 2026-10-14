package ENSAJ.service_catalogue.service;

import ENSAJ.service_catalogue.repository.CatalogueRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CatalogueService {

    private final CatalogueRepository catalogueRepository;

    @Transactional(readOnly = true)
    //indique que la méthode ou la classe annotée devrait être exécutée dans
    //une transaction qui est en mode lecture seule
    public boolean estEnStocke(String skuCode){
        return catalogueRepository.findBySkuCode(skuCode).isPresent();
    }
}
