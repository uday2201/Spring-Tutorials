package com.myspringbootlearning.Spring.Tutorials.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myspringbootlearning.Spring.Tutorials.entity.MessageEntity;
import com.myspringbootlearning.Spring.Tutorials.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/web-hooks")
public class MessageController {

    @Autowired
    public MessageService messageService;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody MessageEntity message) throws JsonProcessingException {
        messageService.sendMessage(message);
        return new ResponseEntity < >("Webhook delivered successfully", HttpStatus.OK);
    }
}