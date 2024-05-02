package com.soulcode.pizzaria.controllers;

import com.soulcode.pizzaria.models.DTOS.BebidaDTO;
import com.soulcode.pizzaria.service.BebidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bebidas")
public class BebidaController {

    @Autowired
    private BebidaService bebidaService;

    @PostMapping("/cadastro")
    public BebidaDTO save(@RequestBody @Valid BebidaDTO bebidaDTO) {
        return this.bebidaService.save(bebidaDTO);
    }
    @GetMapping("/buscartodos")
    public List<BebidaDTO> findAll() {
        return this.bebidaService.findAll();
    }

    @GetMapping( "/{id}")
    public BebidaDTO findById(@PathVariable Long id) {
        return this.bebidaService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public BebidaDTO deleteById(@PathVariable Long id) {
        return this.bebidaService.deleteById(id);
    }

    @PutMapping( "/alterar/{id}")
    public BebidaDTO updateById(@PathVariable @Valid Long id, @RequestBody BebidaDTO bebidaDTO) {
        return this.bebidaService.updateById(id, bebidaDTO);
    }

}
