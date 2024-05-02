package com.soulcode.pizzaria.models.DTOS;

import com.soulcode.pizzaria.models.Bebida;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BebidaDTO {
    private Long id;

    @NotBlank(message = "O nome da bebida deve ser preenchido")
    private String nome;

    @NotNull(message = "O preco do produto deve ser preenchido")
    private Double preco;



    public BebidaDTO() {}

    public BebidaDTO(Bebida bebida) {
        this.id = bebida.getId();
        this.nome = bebida.getNome();
        this.preco = bebida.getPreco();

    }

    public static Bebida converter(BebidaDTO bebidaDTO) {
        Bebida bebida = new Bebida();
        bebida.setId(bebidaDTO.getId());
        bebida.setNome(bebidaDTO.getNome());
        bebida.setPreco(bebidaDTO.getPreco());
        return bebida;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
