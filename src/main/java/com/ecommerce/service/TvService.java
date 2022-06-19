package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Tv;
import com.ecommerce.products.dto.TvDto;
import com.ecommerce.repository.TvRepository;
import com.ecommerce.servicerepository.TvServiceRepository;

@Service
public class TvService implements TvServiceRepository{
	
	private TvRepository tvRepo;
	
	String save="Product saved successfully";
	String update="Product Updated Successfully";
	
	public TvService(TvRepository tvRepo) {
		super();
		this.tvRepo = tvRepo;
	}
	//save tv
	@Override
	public String saveTv(TvDto tvDto) 
	{		
		Tv tv=new Tv();
		BeanUtils.copyProperties(tvDto, tv);
		tvRepo.save(tv);
		return save;
	}
	//get tvs
	@Override
	public List<Tv> getAllTvs() {
		
		return tvRepo.findAll();
	}
	//update tv
	@Override
	public String updateTv(TvDto tv, Long productId) {
		
		Tv newtv=tvRepo.findById(productId).orElseThrow(()->
							new ResourceNotFoundException("Tv", "productId", productId)) ;
		newtv.setBrand(tv.getBrand());
		newtv.setColor(tv.getColor());
		
		newtv.setModel(tv.getModel());
		
		newtv.setSmartTv(tv.getSmartTv());
		 tvRepo.save(newtv);
		 return update;
	}
	
	//delete tv
	@Override
	public String deleteTv(Long productId) {
		
		tvRepo.deleteById(productId);	
		return "deleted";
	}
	
	//get tv by productId
	@Override
	public Tv getTvById(Long productId) {
		
		return tvRepo.findById(productId).orElseThrow(()->
		new ResourceNotFoundException("Tv", "productId", productId));
	}

}
