package com.isg.myAppli.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_mag;
    private String lib_mag;
    @OneToMany(mappedBy = "magasin")
    @JsonIgnore
    private Collection<produit> produits = new ArrayList<>();
}
