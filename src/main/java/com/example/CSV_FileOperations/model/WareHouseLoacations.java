package com.example.CSV_FileOperations.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class WareHouseLoacations {

	@Id
	@GenericGenerator(name="uuid-gen",strategy = "uuid2")
	@GeneratedValue(generator = "uuid-gen")
	private String id;


//	private Product product;
	private String location;
	@ManyToOne
	private WareHouse warehouse;
}

