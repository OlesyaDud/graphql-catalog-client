package com.graphqlproj.catalog_graphql_service.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//avoids null or default values like null
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Item {

    private String name;
    private String category;
    private Float price;
    private Integer stock;
}
