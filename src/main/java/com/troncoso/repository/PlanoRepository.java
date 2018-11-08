package com.troncoso.repository;

import com.troncoso.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface PlanoRepository extends JpaRepository<Plano, Integer> {

    @Modifying
    @Transactional
    @Query("update Plano p set p.name=:nome, p.qntGigas=:qntGigas where p.id=:idPlano")
    void updatePlano(@Param("nome") String name, @Param("qntGigas") Integer qntGigas, @Param("idPlano") Integer idPlano);
}
