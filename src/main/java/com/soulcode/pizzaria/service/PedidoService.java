package com.soulcode.pizzaria.service;

import com.soulcode.pizzaria.models.DTOS.PedidoDTO;
import com.soulcode.pizzaria.models.Pedido;
import com.soulcode.pizzaria.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoDTO save(PedidoDTO pedidoDTO) {
        Pedido pedido = PedidoDTO.converter(pedidoDTO);
        pedidoRepository.save(pedido);
        return new PedidoDTO(pedido);
    }

    public List<PedidoDTO> findAll() {
        List<Pedido> pedido = pedidoRepository.findAll();
        return pedido.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }

    public PedidoDTO findById(Long id) {
        Optional<Pedido> pedido = this.pedidoRepository.findById(id);
        if (pedido.isEmpty()){
            throw new RuntimeException("A Pizza não foi encontrado");
        }else {
            return new PedidoDTO(pedido.get());
        }
    }

    public PedidoDTO deleteById(Long id) {
        PedidoDTO pizzaDTO = this.findById(id);
        this.pedidoRepository.deleteById(id);
        return pizzaDTO;
    }

    public PedidoDTO updateById(Long id, PedidoDTO pedidoDTO) {
        this.findById(id);
        Pedido pedido = PedidoDTO.converter(pedidoDTO);
        pedido.setId(id);
        pedido = this.pedidoRepository.save(pedido);
        return new PedidoDTO(pedido);
    }
}
