package com.soulcode.pizzaria.models.DTOS;

import com.soulcode.pizzaria.models.Tamanho;
import jakarta.validation.constraints.NotBlank;

public class TamanhoDTO {

    private Long id;
    @NotBlank(message = "O atributo tamanho deve ser preenchido")
    private String nome;

    private Float desconto;

    public TamanhoDTO() {}

    public static Tamanho converter(TamanhoDTO tamanhoDTO) {
        Tamanho tamanho = new Tamanho();
        tamanho.setId(tamanhoDTO.getId());
        tamanho.setNome(tamanhoDTO.getNome());
        tamanho.setDesconto(tamanhoDTO.getDesconto());
        return tamanho;
    }

    public TamanhoDTO(Tamanho tamanho) {
        this.id = tamanho.getId();
        this.nome = tamanho.getNome();
        this.desconto = tamanho.getDesconto();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
