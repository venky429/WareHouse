package com.example.CSV_FileOperations.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.CSV_FileOperations.service.WareHouseService;

@Configuration
@EnableScheduling
public class WareHouseSchedular {

	@Autowired
	private WareHouseService warehouseService;
	
	@Scheduled(cron ="0 0/2 * * * *")
	public void warehouseSchedular() {
		System.out.println("cron job");
		warehouseService.warehouseSchedular();
	}
	
}
