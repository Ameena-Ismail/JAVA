package com.coding.countries.Controllers;

import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.countries.Models.Country;
import com.coding.countries.Services.MainService;

@Controller
public class MainController {
    public String star = String.join("", Collections.nCopies(25, "*"));
	private final MainService mainService;
	public MainController(MainService mainService) {
		this.mainService= mainService;
	}
	
	@RequestMapping("/")
	public String index  () {
				System.out.println("hit index");
				System.out.println(star);
// 1				
//		mainService.findCountriesByLanguagePercentDesc("Slovene");
//				System.out.println(star);
// 2
//		mainService.allCountriesByCityCount();
//				System.out.println(star);
// 3
//		mainService.findCitiesInCountryByPop("Mexico",500000);
//				System.out.println(star);
// 4 
//		mainService.findLanguagesByLiteracyGT(89);
//				System.out.println(star);
// 5 
//		mainService.countriesLTSurfaceAreaGTPopulation(501, 100000);
//				System.out.println(star);
//	6
//		mainService.findByGovtFormSurfaceGTLifeExGT("Constitutional Monarchy", 200,75);
//				System.out.println(star);
//	7
//		mainService.findCityByDistrict("Buenos Aires", 500000);
//				System.out.println(star);
//	8				
//		mainService.countryByRegionCnt();
//				System.out.println(star);
		return "index";
	}
}
