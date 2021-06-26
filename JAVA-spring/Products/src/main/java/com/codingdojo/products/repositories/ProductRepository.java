package com.codingdojo.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.products.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
