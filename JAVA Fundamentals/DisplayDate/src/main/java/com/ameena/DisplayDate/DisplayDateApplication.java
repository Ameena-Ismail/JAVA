package com.ameena.DisplayDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
@SpringBootApplication
@Controller
public class DisplayDateApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(DisplayDateApplication.class, args);
	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
		public String date(Model model) {
		java.util.Date Hi = new java.util.Date();
		Format time = new SimpleDateFormat("yyyy MM dd");//HH: 24hr,hh:12hr ,a:am or pm,

		model.addAttribute("Date", time.format(Hi));
		return"date.jsp";
}
	@RequestMapping("/time")
	public String thing(Model mstSystem) {
		Format time = new SimpleDateFormat("hh.mm.ss a");//HH: 24hr,hh:12hr ,a:am or pm,
		String tt = time.format(new Date());

		mstSystem.addAttribute("timeNow",tt);
		return "time.jsp";
	}
}

