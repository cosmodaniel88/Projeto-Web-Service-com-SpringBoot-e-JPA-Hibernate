package com.cosmo.sistema.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cosmo.sistema.entities.Categoria;
import com.cosmo.sistema.entities.OrdemDeItem;
import com.cosmo.sistema.entities.Pagamento;
import com.cosmo.sistema.entities.Pedido;
import com.cosmo.sistema.entities.Produto;
import com.cosmo.sistema.entities.Usuario;
import com.cosmo.sistema.entities.enums.StatusDoPedido;
import com.cosmo.sistema.repositorios.RepositorioDeCategoria;
import com.cosmo.sistema.repositorios.RepositorioDeOrdemDeItem;
import com.cosmo.sistema.repositorios.RepositorioDePedido;
import com.cosmo.sistema.repositorios.RepositorioDeProduto;
import com.cosmo.sistema.repositorios.RepositorioDeUsuario;

@Configuration
@Profile("test") // defindo o perfil em que essa config irá usar
public class TestConfig implements CommandLineRunner {

	// Injeção de dependência
	@Autowired
	private RepositorioDeUsuario urp;

	@Autowired
	private RepositorioDePedido rdp;
	// método que é disparado assim que o programa roda

	@Autowired
	private RepositorioDeCategoria rdc;

	@Autowired
	private RepositorioDeProduto rdpro;
	
	@Autowired
	private RepositorioDeOrdemDeItem rdodi;

	@Override
	public void run(String... args) throws Exception {

		// instanciação dos objetos
		Usuario u1 = new Usuario(null, "Marcia", "marcia@gmail.com", "0000000", "123465789");
		Usuario u2 = new Usuario(null, "Roberto", "roberto@gmail.com", "1111111111", "54321");

		// instanciando os pedidos
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, StatusDoPedido.AGUARDANDO_PAGAMENTO);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2, StatusDoPedido.PAGO);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1, StatusDoPedido.ENVIADO_PARA_ENTREGA);

		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");

		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		// método padrão para salvar no user Repository
		urp.saveAll(Arrays.asList(u1, u2));
		rdp.saveAll(Arrays.asList(o1, o2, o3));
		rdc.saveAll(Arrays.asList(cat1, cat2, cat3));
		rdpro.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat3);
	
		rdpro.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		OrdemDeItem oi1 = new OrdemDeItem(o1, p1, 2, p1.getPreco());
		OrdemDeItem oi2 = new OrdemDeItem(o1, p3, 1, p3.getPreco());
		OrdemDeItem oi3 = new OrdemDeItem(o2, p3, 2, p3.getPreco());
		OrdemDeItem oi4 = new OrdemDeItem(o3, p5, 2, p5.getPreco());
		
		rdodi.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), o1); 
		
		o1.setPagamento(pag1);
		
		rdp.save(o1);
	}
	


}
