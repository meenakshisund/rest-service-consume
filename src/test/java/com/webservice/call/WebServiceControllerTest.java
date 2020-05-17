package com.webservice.call;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Objects;

import static org.mockito.Mockito.when;

@SpringBootTest
class WebServiceControllerTest {

    @Autowired
    private WebServiceController webServiceController;

    @MockBean
    WebService webService;

    @DisplayName("actual rest call - no mock")
    @Test
    void test1() throws URISyntaxException {
        IfscResponse response = new IfscResponse();
        response.setIfscCode("HDFC0001852");
        ResponseEntity<IfscResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        when(webServiceController.getDetailsByIfscCode("HDFC0001852"))
                .thenReturn(responseEntity);
        assert responseEntity.getStatusCode() == HttpStatus.ACCEPTED;
        assert Objects.requireNonNull(responseEntity.getBody()).getIfscCode().equals("HDFC0001852");
    }
}