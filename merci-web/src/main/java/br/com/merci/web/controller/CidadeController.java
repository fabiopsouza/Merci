package br.com.merci.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.merci.core.service.CidadeService;
import br.com.merci.domain.bean.PageImplBean;
import br.com.merci.domain.model.Cidade;

@Controller
@RequestMapping("/cidade")
public class CidadeController extends AbstractController {

	@Autowired
	private CidadeService service;

	private static final String CIDADE_LIST = "pages/cidade/cidade-list";
	private static final String CIDADE_ADD = "pages/cidade/cidade-add";
	
	@RequestMapping(value = {"", "/", "{page}", "{page}/{size}", "{page}/{size}/{nome}"}, method = RequestMethod.GET)
	public String list(Model model, @PathVariable Optional<Integer> page, @PathVariable Optional<Integer> size, @PathVariable Optional<String> name) {

		int pageNumber = page.isPresent() ? page.get() : 0;
		int limitSize = size.isPresent() ? size.get() : 5;
		String nome = name.isPresent() ? name.get() : "";
		
		PageImplBean<Cidade> pageableCidade = service.findByNomeLikeIgnoreCasePageable(nome, new PageRequest(pageNumber, limitSize));
		
		model.addAttribute("pageableCidade", pageableCidade);
		
		return CIDADE_LIST;
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		return CIDADE_ADD;
	}

}
