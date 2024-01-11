package com.telemetry;

import java.util.Date;

import lombok.Data;

@Data
public class TelemetryRowGPBData {
	private Date timestamp;
	private Object content;
}
