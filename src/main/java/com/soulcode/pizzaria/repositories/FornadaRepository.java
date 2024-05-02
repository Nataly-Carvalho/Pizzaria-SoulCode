package com.soulcode.pizzaria.repositories;

import com.soulcode.pizzaria.models.Fornada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornadaRepository extends JpaRepository<Fornada, Long> {

}
