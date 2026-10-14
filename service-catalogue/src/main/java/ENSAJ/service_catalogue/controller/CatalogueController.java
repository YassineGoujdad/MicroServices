package ENSAJ.service_catalogue.controller;


import ENSAJ.service_catalogue.service.CatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalogue")
@RequiredArgsConstructor
public class CatalogueController {
    private final CatalogueService catalogueService;

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean estEnStocke(@PathVariable String skuCode) {
        return catalogueService.estEnStocke(skuCode);
    }

}
