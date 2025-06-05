package com.github.gn5r.htmx.product.form;

import lombok.Data;

@Data
public class ProductSearchForm {

  private String name;
  private Integer priceSince;
  private Integer priceUntil;
  private Integer stockSince;
  private Integer stockUntil;

}
