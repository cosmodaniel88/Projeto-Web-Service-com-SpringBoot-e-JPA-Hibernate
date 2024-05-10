package com.cosmo.sistema.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmo.sistema.entities.Categoria;
import com.cosmo.sistema.repositorios.RepositorioDeCategoria;

@Service //indicando que a classe é componente, pode ser injetada com autowired
public class ServicoDeCategoria {
	
	@Autowired
	private RepositorioDeCategoria rdu;
	
	public List<Categoria> findAll(){
		return rdu.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj =  rdu.findById(id);
		
		return obj.get();
	}
}
