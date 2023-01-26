package com.isg.myAppli.services;

import com.isg.myAppli.models.categorie;
import com.isg.myAppli.repos.categorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categorieService {

    @Autowired
    private categorieRepo categorieRepo;

    public List<categorie> getAllCategories() {
        return categorieRepo.findAll();
    }

    public categorie getCategorieById(long id) {
        return categorieRepo.findById(id).get();
    }

    public categorie addCategorie(categorie categorie) {
        return categorieRepo.save(categorie);
    }

    public categorie updateCategorie(categorie categorie, long id) {
        categorie categorieToUpdate = categorieRepo.findById(id).get();
        categorieToUpdate.setLib_cat(categorie.getLib_cat());
        return categorieRepo.save(categorieToUpdate);
    }

}
