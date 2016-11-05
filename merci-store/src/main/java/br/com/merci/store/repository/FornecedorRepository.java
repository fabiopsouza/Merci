package br.com.merci.store.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.merci.domain.model.Fornecedor;

public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {
	
}
