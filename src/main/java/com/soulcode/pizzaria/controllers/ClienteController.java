package com.soulcode.pizzaria.controllers;

import com.soulcode.pizzaria.models.Cliente;
import com.soulcode.pizzaria.models.DTOS.ClienteDTO;
import com.soulcode.pizzaria.repositories.ClienteRepository;
import com.soulcode.pizzaria.service.ClienteService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastro")
    public ClienteDTO save(@RequestBody @Valid ClienteDTO clienteDTO) {
        return this.clienteService.save(clienteDTO);
    }
    @GetMapping("/buscartodos")
    public List<ClienteDTO> findAll() {
        return this.clienteService.findAll();
    }

    @GetMapping( "/{id}")
    public ClienteDTO findById(@PathVariable Long id) {
        return this.clienteService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ClienteDTO deleteById(@PathVariable Long id) {
        return this.clienteService.deleteById(id);
    }

    @PutMapping( "/alterar/{id}")
    public ClienteDTO updateById(@PathVariable @Valid Long id, @RequestBody ClienteDTO clienteDTO) {
        return this.clienteService.updateById(id, clienteDTO);
    }


    }
