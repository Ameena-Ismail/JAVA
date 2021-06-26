package com.codingdojo.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DojoController2 {
	public static void main(String[] args) {
		SpringApplication.run(DojoController2.class, args);
	}
	
	@RequestMapping("/{track}")
    public String showLesson(@PathVariable("track") String track){
    	if (track.equals("dojo")){
    		track = "The dojo is awesome!";
    	}else if (track.equals("burbank-dojo")) {
    		track = "Burbank Dojo is located in Southern California"; 
    	}else if (track.equals("san-jose")) {
    		track= "SJ dojo is the headquearters";		
    	}
    	return track;
    }
}
