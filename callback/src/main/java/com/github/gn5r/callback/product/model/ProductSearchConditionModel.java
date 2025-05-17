package com.github.gn5r.callback.product.model;

import lombok.Data;

@Data
public class ProductSearchConditionModel {

  private String name;
  private Integer priceSince;
  private Integer priceUntil;
  private Integer stockSince;
  private Integer stockUntil;

}
