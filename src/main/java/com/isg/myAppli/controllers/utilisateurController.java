package com.isg.myAppli.controllers;

import com.isg.myAppli.models.utilisateur;
import com.isg.myAppli.services.utilisateurService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class utilisateurController {

    @Autowired
    private utilisateurService utilisateurService;

    @GetMapping("/all")
    public ResponseEntity<List<utilisateur>> findAll() {
        return ResponseEntity.ok().body(utilisateurService.findAll());
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<utilisateur> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(utilisateurService.findById(id));
    }

    @PutMapping("/find/email")
    public ResponseEntity<utilisateur> findByEmail(@RequestBody EmailClass email) {
        return ResponseEntity.ok().body(utilisateurService.findByEmail(email.getEmail()));
    }

    @PostMapping("/add")
    public ResponseEntity<utilisateur> save(@RequestBody utilisateur utilisateur) {
        return ResponseEntity.ok().body(utilisateurService.save(utilisateur));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
       utilisateurService.delete(id);
       return ResponseEntity.ok().body("utilisateur supprimé");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<utilisateur> update(@RequestBody utilisateur utilisateur, @PathVariable Long id) {
        return ResponseEntity.ok().body(utilisateurService.update(utilisateur, id));
    }

    @PutMapping("/{id_u}/assignPU/{id_pr}")
    public ResponseEntity<String> assignProduitToUtilisateur(@PathVariable Long id_u, @PathVariable Long id_pr) {
        utilisateurService.assignProduitToUtilisateur(id_u, id_pr);
        return ResponseEntity.ok().body("produit assigné à l'utilisateur");
    }
}
@Data
class EmailClass{
    private String email;
}