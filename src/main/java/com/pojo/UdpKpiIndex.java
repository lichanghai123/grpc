package com.pojo;

import java.util.Date;

public class UdpKpiIndex {
    private Long id;

    private String clientLocation;

    private String clientMacAddress;

    private String uuid;

    private Integer mainType;

    private Integer subType;

    private Integer appIdentify;

    private String flow;

    private Float upMfrAvg;

    private Float upMfrMax;

    private String devIp;

    private Date collectTime;

    private Float downMfrAvg;

    private Float downMfrMax;

    private Integer upSendBytesCnt;

    private Integer downRecvBytesCnt;

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

    public Integer getAppIdentify() {
        return appIdentify;
    }

    public void setAppIdentify(Integer appIdentify) {
        this.appIdentify = appIdentify;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public Float getUpMfrAvg() {
        return upMfrAvg;
    }

    public void setUpMfrAvg(Float upMfrAvg) {
        this.upMfrAvg = upMfrAvg;
    }

    public Float getUpMfrMax() {
        return upMfrMax;
    }

    public void setUpMfrMax(Float upMfrMax) {
        this.upMfrMax = upMfrMax;
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

    public Float getDownMfrAvg() {
        return downMfrAvg;
    }

    public void setDownMfrAvg(Float downMfrAvg) {
        this.downMfrAvg = downMfrAvg;
    }

    public Float getDownMfrMax() {
        return downMfrMax;
    }

    public void setDownMfrMax(Float downMfrMax) {
        this.downMfrMax = downMfrMax;
    }

    public Integer getUpSendBytesCnt() {
        return upSendBytesCnt;
    }

    public void setUpSendBytesCnt(Integer upSendBytesCnt) {
        this.upSendBytesCnt = upSendBytesCnt;
    }

    public Integer getDownRecvBytesCnt() {
        return downRecvBytesCnt;
    }

    public void setDownRecvBytesCnt(Integer downRecvBytesCnt) {
        this.downRecvBytesCnt = downRecvBytesCnt;
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