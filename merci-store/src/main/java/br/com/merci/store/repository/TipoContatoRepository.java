package br.com.merci.store.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.merci.domain.model.TipoContato;

public interface TipoContatoRepository extends CrudRepository<TipoContato, Long> {
	
}
