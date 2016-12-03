package br.com.merci.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.merci.domain.model.Estado;
import br.com.merci.store.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;
	
	public Iterable<Estado> findAll(){
		return repository.findAll();
	}
	
	public Estado findOne(Long id){
		return repository.findOne(id);
	}
	
	public void save(Estado estado){
		repository.save(estado);
	}
	
	public void delete(Long id){
		repository.delete(id);
	}
	
}
