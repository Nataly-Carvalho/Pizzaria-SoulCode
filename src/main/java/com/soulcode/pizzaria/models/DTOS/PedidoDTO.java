package com.soulcode.pizzaria.models.DTOS;

import com.soulcode.pizzaria.models.Cliente;
import com.soulcode.pizzaria.models.Fornada;
import com.soulcode.pizzaria.models.Pedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class PedidoDTO {

    private Long id;

    private LocalDateTime dataHora = LocalDateTime.now();

    @Valid
    @NotNull(message = "O id do cliente deve ser preenchido")
    private Long idCliente;

    @NotNull(message = "O id da Fornada deve ser preenchido")
    private Long idFornada;

    public PedidoDTO() {
    }

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.dataHora = pedido.getDataHora();
        this.idCliente = pedido.getCliente().getId();
        this.idFornada = pedido.getFornada().getId();
    }

    public static Pedido converter(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setId(pedidoDTO.getId());
        pedido.setDataHora(pedidoDTO.getDataHora());
        pedido.setCliente(new Cliente(pedidoDTO.getIdCliente()));
        pedido.setFornada(new Fornada(pedidoDTO.getIdFornada()));
        return pedido;
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

   public Long getIdCliente() {
     return idCliente;
    }

   public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
   }

    public Long getIdFornada() {
        return idFornada;
    }

    public void setIdFornada(Long idFornada) {
        this.idFornada = idFornada;
    }
}
