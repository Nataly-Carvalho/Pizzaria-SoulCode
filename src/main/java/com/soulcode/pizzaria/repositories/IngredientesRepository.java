package com.soulcode.pizzaria.repositories;

import com.soulcode.pizzaria.models.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientesRepository extends JpaRepository<Ingredientes, Long> {
    @Query("SELECT ingrediente FROM Ingredientes ingrediente WHERE ingrediente.nome = :nome")
    Optional<Ingredientes> findByNomeContainingIgnoreCase(String nome);
}
