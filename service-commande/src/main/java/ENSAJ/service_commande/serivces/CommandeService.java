package ENSAJ.service_commande.serivces;

import ENSAJ.service_commande.dtos.ArticleLigneCommandeDto;
import ENSAJ.service_commande.dtos.CatalogueResponse;
import ENSAJ.service_commande.dtos.CommandeRequest;
import ENSAJ.service_commande.model.ArticleLigneCommande;
import ENSAJ.service_commande.model.Commande;
import ENSAJ.service_commande.repositories.CommandeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
@RequiredArgsConstructor
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final WebClient webClient;

    public void etablirCommande(CommandeRequest commandeRequest){
        Commande commande = new Commande();
        commande.setNumCommande(UUID.randomUUID().toString());

        List<ArticleLigneCommande> articleLigneCommande = commandeRequest.getArticleLigneCommandeDtos()
                .stream()
                .map(this::mapDTO).toList();
        commande.setArticleLigneCommande(articleLigneCommande);

        List<String> skuCodes = commande
                .getArticleLigneCommande()
                .stream()
                .map(ArticleLigneCommande::getSkuCode)
                .toList();

        CatalogueResponse[] catalogueReponsesArray = webClient.get()
                .uri("http://localhost:8082/api/catalogue",
                        uriBuilder ->
                                uriBuilder.queryParam("skuCode",skuCodes).build()
                )
                .retrieve()
                .bodyToMono(CatalogueResponse[].class)
                .block();

        boolean tousProduitEnStock = Arrays.stream(catalogueReponsesArray).allMatch(CatalogueResponse::getEstEnStock);

        if(tousProduitEnStock){
            commandeRepository.save(commande);
        }else{
            throw new IllegalArgumentException("Produit n'existe pas");
        }
    }

    private ArticleLigneCommande mapDTO(ArticleLigneCommandeDto articleLigneCommandeDto){
        ArticleLigneCommande articleLigneCommande = new ArticleLigneCommande();

        articleLigneCommande.setPrix(articleLigneCommandeDto.getPrix());
        articleLigneCommande.setSkuCode(articleLigneCommandeDto.getSkucode());
        articleLigneCommande.setQuantite(articleLigneCommandeDto.getQuantite());

        return articleLigneCommande;
    }

    public List<Commande> getCommandes() {
        return commandeRepository.findAll();
    }

}
