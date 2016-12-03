package br.com.merci.store.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.merci.domain.model.Estado;

public interface EstadoRepository extends CrudRepository<Estado, Long> {
	
}
