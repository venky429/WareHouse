package com.example.CSV_FileOperations.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.CSV_FileOperations.model.Product;

public interface ProductService {

	String saveAllProducts(MultipartFile file);

	String saveProctsFromCSV(Map<String, Product> map);

	void getProductExportToCSVfile();

}
