package com.cosmo.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmo.sistema.entities.Categoria;

public interface RepositorioDeCategoria extends JpaRepository<Categoria, Long> {
	
}
