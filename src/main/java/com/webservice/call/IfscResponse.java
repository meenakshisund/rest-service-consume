package com.webservice.call;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

class IfscResponse implements Serializable {

    @JsonProperty("BRANCH")
    String branchName;

    @JsonProperty("CENTRE")
    String centre;

    @JsonProperty("DISTRICT")
    String district;

    @JsonProperty("STATE")
    String state;

    @JsonProperty("ADDRESS")
    String address;

    @JsonProperty("CITY")
    String city;

    @JsonProperty("CONTACT")
    String phoneNumber;

    @JsonProperty("MICR")
    String micrCode;

    @JsonProperty("BANK")
    String bankName;

    @JsonIgnore
    @JsonProperty("IFSC")
    String ifscCode;

    @JsonProperty("UPI")
    Boolean upi;

    @JsonProperty("RTGS")
    Boolean rtgs;

    @JsonProperty("NEFT")
    Boolean neft;

    @JsonProperty("IMPS")
    Boolean imps;
}
