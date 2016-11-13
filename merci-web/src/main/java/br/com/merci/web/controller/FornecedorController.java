package br.com.merci.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.merci.domain.exception.HttpResponseException;
import br.com.merci.web.proxy.FornecedorProxy;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorProxy proxy;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		
		try {
			model.addAttribute("fornecedores", proxy.list());
		} catch (HttpResponseException e) {
			// TODO implement
		}
		
		return "pages/fornecedor/fornecedor-list";
	}

}