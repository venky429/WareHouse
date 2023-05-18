package com.example.CSV_FileOperations.serviceImpl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.CSV_FileOperations.model.Product;
import com.example.CSV_FileOperations.service.ProductService;

//@Service
public class ExaMPLE implements ProductService {

	@Override
	public String saveAllProducts(MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveProctsFromCSV(Map<String, Product> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getProductExportToCSVfile() {
		// TODO Auto-generated method stub
		
	}

}
