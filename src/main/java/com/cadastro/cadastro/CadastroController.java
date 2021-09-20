package com.cadastro.cadastro;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class CadastroController {

	@Autowired
	private ClientesRepos clientesRepos;

	@GetMapping("/clientesRepos")
	// @ResponseStatus(HttpStatus.BAD_REQUEST)
	public ModelAndView Lista() {

		ModelAndView modelAndView = new ModelAndView("clientes/cadastro");

		modelAndView.addObject("clientesRepos", clientesRepos.findAll());

		return modelAndView;

	}

	@PostMapping("/clientesRepos")
	@ResponseStatus(HttpStatus.CREATED)
	public String salvar(@Valid Clientes clientes) {
		Clientes clientesEncontrarcpf = clientesRepos.findClientesBycpf(clientes.getCpf());
		Clientes clientesEncontrargmail = clientesRepos.findClientesByemail(clientes.getEmail());
		this.clientesRepos.save(clientes);
		return "redirect:/clientesRepos";

	}

}
