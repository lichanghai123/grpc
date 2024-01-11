package com.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class QueueKpiRaw {
    private Long id;
    private String devIp;
    private String portName;
    private Date collectTime;
    private String channelNo;
    private Integer queIndex;
    private Long passBytes;
    private Long passPkt;
    private Long dropPkt;
    private Long passGreenBytes;
    private Long passGreenPkt;
    private Long dropGreenPkt;
    private Long passYellowBytes;
    private Long passYellowPkt;
    private Long dropYellowPkt;
}