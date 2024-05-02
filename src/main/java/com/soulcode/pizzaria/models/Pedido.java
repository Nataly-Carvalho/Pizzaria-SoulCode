package com.soulcode.pizzaria.models;


import com.soulcode.pizzaria.models.DTOS.ClienteDTO;
import com.soulcode.pizzaria.models.DTOS.FornadaDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Fornada fornada;


    public Pedido (){}

    public Pedido(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Fornada getFornada() {
        return fornada;
    }

    public void setFornada(Fornada fornada) {
        this.fornada = fornada;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
