package com.soulcode.pizzaria.repositories;

import com.soulcode.pizzaria.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT cliente FROM Cliente cliente WHERE cliente.login = :login")
    Optional<Cliente> findByLoginContainingIgnoreCase(String login);
}
