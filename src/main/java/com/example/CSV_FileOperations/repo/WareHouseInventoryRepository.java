package com.example.CSV_FileOperations.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CSV_FileOperations.model.WareHouseInventory;

@Repository
public interface WareHouseInventoryRepository extends JpaRepository<WareHouseInventory,Integer> {

}
