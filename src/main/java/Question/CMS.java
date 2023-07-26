package Question;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CMS {
    public static String getCMS(){
        RestAssured.baseURI = "https://am-vodafone.github.io/cms/mvf/configfiles/rn/op_1032/internationalisation_en_GB.json";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        if(response.statusCode() == 200)
            return response.asString();
        else
            return "The Status Code != 200";
    }

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println(getCMS());
        JsonNode jsonNode =  new ObjectMapper().readTree(getCMS());
        System.out.println("----------------------------------------------");
        System.out.println(jsonNode.get("addons_show_more").asText());
    }

}
