package com.soulcode.pizzaria.controllers;

import com.soulcode.pizzaria.models.DTOS.PedidoDTO;
import com.soulcode.pizzaria.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/cadastro")
    public PedidoDTO save(@Valid @RequestBody PedidoDTO pedidoDTO){
        return this.pedidoService.save(pedidoDTO);
    }
    @GetMapping("/buscartodos")
    public List<PedidoDTO> findAll() {
        return this.pedidoService.findAll();
    }

    @GetMapping( "/{id}")
    public PedidoDTO findById(@PathVariable Long id) {
        return this.pedidoService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public PedidoDTO deleteById(@PathVariable Long id) {
        return this.pedidoService.deleteById(id);
    }

    @PutMapping( "/alterar/{id}")
    public PedidoDTO updateById(@PathVariable @Valid Long id, @RequestBody PedidoDTO pedidoDTO) {
        return this.pedidoService.updateById(id,pedidoDTO);
    }
}
