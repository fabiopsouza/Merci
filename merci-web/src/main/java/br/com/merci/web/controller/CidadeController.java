package br.com.merci.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.merci.domain.exception.HttpResponseException;
import br.com.merci.web.proxy.CidadeProxy;

@Controller
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	private CidadeProxy proxy;

	private static final String CIDADE_LIST = "pages/cidade/cidade-list";
	private static final String CIDADE_ADD = "pages/cidade/cidade-add";

	@RequestMapping(value = {"", "/", "{page}", "{page}/{size}"}, method = RequestMethod.GET)
	public String list(Model model, @PathVariable Optional<Integer> page, @PathVariable Optional<Integer> size) {

		try {
			int pageNumber = page.isPresent() ? page.get() : 0;
			int limitSize = size.isPresent() ? size.get() : 5;
			
			model.addAttribute("pageableCidade", proxy.listPageable(pageNumber, limitSize));
		} catch (HttpResponseException e) {
			// TODO implement
		}

		return CIDADE_LIST;
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		return CIDADE_ADD;
	}

}
