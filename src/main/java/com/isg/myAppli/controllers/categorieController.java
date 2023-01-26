package com.isg.myAppli.controllers;

import com.isg.myAppli.models.categorie;
import com.isg.myAppli.services.categorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class categorieController {

    @Autowired
    private categorieService categorieService;

    @GetMapping("/all")
    public ResponseEntity<List<categorie>> getAllCategories() {
        return ResponseEntity.ok().body(categorieService.getAllCategories());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<categorie> getCategorieById(@PathVariable long id) {
        return ResponseEntity.ok().body(categorieService.getCategorieById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<categorie> addCategorie(@RequestBody categorie categorie) {
        return ResponseEntity.ok().body(categorieService.addCategorie(categorie));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<categorie> updateCategorie(@RequestBody categorie categorie, @PathVariable long id) {
        return ResponseEntity.ok().body(categorieService.updateCategorie(categorie, id));
    }
}
