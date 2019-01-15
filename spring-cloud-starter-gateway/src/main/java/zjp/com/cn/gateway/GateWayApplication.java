package zjp.com.cn.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import zjp.com.cn.gateway.CustomerFilterFactory.RequestTimeGatewayFilterFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * TODO
 * Created by 31349 on 2019-1-2.
 *
 * @author <a href="mailto:zhang_jianping@sicca.com.cn">zjp</a>
 * @version V1.0
 */
@SpringBootApplication
@RestController
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }

    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String httpUri = "http://httpbin.org:80/get";
        ZonedDateTime minusTime = LocalDateTime.now().minusDays(1).atZone(ZoneId.systemDefault());
        return builder.routes()
//                .route(p -> p
//                        .path("/get")
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri("http://httpbin.org:80"))
//                .route(p -> p
//                        .host("*.hystrix.com")
//                        .filters(f -> f
//                                .hystrix(config -> config
////                                        .setName("mycmd")
//                                        .setFallbackUri("forward:/fallback")))
//                        .uri(httpUri))
//                .route("after_route", r -> r.after(minusTime)
//                        .uri(httpUri))
//                .route("header_route", h -> h.header("X-Request-Id", "\\d+")
//                        .filters(f -> f.hystrix(config -> config.setFallbackUri("forward:/fallback")))
//                        .uri("https://www.baidu.com"))
//                .route("cookie_route",c -> c.cookie("name","forezp")
//                        .filters(f -> f
//                                .addRequestHeader("headerfrom","cookies"))
//                        .uri(httpUri))
//                .route("customer_filter_router",p -> p
//                        .path("/customer/**")
//                        .filters(f -> f.
//                                filter(new RequestTimeFilter())
//                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
//                        .uri(httpUri)
//                        .order(0)
//                )
                .route("request_time_route",p -> p
                        .after(minusTime)
                        .filters(f -> f
                                .addRequestParameter("RequestTime","false"))
                        .uri(httpUri).order(0))
                .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }



}
