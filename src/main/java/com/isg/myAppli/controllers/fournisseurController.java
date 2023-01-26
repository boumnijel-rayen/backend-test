package com.isg.myAppli.controllers;

import com.isg.myAppli.models.commandeKey;
import com.isg.myAppli.models.fournisseur;
import com.isg.myAppli.services.fournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseur")
public class fournisseurController {

    @Autowired
    private fournisseurService fournisseurService;

    @GetMapping("/all")
    public ResponseEntity<List<fournisseur>> getAllFournisseurs() {
        return ResponseEntity.ok().body(fournisseurService.getAllFournisseurs());
    }

    @GetMapping("/find/{id_fr}")
    public ResponseEntity<fournisseur> getFournisseurById(@PathVariable long id_fr) {
        return ResponseEntity.ok().body(fournisseurService.getFournisseurById(id_fr));
    }

    @PostMapping("/add")
    public ResponseEntity<fournisseur> addFournisseur(@RequestBody fournisseur fournisseur) {
        return ResponseEntity.ok().body(fournisseurService.addFournisseur(fournisseur));
    }

    @PutMapping("/update/{id_fr}")
    public ResponseEntity<fournisseur> updateFournisseur(@PathVariable long id_fr, @RequestBody fournisseur fournisseur) {
        return ResponseEntity.ok().body(fournisseurService.updateFournisseur(fournisseur, id_fr));
    }

    @DeleteMapping("/delete/{id_fr}")
    public ResponseEntity<String> deleteFournisseur(@PathVariable long id_fr) {
        fournisseurService.deleteFournisseur(id_fr);
        return ResponseEntity.ok().body("Fournisseur supprimé");
    }

    @PutMapping("/{id_u}/assignFU/{id_fr}")
    public ResponseEntity<String> assignUtilisateurToFournisseur(@PathVariable Long id_u, @PathVariable Long id_fr) {
        fournisseurService.assignUtilisateurToFournisseur(id_u, id_fr);
        return ResponseEntity.ok().body("utilisateur assigné à le fournisseur");
    }
}
