package com.ciceroandrade.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ciceroandrade.cursomc.domain.Categoria;
import com.ciceroandrade.cursomc.domain.Municipio;
import com.ciceroandrade.cursomc.domain.Produto;
import com.ciceroandrade.cursomc.domain.Uf;
import com.ciceroandrade.cursomc.repositories.CategoriaRepository;
import com.ciceroandrade.cursomc.repositories.MunicipioRepository;
import com.ciceroandrade.cursomc.repositories.ProdutoRepository;
import com.ciceroandrade.cursomc.repositories.UfRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired 
	private MunicipioRepository municipioRepository;
	
	@Autowired
	private UfRepository ufRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Override
	public void run (String... args) throws Exception{
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto (null, "Computador", 2000.00);
		Produto p2 = new Produto (null, "Impressora", 800.00);
		Produto p3 = new Produto (null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
				
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Uf uf1 = new Uf(null,31, "Minas Gerais");
		Uf uf2 = new Uf(null,35, "São Paulo");
		
		Municipio m1 =new Municipio(null,31001,"Uberlândia",uf1);
		Municipio m2 =new Municipio(null,35001,"São Paulo",uf2);
		Municipio m3 =new Municipio(null,35002,"Campinas",uf2);
		
		uf1.getCidades().add(m1);
		uf2.getCidades().addAll(Arrays.asList(m2,m3));
		
		ufRepository.saveAll(Arrays.asList(uf1,uf2));
		municipioRepository.saveAll(Arrays.asList(m1,m2,m3));
	}
}