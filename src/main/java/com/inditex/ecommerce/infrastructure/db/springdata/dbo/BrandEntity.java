package com.inditex.ecommerce.infrastructure.db.springdata.dbo;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "BRAND")
@Data
public class BrandEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String name;
}
