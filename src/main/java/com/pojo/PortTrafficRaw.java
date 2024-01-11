package com.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class PortTrafficRaw {
    private Long id;
    private String devIp;
    private String portName;
    private Date collectTime;
    private Long receivedBytes;
    private Long sentBytes;
    private Long portTxPkt;
    private Long portRxPkt;
    private Long txDiscardPkt;
    private Long rxDiscardPkt;
    private Long rxCrcErrorPkt;
    private Long rxOversizedDiscardPkt;
    private Long rxUndersizedDiscardPkt;
    private Long rxErrorPkt;
    private Integer txRate;
    private Integer rxRate;
    private Integer txPeakRate;
    private Integer rxPeakRate;
    
    private Integer channelNo;
}