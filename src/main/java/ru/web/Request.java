package ru.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Request {
    private Map<String,List<String>> head;
    private String body;
    private String error;
    private String url;
    private int state;

    public String getHead() {
        if(head != null) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.getSerializerProvider().setNullKeySerializer(new MyNullSerializer());
            try {
                return mapper.writeValueAsString(head);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return "ERROR";
            }

        } else {
            return null;
        }
    }

    public String getBody() {
        return this.body;
    }

    public String getError() {
        return this.error;
    }

    public String getUrl() {
        return url;
    }

    public Request(String url, int state, Map<String, List<String>> head, String body, String error) {
        this.head = head;
        this.body = body;
        this.error = error;
        this.url = url;
        this.state = state;
    }

    public void print() throws JsonProcessingException {
        System.out.println("url: \n"+ this.url + "\n");
        if(head != null) {
            System.out.println("head: \n" + this.getHead() + "\n");
        }
        if(body != null){
            System.out.println("body: \n" + this.body + "\n");
        }
        if(error != null){
            System.out.println("error: \n" + this.error + "\n");
        }
    }

    public int getState() {
        return state;
    }
}
