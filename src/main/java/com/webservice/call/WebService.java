package com.webservice.call;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
class WebService {

    @Autowired
    private RestTemplate customRestTemplate;

    @Value("${razorpay.base.url}")
    private String baseUrl;

    ResponseEntity getDetailsByIfsc(String isfc) throws URISyntaxException, RestClientException  {

        StringBuilder sb = new StringBuilder(baseUrl).append(isfc);

        try {
            return customRestTemplate.exchange(
                    new URI(sb.toString()),
                    HttpMethod.GET,
                    null,
                    IfscResponse.class);

        } catch (HttpClientErrorException ex){
            return new ResponseEntity<>("IFSC Code " + isfc + " not found", HttpStatus.valueOf(ex.getRawStatusCode()));
        }
    }
}