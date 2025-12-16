package org.zgo.client;

import org.zgo.dto.PageResponse;
import org.zgo.dto.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange("http://localhost:9191/products")
public interface ProductClient {

    @PostExchange
    List<Product> addNewProduct(@RequestBody List<Product> products);

    @GetExchange
    PageResponse<Product> getAllProducts(
        @RequestParam int page,
        @RequestParam int size,
        @RequestParam String sortBy,
        @RequestParam String direction
    );

    @GetExchange("/{category}")
    List<Product> getProductsByCategory(@PathVariable String category);
}
