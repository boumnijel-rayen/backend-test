package com.isg.myAppli.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
public class utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_u;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String adresse;
    private String code_postal;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date_naissance;
    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private Collection<fournisseur> fournisseurs = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "utilisateur_produit",
            joinColumns = @JoinColumn(name = "id_u"),
            inverseJoinColumns = @JoinColumn(name = "id_p")
    )
    private Collection<produit> produits = new ArrayList<>();
}
