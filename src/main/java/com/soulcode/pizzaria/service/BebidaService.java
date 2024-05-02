package com.soulcode.pizzaria.service;

import com.soulcode.pizzaria.models.Bebida;
import com.soulcode.pizzaria.models.DTOS.BebidaDTO;
import com.soulcode.pizzaria.repositories.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository bebidaRepository;

    public BebidaDTO save(BebidaDTO bebidaDTO) {
        Optional<Bebida> bebidas = this.bebidaRepository.findByNomeContainingIgnoreCase(bebidaDTO.getNome());
        if (bebidas.isEmpty()){
            Bebida bebida = BebidaDTO.converter(bebidaDTO);
            bebidaRepository.save(bebida);
            return new BebidaDTO(bebida);
        }else {
            throw new RuntimeException("A bebida já esta cadastrada");
        }
    }

    public List<BebidaDTO> findAll() {
        List<Bebida> bebidas = bebidaRepository.findAll();
        return bebidas.stream().map(BebidaDTO::new).collect(Collectors.toList());
    }

    public BebidaDTO findById(Long id) {
        Optional<Bebida> bebida = this.bebidaRepository.findById(id);
        if (bebida.isEmpty()){
            throw new RuntimeException("A bebida não foi encontrado");
        }else {
            return new BebidaDTO(bebida.get());
        }
    }

    public BebidaDTO deleteById(Long id) {
        BebidaDTO dto = this.findById(id);
        this.bebidaRepository.deleteById(id);
        return dto;
    }

    public BebidaDTO updateById(Long id, BebidaDTO bebidaDTO) {
        this.findById(id);
        Optional<Bebida> bebidaNome = this.bebidaRepository.findByNomeContainingIgnoreCase(bebidaDTO.getNome());
        if (bebidaNome.isEmpty()){
            Bebida bebida = BebidaDTO.converter(bebidaDTO);
            bebida.setId(id);
            bebidaRepository.save(bebida);
            return new BebidaDTO(bebida);
        }else {
            throw new RuntimeException("A bebida ja esta cadastrado");
        }
    }

}
