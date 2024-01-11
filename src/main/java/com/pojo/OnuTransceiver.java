package com.pojo;

import java.util.Date;

import lombok.Data;
@Data
public class OnuTransceiver {
    private Long id;

    private String devIp;

    private String portName;

    private Date collectTime;

    private Integer rxPower;

    private Integer txPower;

    private Integer laserBiasCurrent;

    private Integer temperature;

    private Integer voltage;

    private Integer moduleType;

    private String subType;

   
}