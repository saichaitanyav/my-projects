package  com.myretail.project.productservice.feign.hystrix;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;
import ro.pentalog.pentabar.movieservice.feign.ReviewsFeignClient;
import ro.pentalog.pentabar.movieservice.model.MovieReview;

import java.util.Collections;

/**
 * Fallback class used for feign client, in case the hystrix circuit breaks
 * This allows access to the underlying exception that broke the circuit
 */
@Component
public class PriceServiceFallbackFactory implements FallbackFactory<PriceFeignClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PriceServiceFallbackFactory.class);

    @Override
    public PriceFeignClient create(Throwable throwable) {
        return new PriceFeignClient() {
            @Override
            public ProductPrice getProductPrice(Long productId) {
                LOGGER.error("Error occurred trying to fetch price from price service", throwable);
                return new ProductPrice;
            }
        };
    }
}
