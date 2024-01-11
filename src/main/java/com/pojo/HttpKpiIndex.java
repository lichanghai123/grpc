package com.pojo;

import java.util.Date;

public class HttpKpiIndex {
    private Long id;

    private String clientLocation;

    private String clientMacAddress;

    private String uuid;

    private Integer mainType;

    private Integer subType;

    private Integer getSuccCnt;

    private Integer getCnt;

    private Float fgDelayAvg;

    private Integer fgSuccCnt;

    private String devIp;

    private Date collectTime;

    private Date startTime;

    private Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientLocation() {
        return clientLocation;
    }

    public void setClientLocation(String clientLocation) {
        this.clientLocation = clientLocation;
    }

    public String getClientMacAddress() {
        return clientMacAddress;
    }

    public void setClientMacAddress(String clientMacAddress) {
        this.clientMacAddress = clientMacAddress;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getMainType() {
        return mainType;
    }

    public void setMainType(Integer mainType) {
        this.mainType = mainType;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public Integer getGetSuccCnt() {
        return getSuccCnt;
    }

    public void setGetSuccCnt(Integer getSuccCnt) {
        this.getSuccCnt = getSuccCnt;
    }

    public Integer getGetCnt() {
        return getCnt;
    }

    public void setGetCnt(Integer getCnt) {
        this.getCnt = getCnt;
    }

    public Float getFgDelayAvg() {
        return fgDelayAvg;
    }

    public void setFgDelayAvg(Float fgDelayAvg) {
        this.fgDelayAvg = fgDelayAvg;
    }

    public Integer getFgSuccCnt() {
        return fgSuccCnt;
    }

    public void setFgSuccCnt(Integer fgSuccCnt) {
        this.fgSuccCnt = fgSuccCnt;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}