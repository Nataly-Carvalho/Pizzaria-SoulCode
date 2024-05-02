package com.soulcode.pizzaria.models.DTOS;


import com.soulcode.pizzaria.models.Ingredientes;
import com.soulcode.pizzaria.models.PizzaPedida;
import com.soulcode.pizzaria.models.Pizza_has_Ingrediente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class Pizza_has_IngredienteDTO {

    private Long id;
    @Valid
    @NotNull(message = "O atributo id pizza deve ser preenchido")
    private Long idPizzaPedida;

    @Valid
    @NotNull(message = "O atributo id ingredientes deve ser preenchido")
    private Long idIngredientes;

    public Pizza_has_IngredienteDTO() {}

    public Pizza_has_IngredienteDTO(Pizza_has_Ingrediente pizzaHasIngrediente){
        this.id = pizzaHasIngrediente.getId();
        this.idPizzaPedida = pizzaHasIngrediente.getPizzaPedida().getId();
        this.idIngredientes = pizzaHasIngrediente.getIngredientes().getId();
    }

    public static Pizza_has_Ingrediente converter(Pizza_has_IngredienteDTO pizzaHasIngredienteDTO){
        Pizza_has_Ingrediente pizzaHasIngrediente = new Pizza_has_Ingrediente();
        pizzaHasIngrediente.setId(pizzaHasIngredienteDTO.getId());
        pizzaHasIngrediente.setPizzaPedida(new PizzaPedida(pizzaHasIngredienteDTO.getIdPizzaPedida()));
        pizzaHasIngrediente.setIngredientes(new Ingredientes(pizzaHasIngredienteDTO.getIdIngredientes()));
        return pizzaHasIngrediente ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPizzaPedida() {
        return idPizzaPedida;
    }

    public void setIdPizzaPedida(Long idPizzaPedida) {
        this.idPizzaPedida = idPizzaPedida;
    }

    public Long getIdIngredientes() {
        return idIngredientes;
    }

    public void setIdIngredientes(Long idIngredientes) {
        this.idIngredientes = idIngredientes;
    }
}
