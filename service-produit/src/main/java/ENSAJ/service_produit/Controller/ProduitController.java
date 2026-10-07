package ENSAJ.service_produit.Controller;

import ENSAJ.service_produit.DTO.ProduitRequest;
import ENSAJ.service_produit.DTO.ProduitResponse;
import ENSAJ.service_produit.Service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produit")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduit(@RequestBody ProduitRequest produitRequest){
        this.produitService.createProduit(produitRequest);
    }

    @GetMapping
    public List<ProduitResponse> getAllProduit(){
        return this.produitService.getAllProduit();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduit(@PathVariable String id,@RequestBody ProduitRequest produitRequest){
        this.produitService.updateProduit(id, produitRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduit(@PathVariable String id){
        this.produitService.deleteProduit(id);
    }

}
