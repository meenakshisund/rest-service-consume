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

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMicrCode() {
        return micrCode;
    }

    public void setMicrCode(String micrCode) {
        this.micrCode = micrCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public Boolean getUpi() {
        return upi;
    }

    public void setUpi(Boolean upi) {
        this.upi = upi;
    }

    public Boolean getRtgs() {
        return rtgs;
    }

    public void setRtgs(Boolean rtgs) {
        this.rtgs = rtgs;
    }

    public Boolean getNeft() {
        return neft;
    }

    public void setNeft(Boolean neft) {
        this.neft = neft;
    }

    public Boolean getImps() {
        return imps;
    }

    public void setImps(Boolean imps) {
        this.imps = imps;
    }
}
