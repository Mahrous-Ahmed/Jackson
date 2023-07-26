package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetProduct {

    public static void getItem() throws JsonProcessingException {
        RestAssured.baseURI = "https://dummyjson.com/products";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        Response response = httpRequest.get("/1");
        if(response.statusCode() == 200){
           Product product = new ObjectMapper().readValue(response.getBody().asString() , Product.class);
            System.out.println(product.id);
        }
        else {
            System.out.println("Can't get this Product");
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        getItem();
    }
}
