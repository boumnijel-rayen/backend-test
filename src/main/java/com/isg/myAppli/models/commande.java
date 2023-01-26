package com.isg.myAppli.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class commande {
    @EmbeddedId
    private commandeKey id_c;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_fr")
    @JoinColumn(name = "id_p")
    private produit produit;
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_p")
    @JoinColumn(name = "id_fr")
    private fournisseur fournisseur;

    private int quantite;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date date_fourni;
}
