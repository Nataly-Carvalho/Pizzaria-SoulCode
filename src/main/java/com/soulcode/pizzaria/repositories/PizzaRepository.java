package com.soulcode.pizzaria.repositories;

import com.soulcode.pizzaria.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {

}
