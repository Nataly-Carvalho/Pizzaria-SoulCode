package com.soulcode.pizzaria.controllers;


import com.soulcode.pizzaria.models.DTOS.TamanhoDTO;
import com.soulcode.pizzaria.service.TamanhoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tamanho")
public class TamanhoController {

    @Autowired
    private TamanhoService tamanhoService;

    @PostMapping("/cadastro")
    public TamanhoDTO save(@RequestBody @Valid TamanhoDTO pizzaDTO) {
        return this.tamanhoService.save(pizzaDTO);
    }
    @GetMapping("/buscartodos")
    public List<TamanhoDTO> findAll() {
        return this.tamanhoService.findAll();
    }

    @GetMapping( "/{id}")
    public TamanhoDTO findById(@PathVariable Long id) {
        return this.tamanhoService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public TamanhoDTO deleteById(@PathVariable Long id) {
        return this.tamanhoService.deleteById(id);
    }

    @PutMapping( "/alterar/{id}")
    public TamanhoDTO updateById(@PathVariable @Valid Long id, @RequestBody TamanhoDTO tamanhoDTO) {
        return this.tamanhoService.updateById(id,tamanhoDTO);
    }
}
