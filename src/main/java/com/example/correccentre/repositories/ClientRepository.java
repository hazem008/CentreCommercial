package com.example.correccentre.repositories;

import com.example.correccentre.entities.Categorie;
import com.example.correccentre.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByBoutiques_id(Long idBoutique);
    List<Client> findAllByBoutiques_categorie1(Categorie categorie);

    @Query("SELECT c.genre, COUNT (c) FROM Client c GROUP BY c.genre")
    List<Object[]> countClient();

}