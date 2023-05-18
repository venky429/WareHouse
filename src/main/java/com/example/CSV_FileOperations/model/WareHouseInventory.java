package com.example.CSV_FileOperations.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
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
public class WareHouseInventory {

	@Id
	@GenericGenerator(name="uuid-gen",strategy = "uuid2")
	@GeneratedValue(generator = "uuid-gen")
	private String id;
	private String p_id;
	private String wareHouse_id;
	private int quantity;
}
