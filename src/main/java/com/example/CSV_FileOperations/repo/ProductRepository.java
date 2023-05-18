package com.example.CSV_FileOperations.repo;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CSV_FileOperations.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>  {

	

}
