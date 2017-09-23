package ru.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
    @GetMapping("/")
    public ResponseEntity<String> index(){
        Map<String, String> model = new HashMap<>();
        String html = Task.go();
        return new ResponseEntity<String>(html,HttpStatus.OK);
    }
}
