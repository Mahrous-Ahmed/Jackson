package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.Cookie;

import static io.restassured.RestAssured.given;

public class Main {

    public static void parsingCMS_UsingRead() throws JsonProcessingException {
        Cookie myCookie = new Cookie.Builder("session_id", "1234")
                .setSecured(true)
                .setComment("session id cookie")
                .build();

        given().cookie(myCookie)
                .when().post("");

    }

    public static void main(String[] args) throws JsonProcessingException {

    }
}
