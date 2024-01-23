package com.myspringbootlearning.Spring.Tutorials.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myspringbootlearning.Spring.Tutorials.entity.WebhookEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebhookService {

    public void sendWebhook(WebhookEntity message) throws JsonProcessingException {
        String userWebhookUrl = "https://webhook.site/25984838-bd11-4fb7-ae10-7aa95ae657d3";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ObjectMapper objectMapper = new ObjectMapper();
        String messageJson = objectMapper.writeValueAsString(message);
        HttpEntity<String> entity = new HttpEntity<>(messageJson, headers);
        restTemplate.exchange(userWebhookUrl, HttpMethod.POST, entity, String.class);
    }
}
