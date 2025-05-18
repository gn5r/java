package com.github.gn5r.callback.product;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.gn5r.callback.common.filewriter.CSVFileWriter;
import com.github.gn5r.callback.common.filewriter.JSONFileWriter;
import com.github.gn5r.callback.external.entity.Product;
import com.github.gn5r.callback.product.model.ProductSearchConditionModel;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<Product> search(ProductSearchConditionModel condition) {
    var specification = ProductSpecification.searchByCondition(condition);
    return this.productRepository.findAll(specification);
  }

  public Page<Product> searchWithPaging(ProductSearchConditionModel condition, Pageable pageable) {
    var specification = ProductSpecification.searchByCondition(condition);
    return this.productRepository.findAll(specification, pageable);
  }

  public ByteArrayResource downloadCsv(ProductSearchConditionModel condition) throws IOException {
    var items = this.search(condition);
    var csvFileWriter = new CSVFileWriter<Product>(
        i -> new Object[] { i.getId(), i.getName(), i.getPrice(), i.getStock() }, "#", "商品名", "金額", "在庫");
    return csvFileWriter.export(items);
  }

  public ByteArrayResource downloadJson(ProductSearchConditionModel condition) throws JsonProcessingException {
    var items = this.search(condition);
    var jsonFileWriter = new JSONFileWriter<Product>();
    return jsonFileWriter.export(items);
  }
}
