package com.samuelsonpajeu.render.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class StaticBagdeService {
    String url = "https://img.shields.io/badge/Render-%s-%s?logo=render&logoColor=white";

    public String retrieveAPIData(String status, String color) {
        RestTemplate restTemplate = new RestTemplate();

        String uri = String.format(this.url, status, color);

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class );

        String responseBody = response.getBody();

        return responseBody;
    }
}
