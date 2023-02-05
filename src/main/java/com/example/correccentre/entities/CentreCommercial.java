package com.example.correccentre.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "centre_commercial")
public class CentreCommercial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "login")
    private String login;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "nom")
    private String nom;


    @OneToMany(mappedBy = "centreCommercial",cascade = CascadeType.PERSIST)
    private Set<Boutique> boutiques = new LinkedHashSet<>();


}