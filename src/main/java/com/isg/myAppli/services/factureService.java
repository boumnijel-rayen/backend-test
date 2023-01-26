package com.isg.myAppli.services;

import com.isg.myAppli.models.facture;
import com.isg.myAppli.models.fournisseur;
import com.isg.myAppli.models.produit;
import com.isg.myAppli.repos.factureRepo;
import com.isg.myAppli.repos.fournisseurRepo;
import com.isg.myAppli.repos.produitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class factureService {

    @Autowired
    private factureRepo factureRepo;
    @Autowired
    private fournisseurRepo fournisseurRepo;
    @Autowired
    private produitRepo produitRepo;

    public List<facture> getAllFactures() {
        return factureRepo.findAll();
    }

    public facture getFactureById(long id_facture) {
        return factureRepo.findById(id_facture).get();
    }

    public facture addFacture(facture facture) {
        return factureRepo.save(facture);
    }

    public void deleteById(Long id) {
        facture facture = factureRepo.findById(id).get();
        facture.setFournisseur(null);
        factureRepo.deleteById(id);
    }

    public void assignFournisseurToFacture(long id_fr, long id_f){
        facture facture = factureRepo.findById(id_f).get();
        fournisseur fournisseur = fournisseurRepo.findById(id_fr).get();
        facture.setFournisseur(fournisseur);
        factureRepo.save(facture);
    }

    public void assignProduitToFacture(long id_p, long id_f) {
        facture facture = factureRepo.findById(id_f).get();
        produit produit = produitRepo.findById(id_p).get();
        facture.getProduits().add(produit);
        factureRepo.save(facture);
    }
}
