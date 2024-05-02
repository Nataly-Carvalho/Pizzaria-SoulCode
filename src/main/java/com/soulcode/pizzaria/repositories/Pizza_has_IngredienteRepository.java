package com.soulcode.pizzaria.repositories;

import com.soulcode.pizzaria.models.Pizza_has_Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pizza_has_IngredienteRepository extends JpaRepository<Pizza_has_Ingrediente, Long> {
}
