package com.coding.countries.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coding.countries.Models.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

	//	Display total number of cities for each country
	@Query(value="select count(ct.id) , c.name from countries c join cities ct on c.id=ct.country_id group by c.name order by 1 desc;", nativeQuery=true)
	List<Object[]> allCountriesByCityCount();

//	get all the countries with Surface Area below 501 and Population greater than 100,000?
	@Query(value="select c from Country c where c.surface_area < ?1 and c.population > ?2 Order by c.population desc")
	List<Country> countriesLTSurfaceAreaGTPopulation(double area, int population);

//get countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years?
	@Query(value="SELECT c from Country c where c.government_form=?1 and c.surface_area >?2 and life_expectancy > ?3")
	List<Country> findByGovtFormSurfaceGTLifeExGT(String govt, double area, double le);
	
// Summarize the number of countries in each region, descending order.
	@Query(value="select count(*), region from countries group by region order by 1 desc", nativeQuery=true)	
	List<Object[]> countryByRegionCnt();


}
