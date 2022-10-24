package programadorwho.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetwayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return builder
                .routes()
                .route(r -> r.path("/clients/**").uri("lb://client"))
                .route(r -> r.path("/rooms/**").uri("lb://hotel"))
                .route(r -> r.path("/manager-hotel/**").uri("lb://manager-hotel"))
                .build();
    }
}
