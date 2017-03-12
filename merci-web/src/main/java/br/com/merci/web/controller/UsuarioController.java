package br.com.merci.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends AbstractController {

	public UsuarioController() {
		super("usuario");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(){
		return BASE_PATH + "usuario";
	}
	
}
