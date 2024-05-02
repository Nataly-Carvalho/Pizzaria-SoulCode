package com.soulcode.pizzaria.controllers;

import com.soulcode.pizzaria.models.DTOS.PizzaPedidaDTO;
import com.soulcode.pizzaria.service.PizzaPedidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzapedida")
public class PIzzaPedidaController {
    @Autowired
    private PizzaPedidaService pizzaPedidaService;

    @PostMapping("/cadastro")
    public PizzaPedidaDTO save(@RequestBody @Valid PizzaPedidaDTO pizzaDTO) {
        return this.pizzaPedidaService.save(pizzaDTO);
    }
    @GetMapping("/buscartodos")
    public List<PizzaPedidaDTO> findAll() {
        return this.pizzaPedidaService.findAll();
    }

    @GetMapping( "/{id}")
    public PizzaPedidaDTO findById(@PathVariable Long id) {
        return this.pizzaPedidaService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public PizzaPedidaDTO deleteById(@PathVariable Long id) {
        return this.pizzaPedidaService.deleteById(id);
    }

    @PutMapping( "/alterar/{id}")
    public PizzaPedidaDTO updateById(@PathVariable @Valid Long id, @RequestBody PizzaPedidaDTO pizzaDTO) {
        return this.pizzaPedidaService.updateById(id,pizzaDTO);
    }
}
