package com.cosmo.sistema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmo.sistema.entities.Pedido;
import com.cosmo.sistema.servicos.ServicoDePedido;

@RestController // Estamos dizendo que se trata de um Rest controller
@RequestMapping(value = "pedidos") // mapeamento do recurso
public class ControllerPedido {

	@Autowired
	private ServicoDePedido servicoPedido;

	// método padrão para retornar

	@GetMapping // indicando que isso será um cotrolador rest
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> lista = servicoPedido.findAll();
		return ResponseEntity.ok().body(lista);
	}

	// metodo para buscar por id
	// estamos dizendo no getMapping que ele receberá na url esse parâmetro
	// no parâmetro do método, utilizamos a anotação que diz que ele será uma
	// variável de ambiente
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		Pedido obj = servicoPedido.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
