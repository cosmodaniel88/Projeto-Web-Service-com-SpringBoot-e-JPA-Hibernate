package com.cosmo.sistema.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cosmo.sistema.entities.Usuario;
import com.cosmo.sistema.servicos.ServicoDeUsuario;

@RestController //Estamos dizendo que se trata de um Rest controller
@RequestMapping(value="usuarios") //mapeamento do recurso
public class ControllerUsuario {
	
	
	@Autowired
	private ServicoDeUsuario servicoUsuario;
	
	//método padrão para retornar
	
	@GetMapping // indicando que isso será um cotrolador rest
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> lista = servicoUsuario.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	//metodo para buscar por id
	//estamos dizendo no getMapping que ele receberá na url esse parâmetro
	//no parâmetro do método, utilizamos a anotação que diz que ele será uma variável de ambiente
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = servicoUsuario.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario obj){
		obj = servicoUsuario.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		servicoUsuario.delete(id);
		return ResponseEntity.noContent().build();
	}
}
