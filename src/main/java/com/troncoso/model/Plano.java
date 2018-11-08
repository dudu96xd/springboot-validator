package com.troncoso.model;

import javax.persistence.*;

@Entity
@Table(name = "plano")
public class Plano {

    @Id
    @GeneratedValue
    @Column(name = "id_plano")
    private Integer id;

    @Column(name = "nome_plano")
    private String name;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "qnt_gigas")
    private Integer qntGigas;

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

    public Integer getQntGigas() {
        return qntGigas;
    }

    public void setQntGigas(Integer qntGigas) {
        this.qntGigas = qntGigas;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
