package Question.MessageCenterPackage;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Extra {
    @JsonProperty("category")
    public String category;

    @JsonProperty("icon")
    public String icon;

    @JsonProperty("actionText1")
    public String actionText1;

    @JsonProperty("action1")
    public String action1;

    @JsonProperty("actionText2")
    public String actionText2;

    @JsonProperty("action2")
    public String action2;

    @JsonProperty("body")
    public String body;

}
