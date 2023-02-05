package com.example.correccentre.controller;

import com.example.correccentre.entities.Boutique;
import com.example.correccentre.entities.Categorie;
import com.example.correccentre.entities.CentreCommercial;
import com.example.correccentre.entities.Client;
import com.example.correccentre.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Centre")
public class Controller {
    @Autowired
    private IService iService;

    @PostMapping("/SaveCentre")
    public void ajoutCentre(@RequestBody CentreCommercial centre) {
        iService.ajoutCentre(centre);
    }

    @PostMapping("AjoutetAffecteCentreB/{id}")
    public void ajouterEtAffecterlisteBoutiques(@RequestBody List<Boutique> lb,@PathVariable("id") Long idCentre) {
        iService.ajouterEtAffecterlisteBoutiques(lb, idCentre);
    }

    @PostMapping("AjouterAffecteClientB/{id}")
    public void ajouterEtAffecterClientBoutiques(@RequestBody Client client,@PathVariable("id") List<Long> idBoutiques) {
        iService.ajouterEtAffecterClientBoutiques(client, idBoutiques);
    }

    @GetMapping("listClientParBoutique/{id}")
    public List<Client> listeClients(@PathVariable("id") Long idBoutique) {

        return iService.listeClients(idBoutique);
    }

    @GetMapping("listBoutiqueParCC/{id}")
    public List<Boutique> listeBoutiques(@PathVariable("id") Long idCentre) {
        return iService.listeBoutiques(idCentre);
    }

    @GetMapping("listClientParCateg/{categ}")
    public List<Client> listeDeClientsParCategorie(@PathVariable("categ") Categorie categorie) {
        return iService.listeDeClientsParCategorie(categorie);
    }
}
