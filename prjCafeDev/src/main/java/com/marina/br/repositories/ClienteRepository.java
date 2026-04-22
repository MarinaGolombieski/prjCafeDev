package com.marina.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marina.br.entities.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}

