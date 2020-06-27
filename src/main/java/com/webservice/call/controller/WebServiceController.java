package com.webservice.call.controller;

import com.webservice.call.service.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
public class WebServiceController {

    private static final Logger logger = LoggerFactory.getLogger(WebServiceController.class);

    @Autowired
    private WebService webService;

    @RequestMapping(value = "/{ifscCode}", method = RequestMethod.GET)
    public ResponseEntity getDetailsByIfscCode(@PathVariable("ifscCode") String ifscCode,
                                               @RequestHeader("X-Request-ID") String requestId) throws URISyntaxException {
        logger.info("Hello from WebServiceController {}", ifscCode);
        return webService.getDetailsByIfsc(ifscCode);
    }
}