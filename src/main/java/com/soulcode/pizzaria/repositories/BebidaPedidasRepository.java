package com.soulcode.pizzaria.repositories;

import com.soulcode.pizzaria.models.BebidaPedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaPedidasRepository extends JpaRepository<BebidaPedida, Long> {

}
