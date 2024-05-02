package com.soulcode.pizzaria.service;

import com.soulcode.pizzaria.models.Fornada;
import com.soulcode.pizzaria.models.DTOS.FornadaDTO;
import com.soulcode.pizzaria.repositories.FornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FornadaService {

    @Autowired
    private FornadaRepository fornadaRepository;

    public FornadaDTO save(FornadaDTO fornadaDTO) {
        Fornada fornada = FornadaDTO.converter(fornadaDTO);
        fornadaRepository.save(fornada);
        return new FornadaDTO(fornada);
    }

    public List<FornadaDTO> findAll() {
        List<Fornada> fornada = fornadaRepository.findAll();
        return fornada.stream().map(FornadaDTO::new).collect(Collectors.toList());
    }

    public FornadaDTO findById(Long id) {
        Optional<Fornada> fornada = this.fornadaRepository.findById(id);
        if (fornada.isEmpty()){
            throw new RuntimeException("A Fornada não foi encontrado");
        }else {
            return new FornadaDTO(fornada.get());
        }
    }

    public FornadaDTO deleteById(Long id) {
        FornadaDTO fornadaDTO = this.findById(id);
        this.fornadaRepository.deleteById(id);
        return fornadaDTO;
    }

    public FornadaDTO updateById(Long id, FornadaDTO fornadaDTO) {
        this.findById(id);
        Fornada fornada = FornadaDTO.converter(fornadaDTO);
        fornada.setId(id);
        fornada = this.fornadaRepository.save(fornada);
        return new FornadaDTO(fornada);
    }

}
