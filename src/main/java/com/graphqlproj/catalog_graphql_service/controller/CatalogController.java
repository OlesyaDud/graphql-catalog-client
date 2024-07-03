package com.graphqlproj.catalog_graphql_service.controller;


import com.graphqlproj.catalog_graphql_service.dto.Item;
import com.graphqlproj.catalog_graphql_service.dto.ItemRequestDto;
import com.graphqlproj.catalog_graphql_service.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/products")
    public List<Item> viewProducts(){
        return catalogService.viewProducts();
    }

    @GetMapping("/products/category")
    public List<Item> viewProductsByCategory(@RequestParam String category){
        return catalogService.viewProductsByCategory(category);
    }

    @PostMapping("/shipment")
    public Item receiveShipment(@RequestBody ItemRequestDto itemRequestDto){
        return catalogService.receiveNewShipment(itemRequestDto);
    }
}
