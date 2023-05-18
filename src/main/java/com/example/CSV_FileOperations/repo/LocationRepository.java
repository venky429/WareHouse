package com.example.CSV_FileOperations.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CSV_FileOperations.model.WareHouseLoacations;

public interface LocationRepository extends JpaRepository<WareHouseLoacations, String> {

}
