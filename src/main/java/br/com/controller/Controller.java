package br.com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.model.Cars;
import br.com.model.Factories;
import br.com.repository.Repository;

@org.springframework.stereotype.Controller
@RequestMapping("/factories/")
public class Controller {

	@Autowired
	private Repository repo;

	@GetMapping("inicio")
	public String index() {
		return "index";
	}

	@GetMapping("cadastrar")
	public String index(Factories factory) {
		return "add";
	}

	@PostMapping("add")
	public String add(@RequestParam("planilha") MultipartFile planilha, @Validated Factories factory, Cars cars,
			BindingResult result, Model model) throws Exception {
		factory.getName();
		if (result.hasErrors()) {
			return "add";

		}
		String fileName = planilha.getOriginalFilename();
		factory.setDocName(fileName);
		
		this.repo.save(factory);
		this.repo.save(cars);
		if(factory.equals(cars)) {
			System.out.println("sao objetos iguais");
		} else{
		System.out.println("São objetos diferentes");
		}
		return "redirect:list";
	}

	@GetMapping("listar")
	public String listarTodos(Model model, Factories factories,Cars cars) {
		model.addAttribute("factories", this.repo.findAll());
		model.addAttribute("cars",this.repo.findAll());
		return "list";

	}
	@PostMapping("/searcher_code")
	public String getCountryCode(@RequestParam("country_code") String country_code, Model model, Factories factories) {
		Optional<Factories> fact = repo.findByCountryCode(country_code);
		if (fact.isPresent()) {
			model.addAttribute("facts", fact.get());
		}
		return ("pesquisar");
	}

	@GetMapping("editar/{id}")
	public String update(@PathVariable("id") long id, Model model) {
		Factories factories = this.repo.findById(id).orElseThrow(() -> new IllegalArgumentException("factories invalid"+id));
		model.addAttribute("factories", factories);
		return "update";
	}
	@PostMapping("atualizar{id}")
	public String atualiza(@PathVariable("id")long id, @Validated Factories factories, BindingResult result, Model model) {
		if(result.hasErrors()) {
			factories.setId(id);
			return "update";
		}
		this.repo.save(factories);
		repo.save(factories);
		model.addAttribute("factories",this.repo.findAll());
		return "list";
	}

	@GetMapping("deletar/{id}")
	public String deleta(@PathVariable("id") long id, Model model) {
		Factories factories = this.repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("teste deleta" + id));
		this.repo.delete(factories);
		model.addAttribute("factorie", this.repo.findAll());
		return "list";
	}
}
