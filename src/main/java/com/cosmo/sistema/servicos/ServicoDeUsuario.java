package com.cosmo.sistema.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmo.sistema.entities.Usuario;
import com.cosmo.sistema.repositorios.RepositorioDeUsuario;
import com.cosmo.sistema.servicos.excecoes.RecursoNaoEncontrado;

@Service //indicando que a classe é componente, pode ser injetada com autowired
public class ServicoDeUsuario {
	
	@Autowired
	private RepositorioDeUsuario rdu;
	
	public List<Usuario> findAll(){
		return rdu.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj =  rdu.findById(id);
		
		return obj.orElseThrow(() ->  new RecursoNaoEncontrado(id));
	}
	
	public Usuario insert(Usuario obj) {
		return rdu.save(obj); // essa operação já retorna um objeto por padrão
	}
	
	public void delete(Long id) {
		rdu.deleteById(id);
	}
	
	public Usuario update(Long id, Usuario obj) {
		//o getReference apenas prepara o objeto. 
		Usuario entidade = rdu.getReferenceById(id);
		updateDados(entidade, obj);
		return rdu.save(entidade);
	}

	private void updateDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
		
	}
}
