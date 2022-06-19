package com.ecommerce.servicerepository;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.ecommerce.model.Watches;
import com.ecommerce.products.dto.WatchesDto;
@Repository
public interface WatchesServiceRepository {
	
	String  saveWatches(WatchesDto watches);
	
	List<Watches> getAllWatches();
	
	String  updateWatches(WatchesDto watches,Long productId);
	
	String deleteWatches(Long productId);
	
	Watches getWatchesById(Long productid);
}
