package com.soulcode.pizzaria.service;
import com.soulcode.pizzaria.models.DTOS.IngredientesDTO;
import com.soulcode.pizzaria.models.Ingredientes;
import com.soulcode.pizzaria.repositories.IngredientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientesService {

    @Autowired
    private IngredientesRepository ingredientesRepository;

    public IngredientesDTO save(IngredientesDTO ingredientesDTO) {
        Optional<Ingredientes> ingrediente = this.ingredientesRepository.findByNomeContainingIgnoreCase(ingredientesDTO.getNome());
        if (ingrediente.isEmpty()){
            Ingredientes ingredientes = IngredientesDTO.converter(ingredientesDTO);
            ingredientesRepository.save(ingredientes);
            return new IngredientesDTO(ingredientes);
        }else {
            throw new RuntimeException("O Nome do item já esta cadastrado");
        }
    }

    public List<IngredientesDTO> findAll() {
        List<Ingredientes> ingredientes = ingredientesRepository.findAll();
        return ingredientes.stream().map(IngredientesDTO::new).collect(Collectors.toList());
    }

    public IngredientesDTO findById(Long id) {
        Optional<Ingredientes> ingredientes = this.ingredientesRepository.findById(id);
        if (ingredientes.isEmpty()){
            throw new RuntimeException("O ingrediente não foi encontrado");
        }else {
            return new IngredientesDTO(ingredientes.get());
        }
    }

    public IngredientesDTO deleteById(Long id) {
        IngredientesDTO ingredientesDTO = this.findById(id);
        this.ingredientesRepository.deleteById(id);
        return ingredientesDTO;
    }

    public IngredientesDTO updateById(Long id, IngredientesDTO ingredientesDTO) {
        this.findById(id);
        Optional<Ingredientes> ingredienteNome = this.ingredientesRepository.findByNomeContainingIgnoreCase(ingredientesDTO.getNome());
        if (ingredienteNome.isEmpty()){
            Ingredientes ingredientes = IngredientesDTO.converter(ingredientesDTO);
            ingredientes.setId(id);
            ingredientesRepository.save(ingredientes);
            return new IngredientesDTO(ingredientes);
        }else {
            throw new RuntimeException("O ingrediente ja esta cadastrado");
        }
    }
}

