package com.github.gn5r.callback.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.github.gn5r.callback.product.model.ProductSearchConditionModel;
import com.github.gn5r.callback.product.model.ProductSearchResultModel;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public Page<ProductSearchResultModel> search(ProductSearchConditionModel condition, Pageable pageable) {
    Specification<ProductSearchResultModel> specification = ProductSpecification.searchByCondition(condition);
    return this.productRepository.findAll(specification, pageable);
  }
}
