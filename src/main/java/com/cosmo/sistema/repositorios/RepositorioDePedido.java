package com.cosmo.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmo.sistema.entities.Pedido;

public interface RepositorioDePedido extends JpaRepository<Pedido, Long> {
	
}
