package com.ecommerce.servicerepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.Tv;
import com.ecommerce.products.dto.TvDto;

@Repository
public interface TvServiceRepository {
	
	String  saveTv(TvDto tv);
	
	List<Tv> getAllTvs();
	
	Tv getTvById(Long productId);
	
	String  updateTv(TvDto tv,Long productId);
	
	String deleteTv(Long productId);

}
