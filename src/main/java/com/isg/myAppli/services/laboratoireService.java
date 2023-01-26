package com.isg.myAppli.services;

import com.isg.myAppli.models.laboratoire;
import com.isg.myAppli.repos.laboratoireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class laboratoireService {

    @Autowired
    private laboratoireRepo laboratoireRepo;

    public List<laboratoire> getAllLaboratoires() {
        return laboratoireRepo.findAll();
    }

    public laboratoire getLaboratoireById(long id) {
        return laboratoireRepo.findById(id).get();
    }

    public laboratoire addLaboratoire(laboratoire laboratoire) {
        return laboratoireRepo.save(laboratoire);
    }

    public laboratoire updateLaboratoire(laboratoire laboratoire, long id) {
        laboratoire laboratoireToUpdate = laboratoireRepo.findById(id).get();
        laboratoireToUpdate.setLib_lab(laboratoire.getLib_lab());
        return laboratoireRepo.save(laboratoireToUpdate);
    }
}
