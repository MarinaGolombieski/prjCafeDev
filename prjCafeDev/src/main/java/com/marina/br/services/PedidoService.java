package com.marina.br.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.marina.br.dtos.PedidoRequestDTO;
import com.marina.br.dtos.PedidoResponseDTO;
import com.marina.br.entities.Cliente;
import com.marina.br.entities.Pedido;
import com.marina.br.repositories.ClienteRepository;
import com.marina.br.repositories.PedidoRepository;

@Service
public class PedidoService {
private final PedidoRepository pedidorepository;

private final ClienteRepository clienteRepository;

	public PedidoService(PedidoRepository pedidorepository, ClienteRepository clienteRepository) {
		this.pedidorepository = pedidorepository;
		this.clienteRepository = clienteRepository;
	}
	
	public PedidoResponseDTO salvar(PedidoRequestDTO dto) {

	    Cliente cliente = clienteRepository.findById(dto.getClienteId())
	        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

	    if (dto.getValorTotal() <= 0) {
	        throw new RuntimeException("Valor deve ser maior que zero");
	    }

	    Pedido pedido = new Pedido();
	    pedido.setDescricao(dto.getDescricao());
	    pedido.setValorTotal(dto.getValorTotal());
	    pedido.setDataPedido(dto.getDataPedido());
	    pedido.setCliente(cliente); // ← ESSENCIAL

	    Pedido salvo = pedidorepository.save(pedido);

	    return new PedidoResponseDTO(
	        salvo.getId(),
	        salvo.getDescricao(),
	        salvo.getValorTotal(),
	        salvo.getDataPedido()
	    );
	}
	
	public  PedidoResponseDTO buscarPorId(Long id) {
		Pedido pedido = pedidorepository.findById(id).orElseThrow(()-> new RuntimeException("Pedido não encontrado"));
	
		return new PedidoResponseDTO(
				pedido.getId(),
				pedido.getDescricao(),
				pedido.getValorTotal(),
				pedido.getDataPedido()
				);
	}
	
	public List<PedidoResponseDTO> listar(){
	    return pedidorepository.findAll()
	        .stream()
	        .map(pedido -> new PedidoResponseDTO(
	            pedido.getId(),
	            pedido.getDescricao(),
	            pedido.getValorTotal(),
	            pedido.getDataPedido()
	        ))
	        .collect(Collectors.toList());
	}
}

