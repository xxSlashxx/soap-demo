package de.slash.productsservice.product;

import de.slash.productsservice.gen.CreateProductRequest;
import de.slash.productsservice.gen.CreateProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "http://www.slash.de/productsservice/gen";

    @Autowired
    private ProductService productService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createProductRequest")
    @ResponsePayload
    public CreateProductResponse createProduct(@RequestPayload CreateProductRequest request) {
        CreateProductResponse response = new CreateProductResponse();
        Product createdProduct = productService.createProduct(request.getProductDTO().getName(), request.getProductDTO().getPrice());
        response.setId(createdProduct.getId());
        return response;
    }
}
