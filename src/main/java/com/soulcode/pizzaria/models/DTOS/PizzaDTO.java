package com.soulcode.pizzaria.models.DTOS;

import com.soulcode.pizzaria.models.Pizza;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PizzaDTO {

    private Long id;

    @NotBlank(message = "O atributo nome é obrigatorio" )
    private String nome;

    @NotNull(message = "O preco é um atributo obrigatorio")
    private Float precoBase;

    private Boolean personalizada;

    PizzaDTO() {}
    public PizzaDTO (Pizza pizza) {
        this.id = pizza.getId();
        this.nome = pizza.getNome();
        this.precoBase = pizza.getPrecoBase();
        this.personalizada = pizza.getPersonalizada();
    }
    public static Pizza converter(PizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza();
        pizza.setId(pizzaDTO.getId());
        pizza.setNome(pizzaDTO.getNome());
        pizza.setPrecoBase(pizzaDTO.getPrecoBase());
        pizza.setPersonalizada(pizzaDTO.getPersonalizada());
        return pizza;
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
