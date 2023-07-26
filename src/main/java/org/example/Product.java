package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Product {
    public long id;
    public String title;
    public String description;
    public long price;
    public double discountPercentage;
    public double rating;
    public long stock;
    public String brand;
    public String category;
    public String thumbnail;
    public List<String> images;

    public Product(){
        images = new ArrayList<>();
    }

    @JsonProperty("id")
    public long getid() {
        return id;
    }
    @JsonIgnore()
    @JsonProperty("id")
    public void setid(long id) {
        this.id = id;
    }
}
