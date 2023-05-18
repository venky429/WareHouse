package com.example.CSV_FileOperations.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.CSV_FileOperations.model.Product;
import com.example.CSV_FileOperations.repo.ProductRepository;
import com.example.CSV_FileOperations.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductRepository repo;

	@Autowired
	ProductService service;

	@PostMapping("/uploadCsvFileData")
	public String uploadCsvFileData(@RequestParam MultipartFile file) throws IOException {
			Map<String, Product> map = new HashMap<>();
		if (file.getContentType().equals("text/csv")) {
	
			try {
				BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

				Iterable<CSVRecord> csvRecord = csvParser.getRecords();
				Product product = new Product();
				for (CSVRecord record : csvRecord) {
					System.out.println(record);
					System.out.println("record.get(\"SKU\")"+record.get("SKU"));
					if (map.get(record.get("SKU")) != null) {
						
						product = map.get(record.get("SKU"));
						
						if (!record.get("DESCRIPTION").isEmpty() && record.get("DESCRIPTION") != " ")
							product.setDescription(record.get("DESCRIPTION"));
						if (!record.get("PRICE").isEmpty() && record.get("PRICE") != "0") {
							System.out.println(record.get("PRICE"));
							product.setPrice(Double.parseDouble(record.get("PRICE")));
							
						}
						if (!record.get("QUANTITY").isEmpty() && record.get("QUANTITY") != "0")
							product.setQuantity(Integer.parseInt(record.get("QUANTITY")));
					} else {
					//	System.out.println(record.get("PRICE"));
						product.setProductSKU(record.get("SKU"));
						String price=record.get("PRICE").replaceAll(",", "");
						product.setPrice(Double.parseDouble(price));
						product.setDescription(record.get("DESCRIPTION"));
						product.setQuantity(Integer.parseInt(record.get("QUANTITY")));

					}
					System.out.println(record.get("SKU"));
					String key=record.get("SKU");
					map.put(key, product);
				product=new Product();

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			for(Product p: map.values())
				System.out.println("map : "+p);
			return service.saveProctsFromCSV(map);

		} else
			return "give valid source file";

	}

	@PostMapping("/saveProducts")
	public String saveAllProucts(@RequestParam("file") MultipartFile file) {
		System.out.println("entered into controller method");
		System.out.println(file.getOriginalFilename());
//		try (BufferedReader fileReader = new BufferedReader(new FileReader(file.getOriginalFilename()));
//			
//		        CSVParser csvParser = new CSVParser(fileReader,
//		            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
//			System.out.println(file.getOriginalFilename());
//
//		      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//
//		      for (CSVRecord csvRecord : csvRecords) {
//		    	  System.out.println(csvRecord);
//		      }
//
//		    //  return developerTutorialList;
//		    } catch (IOException e) {
//		      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
//		    }

		try {
			// BufferedReader fileReader = new BufferedReader(file);
			FileReader fr = new FileReader(file.getOriginalFilename());
			BufferedReader fileReader = new BufferedReader(new FileReader(file.getOriginalFilename()));
//			CSVParser csvParser = new CSVParser(fileReader,
//		            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
//			System.out.println(file.getOriginalFilename());
//
			CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				System.out.println(csvRecord);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return service.saveAllProducts(file);
	}
	
	
	
	
	@GetMapping("/products")
	public ResponseEntity<?> getProductsCsvFile(){
		service.getProductExportToCSVfile();
		
		return null;
	}

}
