package com.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class OnuTrafficRaw {
    private Long id;
    private String devIp;
    private String portName;
    private Date collectTime;
    private Integer txRate;
    private Integer rxRate;
    private Integer txPeakRate;
    private Integer rxPeakRate;
    
}