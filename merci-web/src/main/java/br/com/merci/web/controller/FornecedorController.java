package br.com.merci.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.merci.core.service.FornecedorService;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController extends AbstractController {
	
	private static final String FORNECEDOR_LIST = "pages/fornecedor/fornecedor-list";
	private static final String FORNECEDOR_ADD = "pages/fornecedor/fornecedor-add";
	
	@Autowired
	private FornecedorService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("fornecedores", service.findAll());
		return FORNECEDOR_LIST;
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		return FORNECEDOR_ADD;
	}

}
