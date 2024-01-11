package com.pojo;

import java.util.Date;

public class PortTrafficStatisticIndex {
    private Long id;

    private Integer packetSniffRate;

    private Float sniffRate;

    private Integer sniffPacketsCnt;

    private Integer sniffBytesCnt;

    private String devIp;

    private Date collectTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPacketSniffRate() {
        return packetSniffRate;
    }

    public void setPacketSniffRate(Integer packetSniffRate) {
        this.packetSniffRate = packetSniffRate;
    }

    public Float getSniffRate() {
        return sniffRate;
    }

    public void setSniffRate(Float sniffRate) {
        this.sniffRate = sniffRate;
    }

    public Integer getSniffPacketsCnt() {
        return sniffPacketsCnt;
    }

    public void setSniffPacketsCnt(Integer sniffPacketsCnt) {
        this.sniffPacketsCnt = sniffPacketsCnt;
    }

    public Integer getSniffBytesCnt() {
        return sniffBytesCnt;
    }

    public void setSniffBytesCnt(Integer sniffBytesCnt) {
        this.sniffBytesCnt = sniffBytesCnt;
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