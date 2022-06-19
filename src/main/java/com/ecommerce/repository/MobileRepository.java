
package com.ecommerce.repository;
  
import org.springframework.data.jpa.repository.JpaRepository; import
org.springframework.stereotype.Repository;

import com.ecommerce.model.Mobile;
  
@Repository 
public interface MobileRepository extends JpaRepository<Mobile, Long>{
  
  }
 