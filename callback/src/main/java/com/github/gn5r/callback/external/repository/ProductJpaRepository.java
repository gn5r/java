package com.github.gn5r.callback.external.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.github.gn5r.callback.external.entity.Product;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

}
