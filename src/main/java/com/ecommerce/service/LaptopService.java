package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Laptop;
import com.ecommerce.products.dto.LaptopDto;
import com.ecommerce.repository.LaptopRepository;
import com.ecommerce.servicerepository.LaptopServiceRepository;

@Service
public class LaptopService implements LaptopServiceRepository{
	@Autowired
	private LaptopRepository lapRepo;
	
	String save="Product saved successfully";
	String update="Product Updated Successfully";
	
	
	public LaptopService(LaptopRepository lapRepo) {
		super();
		this.lapRepo = lapRepo;
	}
	
	
	@Override
	public String saveLaptop(LaptopDto lapDto) {
		Laptop lap=new Laptop();
		BeanUtils.copyProperties(lapDto,lap);
		 lapRepo.save(lap);
		 BeanUtils.copyProperties(lap,lapDto);
		 return save;
	}
	
	@Override
	public List<Laptop> getAllLaptop() {
		
		return lapRepo.findAll();
	}
	
	@Override
	public Laptop getLaptopById(Long productId) {
		
		return lapRepo.findById(productId).orElseThrow(()->
		new ResourceNotFoundException("Laptop", "productId", productId));
	}
	
	@Override
	public String deleteLaptop(Long productId) {

		lapRepo.deleteById(productId);
		return "deleted";
	}
	
	@Override
	public String updateLaptop(LaptopDto lap, Long productId) {
		
		Laptop laptop=lapRepo.findById(productId).orElseThrow( () -> new ResourceNotFoundException("Laptop", "productId", productId));
		
		laptop.setBrand(lap.getBrand());
		laptop.setColor(lap.getColor());
		laptop.setModel(lap.getModel());
		laptop.setOs(lap.getOs());
		laptop.setSsdCapacity(lap.getSsdCapacity());
		laptop.setWeight(lap.getWeight());
		
		lapRepo.save(laptop);
		return update;
	}
}
