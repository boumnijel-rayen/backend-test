package com.isg.myAppli.controllers;

import com.isg.myAppli.models.facture;
import com.isg.myAppli.services.factureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facture")
public class factureController {

    @Autowired
    private factureService factureService;


    @GetMapping("/all")
    public ResponseEntity<List<facture>> getAllFactures() {
        return ResponseEntity.ok().body(factureService.getAllFactures());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<facture> getFactureById(@PathVariable long id) {
        return ResponseEntity.ok().body(factureService.getFactureById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<facture> addFacture(@RequestBody facture facture) {
        return ResponseEntity.ok().body(factureService.addFacture(facture));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFacture(@PathVariable long id) {
        factureService.deleteById(id);
        return ResponseEntity.ok().body("Facture supprimée");
    }

    @PutMapping("/assignFFA/{id_fr}/{id_f}")
    public ResponseEntity<String> assignFournisseurToFacture(@PathVariable long id_fr, @PathVariable long id_f) {
        factureService.assignFournisseurToFacture(id_fr, id_f);
        return ResponseEntity.ok().body("Fournisseur assigné à la facture");
    }

    @PutMapping("/assignPFA/{id_p}/{id_f}")
    public ResponseEntity<String> assignProduitToFacture(@PathVariable long id_p, @PathVariable long id_f) {
        factureService.assignProduitToFacture(id_p, id_f);
        return ResponseEntity.ok().body("Produit assigné à la facture");
    }
}
