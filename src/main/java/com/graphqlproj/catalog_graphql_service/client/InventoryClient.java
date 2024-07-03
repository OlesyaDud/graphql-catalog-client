package com.graphqlproj.catalog_graphql_service.client;


import com.graphqlproj.catalog_graphql_service.dto.Item;
import com.graphqlproj.catalog_graphql_service.dto.ItemRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class InventoryClient {

    @Autowired
    private HttpGraphQlClient graphQlClient;

    public List<Item> viewProducts(){
        String graphQLQuery="query GetProduct {\n" +
                "    getProduct {\n" +
                "        name\n" +
                "        price\n" +
                "    }\n" +
                "}\n";

//        Mono<List<Item>> products =graphQlClient.document(graphQLQuery)
//                .retrieve("getProduct")
//                .toEntityList(Item.class);
//
//        or
//        List<Item> products =graphQlClient.document(graphQLQuery)
//                .retrieve("getProduct")
//                .toEntityList(Item.class).block();
//
//        return products;
//        or

        return graphQlClient.document(graphQLQuery)
                .retrieve("getProduct")
                .toEntityList(Item.class).block();
    }

    public List<Item> viewProductsByCategory(String category) {
        String graphQLQuery = String.format(
                "query GetProduct {\n" +
                        "    getProductsByCategory(category: \"%s\") {\n" +
                        "        price\n" +
                        "        stock\n" +
                        "        category\n" +
                        "        name\n" +
                        "    }\n" +
                        "}", // Closing the query correctly
                category
        );

        return graphQlClient.document(graphQLQuery)
                .retrieve("getProductsByCategory")
                .toEntityList(Item.class).block();
    }


    public Item receiveNewShipment(ItemRequestDto itemRequestDto){
        String graphQLQuery = String.format("mutation ReceiveNewShipment {\n" +
                "    receiveNewShipment(id: \"%s\", quantity: %d) {\n" +
                "        name\n" +
                "        price\n" +
                "        stock\n" +
                "    }\n" +
                "}\n", itemRequestDto.getId(), itemRequestDto.getQty());

         return graphQlClient.document(graphQLQuery)
                .retrieve("receiveNewShipment")
                .toEntity(Item.class).block();
    }

}
