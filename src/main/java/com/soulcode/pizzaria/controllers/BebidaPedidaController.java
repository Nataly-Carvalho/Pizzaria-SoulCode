package com.soulcode.pizzaria.controllers;

import com.soulcode.pizzaria.models.DTOS.BebidaPedidaDTO;
import com.soulcode.pizzaria.service.BebidaPedidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bebidapedida")
public class BebidaPedidaController {

    @Autowired
    private BebidaPedidaService bebidaPedidaService;

    @PostMapping("/cadastro")
    public BebidaPedidaDTO save(@RequestBody @Valid BebidaPedidaDTO bebidaDTO) {
        return this.bebidaPedidaService.save(bebidaDTO);
    }
    @GetMapping("/buscartodos")
    public List<BebidaPedidaDTO> findAll() {
        return this.bebidaPedidaService.findAll();
    }

    @GetMapping( "/{id}")
    public BebidaPedidaDTO findById(@PathVariable Long id) {
        return this.bebidaPedidaService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public BebidaPedidaDTO deleteById(@PathVariable Long id) {
        return this.bebidaPedidaService.deleteById(id);
    }

    @PutMapping( "/alterar/{id}")
    public BebidaPedidaDTO updateById(@PathVariable @Valid Long id, @RequestBody BebidaPedidaDTO bebidaDTO) {
        return this.bebidaPedidaService.updateById(id, bebidaDTO);
    }

}
