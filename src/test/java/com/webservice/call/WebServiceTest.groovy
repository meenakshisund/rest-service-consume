package com.webservice.call

import org.apache.coyote.Response
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate
import spock.lang.*

class WebServiceTest extends Specification {

    RestTemplate customRestTemplate = Mock()
    String baseUrl = "baseUrl"
    WebService webService = new WebService(customRestTemplate: customRestTemplate, baseUrl: baseUrl)
    IfscResponse ifscResponse
    String ifscCode
    String url
    URI uri
    ResponseEntity<IfscResponse> success

    def setup() {
        ifscResponse = new IfscResponse(branchName: "branch")
        ifscCode = "ifscCode"
        url = baseUrl.concat(ifscCode)
        uri = new URI(url)
        success = new ResponseEntity<>(ifscResponse, HttpStatus.OK)
    }

    def "testGetDetailsByIfsc"() {
        when:
        webService.getDetailsByIfsc(ifscCode)

        then:
        1 * customRestTemplate.exchange(uri, HttpMethod.GET, null, IfscResponse.class)>> success

        ifscResponse.branchName == "branch"
        ifscResponse.address == null
    }

    def "testGetDetailsByIfscThrowsException"() {
        when:
        webService.getDetailsByIfsc(ifscCode)

        then:
        1 * customRestTemplate.exchange(uri, HttpMethod.GET, null, IfscResponse.class) >> { new RestClientException("404")}
        RestClientException e = thrown()
    }
}