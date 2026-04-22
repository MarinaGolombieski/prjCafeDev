package com.marina.br.dtos;

public class PedidoResponseDTO {
	private Long id;
	private String descricao;
	private double valorTotal;
	private String dataPedido;
	
	public PedidoResponseDTO(Long id, String descricao, double valorTotal, String dataPedido) {
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
	
	
	
}
