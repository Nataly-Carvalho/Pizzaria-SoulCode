package com.soulcode.pizzaria.models.DTOS;



import com.soulcode.pizzaria.models.Ingredientes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class IngredientesDTO {

    private Long id;

    @NotBlank(message = "O atributo nome não pode ficar vazio")
    private String nome;
    @NotNull(message = "O atributo preço não pode ficar vazio")
    private Float preco;

    public IngredientesDTO(){}

    public IngredientesDTO(Ingredientes ingredientes) {
        this.id = ingredientes.getId();
        this.nome = ingredientes.getNome();
        this.preco = ingredientes.getPreco();
    }
    public static Ingredientes converter(IngredientesDTO ingredientesDTO) {
        Ingredientes ingredientes = new Ingredientes();
        ingredientes.setId(ingredientesDTO.getId());
        ingredientes.setNome(ingredientesDTO.getNome());
        ingredientes.setPreco(ingredientesDTO.getPreco());
        return ingredientes;
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

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
