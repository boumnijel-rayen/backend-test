package com.isg.myAppli.repos;

import com.isg.myAppli.models.fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fournisseurRepo extends JpaRepository<fournisseur, Long> {
}
