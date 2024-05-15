package com.cosmo.sistema.servicos.excecoes;

public class RecursoNaoEncontrado  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	
	public RecursoNaoEncontrado(Object id) {
		super("Recurso não encontrado. Id = " + id);
	}
	
}
