package br.com.merci.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.merci.domain.model.Fornecedor;
import br.com.merci.web.http.HttpProxy;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {

	@Autowired
	private HttpProxy proxy;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("fornecedores", (List<Fornecedor>) proxy.getObject("fornecedor"));
		return "fornecedor/fornecedor-list";
	}

}