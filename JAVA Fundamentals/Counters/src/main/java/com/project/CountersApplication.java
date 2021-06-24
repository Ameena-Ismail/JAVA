package com.project;

import javax.servlet.http.HttpSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class CountersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountersApplication.class, args);
	}
	@RequestMapping("/")
    public String index(HttpSession session){

        Integer count = (Integer) session.getAttribute("count");


        if(session.isNew()) {
        session.setAttribute("count",0);}
        else {
            Integer visit = (Integer) session.getAttribute("count");
            visit += 1;
            session.setAttribute("count", visit);
        }
       return "index.jsp"; 
	}
	
	  @RequestMapping("/counter")
	    public String COUNT(Model model,HttpSession session) {
	        model.addAttribute("counter", session.getAttribute("count"));
	        return "counter.jsp";
	    }

}

