package com.cosmo.sistema.servicos.excecoes;

public class ExcecaoBancoDeDados extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ExcecaoBancoDeDados(String msg) {
		super(msg);
	}
}
