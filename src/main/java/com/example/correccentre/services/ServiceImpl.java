package com.example.correccentre.services;

import com.example.correccentre.entities.Boutique;
import com.example.correccentre.entities.Categorie;
import com.example.correccentre.entities.CentreCommercial;
import com.example.correccentre.entities.Client;
import com.example.correccentre.repositories.BoutiqueRepository;
import com.example.correccentre.repositories.CentreCommercialRepository;
import com.example.correccentre.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;

@Service
public class ServiceImpl implements IService{
    @Autowired
    private BoutiqueRepository boutiqueRepository;
    @Autowired
    private CentreCommercialRepository centreCommercialRepository;
    @Autowired
    private ClientRepository clientRepository;


    @Override
    public void ajoutCentre(CentreCommercial centre) {

        centreCommercialRepository.save(centre);
    }

    @Override
    public void ajouterEtAffecterlisteBoutiques(List<Boutique> lb, Long idCentre) {
        CentreCommercial C = centreCommercialRepository.findById(idCentre).get();
        for (Boutique b1:lb) {
            b1.setCentreCommercial(C);
            boutiqueRepository.save(b1);
        }
    }

    @Override
    public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) {
        clientRepository.save(client);
        for (Long idB: idBoutiques) {
            Boutique bout=boutiqueRepository.findById(idB).get();
            bout.getC1().add(client);
            boutiqueRepository.save(bout);
        }
    }

    @Override
    public List<Client> listeClients(Long idBoutique) {
//        Boutique bb= boutiqueRepository.findById(idBoutique).get();
//
//        return bb.getC1();
        return clientRepository.findAllByBoutiques_id(idBoutique) ;
    }

    @Override
    public List<Boutique> listeBoutiques(Long idCentre) {
        return boutiqueRepository.findAllByCentreCommercial_Id(idCentre);
    }

    @Override
    public List<Client> listeDeClientsParCategorie(Categorie categorie) {


        return clientRepository.findAllByBoutiques_categorie1(categorie);

    }

    @Override
    @Scheduled(cron = "* 5 * * * *")
    public void nbreClientParGenre() {
        for (Object[] Result: clientRepository.countClient()) {
            System.out.println("Genre"+Result[0]+" "+Result[1]);

        }
    }


}
