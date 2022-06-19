

package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Laptop;
import com.ecommerce.model.Mobile;
import com.ecommerce.model.Tv;
import com.ecommerce.model.Watches;
import com.ecommerce.products.dto.LaptopDto;
import com.ecommerce.products.dto.MobileDto;
import com.ecommerce.products.dto.TvDto;
import com.ecommerce.products.dto.WatchesDto;
import com.ecommerce.servicerepository.LaptopServiceRepository;
import com.ecommerce.servicerepository.MobileServiceRepository;
import com.ecommerce.servicerepository.TvServiceRepository;
import com.ecommerce.servicerepository.WatchesServiceRepository;

@RestController
public class ProductsController {
	@Autowired
	private WatchesServiceRepository watchesServiceRepo;
			
	@Autowired 
	private MobileServiceRepository mobileServiceRepo;
  
	@Autowired 
	private TvServiceRepository tvServiceRepo;
  
	@Autowired 
	private LaptopServiceRepository laptopServiceRepo;
	 
	String del="product deleted successfully";
	String msg="no product exists with this productId";

	public ProductsController(
			WatchesServiceRepository watchesServiceRepo, MobileServiceRepository mobileServiceRepo,TvServiceRepository tvServiceRepo,
			LaptopServiceRepository laptopServiceRepo
														 ) {
		super();
		this.watchesServiceRepo = watchesServiceRepo;
		this.mobileServiceRepo = mobileServiceRepo; 
		this.tvServiceRepo = tvServiceRepo; 
		this.laptopServiceRepo = laptopServiceRepo;
		 
	}
	
	
	/* Watches */
	@PostMapping("/saveWatches")
	public ResponseEntity<String> saveWatches(@RequestBody WatchesDto watches)
	{
		
		return new ResponseEntity<>(watchesServiceRepo.saveWatches(watches),HttpStatus.OK);
	}
	
	@GetMapping("/getWatches")
	public List<Watches> getAllWatches()
	{
		return watchesServiceRepo.getAllWatches();
	}
	
	@PutMapping("/updateWatches/{productid}")
	public ResponseEntity<String> updateWatches(@RequestBody WatchesDto watches,@PathVariable Long productid)
	{
		
		return new ResponseEntity<>(watchesServiceRepo.updateWatches(watches, productid),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteWatches/{productid}")	
	public ResponseEntity<String> deleteWatch(@PathVariable Long productid)
	{
		watchesServiceRepo.deleteWatches(productid);
		return new ResponseEntity<>(del,HttpStatus.OK);
	}
	
	@GetMapping("/getWatches/{productid}")
	public ResponseEntity<Watches> getWatchesById(@PathVariable Long productid)
	{
		Watches watch=watchesServiceRepo.getWatchesById(productid);
		
		return new ResponseEntity<>(watch,HttpStatus.OK);
		
	}
	
	
	//Lap-top
	@PostMapping("/saveLaptop")
	public ResponseEntity<String> saveLaptop(@RequestBody LaptopDto lap)
	{
		
		return new ResponseEntity<>(laptopServiceRepo.saveLaptop(lap),HttpStatus.OK);
	}
	
	@GetMapping("/getLaptop")
	public List<Laptop> getAllLaptop()
	{
		return laptopServiceRepo.getAllLaptop();
	}
	
	@PutMapping("/updateLaptop/{productId}")
	public ResponseEntity<String> updateLaptop(@RequestBody LaptopDto lap ,@PathVariable Long productId)
	{
		
		return new ResponseEntity<>(laptopServiceRepo.updateLaptop(lap, productId),HttpStatus.OK);
	}
	
	@GetMapping("/getLaptop/{productId}")
	public ResponseEntity<Laptop> getLaptopById(@PathVariable Long productId)
	{
		Laptop laptop=laptopServiceRepo.getLaptopById(productId);
		return new ResponseEntity<>(laptop,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteLaptop/{productId}")
	public ResponseEntity<String> deleteLaptop(@PathVariable Long productId)
	{
		laptopServiceRepo.deleteLaptop(productId);
		return new ResponseEntity<>(del,HttpStatus.OK);
	}
	
	//Mobile
	@PostMapping("/saveMobile")
	public ResponseEntity<String> saveMobile(@RequestBody MobileDto mobile)
	{
		
		return new ResponseEntity<>(mobileServiceRepo.saveMobile(mobile),HttpStatus.OK);
	}
	
	@GetMapping("/getMobile")
	public List<Mobile> getAllMobile()
	{
		return mobileServiceRepo.getAllMobiles();
	}
	
	@PutMapping("/updateMobile/{productId}")
	public ResponseEntity<String> updateMobile(@RequestBody MobileDto mobile ,@PathVariable Long productId)
	{
		
		return new ResponseEntity<>(mobileServiceRepo.updateMobile(mobile, productId),HttpStatus.OK);
	}
	
	@GetMapping("/getMobile/{productId}")
	public ResponseEntity<Mobile> getMobileById(@PathVariable Long productId)
	{
		Mobile mobile=mobileServiceRepo.getMobileById(productId);
		
		return new ResponseEntity<>(mobile,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteMobile/{productId}")
	public ResponseEntity<String> deleteMobile(@PathVariable Long productId)
	{
		mobileServiceRepo.deleteMobile(productId);
		return new ResponseEntity<>(del,HttpStatus.OK);
	}
	
	//Television
	@PostMapping("/saveTv")
	public ResponseEntity<String> saveTv(@RequestBody TvDto tv)
	{
		
		return new ResponseEntity<>(tvServiceRepo.saveTv(tv),HttpStatus.OK);
	}
	
	@GetMapping("/getTv")
	public List<Tv> getTv()
	{
		return tvServiceRepo.getAllTvs();
	}
	
	@GetMapping("/getTv/{productId}")
	public ResponseEntity<Tv> getTvById(@PathVariable Long productId)
	{
		
		Tv tv=tvServiceRepo.getTvById(productId);
		
		return new ResponseEntity<>(tv,HttpStatus.OK);
	}
	
	@PutMapping("/updateTv/{productId}")
	public ResponseEntity<String> updateTv(@RequestBody TvDto tv,@PathVariable Long productId)
	{
		return new ResponseEntity<>(tvServiceRepo.updateTv(tv, productId),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTv/{productId}")
	public ResponseEntity<String> deleteTv(@PathVariable Long productId)
	{
		tvServiceRepo.deleteTv(productId);
		return new ResponseEntity<>(del,HttpStatus.OK);
	} 
}

