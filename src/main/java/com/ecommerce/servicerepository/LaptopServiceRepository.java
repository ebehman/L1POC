package com.ecommerce.servicerepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.Laptop;
import com.ecommerce.products.dto.LaptopDto;

@Repository
public interface LaptopServiceRepository {
	
	String saveLaptop(LaptopDto lap);
	
	List<Laptop> getAllLaptop();
	
	Laptop getLaptopById(Long productId);
	
	String updateLaptop(LaptopDto lap,Long productId);
	
	String deleteLaptop(Long productId);
	

}
