package com.soulcode.pizzaria.controllers;

import com.soulcode.pizzaria.models.DTOS.ClienteDTO;
import com.soulcode.pizzaria.models.DTOS.FornadaDTO;
import com.soulcode.pizzaria.models.Fornada;
import com.soulcode.pizzaria.service.FornadaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornada")
public class FornadaController {

    @Autowired
    private FornadaService fornadaService;

    @PostMapping("/cadastro")
    public FornadaDTO save(@RequestBody @Valid FornadaDTO fornadaDTO) {
        return this.fornadaService.save(fornadaDTO);
    }
    @GetMapping("/buscartodos")
    public List<FornadaDTO> findAll() {
        return this.fornadaService.findAll();
    }

    @GetMapping( "/{id}")
    public FornadaDTO findById(@PathVariable Long id) {
        return this.fornadaService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public FornadaDTO deleteById(@PathVariable Long id) {
        return this.fornadaService.deleteById(id);
    }

    @PutMapping( "/alterar/{id}")
    public FornadaDTO updateById(@PathVariable @Valid Long id, @RequestBody FornadaDTO fornadaDTO) {
        return this.fornadaService.updateById(id, fornadaDTO);
    }

}
