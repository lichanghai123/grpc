package com.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class EthernetKpiRaw {
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
    private Long rxAlignmentErrPkt;
    private Long txCrcErrorPkt;
    private Long rxCrcErrorPkt;
    private Long txOversizedPkt;
    private Long rxOversizedPkt;
    private Long txUndersizedPkt;
    private Long rxUndersizedPkt;
    private Long txFragmentPkt;
    private Long rxFragmentPkt;
    private Long txJabberPkt;
    private Long rxJabberPkt;
    private Long txErrorPkt;
    private Long rxErrorPkt;
    private Long txRate;
    private Long rxRate;
    private Long txPeakRate;
    private Long rxPeakRate;
    
}