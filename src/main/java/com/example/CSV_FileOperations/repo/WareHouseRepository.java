package com.example.CSV_FileOperations.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.CSV_FileOperations.model.WareHouse;

public interface WareHouseRepository extends JpaRepository<WareHouse,Integer> {

	WareHouse findByProductSKU(String productSKU);

	@Query(nativeQuery=true,value="select sum(quantity) from WareHouse")
	public int getSumofAllProductsINWareHouse();
}
