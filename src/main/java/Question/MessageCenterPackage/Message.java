package Question.MessageCenterPackage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    @JsonProperty("title")
    public String title;

    @JsonProperty("body")
    public String body;

    @JsonProperty("content_type")
    public String contentType;
    @JsonProperty("extra")
    public Extra extra;

    public Message(boolean withImage){
        if(!withImage)
            extra = new Extra();
        else
            extra = new Extra_Image();
    }

}
