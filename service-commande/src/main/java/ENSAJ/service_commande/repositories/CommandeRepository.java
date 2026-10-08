package ENSAJ.service_commande.repositories;

import ENSAJ.service_commande.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
