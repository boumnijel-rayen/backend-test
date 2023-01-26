package com.isg.myAppli.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cat;
    private String lib_cat;
    @OneToMany(mappedBy = "categorie")
    @JsonIgnore
    private Collection<produit> produits = new ArrayList<>();
}
