package ENSAJ.service_produit.Repository;


import ENSAJ.service_produit.Model.Produit;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProduitRepository extends MongoRepository<Produit, String> {
    Example<? extends Produit> Id(String id);
}
