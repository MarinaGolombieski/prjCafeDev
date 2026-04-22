package com.marina.br.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

	@Entity
	@Table(name="tb_pedido")
	public class Pedido {
			@Id
			@GeneratedValue(strategy= GenerationType.IDENTITY)
			private Long id;
			
			private String descricao;
			private double valorTotal;
			private String dataPedido;
			
			@ManyToOne
			@JoinColumn(name = "cliente_id")
			private Cliente cliente;
			
			
			public Pedido() {
				
			}
			
			public Pedido(Long id, String descricao, double valorTotal, String dataPedido) {
				this.id = id;
				this.descricao = descricao;
				this.valorTotal = valorTotal;
				this.dataPedido = dataPedido;
			
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getDescricao() {
				return descricao;
			}

			public void setDescricao(String descricao) {
				this.descricao = descricao;
			}

			public double getValorTotal() {
				return valorTotal;
			}

			public void setValorTotal(double valorTotal) {
				this.valorTotal = valorTotal;
			}

			public String getDataPedido() {
				return dataPedido;
			}

			public void setDataPedido(String dataPedido) {
				this.dataPedido = dataPedido;
			}
			
			public Cliente getCliente() {
			    return cliente;
			}

			public void setCliente(Cliente cliente) {
			    this.cliente = cliente;
			}
			
			
			
			
}
