package com.github.gn5r.callback.product;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.github.gn5r.callback.product.form.ProductSearchForm;
import com.github.gn5r.callback.product.model.ProductSearchConditionModel;
import com.github.gn5r.callback.product.model.ProductSearchResultModel;

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
      @PageableDefault(page = 0, size = 25) Pageable pageable, Model model) {
    log.debug("search");
    ProductSearchConditionModel condition = new ProductSearchConditionModel();
    BeanUtils.copyProperties(form, condition);
    Page<ProductSearchResultModel> page = this.productService.search(condition, pageable);
    model.addAttribute("page", page);
    model.addAttribute("items", page.getContent());
    return "index";
  }

}
