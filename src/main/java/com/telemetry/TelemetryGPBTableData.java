package com.telemetry;

import java.util.List;

import lombok.Data;

@Data
public class TelemetryGPBTableData {
	private String hostName;
	private String tableName;
	private List<TelemetryRowGPBData> rowDatas;
}
