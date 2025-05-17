package com.github.gn5r.callback.product;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.github.gn5r.callback.external.repository.ProductJpaRepository;
import com.github.gn5r.callback.product.model.ProductSearchResultModel;

@Repository
public interface ProductRepository extends ProductJpaRepository, JpaSpecificationExecutor<ProductSearchResultModel> {

}
