package com.example.correccentre.services;

import com.example.correccentre.entities.Boutique;
import com.example.correccentre.entities.Categorie;
import com.example.correccentre.entities.CentreCommercial;
import com.example.correccentre.entities.Client;

import java.io.Serializable;
import java.util.List;

public interface IService extends Serializable {

    void ajoutCentre(CentreCommercial centre);
    void ajouterEtAffecterlisteBoutiques (List<Boutique> lb, Long idCentre);
    void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques);
    List<Client> listeClients(Long idBoutique);
    List<Boutique> listeBoutiques(Long idCentre);

    List<Client> listeDeClientsParCategorie(Categorie categorie);

    void nbreClientParGenre();
}
