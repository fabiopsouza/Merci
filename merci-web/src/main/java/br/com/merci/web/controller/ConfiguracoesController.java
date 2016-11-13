package br.com.merci.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/settings")
public class ConfiguracoesController {

	@RequestMapping(method = RequestMethod.GET)
	public String home(){
		return "pages/configuracoes/settings";
	}
	
}
