package br.com.merci.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Cidade> findAllPageable(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public Page<Cidade> findByNomeLikeIgnoreCasePageable(String nome, Pageable pageable){
		return repository.findByNomeLikeIgnoreCase("%" + nome + "%", pageable);
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
