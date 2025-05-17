package com.github.gn5r.callback.product;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.gn5r.callback.product.form.ProductSearchForm;
import com.github.gn5r.callback.product.model.ProductSearchConditionModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping({ "", "/" })
  public String index(@ModelAttribute("form") ProductSearchForm form) {
    log.debug("index");
    return "index";
  }

  @GetMapping("search")
  public String search(@ModelAttribute("form") ProductSearchForm form,
      @PageableDefault(page = 0, size = 10) Pageable pageable, Model model) {
    log.debug("search");
    var condition = new ProductSearchConditionModel();
    BeanUtils.copyProperties(form, condition);
    var page = this.productService.searchWithPaging(condition, pageable);
    model.addAttribute("page", page);
    model.addAttribute("items", page.getContent());
    return "index";
  }

  @GetMapping("download/csv")
  @ResponseBody
  public ResponseEntity<Resource> downloadCsv(ProductSearchForm form) throws IOException {
    log.debug("download csv");
    var condition = new ProductSearchConditionModel();
    BeanUtils.copyProperties(form, condition);
    ByteArrayResource resource = this.productService.downloadCsv(condition);
    var fileName = UUID.randomUUID().toString() + ".csv";
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
        .contentType(MediaType.parseMediaType("text/csv;charset=UTF-8"))
        .contentLength(resource.contentLength())
        .body(resource);
  }
}
