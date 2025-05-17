package com.github.gn5r.callback.product;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    var sw = new StringWriter();
    try (CSVPrinter csvPrinter = new CSVPrinter(sw,
        CSVFormat.DEFAULT.builder().setHeader("#", "商品名", "金額", "在庫").get())) {
      for (Product item : items) {
        csvPrinter.printRecord(item.getId(), item.getName(), item.getPrice(), item.getStock());
      }
      csvPrinter.flush();

      var bytes = sw.toString().getBytes(StandardCharsets.UTF_8);
      return new ByteArrayResource(bytes);
    }
  }
}
