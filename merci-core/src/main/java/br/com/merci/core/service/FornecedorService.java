package br.com.merci.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.merci.domain.model.Fornecedor;
import br.com.merci.store.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;
	
	public Iterable<Fornecedor> findAll(){
		return repository.findAll();
	}
	
	public Fornecedor findOne(Long id){
		return repository.findOne(id);
	}
	
	public void save(Fornecedor fornecedor){
		repository.save(fornecedor);
	}
	
	public void delete(Long id){
		repository.delete(id);
	}
	
}
