package com.isg.myAppli.services;

import com.isg.myAppli.models.fournisseur;
import com.isg.myAppli.models.produit;
import com.isg.myAppli.models.utilisateur;
import com.isg.myAppli.repos.produitRepo;
import com.isg.myAppli.repos.utilisateurRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class utilisateurService implements UserDetailsService {

    @Autowired
    private utilisateurRepo utilisateurRepo;
    @Autowired
    private produitRepo produitRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        utilisateur utilisateur = utilisateurRepo.findByEmail(email);
        if (utilisateur == null){
            throw new UsernameNotFoundException("user not found");
        }
        Collection<SimpleGrantedAuthority> authorites = new ArrayList<>();
        authorites.add(new SimpleGrantedAuthority("USER"));
        return new User(utilisateur.getEmail(),utilisateur.getPassword(),authorites);
    }

    public List<utilisateur> findAll() {
        return utilisateurRepo.findAll();
    }

    public utilisateur findById(Long id) {
        return utilisateurRepo.findById(id).get();
    }

    public utilisateur findByEmail(String email) {
        return utilisateurRepo.findByEmail(email);
    }

    public utilisateur save(utilisateur utilisateur) {
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        return utilisateurRepo.save(utilisateur);
    }

    public void delete(Long id) {
        utilisateur utilisateur = utilisateurRepo.findById(id).get();
        utilisateur.getFournisseurs().forEach(fournisseur -> {
            fournisseur.setUtilisateur(null);
        });
        utilisateurRepo.delete(utilisateur);
    }

    public utilisateur update(utilisateur utilisateur, Long id) {
        utilisateur utilisateurToUpdate = utilisateurRepo.findById(id).get();
        utilisateurToUpdate.setNom(utilisateur.getNom());
        utilisateurToUpdate.setPrenom(utilisateur.getPrenom());
        utilisateurToUpdate.setEmail(utilisateur.getEmail());
        utilisateurToUpdate.setAdresse(utilisateur.getAdresse());
        utilisateurToUpdate.setCode_postal(utilisateur.getCode_postal());
        utilisateurToUpdate.setDate_naissance(utilisateur.getDate_naissance());
        return utilisateurRepo.save(utilisateurToUpdate);
    }

    public void assignProduitToUtilisateur(Long id_u, Long id_pr) {
        utilisateur utilisateur = utilisateurRepo.findById(id_u).get();
        produit produit = produitRepo.findById(id_pr).get();
        utilisateur.getProduits().add(produit);
        utilisateurRepo.save(utilisateur);
    }

}
