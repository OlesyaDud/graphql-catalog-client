package com.graphqlproj.catalog_graphql_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestDto {

    private  int id;
    private int qty;
}
