package com.cosmo.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmo.sistema.entities.Produto;

public interface RepositorioDeProduto extends JpaRepository<Produto, Long> {
	
}
