package  com.myretail.project.productservice.feign.hystrix;

import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;
import com.myretail.project.productservice.feign.PriceFeignClient;
import com.myretail.project.productservice.model.ProductPrice;

import java.util.Collections;

/**
 * Fallback class used for feign client, in case the hystrix circuit breaks
 */
@Component
public class PriceServiceFallback implements PriceFeignClient {

    @Override
    public ProductPrice getProductPrice(Long productId) {
        return new ProductPrice;
    }
}
