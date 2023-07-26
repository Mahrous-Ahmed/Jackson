package Question;

import Question.MessageCenterPackage.Extra_Image;
import Question.MessageCenterPackage.MessageCenter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Main {

    public static MessageCenter addMessageCenter_withoutImage() throws JsonProcessingException {
        MessageCenter messageCenter = new MessageCenter(false);
        messageCenter.audience = "all";

        messageCenter.notification.alert = "Alert";

        messageCenter.deviceTypes.add("ios");
        messageCenter.deviceTypes.add("android");

        messageCenter.message.title = "Postman - title, body and 2 buttons";
        messageCenter.message.body = "Body";
        messageCenter.message.contentType = "text/html";

        messageCenter.message.extra.category = "{\"id\": \"4\", \"name\": \"Messages\"}";
        messageCenter.message.extra.icon = "ic3G";
        messageCenter.message.extra.actionText1 = "Upgrade";
        messageCenter.message.extra.action1 = "exUrl:https://www.vodafone.com/content/index.html";
        messageCenter.message.extra.actionText2 = "Settings";
        messageCenter.message.extra.action2 = "app:Settings";
        messageCenter.message.extra.body = "For trying";

        return messageCenter;
    }

    public static MessageCenter addMessageCenter_withImage() throws JsonProcessingException {
        MessageCenter messageCenter = new MessageCenter(true);
        messageCenter.audience = "all";

        messageCenter.notification.alert = "Alert";

        messageCenter.deviceTypes.add("ios");
        messageCenter.deviceTypes.add("android");

        messageCenter.message.title = "Postman - title, body and 2 buttons";
        messageCenter.message.body = "Body";
        messageCenter.message.contentType = "text/html";

        Extra_Image extraImage = (Extra_Image) messageCenter.message.extra;
        extraImage.category = "{\"id\": \"4\", \"name\": \"Messages\"}";
        extraImage.icon = "ic3G";
        extraImage.actionText1 = "Upgrade";
        extraImage.action1 = "exUrl:https://www.vodafone.com/content/index.html";
        extraImage.actionText2 = "Settings";
        extraImage.action2 = "app:Settings";
        extraImage.body = "For trying";
        extraImage.image = "https://file.kelleybluebookimages.com/kbb/base/house/2008/2008-BMW-3%20Series-FrontSide_BM328ICP081_505x375.jpg";

        return messageCenter;
    }
    public static void sendNotificationWithoutImage_Q2() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(addMessageCenter_withoutImage());
        System.out.println(json);
        RestAssured.baseURI = "https://go.urbanairship.com/api";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.contentType(ContentType.JSON);
        httpRequest.auth().basic("cFFXoew5TMCg9cCB2FhYUA","HUrQlejpSpWZt4dkdzwrVA");
        httpRequest.body(json);
        Response response = httpRequest.post("/push");

        System.out.println(response.prettyPrint());
    }

    public static void sendNotificationWithImage_Q2() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(addMessageCenter_withImage());
        System.out.println(json);
        RestAssured.baseURI = "https://go.urbanairship.com/api";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.auth().basic("cFFXoew5TMCg9cCB2FhYUA","HUrQlejpSpWZt4dkdzwrVA");
        httpRequest.contentType(ContentType.JSON);
        httpRequest.body(json);
        Response response = httpRequest.post("/push");

        System.out.println(response.prettyPrint());
    }



    public static void main(String[] args) throws JsonProcessingException {
        sendNotificationWithoutImage_Q2();
    }
}
