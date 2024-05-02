package com.soulcode.pizzaria.controllers;

import com.soulcode.pizzaria.models.DTOS.IngredientesDTO;
import com.soulcode.pizzaria.service.IngredientesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ingredientes")
public class IngredientesController {

    @Autowired
    private IngredientesService ingredientesService;

    @PostMapping("/cadastro")
    public IngredientesDTO save(@RequestBody @Valid IngredientesDTO ingredientesDTO) {
        return this.ingredientesService.save(ingredientesDTO);
    }
    @GetMapping("/buscartodos")
    public List<IngredientesDTO> findAll() {
        return this.ingredientesService.findAll();
    }

    @GetMapping( "/{id}")
    public IngredientesDTO findById(@PathVariable Long id) {
        return this.ingredientesService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public IngredientesDTO deleteById(@PathVariable Long id) {
        return this.ingredientesService.deleteById(id);
    }

    @PutMapping( "/alterar/{id}")
    public IngredientesDTO updateById(@PathVariable @Valid Long id, @RequestBody IngredientesDTO ingredientesDTO) {
        return this.ingredientesService.updateById(id, ingredientesDTO);
    }
}
