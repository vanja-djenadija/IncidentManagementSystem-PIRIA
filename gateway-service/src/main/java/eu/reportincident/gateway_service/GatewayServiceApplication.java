package eu.reportincident.gateway_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("incident-service", r -> r.path("/incident-service/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://INCIDENT-SERVICE"))
                .route("moderation-service", r -> r.path("/moderation-service/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://MODERATION-SERVICE"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

}
