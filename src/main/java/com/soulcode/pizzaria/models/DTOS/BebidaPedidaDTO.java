package com.soulcode.pizzaria.models.DTOS;

import com.soulcode.pizzaria.models.Bebida;
import com.soulcode.pizzaria.models.BebidaPedida;
import com.soulcode.pizzaria.models.Pedido;
import jakarta.validation.constraints.NotNull;

public class BebidaPedidaDTO {

    private Long id;
    @NotNull(message = "A quantidade deve ser informada")
    private int quantidade;
    @NotNull(message = "O id pedido deve ser informado")
    private Long idPedido;
    @NotNull(message = "O id bebida deve ser informado")
    private Long idBebida;

    public BebidaPedidaDTO() {}

    public BebidaPedidaDTO (BebidaPedida bebidaPedida) {
        this.id = bebidaPedida.getId();
        this.quantidade = bebidaPedida.getQuantidade();
        this.idPedido = bebidaPedida.getPedido().getId();
        this.idBebida = bebidaPedida.getBebida().getId();
    }

    public static BebidaPedida converter(BebidaPedidaDTO bebidaPedidaDTO) {
        BebidaPedida bebidaPedida = new BebidaPedida();
        bebidaPedida.setId(bebidaPedidaDTO.getId());
        bebidaPedida.setQuantidade(bebidaPedidaDTO.getQuantidade());
        bebidaPedida.setPedido(new Pedido(bebidaPedidaDTO.getIdPedido()));
        bebidaPedida.setBebida(new Bebida(bebidaPedidaDTO.getIdBebida()));
        return bebidaPedida;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(Long idBebida) {
        this.idBebida = idBebida;
    }
}
