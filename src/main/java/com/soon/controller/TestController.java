package com.soon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TestController {

    Logger log = LoggerFactory.getLogger(TestController.class);



    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        log.info("ping check");
        return new ResponseEntity<String>("PING SUCCESS", HttpStatus.OK);
    }

    /*
    @GetMapping("checkDB")
    public ResponseEntity<String> checkDB(){
        log.info("Check DB");



        return
    }
    */

}
