package com.example.CSV_FileOperations.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {

	@Id
	@GenericGenerator(name="uuid-gen",strategy = "uuid2")
	@GeneratedValue(generator = "uuid-gen")
	private String id;
	@Column(unique=true)
	private String ProductSKU;
	private String Description;
	private Double price;
	private int quantity;
}
