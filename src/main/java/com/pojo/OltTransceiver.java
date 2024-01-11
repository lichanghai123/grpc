package com.pojo;

import java.util.Date;

public class OltTransceiver {
    private Long id;

    private String devIp;

    private String portName;

    private Date collectTime;

    private Integer temperature;

    private Integer supplyVoltage;

    private Integer channel1Type;

    private Integer channel1TxBias;

    private Integer channel1TxPower;

    private Integer channel1IdleRssi;

    private Integer channel2Type;

    private Integer channel2TxBias;

    private Integer channel2TxPower;

    private Integer channel2IdleRssi;

    private Integer moduleType;

    private String moduleSubType;

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

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getSupplyVoltage() {
        return supplyVoltage;
    }

    public void setSupplyVoltage(Integer supplyVoltage) {
        this.supplyVoltage = supplyVoltage;
    }

    public Integer getChannel1Type() {
        return channel1Type;
    }

    public void setChannel1Type(Integer channel1Type) {
        this.channel1Type = channel1Type;
    }

    public Integer getChannel1TxBias() {
        return channel1TxBias;
    }

    public void setChannel1TxBias(Integer channel1TxBias) {
        this.channel1TxBias = channel1TxBias;
    }

    public Integer getChannel1TxPower() {
        return channel1TxPower;
    }

    public void setChannel1TxPower(Integer channel1TxPower) {
        this.channel1TxPower = channel1TxPower;
    }

    public Integer getChannel1IdleRssi() {
        return channel1IdleRssi;
    }

    public void setChannel1IdleRssi(Integer channel1IdleRssi) {
        this.channel1IdleRssi = channel1IdleRssi;
    }

    public Integer getChannel2Type() {
        return channel2Type;
    }

    public void setChannel2Type(Integer channel2Type) {
        this.channel2Type = channel2Type;
    }

    public Integer getChannel2TxBias() {
        return channel2TxBias;
    }

    public void setChannel2TxBias(Integer channel2TxBias) {
        this.channel2TxBias = channel2TxBias;
    }

    public Integer getChannel2TxPower() {
        return channel2TxPower;
    }

    public void setChannel2TxPower(Integer channel2TxPower) {
        this.channel2TxPower = channel2TxPower;
    }

    public Integer getChannel2IdleRssi() {
        return channel2IdleRssi;
    }

    public void setChannel2IdleRssi(Integer channel2IdleRssi) {
        this.channel2IdleRssi = channel2IdleRssi;
    }

    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    public String getModuleSubType() {
        return moduleSubType;
    }

    public void setModuleSubType(String moduleSubType) {
        this.moduleSubType = moduleSubType;
    }
}