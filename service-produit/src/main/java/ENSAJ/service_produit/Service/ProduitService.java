package ENSAJ.service_produit.Service;

import ENSAJ.service_produit.DTO.ProduitRequest;
import ENSAJ.service_produit.DTO.ProduitResponse;
import ENSAJ.service_produit.Model.Produit;
import ENSAJ.service_produit.Repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProduitService {
    private final ProduitRepository produitRepository;

    public void createProduit(ProduitRequest produitRequest){
        Produit produit = Produit.builder()
                .libelle(produitRequest.getLibelle())
                .prix(produitRequest.getPrix())
                .description(produitRequest.getDescription())
                .build();

        produitRepository.save(produit);
        log.info("Le produit {} est enregistré", produit.getId());
    }

    public List<ProduitResponse> getAllProduit(){
        List<Produit> produits = this.produitRepository.findAll();

        return produits.stream().map(this::mapToProduitResponse).toList();
    }

    private ProduitResponse mapToProduitResponse(Produit produit){
        return ProduitResponse.builder()
                .id(produit.getId())
                .libelle(produit.getLibelle())
                .prix(produit.getPrix())
                .description(produit.getDescription())
                .build();
    }

    public void updateProduit(String id, ProduitRequest produitRequest){
        Produit produit = produitRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Produit existe déja")
        );

        produit.setLibelle(produitRequest.getLibelle());
        produit.setPrix(produitRequest.getPrix());
        produit.setDescription(produitRequest.getDescription());

        produitRepository.save(produit);

        log.info("Produit modifié");
    }

    public void deleteProduit(String id){
        produitRepository.deleteById(id);
        log.info("produit supprimé");
    }
}
