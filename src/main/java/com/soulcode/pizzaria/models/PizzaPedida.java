package com.soulcode.pizzaria.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PizzaPedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long quantidade;

    @ManyToOne
    private Pizza pizzas;

    @ManyToOne
    private Tamanho tamanho;

    @ManyToOne
    private Pedido pedidos;

    public PizzaPedida() {}

    public PizzaPedida(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;

    }

    public Pizza getPizzas() {
        return pizzas;
    }

    public void setPizzas(Pizza pizzas) {
        this.pizzas = pizzas;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Pedido getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }
}
