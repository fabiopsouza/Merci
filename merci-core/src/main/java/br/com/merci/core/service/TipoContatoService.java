package br.com.merci.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.merci.domain.model.TipoContato;
import br.com.merci.store.repository.TipoContatoRepository;

@Service
public class TipoContatoService {

	@Autowired
	private TipoContatoRepository repository;
	
	public Iterable<TipoContato> findAll(){
		return repository.findAll();
	}
	
	public TipoContato findOne(Long id){
		return repository.findOne(id);
	}
	
	public void save(TipoContato tipoContato){
		repository.save(tipoContato);
	}
	
	public void delete(Long id){
		repository.delete(id);
	}
	
}
