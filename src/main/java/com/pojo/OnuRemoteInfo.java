package com.pojo;

import java.util.Date;

public class OnuRemoteInfo {
    private Long id;

    private String devIp;

    private String portName;

    private Date collectTime;

    private Long correctedBytes;

    private Long correctedWords;

    private Long uncorrectedWords;

    private Long totalRxCodeWords;

    private Integer fecSeconds;

    private Long hecErrorCount;

    private Long keyErrorCount;

    private Integer memOccup;

    private Integer cpuOccup;

    private Integer cpuTemp;

    private Long sendPackets;

    private Long recvPackets;

    private Long recvErrorsPackets;

    private Long droppedPackets;

    private Long passingPackets;

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

    public Long getCorrectedBytes() {
        return correctedBytes;
    }

    public void setCorrectedBytes(Long correctedBytes) {
        this.correctedBytes = correctedBytes;
    }

    public Long getCorrectedWords() {
        return correctedWords;
    }

    public void setCorrectedWords(Long correctedWords) {
        this.correctedWords = correctedWords;
    }

    public Long getUncorrectedWords() {
        return uncorrectedWords;
    }

    public void setUncorrectedWords(Long uncorrectedWords) {
        this.uncorrectedWords = uncorrectedWords;
    }

    public Long getTotalRxCodeWords() {
        return totalRxCodeWords;
    }

    public void setTotalRxCodeWords(Long totalRxCodeWords) {
        this.totalRxCodeWords = totalRxCodeWords;
    }

    public Integer getFecSeconds() {
        return fecSeconds;
    }

    public void setFecSeconds(Integer fecSeconds) {
        this.fecSeconds = fecSeconds;
    }

    public Long getHecErrorCount() {
        return hecErrorCount;
    }

    public void setHecErrorCount(Long hecErrorCount) {
        this.hecErrorCount = hecErrorCount;
    }

    public Long getKeyErrorCount() {
        return keyErrorCount;
    }

    public void setKeyErrorCount(Long keyErrorCount) {
        this.keyErrorCount = keyErrorCount;
    }

    public Integer getMemOccup() {
        return memOccup;
    }

    public void setMemOccup(Integer memOccup) {
        this.memOccup = memOccup;
    }

    public Integer getCpuOccup() {
        return cpuOccup;
    }

    public void setCpuOccup(Integer cpuOccup) {
        this.cpuOccup = cpuOccup;
    }

    public Integer getCpuTemp() {
        return cpuTemp;
    }

    public void setCpuTemp(Integer cpuTemp) {
        this.cpuTemp = cpuTemp;
    }

    public Long getSendPackets() {
        return sendPackets;
    }

    public void setSendPackets(Long sendPackets) {
        this.sendPackets = sendPackets;
    }

    public Long getRecvPackets() {
        return recvPackets;
    }

    public void setRecvPackets(Long recvPackets) {
        this.recvPackets = recvPackets;
    }

    public Long getRecvErrorsPackets() {
        return recvErrorsPackets;
    }

    public void setRecvErrorsPackets(Long recvErrorsPackets) {
        this.recvErrorsPackets = recvErrorsPackets;
    }

    public Long getDroppedPackets() {
        return droppedPackets;
    }

    public void setDroppedPackets(Long droppedPackets) {
        this.droppedPackets = droppedPackets;
    }

    public Long getPassingPackets() {
        return passingPackets;
    }

    public void setPassingPackets(Long passingPackets) {
        this.passingPackets = passingPackets;
    }
}