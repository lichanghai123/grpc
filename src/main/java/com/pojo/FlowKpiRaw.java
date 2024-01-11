package com.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class FlowKpiRaw {
    private Long id;
    private String devIp;
    private String portName;
    private Date collectTime;
    private Long dropCnt;
    private Long passCnt;
    private Integer dropMax;
    private Integer dropMin;
    private Integer dropRateMax;
    private Integer dropRateMin;
    private Integer dropSecondsCnt;
    private Long passBytes;
    private Integer mfrAvg;
    private Long upPassBytes;
    private Long upPassCnt;
    private Long updropCnt;
    
}