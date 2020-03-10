package com.webservice.call;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
public class WebServiceController {

    @Autowired
    private WebService webService;

    @RequestMapping(value = "/{ifscCode}", method = RequestMethod.GET)
    public ResponseEntity getDetailsByIfscCode(@PathVariable("ifscCode") String ifscCode) throws URISyntaxException {
        return webService.getDetailsByIfsc(ifscCode);
    }
}