package io.vividcode.quarkus;

import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResponse {

  @Inject
  ProductService productService;

  @GET
  public List<Product> list() {
    return productService.list();
  }

  @Path("priceGte")
  @GET
  public List<Product> priceGte(@QueryParam("price") BigDecimal price) {
    return productService.findPriceGte(price);
  }

  @POST
  public Product create(Product product) {
    return productService.addProduct(product);
  }

  @Path("{id}")
  @DELETE
  public void delete(@PathParam("id") Long id) {
    productService.delete(id);
  }
}
