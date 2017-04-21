package br.com.merci.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController extends AbstractController {
	
	private static final String HOME = "pages/home";
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(){
		return HOME;
	}
	
}
