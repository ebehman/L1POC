package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Mobile;
import com.ecommerce.products.dto.MobileDto;
import com.ecommerce.repository.MobileRepository;
import com.ecommerce.servicerepository.MobileServiceRepository;

@Service
public class MobileService implements MobileServiceRepository{
	
	private MobileRepository mobileRepo;
	String save="Product saved successfully";
	String update="Product Updated Successfully";

	public MobileService(MobileRepository mobileRepo) {
		super();
		this.mobileRepo = mobileRepo;
	}
	
	@Override
	public String saveMobile(MobileDto mobileDto) {
		Mobile mobile=new Mobile();
		BeanUtils.copyProperties(mobileDto, mobile);
		mobileRepo.save(mobile);
		return save;
	}
	
	@Override
	public List<Mobile> getAllMobiles() {
		
		return mobileRepo.findAll();
	}
	
	@Override
	public Mobile getMobileById(Long productId) {
		return mobileRepo.findById(productId).orElseThrow(()->
		new ResourceNotFoundException("mobile", "productId", productId));
	}	
	
	@Override
	public String deleteMobile(Long productId) {
		mobileRepo.deleteById(productId);
		return "deleted";
	}
	
	@Override
	public String updateMobile(MobileDto mobile, Long productId) {
	Mobile m=mobileRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("mobile", "productId", productId));
			
	m.setBattery(mobile.getBattery());
	m.setBrand(mobile.getBrand());
	m.setColor(mobile.getColor());
	
	m.setModel(mobile.getModel());
	m.setProcessor(mobile.getProcessor());
	
		mobileRepo.save(m);
		return update;
	}
}
