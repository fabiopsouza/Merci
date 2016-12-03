package br.com.merci.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.merci.domain.model.TipoDocumento;
import br.com.merci.store.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository repository;
	
	public Iterable<TipoDocumento> findAll(){
		return repository.findAll();
	}
	
	public TipoDocumento findOne(Long id){
		return repository.findOne(id);
	}
	
	public void save(TipoDocumento tipoDocumento){
		repository.save(tipoDocumento);
	}
	
	public void delete(Long id){
		repository.delete(id);
	}
	
}
