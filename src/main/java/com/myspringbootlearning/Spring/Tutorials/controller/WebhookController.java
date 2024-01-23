package com.myspringbootlearning.Spring.Tutorials.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myspringbootlearning.Spring.Tutorials.entity.WebhookEntity;
import com.myspringbootlearning.Spring.Tutorials.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/web-hooks")
public class WebhookController {

    @Autowired
    public WebhookService webhookService;

    @PostMapping
    public ResponseEntity<String> sendWebhook(@RequestBody WebhookEntity webhook) throws JsonProcessingException {
        webhookService.sendWebhook(webhook);
        return new ResponseEntity < >("Webhook delivered successfully", HttpStatus.OK);
    }
}