package com.conectavel.projetc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conectavel.projetc.repository.EnderecoRepository;

@Service
public class EnderecoService {
	private final EnderecoRepository enderecoRepository;
	
	@Autowired
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	
}
