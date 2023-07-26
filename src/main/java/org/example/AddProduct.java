package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddProduct {
    public static String getProductBody() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = new Product();
        product.title = "iPhone 14";
        product.description = "description";
        product.price = 50000;
        product.discountPercentage = 20.50;
        product.rating = 4.60;
        product.stock = 300;
        product.brand = "Apple";
        product.category = "smartphones";
        product.thumbnail = "https://i.dummyjson.com/data/products/1/thumbnail.jpg";
        product.images.add("https://i.dummyjson.com/data/products/1/1.jpg");
        product.images.add("https://i.dummyjson.com/data/products/1/2.jpg");
        product.images.add("https://i.dummyjson.com/data/products/1/3.jpg");
        System.out.println(objectMapper.writeValueAsString(product));
        return objectMapper.writeValueAsString(product);
    }

    public static void AddItem() throws JsonProcessingException {
        RestAssured.baseURI = "https://dummyjson.com/products";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(getProductBody());
        Response response = httpRequest.post("/add");
        if(response.statusCode() == 200){
          response.getBody().prettyPrint();
        }
        else {
            System.out.println("Can't Add new Product");
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        AddItem();
    }
}
