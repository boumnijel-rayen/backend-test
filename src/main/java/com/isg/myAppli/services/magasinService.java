package com.isg.myAppli.services;

import com.isg.myAppli.models.magasin;
import com.isg.myAppli.models.produit;
import com.isg.myAppli.repos.magasinRepo;
import com.isg.myAppli.repos.produitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class magasinService {

    @Autowired
    private magasinRepo magasinRepo;
    @Autowired
    private produitRepo produitRepo;

    public List<magasin> getAllMagasins() {
        return magasinRepo.findAll();
    }

    public magasin getMagasinById(long id_mag) {
        return magasinRepo.findById(id_mag).get();
    }

    public magasin addMagasin(magasin magasin) {
        return magasinRepo.save(magasin);
    }

    public magasin updateMagasin(magasin magasin,long id_mag) {
        magasin magasinToUpdate = magasinRepo.findById(id_mag).get();
        magasinToUpdate.setLib_mag(magasin.getLib_mag());
        return magasinRepo.save(magasinToUpdate);
    }

    public void deleteMagasin(long id_mag) {
        magasinRepo.findById(id_mag).get().getProduits().forEach(produit -> {
            produit.setMagasin(null);
        });
        magasinRepo.deleteById(id_mag);
    }
}
