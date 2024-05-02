package com.soulcode.pizzaria.service;


import com.soulcode.pizzaria.models.Pizza_has_Ingrediente;
import com.soulcode.pizzaria.models.DTOS.Pizza_has_IngredienteDTO;
import com.soulcode.pizzaria.repositories.Pizza_has_IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Pizza_has_IngredienteService {

    @Autowired
    private Pizza_has_IngredienteRepository pizza_has_ingredienteRepository;

    public Pizza_has_IngredienteDTO save(Pizza_has_IngredienteDTO pizzaDTO) {
        Pizza_has_Ingrediente pizza = Pizza_has_IngredienteDTO.converter(pizzaDTO);
        pizza_has_ingredienteRepository.save(pizza);
        return new Pizza_has_IngredienteDTO(pizza);
    }

    public List<Pizza_has_IngredienteDTO> findAll() {
        List<Pizza_has_Ingrediente> pizza = pizza_has_ingredienteRepository.findAll();
        return pizza.stream().map(Pizza_has_IngredienteDTO::new).collect(Collectors.toList());
    }

    public Pizza_has_IngredienteDTO findById(Long id) {
        Optional<Pizza_has_Ingrediente> pizza = this.pizza_has_ingredienteRepository.findById(id);
        if (pizza.isEmpty()){
            throw new RuntimeException("A Pizza não foi encontrado");
        }else {
            return new Pizza_has_IngredienteDTO(pizza.get());
        }
    }

    public Pizza_has_IngredienteDTO deleteById(Long id) {
        Pizza_has_IngredienteDTO pizzaDTO = this.findById(id);
        this.pizza_has_ingredienteRepository.deleteById(id);
        return pizzaDTO;
    }

    public Pizza_has_IngredienteDTO updateById(Long id, Pizza_has_IngredienteDTO pizzaDTO) {
        this.findById(id);
        Pizza_has_Ingrediente pizza = Pizza_has_IngredienteDTO.converter(pizzaDTO);
        pizza.setId(id);
        pizza = this.pizza_has_ingredienteRepository.save(pizza);
        return new Pizza_has_IngredienteDTO(pizza);
    }
}
