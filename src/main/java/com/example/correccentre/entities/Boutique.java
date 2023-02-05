package com.example.correccentre.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "boutique")
public class Boutique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Enumerated(EnumType.STRING)
    @Column(name = "categorie_1")
    private Categorie categorie1;

    @JsonIgnore
    @ManyToMany
    private List<Client> C1;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "centre_commercial_id")
    private CentreCommercial centreCommercial;


}