package com.isg.myAppli.repos;

import com.isg.myAppli.models.facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface factureRepo extends JpaRepository<facture, Long> {
}
