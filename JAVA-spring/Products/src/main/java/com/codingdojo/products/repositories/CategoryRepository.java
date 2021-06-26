package com.codingdojo.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.products.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	//CrudRepository<Model type, Id type>
}
