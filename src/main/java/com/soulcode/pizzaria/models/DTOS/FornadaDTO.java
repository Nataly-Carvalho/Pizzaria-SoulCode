package com.soulcode.pizzaria.models.DTOS;

import com.soulcode.pizzaria.models.Fornada;
import jakarta.validation.constraints.NotNull;

public class FornadaDTO {
    private Long id;

   @NotNull(message = "O numero da fornada deve ser informado")
    private int numFornada;

    @NotNull(message = "A quantidade de pizzas deve ser informnada")
    private int qtdPizzas;

    public FornadaDTO() {}

    public FornadaDTO(Fornada fornada) {
        this.id = fornada.getId();
        this.numFornada = fornada.getNumFornada();
        this.qtdPizzas = fornada.getQtdPizzas();
    }
    public static Fornada converter(FornadaDTO fornadaDTO) {
        Fornada fornada = new Fornada();
        fornada.setId(fornadaDTO.getId());
        fornada.setNumFornada(fornadaDTO.getNumFornada());
        fornada.setQtdPizzas(fornadaDTO.getQtdPizzas());
        return fornada;

    }

    public int getNumFornada() {
        return numFornada;
    }

    public void setNumFornada(int numFornada) {
        this.numFornada = numFornada;
    }

    public int getQtdPizzas() {
        return qtdPizzas;
    }

    public void setQtdPizzas(int qtdPizzas) {
        this.qtdPizzas = qtdPizzas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
