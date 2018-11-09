package com.ciceroandrade.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciceroandrade.cursomc.domain.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

	Optional<Municipio> findById(Integer id);

}
