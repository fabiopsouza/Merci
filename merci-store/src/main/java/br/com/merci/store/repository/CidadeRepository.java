package br.com.merci.store.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.merci.domain.model.Cidade;

public interface CidadeRepository extends PagingAndSortingRepository<Cidade, Long> {
	
	Page<Cidade> findByNomeLikeIgnoreCase(String nome, Pageable pageable);
	
}
