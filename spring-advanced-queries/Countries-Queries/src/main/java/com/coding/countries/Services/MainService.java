package com.coding.countries.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coding.countries.Models.City;
import com.coding.countries.Models.Country;
import com.coding.countries.Models.Language;
import com.coding.countries.Repositories.CityRepository;
import com.coding.countries.Repositories.CountryRepository;
import com.coding.countries.Repositories.LanguageRepository;

@Service
public class MainService {
	private final LanguageRepository languageRepository;
	private final CityRepository cityRepository;
	private final CountryRepository countryRepository;
	public MainService(
			LanguageRepository languageRepository
			, CityRepository cityRepository
			, CountryRepository countryRepository) {
		this.languageRepository = languageRepository;
		this.cityRepository = cityRepository;
		this.countryRepository = countryRepository;
	}
	public List<Language> nehehe(){
		List<Language> result = languageRepository.nehehe();
		for (Language language:result){
			System.out.println(language.getLanguage());			
		}
		return result;
	}
	
//	1
	public List<Country> findCountriesByLanguagePercentDesc(String language){
		List<Language> initial = languageRepository.findCountriesByLanguageOrderByPercentageDesc(language);
		List<Country> result= new ArrayList<Country>();
		for(Language x: initial) {
			System.out.println("Language: "+ language +"/ Percentage: " + x.getPercentage()+" / Country : " + x.getCountry().getName()  );			
			result.add(x.getCountry());
		}
		return result;
	}

//	2
	public List<Object[]> allCountriesByCityCount(){
		List<Object[]> result = countryRepository.allCountriesByCityCount();
		for(Object[] row:result) {
			System.out.println(row[0] + " : " + row[1]);			
		}
		return result;
	}
	
// 	3 
	public List<City> findCitiesInCountryByPop(String country, int population){
		List<City> result = cityRepository.findCitiesInCountryByPop(country, population);
		for(City row: result) {
			System.out.println(row.getPopulation() +" : "+ row.getName());			
		}
		return result;
	}

// 	4
	public List<Language> findLanguagesByLiteracyGT(double pct){
		List<Language> result = languageRepository.findLanguagesByLiteracyGT(pct);
		for(Language row: result) {
			System.out.println(row.getPercentage() +" : "+ row.getLanguage());			
		}		
		return result;
	}

//	5
	public List<Country> countriesLTSurfaceAreaGTPopulation(double area, int population){
		List<Country> result = countryRepository.countriesLTSurfaceAreaGTPopulation(area, population);
		for(Country row: result) {
			System.out.println("Population : "+row.getPopulation() +" Surface Area : "+ row.getSurface_area() +" Country : " + row.getName());			
		}		
		return result;
	}
//	6
	public List<Country> findByGovtFormSurfaceGTLifeExGT(String govt, double area, double le){
		List<Country> result = countryRepository.findByGovtFormSurfaceGTLifeExGT(govt, area, le); 
		System.out.println(govt);
		for(Country row: result) {
			System.out.println(" Country : " + row.getName() + " / Area : "+ row.getSurface_area() +" / Life Expectancy" + row.getLife_expaectancy());			
		}		
		return result;
	}	
//	7
	public List<City> findCityByDistrict(String district, int population){
		List<City> result = cityRepository.findCityByDistrict(district, population);
		System.out.println("Country : "+ result.get(0).getCountry().getName() );
		for(City row: result) {
			System.out.println(" City : " + row.getName() + " / District" + row.getDistrict());			
		}		
		
		return result;
	}
// 8 
	public 	List<Object[]> countryByRegionCnt(){
		List<Object[]> result = countryRepository.countryByRegionCnt();
		for(Object[] row:result) {
			System.out.println(row[0] +" " + row[1]);					
		}
		return result;
	}

	
}
