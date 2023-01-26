package com.isg.myAppli.controllers;

import com.isg.myAppli.models.produit;
import com.isg.myAppli.services.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class produitController {

    @Autowired
    private produitService produitService;

    @GetMapping("/all")
    public ResponseEntity<List<produit>> findAll() {
        return ResponseEntity.ok().body(produitService.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<produit> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(produitService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<produit> save(@RequestBody produit produit) {
        return ResponseEntity.ok().body(produitService.save(produit));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<produit> update(@RequestBody produit produit, @PathVariable Long id) {
        return ResponseEntity.ok().body(produitService.update(produit, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        produitService.deleteById(id);
        return ResponseEntity.ok().body("Produit supprimé");
    }

    @PutMapping("{id_p}/assignCP/{id_cat}")
    public ResponseEntity<String> assignCategoryToProduit(@PathVariable Long id_p, @PathVariable Long id_cat) {
        produitService.assignCategory(id_p, id_cat);
        return ResponseEntity.ok().body("category assigné au produit");
    }

    @PutMapping("{id_p}/assignLP/{id_lab}")
    public ResponseEntity<String> assignLaboratoireToProduit(@PathVariable Long id_p, @PathVariable Long id_lab) {
        produitService.assignLaboratoire(id_p, id_lab);
        return ResponseEntity.ok().body("laboratoire assigné au produit");
    }

    @PutMapping("{id_p}/assignMP/{id_mag}")
    public ResponseEntity<String> assignMagasinToProduit(@PathVariable Long id_p, @PathVariable Long id_mag) {
        produitService.assignMagasin(id_p, id_mag);
        return ResponseEntity.ok().body("magasin assigné au produit");
    }

    @GetMapping("/findParMot/{motCle}")
    public ResponseEntity<List<produit>> findByMotCle(@PathVariable String motCle) {
        return ResponseEntity.ok().body(produitService.findByMotCle(motCle));
    }

}
