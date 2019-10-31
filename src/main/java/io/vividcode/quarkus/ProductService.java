package io.vividcode.quarkus;

import java.math.BigDecimal;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class ProductService {
  @Transactional
  public Product addProduct(Product product) {
    product.persist();
    return product;
  }

  public List<Product> list() {
    return Product.listAll();
  }

  @Transactional
  public void delete(Long id) {
    Product.delete("id", id);
  }

  public List<Product> findPriceGte(BigDecimal price) {
    return Product.priceGte(price);
  }
}
