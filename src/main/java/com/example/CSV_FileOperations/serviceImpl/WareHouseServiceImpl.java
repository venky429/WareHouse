package com.example.CSV_FileOperations.serviceImpl;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CSV_FileOperations.model.Product;
import com.example.CSV_FileOperations.model.WareHouse;
import com.example.CSV_FileOperations.repo.ProductRepository;
import com.example.CSV_FileOperations.repo.WareHouseRepository;
import com.example.CSV_FileOperations.service.WareHouseService;

@Service
public class WareHouseServiceImpl implements WareHouseService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private WareHouseRepository wareHouseRepo;

	@Override
	public void warehouseSchedular() {
		List<Product> prods = (productRepo.findAll());
		WareHouse warehouse = new WareHouse();
		for (Product prod : prods) {
		
			int q = 0;
			if (wareHouseRepo.findAll().size() > 0) {
				warehouse = wareHouseRepo.findByProductSKU(prod.getProductSKU());
				if (warehouse != null && warehouse.getQuantity() > 0) {
					if(warehouse.getQuantity()>=80) {
						warehouse.setLoc("B");
						int A_count=prod.getQuantity();
						int b_count=0;
					warehouse.setQuantity(prod.getQuantity() + warehouse.getQuantity());
					}
					else {
						warehouse.setQuantity(prod.getQuantity() + warehouse.getQuantity());
					}
					
				}
				 else {
					 warehouse = new WareHouse();
						warehouse.setLoc("A");
						warehouse.setProductSKU(prod.getProductSKU());
						warehouse.setQuantity(prod.getQuantity());
					}
			} else {
				warehouse.setLoc("A");
				warehouse.setProductSKU(prod.getProductSKU());
				warehouse.setQuantity(prod.getQuantity());
			}

			System.out.println(warehouse);
			wareHouseRepo.save(warehouse);
			warehouse=null;
			System.gc();
			// System.out.println(prod);
		}

//		WareHouse warehouse=null;
//		for(Product prod : prods) {
//			System.out.println("for");
//			if(wareHouseRepo.findAll().size()>0) {
//				System.out.println("if > 0");
//		 warehouse=
//					wareHouseRepo.findByProductSKU(prod.getProductSKU());
//		 if( warehouse.getProductSKU()!=null) {
//			 System.out.println(" if not null");
//				warehouse.setQuantity(prod.getQuantity()+warehouse.getQuantity());
//			
//		 }}else {
//			 System.out.println("else");	
//			 warehouse=new WareHouse();
//				warehouse.setProductSKU(prod.getProductSKU());
//				warehouse.setQuantity(prod.getQuantity());
//				warehouse.setLoc("a");
//			}
//			wareHouseRepo.save(warehouse);
//			warehouse=new WareHouse();
//		}

	}

	public String setLocationForProduct() {
		return null;
	}

}
