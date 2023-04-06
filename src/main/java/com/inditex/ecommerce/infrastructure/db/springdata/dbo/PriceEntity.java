package com.inditex.ecommerce.infrastructure.db.springdata.dbo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRICE")
@Getter
@Setter
@NoArgsConstructor
public class PriceEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @OneToOne
  @JoinColumn(name = "brandId", referencedColumnName = "id")
  private BrandEntity brand;
  private Date startDate;
  private Date endDate;
  @OneToOne
  @JoinColumn(name = "productId", referencedColumnName = "id")
  private ProductEntity product;
  private Integer priority;
  private BigDecimal amount;
  private String currency;
  private Integer priceList;
  
}
