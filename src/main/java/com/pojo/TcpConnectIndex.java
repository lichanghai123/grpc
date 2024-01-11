package com.pojo;

import java.util.Date;

public class TcpConnectIndex {
    private Long id;

    private String clientLocation;

    private String clientMacAddress;

    private String uuid;

    private Integer upConnectInitCnt;

    private Integer upConnectAckCnt;

    private Integer upConnectSuccCnt;

    private Float upSynDrttAvg;

    private Float downSynDrttAvg;

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

    public Integer getUpConnectInitCnt() {
        return upConnectInitCnt;
    }

    public void setUpConnectInitCnt(Integer upConnectInitCnt) {
        this.upConnectInitCnt = upConnectInitCnt;
    }

    public Integer getUpConnectAckCnt() {
        return upConnectAckCnt;
    }

    public void setUpConnectAckCnt(Integer upConnectAckCnt) {
        this.upConnectAckCnt = upConnectAckCnt;
    }

    public Integer getUpConnectSuccCnt() {
        return upConnectSuccCnt;
    }

    public void setUpConnectSuccCnt(Integer upConnectSuccCnt) {
        this.upConnectSuccCnt = upConnectSuccCnt;
    }

    public Float getUpSynDrttAvg() {
        return upSynDrttAvg;
    }

    public void setUpSynDrttAvg(Float upSynDrttAvg) {
        this.upSynDrttAvg = upSynDrttAvg;
    }

    public Float getDownSynDrttAvg() {
        return downSynDrttAvg;
    }

    public void setDownSynDrttAvg(Float downSynDrttAvg) {
        this.downSynDrttAvg = downSynDrttAvg;
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