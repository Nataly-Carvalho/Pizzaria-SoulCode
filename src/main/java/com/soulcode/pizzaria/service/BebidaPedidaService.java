package com.soulcode.pizzaria.service;

import com.soulcode.pizzaria.models.BebidaPedida;
import com.soulcode.pizzaria.models.DTOS.BebidaPedidaDTO;
import com.soulcode.pizzaria.repositories.BebidaPedidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BebidaPedidaService {

    @Autowired
    private BebidaPedidasRepository bebidaPedidasRepository;

    public BebidaPedidaDTO save(BebidaPedidaDTO bebidaPedidasDTO) {
        BebidaPedida bebidaPedidas = BebidaPedidaDTO.converter(bebidaPedidasDTO);
        bebidaPedidasRepository.save(bebidaPedidas);
        return new BebidaPedidaDTO(bebidaPedidas);
    }

    public List<BebidaPedidaDTO> findAll() {
        List<BebidaPedida> bebidaPedidas = bebidaPedidasRepository.findAll();
        return bebidaPedidas.stream().map(BebidaPedidaDTO::new).collect(Collectors.toList());
    }

    public BebidaPedidaDTO findById(Long id) {
        Optional<BebidaPedida> bebidaPedidas = this.bebidaPedidasRepository.findById(id);
        if (bebidaPedidas.isEmpty()){
            throw new RuntimeException("A Bebida Pedidas não foi encontrado");
        }else {
            return new BebidaPedidaDTO(bebidaPedidas.get());
        }
    }

    public BebidaPedidaDTO deleteById(Long id) {
        BebidaPedidaDTO bebidaPedidasDTO = this.findById(id);
        this.bebidaPedidasRepository.deleteById(id);
        return bebidaPedidasDTO;
    }

    public BebidaPedidaDTO updateById(Long id, BebidaPedidaDTO fornadaDTO) {
        this.findById(id);
        BebidaPedida bebidaPedidas = BebidaPedidaDTO.converter(fornadaDTO);
        bebidaPedidas.setId(id);
        bebidaPedidas = this.bebidaPedidasRepository.save(bebidaPedidas);
        return new BebidaPedidaDTO(bebidaPedidas);
    }

}
