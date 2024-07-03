package com.graphqlproj.catalog_graphql_service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphQlClientConfig {

    @Bean
    public HttpGraphQlClient graphQlClient(){
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8001/graphql")
                .build();
        return HttpGraphQlClient.builder(webClient).build();
    }
}
