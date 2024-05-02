package com.soulcode.pizzaria.service;

import com.soulcode.pizzaria.models.DTOS.PizzaDTO;
import com.soulcode.pizzaria.models.Pizza;
import com.soulcode.pizzaria.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public PizzaDTO save(PizzaDTO pizzaDTO) {
        Pizza pizza = PizzaDTO.converter(pizzaDTO);
        pizzaRepository.save(pizza);
        return new PizzaDTO(pizza);
    }

    public List<PizzaDTO> findAll() {
        List<Pizza> pizza = pizzaRepository.findAll();
        return pizza.stream().map(PizzaDTO::new).collect(Collectors.toList());
    }

    public PizzaDTO findById(Long id) {
        Optional<Pizza>pizza = this.pizzaRepository.findById(id);
        if (pizza.isEmpty()){
            throw new RuntimeException("A Pizza não foi encontrado");
        }else {
            return new PizzaDTO(pizza.get());
        }
    }

    public PizzaDTO deleteById(Long id) {
        PizzaDTO pizzaDTO = this.findById(id);
        this.pizzaRepository.deleteById(id);
        return pizzaDTO;
    }

    public PizzaDTO updateById(Long id, PizzaDTO pizzaDTO) {
        this.findById(id);
        Pizza pizza = PizzaDTO.converter(pizzaDTO);
        pizza.setId(id);
        pizza = this.pizzaRepository.save(pizza);
        return new PizzaDTO(pizza);
    }
}
