package br.com.merci.store.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.merci.domain.model.Cidade;

public interface CidadeRepository extends CrudRepository<Cidade, Long> {
	
}
