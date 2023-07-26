package Question.MessageCenterPackage;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MessageCenter {
       @JsonProperty("audience")
        public String audience;
        @JsonProperty("notification")
        public Notification notification;
        @JsonProperty("device_types")
        public List<String> deviceTypes;

        @JsonProperty("message")
        public Message message;

       public MessageCenter(boolean withImage){
        deviceTypes = new ArrayList<>();
        notification = new Notification();
        message = new Message(withImage);
       }


}
