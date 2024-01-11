package com.pojo;

import java.util.Date;

public class HttpDelayKpiIndex {
    private Long id;

    private String clientLocation;

    private String clientMacAddress;

    private String uuid;

    private Integer mainType;

    private Integer subType;

    private Float delayAvg;

    private Integer sslCnt;

    private Float shDelayAvg;

    private Integer helloCnt;

    private Float chDelayAvg;

    private Integer cHelloCnt;

    private Float fdDelayAvg;

    private Integer fDataCnt;

    private Float asDelayAvg;

    private Integer askSskCnt;

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

    public Float getDelayAvg() {
        return delayAvg;
    }

    public void setDelayAvg(Float delayAvg) {
        this.delayAvg = delayAvg;
    }

    public Integer getSslCnt() {
        return sslCnt;
    }

    public void setSslCnt(Integer sslCnt) {
        this.sslCnt = sslCnt;
    }

    public Float getShDelayAvg() {
        return shDelayAvg;
    }

    public void setShDelayAvg(Float shDelayAvg) {
        this.shDelayAvg = shDelayAvg;
    }

    public Integer getHelloCnt() {
        return helloCnt;
    }

    public void setHelloCnt(Integer helloCnt) {
        this.helloCnt = helloCnt;
    }

    public Float getChDelayAvg() {
        return chDelayAvg;
    }

    public void setChDelayAvg(Float chDelayAvg) {
        this.chDelayAvg = chDelayAvg;
    }

    public Integer getcHelloCnt() {
        return cHelloCnt;
    }

    public void setcHelloCnt(Integer cHelloCnt) {
        this.cHelloCnt = cHelloCnt;
    }

    public Float getFdDelayAvg() {
        return fdDelayAvg;
    }

    public void setFdDelayAvg(Float fdDelayAvg) {
        this.fdDelayAvg = fdDelayAvg;
    }

    public Integer getfDataCnt() {
        return fDataCnt;
    }

    public void setfDataCnt(Integer fDataCnt) {
        this.fDataCnt = fDataCnt;
    }

    public Float getAsDelayAvg() {
        return asDelayAvg;
    }

    public void setAsDelayAvg(Float asDelayAvg) {
        this.asDelayAvg = asDelayAvg;
    }

    public Integer getAskSskCnt() {
        return askSskCnt;
    }

    public void setAskSskCnt(Integer askSskCnt) {
        this.askSskCnt = askSskCnt;
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