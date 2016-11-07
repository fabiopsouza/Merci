package br.com.merci.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.merci.store.repository.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository repository;
	
	public List<String> buscarPerfisPeloNomeUsuario(String nomeUsuario){
		return repository.buscarPerfisPeloNomeUsuario(nomeUsuario);
	}
	
}
