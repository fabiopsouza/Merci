package br.com.merci.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends AbstractController {

	private static final String USUARIO_LIST = "pages/usuario/usuario-list";
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(){
		return USUARIO_LIST;
	}
	
}
