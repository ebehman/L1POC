package com.ecommerce.service;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Watches;
import com.ecommerce.products.dto.WatchesDto;
import com.ecommerce.repository.WatchesRepository;
import com.ecommerce.servicerepository.WatchesServiceRepository;
@Service
public class WatchesService implements WatchesServiceRepository{
	
	@Autowired
	private WatchesRepository watchesRepo;
	String save="Product saved successfully";
	String update="Product Updated Successfully";

	public WatchesService(WatchesRepository watchesRepo) {
		super();
		this.watchesRepo = watchesRepo;
	}
	//save watches
	@Override
	public String saveWatches(WatchesDto watchesDto) {
		Watches watch=new Watches();
		BeanUtils.copyProperties(watchesDto, watch);
		watchesRepo.save(watch);
		return save;
	}
	
	//get all watches
	@Override
	public List<Watches> getAllWatches() {
		
		return watchesRepo.findAll();
	}
	
	//update watches
	@Override
	public String updateWatches(WatchesDto watches, Long productId) {
		Watches watch=watchesRepo.findById(productId).orElseThrow(()->
					new ResourceNotFoundException("Watches","productId",productId));
		watch.setBrand(watches.getBrand());
		watch.setColor(watches.getColor());
		watch.setConnectorType(watches.getConnectorType());
		watch.setModel(watches.getModel());
		watch.setStyle(watches.getStyle());
		watch.setWaterRessistent(watches.isWaterRessistent());
		watchesRepo.save(watch);
		return update;
	}
	
	//delete watches
	@Override
	public String deleteWatches(Long productId) {
		
		watchesRepo.deleteById(productId);
		return "deleted";
		
	}
	
	//get watches by id
	@Override
	public Watches getWatchesById(Long productId) {
		
		return watchesRepo.findById(productId).orElseThrow(()->
		new ResourceNotFoundException("watches", "productId", productId));
	}
}
