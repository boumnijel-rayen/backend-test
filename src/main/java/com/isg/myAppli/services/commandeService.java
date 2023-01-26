package com.isg.myAppli.services;

import com.isg.myAppli.models.commande;
import com.isg.myAppli.models.commandeKey;
import com.isg.myAppli.repos.commandeRepo;
import com.isg.myAppli.repos.fournisseurRepo;
import com.isg.myAppli.repos.produitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class commandeService {

    @Autowired
    private commandeRepo commandeRepo;
    @Autowired
    private produitRepo produitRepo;
    @Autowired
    private fournisseurRepo fournisseurRepo;

    public List<commande> getAllCommandes() {
        return commandeRepo.findAll();
    }

    public commande getCommandeById(long id_p, long id_fr) {
        return commandeRepo.GetById(id_p, id_fr);
    }

    public commande addCommande(commande commande, long id_p, long id_fr) {
        commandeKey commandeKey = new commandeKey();
        commandeKey.setId_p(id_p);
        commandeKey.setId_fr(id_fr);
        commande commande1 = new commande();
        commande1.setId_c(commandeKey);
        commande1.setDate_fourni(commande.getDate_fourni());
        commande1.setQuantite(commande.getQuantite());
        commande1.setProduit(produitRepo.findById(id_p).get());
        commande1.setFournisseur(fournisseurRepo.findById(id_fr).get());
        return commandeRepo.save(commande1);
    }

    public commande updateCommande(commande commande, long id_p, long id_fr) {
        commande commandeToUpdate = commandeRepo.GetById(id_p, id_fr);
        commandeToUpdate.setQuantite(commande.getQuantite());
        commandeToUpdate.setDate_fourni(commande.getDate_fourni());
        return commandeRepo.save(commandeToUpdate);
    }

    public void deleteCommande(long id_p, long id_fr) {
        commande commandeToDelete = commandeRepo.GetById(id_p, id_fr);
        commandeToDelete.setProduit(null);
        commandeToDelete.setFournisseur(null);
        commandeRepo.delete(commandeToDelete);
    }

}
