package com.codingdojo.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("gold")== null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", new ArrayList<String>());
			
			System.out.println("iam here : "+ session.getAttribute("gold"));
		}
			
		return "index.jsp";
	}
	@RequestMapping(value="/findgold", method=RequestMethod.POST)
	public String findGold(HttpSession session, @RequestParam(value="place") String place,Model model) {
		
		String timeStamp = new SimpleDateFormat("MMMMM dd yyyy HH:mm a").format(new Date());
		System.out.println(timeStamp);
		
		if(place.equals("farm")) {
			Integer randGold = getRandomGold(20,10);
//			System.out.println("Farm's random gold : "+randGold);
			Integer myGold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", myGold+randGold);
//			System.out.println(session.getAttribute("gold"));
			((ArrayList<String>) session.getAttribute("activities")).add("You entered a farm and earned "+randGold+" gold. ("+timeStamp+")");

		}else if (place.equals("cave")) {
			Integer randGold = getRandomGold(10,5);
//			System.out.println("Cave's random gold : "+randGold);
			Integer myGold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", myGold+randGold);
//			System.out.println(session.getAttribute("gold"));
			((ArrayList<String>) session.getAttribute("activities")).add("You entered a cave and earned "+randGold+" gold. ("+timeStamp+")");
		}else if (place.equals("house")) {
			Integer randGold = getRandomGold(5,2);
//			System.out.println("House's random gold : "+randGold);
			Integer myGold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", myGold+randGold);
//			System.out.println(session.getAttribute("gold"));
			((ArrayList<String>) session.getAttribute("activities")).add("You entered a house and earned "+randGold+" gold. ("+timeStamp+")");
		}else if(place.equals("casino")) {
			Integer randGold = getRandomGold(50,-50);
//			System.out.println("casino's random gold : "+randGold);
			Integer myGold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", myGold+randGold);
//			System.out.println(session.getAttribute("gold"));
			if(randGold<0) {
				((ArrayList<String>) session.getAttribute("activities")).add("You entered a Casino and lost "+randGold+" gold. Ouch .. ("+timeStamp+")");
			}else {
				((ArrayList<String>) session.getAttribute("activities")).add("You entered a Casino and won "+randGold+" gold. ("+timeStamp+")");
			}
		}	
		
		return "redirect:/";
	}
	
	
	//get random gold by calling this method 
	public int getRandomGold(int max, int min) {
		Random rand = new Random();
		int value = rand.nextInt((max-min)+1)+min;
		return value;
	}
}
