package com.pojo;

import java.util.Date;

public class OnuLocalInfo {
    private Long id;

    private String devIp;

    private String portName;

    private Date collectTime;

    private Integer oltRxPower;

    private Integer onlineDuration;

    private Integer lastDownTime;

    private Integer lastDownCause;

    private Integer onuStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevIp() {
        return devIp;
    }

    public void setDevIp(String devIp) {
        this.devIp = devIp;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public Integer getOltRxPower() {
        return oltRxPower;
    }

    public void setOltRxPower(Integer oltRxPower) {
        this.oltRxPower = oltRxPower;
    }

    public Integer getOnlineDuration() {
        return onlineDuration;
    }

    public void setOnlineDuration(Integer onlineDuration) {
        this.onlineDuration = onlineDuration;
    }

    public Integer getLastDownTime() {
        return lastDownTime;
    }

    public void setLastDownTime(Integer lastDownTime) {
        this.lastDownTime = lastDownTime;
    }

    public Integer getLastDownCause() {
        return lastDownCause;
    }

    public void setLastDownCause(Integer lastDownCause) {
        this.lastDownCause = lastDownCause;
    }

    public Integer getOnuStatus() {
        return onuStatus;
    }

    public void setOnuStatus(Integer onuStatus) {
        this.onuStatus = onuStatus;
    }
}