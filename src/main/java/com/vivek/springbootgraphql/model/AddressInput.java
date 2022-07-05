package com.vivek.springbootgraphql.model;

import graphql.schema.GraphQLInputType;
import lombok.Data;

@Data
public class AddressInput implements GraphQLInputType {


    @Override
    public String getName() {
        return "addressUpdate";
    }

    private Integer actorId;
    private String address;
}
