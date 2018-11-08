package com.troncoso.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nome")
    private String name;

    @Column(name = "email")
    @Email(message = "Invalid email")
    private String email;

    @Column(name = "data_cadastro")
    private Date sysDate;

    @Column(name = "linha")
    private String linha;

    @Column(name = "id_plano")
    private String idPlano;

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSysDate() {
        return sysDate;
    }

    public void setSysDate(Date sysDate) {
        this.sysDate = sysDate;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public String getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(String idPlano) {
        this.idPlano = idPlano;
    }
}
