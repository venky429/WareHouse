//package com.example.CSV_FileOperations.config;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.example.CSV_FileOperations.model.Product;
//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvException;
//
//public class CSVConfig {
//
//	public List<Product> readCsvData(String filePath) throws IOException, CsvException {
//        List<Product> persons = new ArrayList<>();
//        
//        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
//            String[] line;
//            reader.skip(1); // Skip the header line
//            
//            while ((line = reader.readNext()) != null) {
//            	Product person = new Product();
//                person.setId(line[0]);
//                person.setName(line[1]);
//                person.setAge(Integer.parseInt(line[2]));
//                
//                persons.add(person);
//            }
//        }
//        
//        return persons;
//    }
//}
