package br.com.merci.web.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.merci.domain.model.Usuario;
import br.com.merci.web.http.HttpProxy;
import br.com.merci.web.security.model.CustomUserDetails;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private HttpProxy proxy;

	@Override
	@SuppressWarnings("unchecked")
	public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {

		Usuario usuario = (Usuario) proxy.getObject("usuario/" + nomeUsuario);

		if (usuario == null)
			throw new UsernameNotFoundException("Usuário não encontrado com o nome: " + nomeUsuario);

		List<String> perfis = (List<String>) proxy.getObject("perfil/" + nomeUsuario);

		return new CustomUserDetails(usuario, perfis);
	}

}
