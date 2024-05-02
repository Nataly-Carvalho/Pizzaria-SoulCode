package com.soulcode.pizzaria.repositories;

import com.soulcode.pizzaria.models.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long> {
    @Query("SELECT bebida FROM Bebida bebida WHERE bebida.nome = :nome")
    Optional<Bebida> findByNomeContainingIgnoreCase(String nome);
}
