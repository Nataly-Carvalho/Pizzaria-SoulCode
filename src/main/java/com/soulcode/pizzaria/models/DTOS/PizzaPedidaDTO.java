package com.soulcode.pizzaria.models.DTOS;

import com.soulcode.pizzaria.models.Pedido;
import com.soulcode.pizzaria.models.Pizza;
import com.soulcode.pizzaria.models.PizzaPedida;
import com.soulcode.pizzaria.models.Tamanho;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class PizzaPedidaDTO {

    private Long id;

    @NotNull(message = "A quantidade não pode ser nula")
    private Long quantidade;
    @Valid
    @NotNull(message = "O id não pode ser nulo")
    private Long idPizzas;
    @Valid
    @NotNull(message = "O id não pode ser nulo")
    private Long idTamanho;
    @Valid
    @NotNull(message = "O id não pode ser nulo")
    private Long idPedidos;

    public PizzaPedidaDTO() {}

    public PizzaPedidaDTO(PizzaPedida pizzaPedida) {
        this.id = pizzaPedida.getId();
        this.quantidade = pizzaPedida.getQuantidade();
        this.idPedidos = pizzaPedida.getPedidos().getId();
        this.idPizzas = pizzaPedida.getPizzas().getId();
        this.idTamanho = pizzaPedida.getTamanho().getId();
    }

    public static PizzaPedida converter(PizzaPedidaDTO pizzaPedidaDTO) {
        PizzaPedida pizzaPedida = new PizzaPedida();
        pizzaPedida.setId(pizzaPedidaDTO.getId());
        pizzaPedida.setQuantidade(pizzaPedidaDTO.getQuantidade());
        pizzaPedida.setPizzas(new Pizza(pizzaPedidaDTO.getIdPizzas()));
        pizzaPedida.setTamanho(new Tamanho(pizzaPedidaDTO.getIdTamanho()));
        pizzaPedida.setPedidos(new Pedido(pizzaPedidaDTO.getIdPizzas()));
        return pizzaPedida;
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

    public Long getIdPizzas() {
        return idPizzas;
    }

    public void setIdPizzas(Long idPizzas) {
        this.idPizzas = idPizzas;
    }

    public Long getIdTamanho() {
        return idTamanho;
    }

    public void setIdTamanho(Long idTamanho) {
        this.idTamanho = idTamanho;
    }

    public Long getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(Long idPedidos) {
        this.idPedidos = idPedidos;
    }
}
