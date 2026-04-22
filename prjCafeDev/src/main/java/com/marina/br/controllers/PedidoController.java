package com.marina.br.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marina.br.dtos.PedidoRequestDTO;
import com.marina.br.dtos.PedidoResponseDTO;
import com.marina.br.services.PedidoService;

@RestController
@RequestMapping("/produto")
public class PedidoController {
	private final PedidoService service;


	public PedidoController(PedidoService service) {
		this.service = service;
	}

	

	@PostMapping
	public PedidoResponseDTO salvar(@RequestBody PedidoRequestDTO dto) {
		return service.salvar(dto);
	}

	

	@GetMapping("/{id}")
	public PedidoResponseDTO buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	
	@GetMapping
	public List<PedidoResponseDTO>listar(){
		return service.listar();
	}

}

