package com.soulcode.pizzaria.controllers;

import com.soulcode.pizzaria.models.DTOS.IngredientesDTO;
import com.soulcode.pizzaria.models.DTOS.PizzaDTO;
import com.soulcode.pizzaria.models.Pizza;
import com.soulcode.pizzaria.service.PizzaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping("/cadastro")
    public PizzaDTO save(@RequestBody @Valid PizzaDTO pizzaDTO) {
        return this.pizzaService.save(pizzaDTO);
    }
    @GetMapping("/buscartodos")
    public List<PizzaDTO> findAll() {
        return this.pizzaService.findAll();
    }

    @GetMapping( "/{id}")
    public PizzaDTO findById(@PathVariable Long id) {
        return this.pizzaService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public PizzaDTO deleteById(@PathVariable Long id) {
        return this.pizzaService.deleteById(id);
    }

    @PutMapping( "/alterar/{id}")
    public PizzaDTO updateById(@PathVariable @Valid Long id, @RequestBody PizzaDTO pizzaDTO) {
        return this.pizzaService.updateById(id,pizzaDTO);
    }
}
