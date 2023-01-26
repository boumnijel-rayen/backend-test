package com.isg.myAppli.services;

import com.isg.myAppli.models.*;
import com.isg.myAppli.repos.commandeRepo;
import com.isg.myAppli.repos.factureRepo;
import com.isg.myAppli.repos.fournisseurRepo;
import com.isg.myAppli.repos.utilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class fournisseurService {

    @Autowired
    private fournisseurRepo fournisseurRepo;
    @Autowired
    private factureRepo factureRepo;
    @Autowired
    private commandeRepo commandeRepo;
    @Autowired
    private utilisateurRepo utilisateurRepo;
    public List<fournisseur> getAllFournisseurs() {
        return fournisseurRepo.findAll();
    }

    public fournisseur getFournisseurById(long id_fr) {
        return fournisseurRepo.findById(id_fr).get();
    }

    public fournisseur addFournisseur(fournisseur fournisseur) {
        return fournisseurRepo.save(fournisseur);
    }

    public fournisseur updateFournisseur(fournisseur fournisseur, long id_fr) {
        fournisseur fournisseurToUpdate = fournisseurRepo.findById(id_fr).get();
        fournisseurToUpdate.setNom_fr(fournisseur.getNom_fr());
        fournisseurToUpdate.setPrenom_fr(fournisseur.getPrenom_fr());
        fournisseurToUpdate.setEmail_fr(fournisseur.getEmail_fr());
        fournisseurToUpdate.setAdresse_fr(fournisseur.getAdresse_fr());
        fournisseurToUpdate.setTelephone_fr(fournisseur.getTelephone_fr());
        return fournisseurRepo.save(fournisseurToUpdate);
    }

    public void deleteFournisseur(long id_fr) {
        fournisseur fournisseurToDelete = fournisseurRepo.findById(id_fr).get();
        fournisseurToDelete.getFactures().forEach(facture -> {
            facture.setFournisseur(null);
            factureRepo.delete(facture);
        });
        fournisseurToDelete.getCommandes().forEach(commande -> {
            commande.setFournisseur(null);
            commande.setProduit(null);
            commandeRepo.delete(commande);
        });
        fournisseurToDelete.setUtilisateur(null);
        fournisseurRepo.deleteById(id_fr);
    }

    public void assignUtilisateurToFournisseur(Long id_u, Long id_fr) {
        utilisateur utilisateur = utilisateurRepo.findById(id_u).get();
        fournisseur fournisseur = fournisseurRepo.findById(id_fr).get();
        fournisseur.setUtilisateur(utilisateur);
        fournisseurRepo.save(fournisseur);
    }

}
