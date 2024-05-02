package com.soulcode.pizzaria.controllers;


import com.soulcode.pizzaria.models.DTOS.Pizza_has_IngredienteDTO;
import com.soulcode.pizzaria.service.Pizza_has_IngredienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzaingrediente")
public class Pizza_has_IngredienteController {

    @Autowired
    Pizza_has_IngredienteService pizzaHasIngredienteService;

    @PostMapping("/cadastro")
    public Pizza_has_IngredienteDTO save(@RequestBody @Valid Pizza_has_IngredienteDTO pizzaDTO) {
        return this.pizzaHasIngredienteService.save(pizzaDTO);
    }
    @GetMapping("/buscartodos")
    public List<Pizza_has_IngredienteDTO> findAll() {
        return this.pizzaHasIngredienteService.findAll();
    }

    @GetMapping( "/{id}")
    public Pizza_has_IngredienteDTO findById(@PathVariable Long id) {
        return this.pizzaHasIngredienteService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Pizza_has_IngredienteDTO deleteById(@PathVariable Long id) {
        return this.pizzaHasIngredienteService.deleteById(id);
    }

    @PutMapping( "/alterar/{id}")
    public Pizza_has_IngredienteDTO updateById(@PathVariable @Valid Long id, @RequestBody Pizza_has_IngredienteDTO pizzaDTO) {
        return this.pizzaHasIngredienteService.updateById(id,pizzaDTO);
    }

}
