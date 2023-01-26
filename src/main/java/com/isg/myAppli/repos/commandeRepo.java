package com.isg.myAppli.repos;

import com.isg.myAppli.models.commande;
import com.isg.myAppli.models.commandeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@Repository
public interface commandeRepo extends JpaRepository<commande, commandeKey> {
    @Query(value = "SELECT * FROM `commande` WHERE id_p = :id_p and id_fr = :id_fr", nativeQuery = true)
    public commande GetById(@Param("id_p") long id_p,@Param("id_fr") long id_fr);
}
