package com.soulcode.pizzaria.service;

import com.soulcode.pizzaria.models.DTOS.PizzaPedidaDTO;
import com.soulcode.pizzaria.models.PizzaPedida;
import com.soulcode.pizzaria.repositories.PizzaPedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaPedidaService {
    @Autowired
    private PizzaPedidaRepository pizzaRepository;

    public PizzaPedidaDTO save(PizzaPedidaDTO pizzaDTO) {
        PizzaPedida pizza = PizzaPedidaDTO.converter(pizzaDTO);
        pizzaRepository.save(pizza);
        return new PizzaPedidaDTO(pizza);
    }

    public List<PizzaPedidaDTO> findAll() {
        List<PizzaPedida> pizza = pizzaRepository.findAll();
        return pizza.stream().map(PizzaPedidaDTO::new).collect(Collectors.toList());
    }

    public PizzaPedidaDTO findById(Long id) {
        Optional<PizzaPedida> pizza = this.pizzaRepository.findById(id);
        if (pizza.isEmpty()){
            throw new RuntimeException("A Pizza pedida não foi encontrado");
        }else {
            return new PizzaPedidaDTO(pizza.get());
        }
    }

    public PizzaPedidaDTO deleteById(Long id) {
        PizzaPedidaDTO pizzaDTO = this.findById(id);
        this.pizzaRepository.deleteById(id);
        return pizzaDTO;
    }

    public PizzaPedidaDTO updateById(Long id, PizzaPedidaDTO pizzaDTO) {
        this.findById(id);
        PizzaPedida pizza = PizzaPedidaDTO.converter(pizzaDTO);
        pizza.setId(id);
        pizza = this.pizzaRepository.save(pizza);
        return new PizzaPedidaDTO(pizza);
    }
}
