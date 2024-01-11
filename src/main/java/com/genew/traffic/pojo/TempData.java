package com.genew.traffic.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class TempData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String mainTypeName;
	
	private int mainType;
	
	private String subTypeName;
	
	private int subType;
	
	private String destIp;

	private String destPort;

	private String protocol;

	private String tableName;//表名
	
	private String tempName;//全网唯一
	
	private String srcIp;//源ip
	
	private String srcPort;//源端口

}
