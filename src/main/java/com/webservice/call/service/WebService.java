package com.webservice.call.service;

import com.webservice.call.model.IfscResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class WebService {

    @Autowired
    private RestTemplate customRestTemplate;

    @Value("${razorpay.base.url}")
    private String baseUrl;

    public ResponseEntity getDetailsByIfsc(String isfc) throws URISyntaxException, RestClientException  {
        URI uri = new URI(baseUrl + isfc);
        try {
            return customRestTemplate.exchange(uri, HttpMethod.GET, null, IfscResponse.class);
        } catch (RestClientException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}