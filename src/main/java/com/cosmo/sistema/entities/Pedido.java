package com.cosmo.sistema.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.cosmo.sistema.entities.enums.StatusDoPedido;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;

	private Integer status;

	@ManyToOne // muitos para um
	@JoinColumn(name = "client_id")
	private Usuario cliente;

	@OneToMany(mappedBy = "id.pedido")
	private Set<OrdemDeItem> items = new HashSet<>();

	// mapeando unidades para ter o mesmo ID
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;

	public Pedido() {

	}

	public Pedido(Long id, Instant momento, Usuario cliente, StatusDoPedido status) {
		super();
		this.id = id;
		this.momento = momento;
		this.cliente = cliente;
		// vou chamar o set para passar o nosso valor para o status acima.
		setStatus(status);
	}

	public Long getId() {
		return id;
	}

	public StatusDoPedido getStatus() {
		// retorne o enum que possuir o código atribuído lá em cima.

		return StatusDoPedido.valueOf(status);
	}

	// ele recebe um enum
	public void setStatus(StatusDoPedido status) {
		// se esse argumento for diferente de null
		if (status != null) {
			// o nosso status da classe lá em cima, vai receber o código desse enum
			this.status = status.getCode();
		}
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	
	public Double getTotal() {
		Double total = 0.0;
		for(OrdemDeItem oi : items) {
			total += oi.getSubTotal();
		}
		
		return total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Set<OrdemDeItem> getItems() {
		return items;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

}
