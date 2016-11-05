package br.com.merci.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.merci.domain.model.Fornecedor;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController extends ParentController {

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("fornecedores", (List<Fornecedor>) getObject("fornecedor"));
		return "fornecedor/index";
	}

}