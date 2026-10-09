package ENSAJ.service_commande.controllers;

import ENSAJ.service_commande.dtos.CommandeRequest;
import ENSAJ.service_commande.serivces.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/commande")
@RequiredArgsConstructor
public class CommandeController {
    private final CommandeService commandeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String etablirCommande(@RequestBody CommandeRequest commandeRequest){
        commandeService.etablirCommande(commandeRequest);
        return "La commande établie avec succé";
    }
}
