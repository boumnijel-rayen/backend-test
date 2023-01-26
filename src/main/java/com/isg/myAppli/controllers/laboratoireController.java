package com.isg.myAppli.controllers;

import com.isg.myAppli.models.laboratoire;
import com.isg.myAppli.services.laboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laboratoire")
public class laboratoireController {

    @Autowired
    private laboratoireService laboratoireService;

    @GetMapping("/all")
    public ResponseEntity<List<laboratoire>> getAllLaboratoires() {
        return ResponseEntity.ok().body(laboratoireService.getAllLaboratoires());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<laboratoire> getLaboratoireById(@PathVariable long id) {
        return ResponseEntity.ok().body(laboratoireService.getLaboratoireById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<laboratoire> addLaboratoire(@RequestBody laboratoire laboratoire) {
        return ResponseEntity.ok().body(laboratoireService.addLaboratoire(laboratoire));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<laboratoire> updateLaboratoire(@RequestBody laboratoire laboratoire, @PathVariable long id) {
        return ResponseEntity.ok().body(laboratoireService.updateLaboratoire(laboratoire, id));
    }
}
