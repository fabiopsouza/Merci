package br.com.merci.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.merci.domain.http.HttpResponse;
import br.com.merci.domain.model.Perfil;
import br.com.merci.domain.model.Usuario;
import br.com.merci.web.http.HttpProxy;
import br.com.merci.web.security.model.CustomUserDetails;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private HttpProxy proxy;

	@Override
	public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {

		try {
			HttpResponse responseUsuario = proxy.getObject("usuario/" + nomeUsuario, Usuario.class);
		
			Usuario usuario = (Usuario) responseUsuario.getData();
	
			if (usuario == null)
				throw new UsernameNotFoundException("Usuário não encontrado com o nome: " + nomeUsuario);
	
			List<String> perfis = getPerfisFrom(usuario);
		
			return new CustomUserDetails(usuario, perfis);
			
		} catch (Exception e) {
			return null;
		}
	}

	private List<String> getPerfisFrom(Usuario usuario) {
		
		//TODO tranformar em lambda!
		List<String> perfis = new ArrayList<>();
		
		for (Perfil perfil : usuario.getPerfis()) {
			perfis.add(perfil.getNome());
		}
		
		return perfis;
	}

}