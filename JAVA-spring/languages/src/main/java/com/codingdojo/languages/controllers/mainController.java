package com.codingdojo.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.codingdojo.languages.models.Languages;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class mainController {
	private final LanguageService languageService;

	public mainController(LanguageService languageService) {
		this.languageService = languageService;
	}

	// redirect to /languages
	@RequestMapping("/")
	public String redirectToIndex() {
		return "redirect:/languages";
	}

	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Languages language) {
		List<Languages> langs = languageService.allLanguages();
		model.addAttribute("languages", langs);
		return "index.jsp";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Languages language, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
			// must be rendering page, cannot be redirect otherwise errors would get thrown out
			// return "/languages"; does not work.
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}

	@RequestMapping("/languages/{id}")
	public String showLang(@PathVariable("id") Long id, Model model) {
		Languages lang = languageService.findLang(id);
		model.addAttribute("lang", lang);
		return "showLang.jsp";
	}

	// delete routing
	@RequestMapping("/languages/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}

	// edit routing
	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		// edit a form
		Languages lang = languageService.findLang(id);
		model.addAttribute("lang", lang);
		return "edit.jsp";
	}

	@RequestMapping("/update/{id}")
	public String update(@Valid @ModelAttribute("lang") Languages lang, BindingResult result) {
		languageService.createLanguage(lang);
		return "redirect:/languages";
				
	}
}
