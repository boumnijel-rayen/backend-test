package com.isg.myAppli.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class laboratoire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_lab;
    private String lib_lab;
    @OneToMany(mappedBy = "laboratoire")
    @JsonIgnore
    private Collection<produit> produits = new ArrayList<>();
}
