package com.isg.myAppli.repos;

import com.isg.myAppli.models.produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface produitRepo extends JpaRepository<produit, Long> {

    @Query(value = "SELECT * FROM `produit` WHERE description like CONCAT('%',:mot,'%') or lib_p like CONCAT('%',:mot,'%')",nativeQuery = true)
    public List<produit> findByMot(@Param("mot") String mot);
}
