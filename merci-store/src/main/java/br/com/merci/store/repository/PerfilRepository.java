package br.com.merci.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.merci.domain.model.Perfil;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Long> {

	@Query("select p.nome from Usuario u left join u.perfis p where u.nome = ?1")
	public List<String> buscarPerfisPeloNomeUsuario(String nomeUsuario);
	
}
