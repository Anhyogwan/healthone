package com.secui.healthone.mattermost;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> test(){
        throw new RuntimeException();
        //return ResponseEntity.status(HttpStatus.FORBIDDEN).body("exception");
    }
}

