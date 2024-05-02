package com.soulcode.pizzaria.repositories;


import com.soulcode.pizzaria.models.Tamanho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TamanhoRepository extends JpaRepository<Tamanho, Long> {
    @Query("SELECT tamanho FROM Tamanho tamanho WHERE tamanho.nome = :nome")
    Optional<Tamanho> findByNomeContainingIgnoreCase(String nome);
}
