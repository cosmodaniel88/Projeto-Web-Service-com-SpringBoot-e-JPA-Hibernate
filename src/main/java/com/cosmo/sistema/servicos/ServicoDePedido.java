package com.cosmo.sistema.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmo.sistema.entities.Pedido;
import com.cosmo.sistema.entities.Usuario;
import com.cosmo.sistema.repositorios.RepositorioDePedido;

@Service //indicando que a classe é componente, pode ser injetada com autowired
public class ServicoDePedido {
	
	@Autowired
	private RepositorioDePedido rdp;
	
	public List<Pedido> findAll(){
		return rdp.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj =  rdp.findById(id);
		
		return obj.get();
	}
}
