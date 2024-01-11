package com.pojo;

import java.util.Date;

public class OnuLineQuality {
    private Long id;

    private String devIp;

    private String portName;

    private Date collectTime;

    private Integer lofiAlarmCount;

    private Integer dowiAlarmCount;

    private Integer delimiterErrorCount;

    private Long upbipErrorCount;

    private Long downbipErrorCount;

    private Long fecBlock;

    private Long fecErrorBlock;

    private Long fecTotalBlock;

    private Long upFecByte;

    private Long hecErrorCount;

    private Long gemCount;

    private Integer losiAlarmCount;

    private Integer dgiAlarmCount;

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

    public Integer getLofiAlarmCount() {
        return lofiAlarmCount;
    }

    public void setLofiAlarmCount(Integer lofiAlarmCount) {
        this.lofiAlarmCount = lofiAlarmCount;
    }

    public Integer getDowiAlarmCount() {
        return dowiAlarmCount;
    }

    public void setDowiAlarmCount(Integer dowiAlarmCount) {
        this.dowiAlarmCount = dowiAlarmCount;
    }

    public Integer getDelimiterErrorCount() {
        return delimiterErrorCount;
    }

    public void setDelimiterErrorCount(Integer delimiterErrorCount) {
        this.delimiterErrorCount = delimiterErrorCount;
    }

    public Long getUpbipErrorCount() {
        return upbipErrorCount;
    }

    public void setUpbipErrorCount(Long upbipErrorCount) {
        this.upbipErrorCount = upbipErrorCount;
    }

    public Long getDownbipErrorCount() {
        return downbipErrorCount;
    }

    public void setDownbipErrorCount(Long downbipErrorCount) {
        this.downbipErrorCount = downbipErrorCount;
    }

    public Long getFecBlock() {
        return fecBlock;
    }

    public void setFecBlock(Long fecBlock) {
        this.fecBlock = fecBlock;
    }

    public Long getFecErrorBlock() {
        return fecErrorBlock;
    }

    public void setFecErrorBlock(Long fecErrorBlock) {
        this.fecErrorBlock = fecErrorBlock;
    }

    public Long getFecTotalBlock() {
        return fecTotalBlock;
    }

    public void setFecTotalBlock(Long fecTotalBlock) {
        this.fecTotalBlock = fecTotalBlock;
    }

    public Long getUpFecByte() {
        return upFecByte;
    }

    public void setUpFecByte(Long upFecByte) {
        this.upFecByte = upFecByte;
    }

    public Long getHecErrorCount() {
        return hecErrorCount;
    }

    public void setHecErrorCount(Long hecErrorCount) {
        this.hecErrorCount = hecErrorCount;
    }

    public Long getGemCount() {
        return gemCount;
    }

    public void setGemCount(Long gemCount) {
        this.gemCount = gemCount;
    }

    public Integer getLosiAlarmCount() {
        return losiAlarmCount;
    }

    public void setLosiAlarmCount(Integer losiAlarmCount) {
        this.losiAlarmCount = losiAlarmCount;
    }

    public Integer getDgiAlarmCount() {
        return dgiAlarmCount;
    }

    public void setDgiAlarmCount(Integer dgiAlarmCount) {
        this.dgiAlarmCount = dgiAlarmCount;
    }
}