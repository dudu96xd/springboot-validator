package com.troncoso.repository;

import com.troncoso.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Modifying
    @Transactional
    @Query("update Usuario usuario set usuario.name=:nome, usuario.email=:email, usuario.sysDate=:data_cadastro where usuario.id=:id_usuario")
    void updateUsuario(@Param("nome") String name, @Param("email") String email,
                       @Param("data_cadastro") Date data_cadastro, @Param("id_usuario") Integer id_usuario);
}
