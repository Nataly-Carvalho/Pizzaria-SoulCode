package com.soulcode.pizzaria.models;

import jakarta.persistence.*;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Float precoBase;

    private Boolean personalizada;

    public Pizza() {}

    public Pizza(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Float precoBase) {
        this.precoBase = precoBase;
    }

    public Boolean getPersonalizada() {
        return personalizada;
    }

    public void setPersonalizada(Boolean personalizada) {
        this.personalizada = personalizada;
    }
}
