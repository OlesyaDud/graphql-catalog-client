package com.graphqlproj.catalog_graphql_service.service;

import com.graphqlproj.catalog_graphql_service.client.InventoryClient;
import com.graphqlproj.catalog_graphql_service.dto.Item;
import com.graphqlproj.catalog_graphql_service.dto.ItemRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    @Autowired
    private InventoryClient inventoryClient;

    public List<Item> viewProducts(){
        return inventoryClient.viewProducts();
    }

    public List<Item> viewProductsByCategory(String category){
        return inventoryClient.viewProductsByCategory(category);
    }

    public Item receiveNewShipment(ItemRequestDto itemRequestDto){
        return inventoryClient.receiveNewShipment(itemRequestDto);
    }
}
