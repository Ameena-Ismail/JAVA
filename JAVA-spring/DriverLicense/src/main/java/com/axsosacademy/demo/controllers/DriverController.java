package com.axsosacademy.demo.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsosacademy.demo.models.License;
import com.axsosacademy.demo.models.Person;
import com.axsosacademy.demo.services.LicenseServices;
import com.axsosacademy.demo.services.PersonServices;
;

@Controller
public class DriverController {
	private final PersonServices personService;
	private final LicenseServices licenseService;
	public DriverController(PersonServices personService, LicenseServices licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}

	@RequestMapping("/")
	public String index() {
		return "redirect:/person/new";
	}

	
	@RequestMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "index.jsp";
	}
	
	//create a Person
	@RequestMapping(value = "/create/person", method = RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {

			personService.createPerson(person);
			return "redirect:/person/new";
		}
	}
	


	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license")License license, Model model) {
		List<Person> listPerson = personService.findAll();
		model.addAttribute("persons", listPerson);
		return "license.jsp";
	}
	
	//create license
	@RequestMapping(value="/licenses/create", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license")License license, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/licenses/new";
		}else {
			licenseService.createLicense(license);
			return "redirect:/";
		}
		
	}
	//render user profile
	@RequestMapping("/person/{id}")
	public String showProfile(@PathVariable("id")Long id, Model model) {
		Person findPerson = personService.findPerson(id);
		if (findPerson == null) {
			return "redirect:/";
		}else {
			model.addAttribute("person", findPerson);
			return "result.jsp";
		}
		
	}
	
	
	
}