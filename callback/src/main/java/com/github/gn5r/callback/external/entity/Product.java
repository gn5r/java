package com.github.gn5r.callback.external.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

  @Id
  private Integer id;
  private String name;
  private Integer price;
  private Integer stock;
}
