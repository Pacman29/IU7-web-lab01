package task_options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Request {
    private Map<String,List<String>> head;
    private String body;
    private String error;
    private String url;

    public Request(String url, Map<String, List<String>> head, String body, String error) {
        this.head = head;
        this.body = body;
        this.error = error;
        this.url = url;
    }

    public void print() throws JsonProcessingException {
        System.out.println("url: \n"+ this.url + "\n");
        if(head != null) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.getSerializerProvider().setNullKeySerializer(new MyNullSerializer());

            String json = mapper.writeValueAsString(head);

            System.out.println("head: \n" + json + "\n");
        }
        if(body != null){
            System.out.println("body: \n" + this.body + "\n");
        }
        if(error != null){
            System.out.println("error: \n" + this.error + "\n");
        }
    }
}
