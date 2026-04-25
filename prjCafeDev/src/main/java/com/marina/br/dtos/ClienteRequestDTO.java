package com.marina.br.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClienteRequestDTO {
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
	private String email;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
