package com.cosmo.sistema.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmo.sistema.entities.Usuario;
import com.cosmo.sistema.repositorios.RepositorioDeUsuario;

@Service //indicando que a classe é componente, pode ser injetada com autowired
public class ServicoDeUsuario {
	
	@Autowired
	private RepositorioDeUsuario rdu;
	
	public List<Usuario> findAll(){
		return rdu.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj =  rdu.findById(id);
		
		return obj.get();
	}
}
