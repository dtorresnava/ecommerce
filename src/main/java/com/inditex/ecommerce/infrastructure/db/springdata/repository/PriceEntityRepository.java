package com.inditex.ecommerce.infrastructure.db.springdata.repository;

import java.util.Date;
import java.util.List;

import com.inditex.ecommerce.infrastructure.db.springdata.dbo.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceEntityRepository extends JpaRepository<PriceEntity, Long> {

  List<PriceEntity> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
      Long brandId, Long productId, Date startDate, Date endDate);
}
