package com.example.CSV_FileOperations.serviceImpl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.CSV_FileOperations.model.Product;
import com.example.CSV_FileOperations.repo.ProductRepository;
import com.example.CSV_FileOperations.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
List<?> l=new ArrayList();
	@Autowired
	private ProductRepository repo;
	
	@Override
	public String saveAllProducts(MultipartFile file) {
		
		return null;
	}

	@Override
	public String saveProctsFromCSV(Map<String, Product> map) {
		for(Product p: map.values()) {
	//		System.out.println("------------------------------");
			
	//		System.out.println(p);
			repo.save(p);
		}
//		Iterable<Product> itr=map.values();
//		repo.saveAll(itr);
		return "products inserted succesfully";
		
	}

	@Override
	public void getProductExportToCSVfile() {
		List<Product> products=repo.findAll();
		String fileName="products"+System.currentTimeMillis()+".txt";
		try (PrintWriter writer = new PrintWriter(new FileWriter("C:/Users/CIPL1355/Downloads/"+fileName));
	             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Id", "Description", "ProductSku","price","quantity"))) {
	            for (Product product : products) {
	                csvPrinter.printRecord(product.getId(), product.getDescription(), product.getProductSKU(), product.getPrice(),product.getQuantity());
	            }
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
