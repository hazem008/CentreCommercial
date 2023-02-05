package com.example.correccentre.repositories;

import com.example.correccentre.entities.Boutique;
import com.example.correccentre.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoutiqueRepository extends JpaRepository<Boutique, Long> {
    List<Boutique> findAllByCentreCommercial_Id(Long idCentre);
}