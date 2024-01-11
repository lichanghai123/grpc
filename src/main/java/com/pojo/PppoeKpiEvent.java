package com.pojo;

import java.util.Date;

public class PppoeKpiEvent {
    private Long id;

    private Date eventTime;

    private String clientMacAddress;

    private Float upwardDrtt;

    private Float downwardDrtt;

    private String devIp;

    private Date collectTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getClientMacAddress() {
        return clientMacAddress;
    }

    public void setClientMacAddress(String clientMacAddress) {
        this.clientMacAddress = clientMacAddress;
    }

    public Float getUpwardDrtt() {
        return upwardDrtt;
    }

    public void setUpwardDrtt(Float upwardDrtt) {
        this.upwardDrtt = upwardDrtt;
    }

    public Float getDownwardDrtt() {
        return downwardDrtt;
    }

    public void setDownwardDrtt(Float downwardDrtt) {
        this.downwardDrtt = downwardDrtt;
    }

    public String getDevIp() {
        return devIp;
    }

    public void setDevIp(String devIp) {
        this.devIp = devIp;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}