package com.ecommerce.servicerepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.Mobile;
import com.ecommerce.products.dto.MobileDto;

@Repository
public interface MobileServiceRepository {
	
	String saveMobile(MobileDto mobile);
	
	List<Mobile> getAllMobiles();
	
	Mobile getMobileById(Long productId);
	
	String  updateMobile(MobileDto mobile, Long productId);
	
	String deleteMobile(Long productId);
}
