package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    private MessageComponent messageComponent;

    @PostMapping(value = "/messages/{contents}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> processOrder(@PathVariable String contents) {
        messageComponent.sendMessage(contents);
        return ResponseEntity.ok().build();
    }

}
