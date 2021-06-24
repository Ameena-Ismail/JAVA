package com.coding.countries.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coding.countries.Models.Language;

public interface LanguageRepository extends CrudRepository<Language,Long>{
	
	@Query(value="SELECT * from languages", nativeQuery=true)
	List<Language> nehehe();

	@Query(value="SELECT * from languages  where language =?1 Order by percentage desc", nativeQuery=true)
    List<Language> findCountriesByLanguageOrderByPercentageDesc(String language);

//	get all languages in each country with a percentage greater than 89%? Your query should arrange the result by percentage in descending order.
	@Query(value="select l.* from countries c join languages l on c.id= l.country_id where l.percentage > ?1 order by l.percentage desc", nativeQuery=true)
	List<Language> findLanguagesByLiteracyGT(double pct);
	
}
