package com.soulcode.pizzaria.repositories;

import com.soulcode.pizzaria.models.PizzaPedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaPedidaRepository extends JpaRepository<PizzaPedida, Long> {
}
