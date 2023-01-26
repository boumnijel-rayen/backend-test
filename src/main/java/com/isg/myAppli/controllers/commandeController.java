package com.isg.myAppli.controllers;

import com.isg.myAppli.models.commande;
import com.isg.myAppli.services.commandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class commandeController {

    @Autowired
    private commandeService commandeService;

    @GetMapping("/all")
    public ResponseEntity<List<commande>> getAllCommandes() {
        return ResponseEntity.ok().body(commandeService.getAllCommandes());
    }

    @GetMapping("/find/{id_p}/{id_fr}")
    public ResponseEntity<commande> getCommandeById(@PathVariable("id_p") long id_p, @PathVariable("id_fr") long id_fr) {
        return ResponseEntity.ok().body(commandeService.getCommandeById(id_p, id_fr));
    }

    @PostMapping("/add/{id_p}/{id_fr}")
    public ResponseEntity<commande> addCommande(@RequestBody commande commande, @PathVariable long id_p, @PathVariable long id_fr) {
        return ResponseEntity.ok().body(commandeService.addCommande(commande,id_p,id_fr));
    }

    @PutMapping("/update/{id_p}/{id_fr}")
    public ResponseEntity<commande> updateCommande(@RequestBody commande commande, @PathVariable long id_p, @PathVariable long id_fr) {
        return ResponseEntity.ok().body(commandeService.updateCommande(commande, id_p, id_fr));
    }

    @DeleteMapping("/delete/{id_p}/{id_fr}")
    public ResponseEntity<String> deleteCommande(@PathVariable long id_p, @PathVariable long id_fr) {
        commandeService.deleteCommande(id_p, id_fr);
        return ResponseEntity.ok().body("Commande supprimée");
    }

}
