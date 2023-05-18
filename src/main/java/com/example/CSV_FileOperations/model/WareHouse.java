package com.example.CSV_FileOperations.model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WareHouse {
	@Id
	@GenericGenerator(name="uuid-gen",strategy = "uuid2")
	@GeneratedValue(generator = "uuid-gen")
	private String id;
	private String productSKU;
	private String loc;
//	@OneToMany(mappedBy = "warehouse")
//	private List<WareHouseLoacations> location;
//	
	private int quantity=0;
	
	@Transient
	static int count=0;
	
	public WareHouse() {
		count++;
		System.out.println("object count :"+count);
	}
	protected void finalize() throws Throwable {
		count =0;
		System.out.println("inside garbage collector");
	}
}
