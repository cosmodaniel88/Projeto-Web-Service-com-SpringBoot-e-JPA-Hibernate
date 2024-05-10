package com.cosmo.sistema.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmo.sistema.entities.Produto;
import com.cosmo.sistema.repositorios.RepositorioDeProduto;

@Service //indicando que a classe é componente, pode ser injetada com autowired
public class ServicoDeProduto {
	
	@Autowired
	private RepositorioDeProduto rdu;
	
	public List<Produto> findAll(){
		return rdu.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj =  rdu.findById(id);
		
		return obj.get();
	}
}
