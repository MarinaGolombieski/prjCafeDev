package com.marina.br.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.marina.br.dtos.ClienteRequestDTO;
import com.marina.br.dtos.ClienteResponseDTO;
import com.marina.br.entities.Cliente;
import com.marina.br.repositories.ClienteRepository;

@Service
public class ClienteService {
private final ClienteRepository clienterepository;
	
	public ClienteService(ClienteRepository clienterepository) {
		this.clienterepository = clienterepository;
		
	}
	
	public ClienteResponseDTO salvar(ClienteRequestDTO dto) {
		Cliente cliente = new Cliente();
		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		
		Cliente salvo  = clienterepository.save(cliente);
		
		return new ClienteResponseDTO(
				salvo.getId(),
				salvo.getNome(),
				salvo.getEmail()
				);	
	}

	
	public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {
    Cliente cliente = clienterepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

    cliente.setNome(dto.getNome());
    cliente.setEmail(dto.getEmail());

    Cliente atualizado = clienterepository.save(cliente);

    return new ClienteResponseDTO(
        atualizado.getId(),
        atualizado.getNome(),
        atualizado.getEmail()
    );
}

	
public void deletar(Long id) {
    clienterepository.deleteById(id);
}


	
		public  ClienteResponseDTO buscarPorId(Long id) {
			Cliente cliente = clienterepository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
		
			return new ClienteResponseDTO(
				cliente.getId(),
				cliente.getNome(),
				cliente.getEmail()
				);
		}	

	public List <ClienteResponseDTO> listar(){
		return clienterepository.findAll()
				.stream()
				.map(cliente -> new ClienteResponseDTO(
						cliente.getId(),
						cliente.getNome(),
						cliente.getEmail()
						))
				.collect(Collectors.toList());
	}
}

