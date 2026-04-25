package com.marina.br.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.marina.br.dtos.ClienteRequestDTO;
import com.marina.br.dtos.ClienteResponseDTO;
import com.marina.br.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	private final ClienteService service;


	public ClienteController(ClienteService service) {
		this.service = service;
	}

	

	@PostMapping
	public ClienteResponseDTO salvar(@RequestBody @Valid ClienteRequestDTO dto) {
		return service.salvar(dto);
	}

	

	@GetMapping("/{id}")
	public ClienteResponseDTO buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}
	

	@PutMapping("/{id}")
	public ClienteResponseDTO atualizar(@PathVariable Long id, @RequestBody ClienteRequestDTO dto) {
    return service.atualizar(id, dto);
}
	

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
    service.deletar(id);


		
	@GetMapping
	public List<ClienteResponseDTO>listar(){
		return service.listar();
	}

}

