package com.ciceroandrade.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciceroandrade.cursomc.domain.Uf;

@Repository
public interface UfRepository extends JpaRepository<Uf, Integer> {

	Optional<Uf> findById(Integer id);

}
