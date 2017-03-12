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

	public FornecedorController() {
		super("fornecedor");
	}
	
	@Autowired
	private FornecedorService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("fornecedores", service.findAll());
		return BASE_PATH + "fornecedor-list";
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		return BASE_PATH + "fornecedor-add";
	}

}
