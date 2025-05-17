package com.github.gn5r.callback.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.github.gn5r.callback.external.entity.Product;
import com.github.gn5r.callback.product.model.ProductSearchConditionModel;

import jakarta.persistence.criteria.Predicate;

public class ProductSpecification {

  public static Specification<Product> searchByCondition(ProductSearchConditionModel condition) {
    return (root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (StringUtils.isNotBlank(condition.getName())) {
        predicates.add(cb.like(root.get("name"), "%" + condition.getName() + "%"));
      }

      if (condition.getPriceSince() != null) {
        predicates.add(cb.greaterThanOrEqualTo(root.get("price"), condition.getPriceSince()));
      }

      if (condition.getPriceUntil() != null) {
        predicates.add(cb.lessThanOrEqualTo(root.get("price"), condition.getPriceUntil()));
      }

      if (condition.getStockSince() != null) {
        predicates.add(cb.greaterThanOrEqualTo(root.get("stock"), condition.getStockSince()));
      }

      if (condition.getStockUntil() != null) {
        predicates.add(cb.lessThanOrEqualTo(root.get("stock"), condition.getStockUntil()));
      }

      return cb.and(predicates.toArray(new Predicate[0]));
    };
  }
}
