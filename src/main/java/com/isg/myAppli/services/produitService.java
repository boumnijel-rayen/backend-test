package com.isg.myAppli.services;

import com.isg.myAppli.models.categorie;
import com.isg.myAppli.models.laboratoire;
import com.isg.myAppli.models.magasin;
import com.isg.myAppli.models.produit;
import com.isg.myAppli.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class produitService {

    @Autowired
    private produitRepo produitRepo;
    @Autowired
    private categorieRepo categorieRepo;
    @Autowired
    private laboratoireRepo laboratoireRepo;
    @Autowired
    private magasinRepo magasinRepo;
    @Autowired
    private commandeRepo commandeRepo;
    @Autowired
    private factureService factureService;

    public List<produit> findAll() {
        return produitRepo.findAll();
    }

    public produit findById(Long id) {
        return produitRepo.findById(id).get();
    }

    public produit save(produit produit) {
        return produitRepo.save(produit);
    }

    public produit update(produit produit,long id_p) {
        produit produitToUpdate = produitRepo.findById(id_p).get();
        produitToUpdate.setLib_p(produit.getLib_p());
        produitToUpdate.setPrix_p(produit.getPrix_p());
        produitToUpdate.setDescription(produit.getDescription());
        produitToUpdate.setDate_ajout(produit.getDate_ajout());
        produitToUpdate.setPrix_liv(produit.getPrix_liv());
        return produitRepo.save(produitToUpdate);
    }

    public void deleteById(Long id) {
        produit produit = produitRepo.findById(id).get();
        produit.setMagasin(null);
        produit.setCategorie(null);
        produit.setLaboratoire(null);
        produit.getFactures().forEach(facture ->
                factureService.deleteById(facture.getId_f())
        );
        produit.getUtilisateurs().forEach(utilisateur ->
                utilisateur.setProduits(null)
        );
        produit.getCommandes().forEach(commande -> {
            commande.setProduit(null);
            commande.setFournisseur(null);
            commandeRepo.delete(commande);
        });//error
        produitRepo.deleteById(id);
    }

    public void assignCategory(Long id_p, Long id_cat) {
        produit produit = produitRepo.findById(id_p).get();
        categorie categorie = categorieRepo.findById(id_cat).get();
        produit.setCategorie(categorie);
        produitRepo.save(produit);
    }

    public void assignLaboratoire(Long id_p, Long id_lab) {
        produit produit = produitRepo.findById(id_p).get();
        laboratoire laboratoire = laboratoireRepo.findById(id_lab).get();
        produit.setLaboratoire(laboratoire);
        produitRepo.save(produit);
    }

    public void assignMagasin(Long id_p, Long id_mag) {
        produit produit = produitRepo.findById(id_p).get();
        magasin magasin = magasinRepo.findById(id_mag).get();
        produit.setMagasin(magasin);
        produitRepo.save(produit);
    }

    public List<produit> findByMotCle(String mc) {
        return produitRepo.findByMot(mc);
    }
}
