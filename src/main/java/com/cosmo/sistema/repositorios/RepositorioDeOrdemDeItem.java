package com.cosmo.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmo.sistema.entities.OrdemDeItem;

public interface RepositorioDeOrdemDeItem extends JpaRepository<OrdemDeItem, Long> {
	
}
