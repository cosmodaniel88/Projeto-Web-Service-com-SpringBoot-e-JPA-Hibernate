package com.cosmo.sistema.entities.enums;

public enum StatusDoPedido {
	//o java atribui valor númerico para cada enum
	//Ele faz isso automaticamente, seguindo a ordem.
	//isso pode acarretar um problema;
	//a informação enviada ao banco de dados não é a string
	//mas sim o valor numérico seguindo a ordem.
	//acontece que, caso façamos alguma alteração nos enums, mexendo a na ordem deles
	//haverá conflito de informações entre a aplicação e o banco de dados.
	//Para evitar esse problema, nós devemos enumearar manualmente os enums, para ter controle sobre
	//essa informação no banco de dados
	//com essa implementação, o java pede que criemos uma estrutura para embasar essa numeração.
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO_PARA_ENTREGA(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	//lógica para implementação da enumeração dos enums
	private int code;
	
	//faremos um construtor para o enum
	private StatusDoPedido(int code) {
		this.code = code;
	}
	//método para pegar o code
	public int getCode() {
		return code;
	}
	
	//método para conversão de int para enum
	//vamos criar um método estático, pois não precisaremos instancar para utilizá-lo
	
	public static StatusDoPedido valueOf(int code) {
		//método para percorrer toda a lista de enums
		for(StatusDoPedido valor : StatusDoPedido.values()) {
			//se o código do enum for itual ao código passado no argumento
			//então você retorna o enum
			if(valor.getCode() == code) {
				return valor;
			}
		}
		
		throw new IllegalArgumentException("Valor do enum é inválido");
	}
	
}
