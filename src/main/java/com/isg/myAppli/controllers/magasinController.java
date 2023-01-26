package com.isg.myAppli.controllers;

import com.isg.myAppli.models.magasin;
import com.isg.myAppli.services.magasinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/magasin")
public class magasinController {

    @Autowired
    private magasinService magasinService;

    @GetMapping("/all")
    public ResponseEntity<List<magasin>> getAllMagasins() {
        return ResponseEntity.ok().body(magasinService.getAllMagasins());
    }

    @PostMapping("/add")
    public ResponseEntity<magasin> addMagasin(@RequestBody magasin magasin) {
        return ResponseEntity.ok().body(magasinService.addMagasin(magasin));
    }

    @GetMapping("/find/{id_mag}")
    public ResponseEntity<magasin> getMagasinById(@PathVariable long id_mag) {
        return ResponseEntity.ok().body(magasinService.getMagasinById(id_mag));
    }

    @PutMapping("/update/{id_mag}")
    public ResponseEntity<magasin> updateMagasin(@RequestBody magasin magasin, @PathVariable long id_mag) {
        return ResponseEntity.ok().body(magasinService.updateMagasin(magasin, id_mag));
    }

    @DeleteMapping("/delete/{id_mag}")
    public ResponseEntity<String> deleteMagasin(@PathVariable long id_mag) {
        magasinService.deleteMagasin(id_mag);
        return ResponseEntity.ok().body("Magasin deleted");
    }
}
