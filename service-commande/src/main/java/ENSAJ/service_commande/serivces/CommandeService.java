package ENSAJ.service_commande.serivces;

import ENSAJ.service_commande.dtos.ArticleLigneCommandeDto;
import ENSAJ.service_commande.dtos.CommandeRequest;
import ENSAJ.service_commande.model.ArticleLigneCommande;
import ENSAJ.service_commande.model.Commande;
import ENSAJ.service_commande.repositories.CommandeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Transactional
@Service
@RequiredArgsConstructor
public class CommandeService {

    private final CommandeRepository commandeRepository;

    public void etablirCommande(CommandeRequest commandeRequest){
        Commande commande = new Commande();
        commande.setNumCommande(UUID.randomUUID().toString());

        List<ArticleLigneCommande> articleLigneCommande = commandeRequest.getArticleLigneCommandeDtos()
                .stream()
                .map(this::mapDTO).toList();
        commande.setArticleLigneCommande(articleLigneCommande);
        commandeRepository.save(commande);
    }

    private ArticleLigneCommande mapDTO(ArticleLigneCommandeDto articleLigneCommandeDto){
        ArticleLigneCommande articleLigneCommande = new ArticleLigneCommande();
        articleLigneCommande.setId(articleLigneCommandeDto.getId());
        articleLigneCommande.setPrix(articleLigneCommandeDto.getPrix());


    }

}
