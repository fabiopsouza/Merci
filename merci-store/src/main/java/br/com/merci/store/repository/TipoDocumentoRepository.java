package br.com.merci.store.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.merci.domain.model.TipoDocumento;

public interface TipoDocumentoRepository extends CrudRepository<TipoDocumento, Long> {
	
}
