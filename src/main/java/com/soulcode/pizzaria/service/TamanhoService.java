package com.soulcode.pizzaria.service;


import com.soulcode.pizzaria.models.DTOS.TamanhoDTO;
import com.soulcode.pizzaria.models.Tamanho;
import com.soulcode.pizzaria.repositories.TamanhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TamanhoService {

    @Autowired
    private TamanhoRepository tamanhoRepository;

    public TamanhoDTO save(TamanhoDTO tamanhoDTO) {
        Optional<Tamanho> tamanho = this.tamanhoRepository.findByNomeContainingIgnoreCase(tamanhoDTO.getNome());
        if (tamanho.isEmpty()) {
            Tamanho cliente = TamanhoDTO.converter(tamanhoDTO);
            tamanhoRepository.save(cliente);
            return new TamanhoDTO(cliente);

        } else {
            throw new RuntimeException("O Tamanho já esta cadastrado");
        }
    }
    public List<TamanhoDTO> findAll() {
        List<Tamanho> tamanho = tamanhoRepository.findAll();
        return tamanho.stream().map(TamanhoDTO::new).collect(Collectors.toList());
    }

    public TamanhoDTO findById(Long id) {
        Optional<Tamanho>tamanho = this.tamanhoRepository.findById(id);
        if (tamanho.isEmpty()){
            throw new RuntimeException("A Pizza não foi encontrado");
        }else {
            return new TamanhoDTO(tamanho.get());
        }
    }

    public TamanhoDTO deleteById(Long id) {
        TamanhoDTO tamanhoDTO = this.findById(id);
        this.tamanhoRepository.deleteById(id);
        return tamanhoDTO;
    }

    public TamanhoDTO updateById(Long id, TamanhoDTO tamanhoDTO) {
        this.findById(id);
        Optional<Tamanho> tamanho = this.tamanhoRepository.findByNomeContainingIgnoreCase(tamanhoDTO.getNome());
        if (tamanho.isEmpty()) {
            Tamanho cliente = TamanhoDTO.converter(tamanhoDTO);
            cliente.setId(id);
            tamanhoRepository.save(cliente);
            return new TamanhoDTO(cliente);
        } else {
            throw new RuntimeException("O tamanho ja esta cadastrado");
        }
    }
}
