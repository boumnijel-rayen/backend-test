package com.isg.myAppli.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
public class facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_f;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_fr")
    private fournisseur fournisseur;

    @ManyToMany
    @JoinTable(name = "facture_produit",
            joinColumns = @JoinColumn(name = "id_f"),
            inverseJoinColumns = @JoinColumn(name = "id_p"))
    private Collection<produit> produits = new ArrayList<>();

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date date_facture;
    private Double total_HT;
    private Double total_TTC;
    private Double total_TVA;
}
