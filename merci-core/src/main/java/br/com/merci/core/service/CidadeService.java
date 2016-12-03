package br.com.merci.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.merci.domain.model.Cidade;
import br.com.merci.store.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public Iterable<Cidade> findAll(){
		return repository.findAll();
	}
	
	public Cidade findOne(Long id){
		return repository.findOne(id);
	}	
	
	public void save(Cidade cidade){
		repository.save(cidade);
	}
	
	public void delete(Long id){
		repository.delete(id);
	}
}
