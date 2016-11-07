package br.com.merci.web.security.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import br.com.merci.domain.model.Usuario;

public class CustomUserDetails extends Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	private List<String> nomesPerfil;

	public CustomUserDetails(Usuario usuario, List<String> nomesPerfil) {
		super(usuario);
		this.nomesPerfil = nomesPerfil;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String perfis = StringUtils.collectionToCommaDelimitedString(nomesPerfil);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(perfis);
	}

	@Override
	public String getPassword() {
		return super.getSenha();
	}

	@Override
	public String getUsername() {
		return super.getNome();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return super.getAtivo();
	}

}
