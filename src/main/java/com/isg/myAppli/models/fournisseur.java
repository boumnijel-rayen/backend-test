package com.isg.myAppli.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_fr;
    private String nom_fr;
    private String prenom_fr;
    private String email_fr;
    private String adresse_fr;
    private String telephone_fr;
    @OneToMany(mappedBy = "fournisseur")
    @JsonIgnore
    private Collection<facture> factures = new ArrayList<>();
    @OneToMany(mappedBy = "fournisseur")
    @JsonIgnore
    private Collection<commande> commandes = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_u")
    private utilisateur utilisateur;
}
