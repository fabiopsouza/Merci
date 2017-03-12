package br.com.merci.web.controller;

public abstract class AbstractController {

	protected String BASE_PATH = "pages/";
	
	public AbstractController() {
		BASE_PATH = BASE_PATH + "/";
	}
	
	public AbstractController(String rootPath) {
		BASE_PATH = BASE_PATH + rootPath + "/";
	}
	
}
