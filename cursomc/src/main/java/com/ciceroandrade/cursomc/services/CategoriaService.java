package com.ciceroandrade.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciceroandrade.cursomc.domain.Categoria;
import com.ciceroandrade.cursomc.repositories.CategoriaRepository;
import com.ciceroandrade.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id +", "+ Categoria.class.getName()));
	}
}