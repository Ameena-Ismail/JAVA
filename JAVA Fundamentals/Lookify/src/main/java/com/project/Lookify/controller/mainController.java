package com.project.Lookify.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Lookify.models.song;
import com.project.Lookify.services.SongService;

@Controller
public class mainController {
private final SongService songService;
public mainController(SongService service) {
	this.songService = service;
		}
	
	@RequestMapping("/")
	public String renderHome() {
		return "home.jsp";
	}
	@RequestMapping("/dashboard")
	public String renderaDashboard() {
		return "dashboard.jsp";
	}
	@RequestMapping("/songs/new")
	public String New(@ModelAttribute("song") song song) {
		return "/songs/new.jsp";
	}
	
	@RequestMapping(value="/songs", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("song") song song, BindingResult result) {
		
		if(result.hasErrors())
			return "/songs/new.jsp";
		SongService.addNew(song);
		return "redirect:/songs";
	}
		
	@RequestMapping("/songs/{id}")
		public String Show(@PathVariable("id") Long id, Model model) {
			model.addAttribute("song", songService.findSong(id));
			return "/songs/show.jsp";
	}
	
	@RequestMapping("/songs/topTen")
	public String TopTen(Model model) {
		model.addAttribute("songs", songService.topTenByRating());
		return "/songs/topTen.jsp";
	}
	
	
	
	

		@RequestMapping("/songs")
		public String Songs(Model model) {
			model.addAttribute("songs", songService.allSongs());
			return "/songs/songs.jsp";
		}

		}
		@RequestMapping("/songs/search")
		public String Search(@RequestParam("artist") String artist, Model model) {
			model.addAttribute("songs",	songService.songsContainingArtist(artist));
			model.addAttribute("artist", artist);
			return "/songs/search.jsp";
		}


		}

		@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
		public String Delete(@PathVariable("id") Long id) {
			songService.deleteSong(id);
			return "redirect:/songs";
		}
}





