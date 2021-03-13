package  com.myretail.project.productservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.pentalog.pentabar.movieservice.feign.hystrix.ReviewServiceFallback;
import ro.pentalog.pentabar.movieservice.feign.hystrix.ReviewServiceFallbackFactory;
import ro.pentalog.pentabar.movieservice.model.MovieReview;

@FeignClient(name = "price-service", /*fallback = PriceServiceFallback.class,*/ fallbackFactory = PriceServiceFallbackFactory.class)
public interface PriceFeignClient {

    @GetMapping("/price/search/findPriceByProductId")
    ProductPrice getProductPrice(@RequestParam("productID") Long productId);
}