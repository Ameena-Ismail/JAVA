package com.coding.countries.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coding.countries.Models.City;

public interface CityRepository extends CrudRepository<City, Long>{
//All the cities in Mexico with a population of greater than 500,000? Your query should arrange the result by population in descending order.
	@Query(value="select * from cities where country_id in(select id from countries where name=?1) and population > ?2 order by population desc",nativeQuery=true)
	List<City> findCitiesInCountryByPop(String country, int population);

//	Get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000. return the Country Name, City Name, District, and Population.
	@Query(value="SELECT c from City c  where district = ?1 and population > ?2")
	List<City> findCityByDistrict(String district, int population);	
}
