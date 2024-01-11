package com.core;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.component.RedisClient;
import com.mapper.DnsKpiIndexMapper;
/*import com.mapper.EthernetKpiRawMapper;
import com.mapper.FlowKpiRawMapper;*/
import com.mapper.HttpDelayKpiIndexMapper;
import com.mapper.HttpKpiIndexMapper;
import com.mapper.PortTrafficStatisticsMapper;
import com.mapper.PppoeEventMapper;
import com.mapper.PppoeKpiEventMapper;
/*import com.mapper.OltTransceiverMapper;
import com.mapper.OnuLineQualityMapper;
import com.mapper.OnuLocalInfoMapper;
import com.mapper.OnuRemoteInfoMapper;
import com.mapper.OnuTrafficRawMapper;
import com.mapper.OnuTransceiverMapper;
import com.mapper.PortTrafficRawMapper;
import com.mapper.QueueKpiRawMapper;*/
import com.mapper.RtpKpiIndexMapper;
import com.mapper.TcpConnectIndexMapper;
import com.mapper.TcpKpiIndexMapper;
import com.mapper.TerminalEventMapper;
import com.mapper.UdpKpiIndexMapper;
import com.mapper.UserIdentityEventMapper;
import com.pojo.DnsKpiIndex;
/*import com.pojo.EthernetKpiRaw;
import com.pojo.FlowKpiRaw;*/
import com.pojo.HttpDelayKpiIndex;
import com.pojo.HttpKpiIndex;
import com.pojo.PortTrafficStatisticIndex;
import com.pojo.PppoeEvent;
import com.pojo.PppoeKpiEvent;
/*import com.pojo.OltTransceiver;
import com.pojo.OnuLineQuality;
import com.pojo.OnuLocalInfo;
import com.pojo.OnuRemoteInfo;
import com.pojo.OnuTrafficRaw;
import com.pojo.OnuTransceiver;
import com.pojo.PortTrafficRaw;
import com.pojo.QueueKpiRaw;*/
import com.pojo.RtpKpiIndex;
import com.pojo.TcpConnectIndex;
import com.pojo.TcpKpiIndex;
import com.pojo.TerminalEvent;
import com.pojo.UdpKpiIndex;
import com.pojo.UserIdentityEvent;
/*import com.telemetry.AnBbQueueKpi.QueueKpiRecords;
import com.telemetry.AnBbQueueKpi.QueueKpiRecords.QueueKpiRecord;
import com.telemetry.AnBbServiceFlowKpi.ServiceFlowKpiRecords;
import com.telemetry.AnBbServiceFlowKpi.ServiceFlowKpiRecords.ServiceFlowKpiRecord;
import com.telemetry.AnEthernetKpi.EthernetPortKpiRecords;
import com.telemetry.AnEthernetKpi.EthernetPortKpiRecords.EthernetPortKpiRecord;
import com.telemetry.AnGponOnuTransceivers.GponOnuTransceivers;
import com.telemetry.AnGponOnuTransceivers.GponOnuTransceivers.GponOnuTransceiver;
import com.telemetry.AnGponPmOltTraffic.GponPmOltChannelTraffics;
import com.telemetry.AnGponPmOltTraffic.GponPmOltChannelTraffics.GponPmOltChannelTraffic;
import com.telemetry.AnGponPmOltTraffic.GponPmOltTraffics;
import com.telemetry.AnGponPmOltTraffic.GponPmOltTraffics.GponPmOltTraffic;
import com.telemetry.AnGponPmOltTransceivers.GponOltTransceivers;
import com.telemetry.AnGponPmOltTransceivers.GponOltTransceivers.GponOltTransceiver;
import com.telemetry.AnGponPmOnuLineQuality.GponPmOnuLineQualitys;
import com.telemetry.AnGponPmOnuLineQuality.GponPmOnuLineQualitys.GponPmOnuLineQuality;
import com.telemetry.AnGponPmOnuLocalInfo.GponPmOnuLocalInfos;
import com.telemetry.AnGponPmOnuLocalInfo.GponPmOnuLocalInfos.GponPmOnuLocalInfo;
import com.telemetry.AnGponPmOnuRemoteInfo.GponPmOnuRemoteInfos;
import com.telemetry.AnGponPmOnuRemoteInfo.GponPmOnuRemoteInfos.GponPmOnuRemoteInfo;
import com.telemetry.AnGponPmOnuTraffic.GponPmOnuTraffics;
import com.telemetry.AnGponPmOnuTraffic.GponPmOnuTraffics.GponPmOnuTraffic;*/
import com.telemetry.ApplicationContextUtil;
import com.telemetry.GnDnsKpiIndex.DnsKpiIndexes;
import com.telemetry.GnHttpDelayKpiIndex.HttpDelayKpiIndexes;
import com.telemetry.GnHttpKpiIndex.HttpKpiIndexes;
import com.telemetry.GnPortTrafficStatistics;
import com.telemetry.GnPortTrafficStatistics.PortTrafficStatistics;
import com.telemetry.GnPortTrafficStatistics.PortTrafficStatistics.PortTrafficStatistic;
import com.telemetry.GnPppoeEvent.PppoeEvents;
import com.telemetry.GnPppoeKpiEvent.PppoeKpiEvents;
import com.telemetry.GnRtpKpiIndex.RtpKpiIndexes;
import com.telemetry.GnTcpConnectIndex.TcpConnectIndexes;
import com.telemetry.GnTcpKpiIndex.TcpKpiIndexes;
import com.telemetry.GnTerminalEvent.TerminalEvents;
import com.telemetry.GnUdpKpiIndex.UdpKpiIndexes;
import com.telemetry.GnUserIdentityEvent.UserIdentityEvents;
import com.telemetry.TelemetryGPBTableData;
import com.telemetry.TelemetryRowGPBData;
import com.util.TrafficUtil;


/**
 * @author LiuCheng
 * @date 2021/6/22 19:24
 */

public class TelemetryMessageEventProcessor implements Runnable {

    private TelemetryGPBTableData telemetryMessage;
    
    public TelemetryMessageEventProcessor(TelemetryGPBTableData telemetryMessage) {
        this.telemetryMessage = telemetryMessage;
    }

    @Override
    public void run() {
    	String tableName = TrafficUtil.getTableNameByPath(telemetryMessage.getTableName());
    	if(tableName != null){
    		String className= telemetryMessage.getTableName().split(":")[1];
    		String devIp =telemetryMessage.getHostName();
	    	for (TelemetryRowGPBData telemetryRowGPBData : telemetryMessage.getRowDatas()) {
	    		switch (className) {
				case "DnsKpiIndexes":
					List<DnsKpiIndex> dbDnsKpiIndexes = new ArrayList<DnsKpiIndex>();
					DnsKpiIndexes gDnsKpiIndexes = (DnsKpiIndexes)telemetryRowGPBData.getContent();
					List<DnsKpiIndexes.DnsKpiIndex> devDnsKpiIndexes = gDnsKpiIndexes.getDnsKpiIndexList();
					for (DnsKpiIndexes.DnsKpiIndex gponDnsKpiIndex : devDnsKpiIndexes) {
						DnsKpiIndex portTrafficRaw = new DnsKpiIndex();
						portTrafficRaw.setDevIp(devIp);
						portTrafficRaw.setCollectTime(telemetryRowGPBData.getTimestamp());
						portTrafficRaw.setAvgDelay(gponDnsKpiIndex.getAvgDelay());
						portTrafficRaw.setClientIp(gponDnsKpiIndex.getDnsClientIp());
						String loction = gponDnsKpiIndex.getClientLocation();
						try {
							RedisClient redisClient = ApplicationContextUtil.getBean(RedisClient.class);
							loction = redisClient.getLocation("LTMac-"+gponDnsKpiIndex.getClientMacAddress());
						} catch (Exception e) {
						}
						portTrafficRaw.setClientLocation(loction);
						portTrafficRaw.setClientMacAddress(gponDnsKpiIndex.getClientMacAddress());
						portTrafficRaw.setInvalidNum(gponDnsKpiIndex.getInvalidNum());
						portTrafficRaw.setNoErrorNum(gponDnsKpiIndex.getNoErrorNum());
						portTrafficRaw.setServerIp(gponDnsKpiIndex.getDnsServerIp());
						portTrafficRaw.setTotalNum(gponDnsKpiIndex.getTotalNum());
						portTrafficRaw.setUuid(gponDnsKpiIndex.getUuid());
						portTrafficRaw.setStartTime(new Date(gponDnsKpiIndex.getStartTime()*1000L));
						portTrafficRaw.setEndTime(new Date(gponDnsKpiIndex.getEndTime()*1000L));
						dbDnsKpiIndexes.add(portTrafficRaw);
					}
					if(dbDnsKpiIndexes.size() > 0){
						DnsKpiIndexMapper portTrafficRawMapper = ApplicationContextUtil.getBean(DnsKpiIndexMapper.class);
						portTrafficRawMapper.batchInsert(tableName, dbDnsKpiIndexes);
					}
					break;
				case "HttpDelayKpiIndexes":
					List<HttpDelayKpiIndex> dbHttpDelayKpiIndexes = new ArrayList<HttpDelayKpiIndex>();
					HttpDelayKpiIndexes gHttpDelayKpiIndexes = (HttpDelayKpiIndexes)telemetryRowGPBData.getContent();
					List<HttpDelayKpiIndexes.HttpDelayKpiIndex> devHttpDelayKpiIndexes = gHttpDelayKpiIndexes.getHttpDelayKpiIndexList();
					for (HttpDelayKpiIndexes.HttpDelayKpiIndex gponHttpDelayKpiIndex : devHttpDelayKpiIndexes) {
						HttpDelayKpiIndex portTrafficRaw = new HttpDelayKpiIndex();
						portTrafficRaw.setDevIp(devIp);
						portTrafficRaw.setCollectTime(telemetryRowGPBData.getTimestamp());
						portTrafficRaw.setAsDelayAvg(gponHttpDelayKpiIndex.getAckSslDelayAvg());
						portTrafficRaw.setAskSskCnt(gponHttpDelayKpiIndex.getAckSslCnt());
						portTrafficRaw.setChDelayAvg(gponHttpDelayKpiIndex.getClientHelloDelayAvg());
						portTrafficRaw.setcHelloCnt(gponHttpDelayKpiIndex.getClientHelloCnt());
						String loction = gponHttpDelayKpiIndex.getClientLocation();
						try {
							RedisClient redisClient = ApplicationContextUtil.getBean(RedisClient.class);
							loction = redisClient.getLocation("LTMac-"+gponHttpDelayKpiIndex.getClientMacAddress());
						} catch (Exception e) {
						}
						portTrafficRaw.setClientLocation(loction);
						portTrafficRaw.setClientMacAddress(gponHttpDelayKpiIndex.getClientMacAddress());
						portTrafficRaw.setDelayAvg(gponHttpDelayKpiIndex.getSslDelayAvg());
						portTrafficRaw.setfDataCnt(gponHttpDelayKpiIndex.getFirstDataCnt());
						portTrafficRaw.setFdDelayAvg(gponHttpDelayKpiIndex.getFirstDataDelayAvg());
						portTrafficRaw.setHelloCnt(gponHttpDelayKpiIndex.getClientHelloCnt());
						portTrafficRaw.setMainType(gponHttpDelayKpiIndex.getApplicationMainType());
						portTrafficRaw.setShDelayAvg(gponHttpDelayKpiIndex.getServerHelloDelayAvg());
						portTrafficRaw.setSslCnt(gponHttpDelayKpiIndex.getSslCnt());
						portTrafficRaw.setSubType(gponHttpDelayKpiIndex.getApplicationSubType());
						portTrafficRaw.setUuid(gponHttpDelayKpiIndex.getUuid());
						portTrafficRaw.setStartTime(new Date(gponHttpDelayKpiIndex.getStartTime()*1000L));
						portTrafficRaw.setEndTime(new Date(gponHttpDelayKpiIndex.getEndTime()*1000L));
						dbHttpDelayKpiIndexes.add(portTrafficRaw);
					}
					if(dbHttpDelayKpiIndexes.size() > 0){
						HttpDelayKpiIndexMapper portTrafficRawMapper = ApplicationContextUtil.getBean(HttpDelayKpiIndexMapper.class);
						portTrafficRawMapper.batchInsert(tableName, dbHttpDelayKpiIndexes);
					}
					break;
				case "HttpKpiIndexes":
					List<HttpKpiIndex> dbHttpKpiIndexes = new ArrayList<HttpKpiIndex>();
					HttpKpiIndexes gHttpKpiIndexes = (HttpKpiIndexes)telemetryRowGPBData.getContent();
					List<HttpKpiIndexes.HttpKpiIndex> devHttpKpiIndexes = gHttpKpiIndexes.getHttpKpiIndexList();
					for (HttpKpiIndexes.HttpKpiIndex gponHttpKpiIndex : devHttpKpiIndexes) {
						HttpKpiIndex portTrafficRaw = new HttpKpiIndex();
						portTrafficRaw.setDevIp(devIp);
						portTrafficRaw.setCollectTime(telemetryRowGPBData.getTimestamp());
						String loction = gponHttpKpiIndex.getClientLocation();
						try {
							RedisClient redisClient = ApplicationContextUtil.getBean(RedisClient.class);
							loction = redisClient.getLocation("LTMac-"+gponHttpKpiIndex.getClientMacAddress());
						} catch (Exception e) {
						}
						portTrafficRaw.setClientLocation(loction);
						portTrafficRaw.setClientMacAddress(gponHttpKpiIndex.getClientMacAddress());
						portTrafficRaw.setFgDelayAvg(gponHttpKpiIndex.getFirstGetDelayAvg());
						portTrafficRaw.setFgSuccCnt(gponHttpKpiIndex.getFirstGetSuccCnt());
						portTrafficRaw.setGetCnt(gponHttpKpiIndex.getGetCnt());
						portTrafficRaw.setGetSuccCnt(gponHttpKpiIndex.getGetSuccCnt());
						portTrafficRaw.setMainType(gponHttpKpiIndex.getApplicationMainType());
						portTrafficRaw.setSubType(gponHttpKpiIndex.getApplicationSubType());
						portTrafficRaw.setUuid(gponHttpKpiIndex.getUuid());
						portTrafficRaw.setStartTime(new Date(gponHttpKpiIndex.getStartTime()*1000L));
						portTrafficRaw.setEndTime(new Date(gponHttpKpiIndex.getEndTime()*1000L));
						dbHttpKpiIndexes.add(portTrafficRaw);
					}
					if(dbHttpKpiIndexes.size() > 0){
						HttpKpiIndexMapper portTrafficRawMapper = ApplicationContextUtil.getBean(HttpKpiIndexMapper.class);
						portTrafficRawMapper.batchInsert(tableName, dbHttpKpiIndexes);
					}
					break;
				case "RtpKpiIndexes":
					List<RtpKpiIndex> dbRtpKpiIndexes = new ArrayList<RtpKpiIndex>();
					RtpKpiIndexes gRtpKpiIndexes = (RtpKpiIndexes)telemetryRowGPBData.getContent();
					List<RtpKpiIndexes.RtpKpiIndex> devRtpKpiIndexes = gRtpKpiIndexes.getRtpKpiIndexList();
					for (RtpKpiIndexes.RtpKpiIndex gponRtpKpiIndex : devRtpKpiIndexes) {
						RtpKpiIndex portTrafficRaw = new RtpKpiIndex();
						portTrafficRaw.setDevIp(devIp);
						portTrafficRaw.setCollectTime(telemetryRowGPBData.getTimestamp());
						portTrafficRaw.setAppIdentify(gponRtpKpiIndex.getApplicationIdentify());
						String loction = gponRtpKpiIndex.getClientLocation();
						try {
							RedisClient redisClient = ApplicationContextUtil.getBean(RedisClient.class);
							loction = redisClient.getLocation("LTMac-"+gponRtpKpiIndex.getClientMacAddress());
						} catch (Exception e) {
						}
						portTrafficRaw.setClientLocation(loction);
						portTrafficRaw.setClientMacAddress(gponRtpKpiIndex.getClientMacAddress());
						portTrafficRaw.setDownwardDplCnt(gponRtpKpiIndex.getDownwardDplCnt());
						portTrafficRaw.setDownwardMfrAvg(gponRtpKpiIndex.getDownwardMfrAvg());
						portTrafficRaw.setDownwardMfrMax(gponRtpKpiIndex.getDownwardMfrMax());
						portTrafficRaw.setDownwardPpCnt(gponRtpKpiIndex.getDownwardPpCnt());
						portTrafficRaw.setDownwardUcplTimeMax(gponRtpKpiIndex.getDownwardUcplTimeMax());
						portTrafficRaw.setDownwardUpdtAvg(gponRtpKpiIndex.getDownwardUpdtAvg());
						portTrafficRaw.setDownwardUpdtMax(gponRtpKpiIndex.getDownwardUpdtMax());
						portTrafficRaw.setDownwardUplCnt(gponRtpKpiIndex.getDownwardUplCnt());
						portTrafficRaw.setFlow(gponRtpKpiIndex.getFlow());
						portTrafficRaw.setMainType(gponRtpKpiIndex.getApplicationMainType());
						portTrafficRaw.setSubType(gponRtpKpiIndex.getApplicationSubType());
						portTrafficRaw.setUpwardDplCnt(gponRtpKpiIndex.getUpwardDplCnt());
						portTrafficRaw.setUpwardMfrAvg(gponRtpKpiIndex.getUpwardMfrAvg());
						portTrafficRaw.setUpwardMfrMax(gponRtpKpiIndex.getUpwardMfrMax());
						portTrafficRaw.setUpwardPpCnt(gponRtpKpiIndex.getUpwardPpCnt());
						portTrafficRaw.setUpwardUplCnt(gponRtpKpiIndex.getUpwardUplCnt());
						portTrafficRaw.setUpwardUpdtMax(gponRtpKpiIndex.getUpwardUpdtMax());
						portTrafficRaw.setUpwardUcplTimeMax(gponRtpKpiIndex.getUpwardUcplTimeMax());
						portTrafficRaw.setUpwardUpdtAvg(gponRtpKpiIndex.getUpwardUpdtAvg());
						portTrafficRaw.setUuid(gponRtpKpiIndex.getUuid());
						portTrafficRaw.setStartTime(new Date(gponRtpKpiIndex.getStartTime()*1000L));
						portTrafficRaw.setEndTime(new Date(gponRtpKpiIndex.getEndTime()*1000L));
						portTrafficRaw.setUpSendBytesCnt(gponRtpKpiIndex.getUpwardSendBytesCnt());
						portTrafficRaw.setDownSendBytesCnt(gponRtpKpiIndex.getDownwardSendBytesCnt());
						dbRtpKpiIndexes.add(portTrafficRaw);
					}
					if(dbRtpKpiIndexes.size() > 0){
						RtpKpiIndexMapper portTrafficRawMapper = ApplicationContextUtil.getBean(RtpKpiIndexMapper.class);
						portTrafficRawMapper.batchInsert(tableName, dbRtpKpiIndexes);
					}
					break;
				case "TcpConnectIndexes":
					List<TcpConnectIndex> dbTcpConnectIndexes = new ArrayList<TcpConnectIndex>();
					TcpConnectIndexes gTcpConnectIndexes = (TcpConnectIndexes)telemetryRowGPBData.getContent();
					List<TcpConnectIndexes.TcpConnectIndex> devTcpConnectIndexes = gTcpConnectIndexes.getTcpConnectIndexList();
					for (TcpConnectIndexes.TcpConnectIndex gponTcpConnectIndex : devTcpConnectIndexes) {
						TcpConnectIndex portTrafficRaw = new TcpConnectIndex();
						portTrafficRaw.setDevIp(devIp);
						portTrafficRaw.setCollectTime(telemetryRowGPBData.getTimestamp());
						String loction = gponTcpConnectIndex.getClientLocation();
						try {
							RedisClient redisClient = ApplicationContextUtil.getBean(RedisClient.class);
							loction = redisClient.getLocation("LTMac-"+gponTcpConnectIndex.getClientMacAddress());
						} catch (Exception e) {
						}
						portTrafficRaw.setClientLocation(loction);
						portTrafficRaw.setClientMacAddress(gponTcpConnectIndex.getClientMacAddress());
						portTrafficRaw.setDownSynDrttAvg(gponTcpConnectIndex.getDownwardSynDrttAvg());
						portTrafficRaw.setUpConnectAckCnt(gponTcpConnectIndex.getUpwardConnectAckCnt());
						portTrafficRaw.setUpConnectInitCnt(gponTcpConnectIndex.getUpwardConnectInitCnt());
						portTrafficRaw.setUpConnectSuccCnt(gponTcpConnectIndex.getUpwardConnectSuccCnt());
						portTrafficRaw.setUpSynDrttAvg(gponTcpConnectIndex.getUpwardSynDrttAvg());
						portTrafficRaw.setUuid(gponTcpConnectIndex.getUuid());
						portTrafficRaw.setStartTime(new Date(gponTcpConnectIndex.getStartTime()*1000L));
						portTrafficRaw.setEndTime(new Date(gponTcpConnectIndex.getEndTime()*1000L));
						dbTcpConnectIndexes.add(portTrafficRaw);
					}
					if(dbTcpConnectIndexes.size() > 0){
						TcpConnectIndexMapper portTrafficRawMapper = ApplicationContextUtil.getBean(TcpConnectIndexMapper.class);
						portTrafficRawMapper.batchInsert(tableName, dbTcpConnectIndexes);
					}
					break;
				case "TcpKpiIndexes":
					List<TcpKpiIndex> dbTcpKpiIndexes = new ArrayList<TcpKpiIndex>();
					TcpKpiIndexes gTcpKpiIndexes = (TcpKpiIndexes)telemetryRowGPBData.getContent();
					List<TcpKpiIndexes.TcpKpiIndex> devTcpKpiIndexes = gTcpKpiIndexes.getTcpKpiIndexList();
					for (TcpKpiIndexes.TcpKpiIndex gponTcpKpiIndex : devTcpKpiIndexes) {
						TcpKpiIndex portTrafficRaw = new TcpKpiIndex();
						portTrafficRaw.setDevIp(devIp);
						portTrafficRaw.setCollectTime(telemetryRowGPBData.getTimestamp());
						portTrafficRaw.setAppIdentify(gponTcpKpiIndex.getApplicationIdentify());
						String loction = gponTcpKpiIndex.getClientLocation();
						try {
							RedisClient redisClient = ApplicationContextUtil.getBean(RedisClient.class);
							loction = redisClient.getLocation("LTMac-"+gponTcpKpiIndex.getClientMacAddress());
						} catch (Exception e) {
						}
						portTrafficRaw.setClientLocation(loction);
						portTrafficRaw.setClientMacAddress(gponTcpKpiIndex.getClientMacAddress());
						portTrafficRaw.setDownDplCnt(gponTcpKpiIndex.getDownwardDplCnt());
						portTrafficRaw.setDownDrtjAvg(gponTcpKpiIndex.getDownwardDrtjAvg());
						portTrafficRaw.setDownDrtjMax(gponTcpKpiIndex.getDownwardDrtjMax());
						portTrafficRaw.setDownDrttAvg(gponTcpKpiIndex.getDownwardDrttAvg());
						portTrafficRaw.setDownDrttMax(gponTcpKpiIndex.getDownwardDrttMax());
						portTrafficRaw.setDownDrttMin(gponTcpKpiIndex.getDownwardDrttMin());
						portTrafficRaw.setDownDupCnt(gponTcpKpiIndex.getDownwardDupCnt());
						portTrafficRaw.setDownMfrAvg(gponTcpKpiIndex.getDownwardMfrAvg());
						portTrafficRaw.setDownMfrMax(gponTcpKpiIndex.getDownwardMfrMax());
						portTrafficRaw.setDownOooCnt(gponTcpKpiIndex.getDownwardOooCnt());
						portTrafficRaw.setDownPpCnt(gponTcpKpiIndex.getDownwardPpCnt());
						portTrafficRaw.setDownUplCnt(gponTcpKpiIndex.getDownwardUplCnt());
						portTrafficRaw.setFlow(gponTcpKpiIndex.getFlow());
						portTrafficRaw.setMainType(gponTcpKpiIndex.getApplicationMainType());
						portTrafficRaw.setSubType(gponTcpKpiIndex.getApplicationSubType());
						portTrafficRaw.setUpDplCnt(gponTcpKpiIndex.getUpwardDplCnt());
						portTrafficRaw.setUpDrtjAvg(gponTcpKpiIndex.getUpwardDrtjAvg());
						portTrafficRaw.setUpDrtjMax(gponTcpKpiIndex.getUpwardDrtjMax());
						portTrafficRaw.setUpDrttAvg(gponTcpKpiIndex.getUpwardDrttAvg());
						portTrafficRaw.setUpDrttMax(gponTcpKpiIndex.getUpwardDrttMax());
						portTrafficRaw.setUpDrttMin(gponTcpKpiIndex.getUpwardDrttMin());
						portTrafficRaw.setUpDupCnt(gponTcpKpiIndex.getUpwardDupCnt());
						portTrafficRaw.setUpMfrAvg(gponTcpKpiIndex.getUpwardMfrAvg());
						portTrafficRaw.setUpMfrMax(gponTcpKpiIndex.getUpwardMfrMax());
						portTrafficRaw.setUpOooCnt(gponTcpKpiIndex.getUpwardOooCnt());
						portTrafficRaw.setUpPpCnt(gponTcpKpiIndex.getUpwardPpCnt());
						portTrafficRaw.setUpUplCnt(gponTcpKpiIndex.getUpwardUplCnt());
						portTrafficRaw.setUuid(gponTcpKpiIndex.getUuid());
						portTrafficRaw.setStartTime(new Date(gponTcpKpiIndex.getStartTime()*1000L));
						portTrafficRaw.setEndTime(new Date(gponTcpKpiIndex.getEndTime()*1000L));
						portTrafficRaw.setUpSendBytesCnt(gponTcpKpiIndex.getUpwardSendBytesCnt());
						portTrafficRaw.setDownRecvBytesCnt(gponTcpKpiIndex.getDownwardRecvBytesCnt());
						portTrafficRaw.setUpDrtjCnt1(gponTcpKpiIndex.getUpwardDrtjCnt1());
						portTrafficRaw.setUpDrtjCnt2(gponTcpKpiIndex.getUpwardDrtjCnt2());
						portTrafficRaw.setUpDrtjCnt3(gponTcpKpiIndex.getUpwardDrtjCnt3());
						portTrafficRaw.setUpDrtjCnt4(gponTcpKpiIndex.getUpwardDrtjCnt4());
						portTrafficRaw.setUpDrtjCnt5(gponTcpKpiIndex.getUpwardDrtjCnt5());
						portTrafficRaw.setDownDrtjCnt1(gponTcpKpiIndex.getDownwardDrtjCnt1());
						portTrafficRaw.setDownDrtjCnt2(gponTcpKpiIndex.getDownwardDrtjCnt2());
						portTrafficRaw.setDownDrtjCnt3(gponTcpKpiIndex.getDownwardDrtjCnt3());
						portTrafficRaw.setDownDrtjCnt4(gponTcpKpiIndex.getDownwardDrtjCnt4());
						portTrafficRaw.setDownDrtjCnt5(gponTcpKpiIndex.getDownwardDrtjCnt5());
						dbTcpKpiIndexes.add(portTrafficRaw);
					}
					if(dbTcpKpiIndexes.size() > 0){
						TcpKpiIndexMapper portTrafficRawMapper = ApplicationContextUtil.getBean(TcpKpiIndexMapper.class);
						portTrafficRawMapper.batchInsert(tableName, dbTcpKpiIndexes);
					}
					break;
				case "UdpKpiIndexes":
					List<UdpKpiIndex> dbUdpKpiIndexes = new ArrayList<UdpKpiIndex>();
					UdpKpiIndexes gUdpKpiIndexes = (UdpKpiIndexes)telemetryRowGPBData.getContent();
					List<UdpKpiIndexes.UdpKpiIndex> devUdpKpiIndexes = gUdpKpiIndexes.getUdpKpiIndexList();
					for (UdpKpiIndexes.UdpKpiIndex gponUdpKpiIndex : devUdpKpiIndexes) {
						UdpKpiIndex portTrafficRaw = new UdpKpiIndex();
						portTrafficRaw.setDevIp(devIp);
						portTrafficRaw.setCollectTime(telemetryRowGPBData.getTimestamp());
						portTrafficRaw.setAppIdentify(gponUdpKpiIndex.getApplicationIdentify());
						String loction = gponUdpKpiIndex.getClientLocation();
						try {
							RedisClient redisClient = ApplicationContextUtil.getBean(RedisClient.class);
							loction = redisClient.getLocation("LTMac-"+gponUdpKpiIndex.getClientMacAddress());
						} catch (Exception e) {
						}
						portTrafficRaw.setClientLocation(loction);
						portTrafficRaw.setClientMacAddress(gponUdpKpiIndex.getClientMacAddress());
						portTrafficRaw.setDownMfrAvg(gponUdpKpiIndex.getDownwardMfrAvg());
						portTrafficRaw.setDownMfrMax(gponUdpKpiIndex.getDownwardMfrMax());
						portTrafficRaw.setFlow(gponUdpKpiIndex.getFlow());
						portTrafficRaw.setMainType(gponUdpKpiIndex.getApplicationMainType());
						portTrafficRaw.setSubType(gponUdpKpiIndex.getApplicationSubType());
						portTrafficRaw.setUpMfrAvg(gponUdpKpiIndex.getUpwardMfrAvg());
						portTrafficRaw.setUpMfrMax(gponUdpKpiIndex.getUpwardMfrMax());
						portTrafficRaw.setUuid(gponUdpKpiIndex.getUuid());
						portTrafficRaw.setStartTime(new Date(gponUdpKpiIndex.getStartTime()*1000L));
						portTrafficRaw.setEndTime(new Date(gponUdpKpiIndex.getEndTime()*1000L));
						portTrafficRaw.setUpSendBytesCnt(gponUdpKpiIndex.getUpwardSendBytesCnt());
						portTrafficRaw.setDownRecvBytesCnt(gponUdpKpiIndex.getDownwardRecvBytesCnt());
						dbUdpKpiIndexes.add(portTrafficRaw);
					}
					if(dbUdpKpiIndexes.size() > 0){
						UdpKpiIndexMapper portTrafficRawMapper = ApplicationContextUtil.getBean(UdpKpiIndexMapper.class);
						portTrafficRawMapper.batchInsert(tableName, dbUdpKpiIndexes);
					}
					break;
				case "PortTrafficStatistics":
					List<PortTrafficStatisticIndex> dbPortTraffics = new ArrayList<PortTrafficStatisticIndex>();
					GnPortTrafficStatistics.PortTrafficStatistics gPortTraffic = (GnPortTrafficStatistics.PortTrafficStatistics)telemetryRowGPBData.getContent();
					List<PortTrafficStatistic> devPortTraffic = gPortTraffic.getPortTrafficStatisticList();
					for (PortTrafficStatistic gponPortTraffic : devPortTraffic) {
						PortTrafficStatisticIndex portTrafficRaw = new PortTrafficStatisticIndex();
						portTrafficRaw.setDevIp(devIp);
						portTrafficRaw.setCollectTime(telemetryRowGPBData.getTimestamp());
						portTrafficRaw.setPacketSniffRate(gponPortTraffic.getPacketSniffRate());
						portTrafficRaw.setSniffBytesCnt(gponPortTraffic.getSniffBytesCnt());
						portTrafficRaw.setSniffPacketsCnt(gponPortTraffic.getSniffPacketsCnt());
						portTrafficRaw.setSniffRate(gponPortTraffic.getSniffRate());
						dbPortTraffics.add(portTrafficRaw);
					}
					if(dbPortTraffics.size() > 0){
						PortTrafficStatisticsMapper portTrafficRawMapper = ApplicationContextUtil.getBean(PortTrafficStatisticsMapper.class);
						portTrafficRawMapper.batchInsert(tableName, dbPortTraffics);
					}
					break;
				case "PppoeEvent":
					List<PppoeEvent> dbPppoeEvents = new ArrayList<PppoeEvent>();
					PppoeEvents gPppoeEvents = (PppoeEvents)telemetryRowGPBData.getContent();
					List<PppoeEvents.PppoeEvent> devPppoeEvents = gPppoeEvents.getPppoeEventList();
					for (PppoeEvents.PppoeEvent gponPpoeEvent : devPppoeEvents) {
						PppoeEvent portTrafficRaw = new PppoeEvent();
						portTrafficRaw.setDevIp(devIp);
						portTrafficRaw.setCollectTime(telemetryRowGPBData.getTimestamp());
						portTrafficRaw.setClientMacAddress(gponPpoeEvent.getClientMacAddress());
						portTrafficRaw.setEventTime(new Date(gponPpoeEvent.getEventTime()*1L));
						portTrafficRaw.setStatAlarm(gponPpoeEvent.getStatAlarm());
						portTrafficRaw.setUserAccount(gponPpoeEvent.getUserAccount());
						dbPppoeEvents.add(portTrafficRaw);
					}
					if(dbPppoeEvents.size() > 0){
						PppoeEventMapper portTrafficRawMapper = ApplicationContextUtil.getBean(PppoeEventMapper.class);
						portTrafficRawMapper.batchInsert(tableName, dbPppoeEvents);
					}
					break;
				case "PppoeKpiEvent":
					List<PppoeKpiEvent> dbPppoeKpiEvents = new ArrayList<PppoeKpiEvent>();
					PppoeKpiEvents gPppoeKpiEvents = (PppoeKpiEvents)telemetryRowGPBData.getContent();
					List<PppoeKpiEvents.PppoeKpiEvent> devPppoeKpiEvents = gPppoeKpiEvents.getPppoeKpiEventList();
					for (PppoeKpiEvents.PppoeKpiEvent gponPppoeKpiEvent: devPppoeKpiEvents) {
						PppoeKpiEvent portTrafficRaw = new PppoeKpiEvent();
						portTrafficRaw.setDevIp(devIp);
						portTrafficRaw.setCollectTime(telemetryRowGPBData.getTimestamp());
						portTrafficRaw.setClientMacAddress(gponPppoeKpiEvent.getClientMacAddress());
						portTrafficRaw.setDownwardDrtt(gponPppoeKpiEvent.getDownwardDrtt());
						portTrafficRaw.setEventTime(new Date(gponPppoeKpiEvent.getEventTime()*1L));
						portTrafficRaw.setUpwardDrtt(gponPppoeKpiEvent.getUpwardDrtt());
						dbPppoeKpiEvents.add(portTrafficRaw);
					}
					if(dbPppoeKpiEvents.size() > 0){
						PppoeKpiEventMapper portTrafficRawMapper = ApplicationContextUtil.getBean(PppoeKpiEventMapper.class);
						portTrafficRawMapper.batchInsert(tableName, dbPppoeKpiEvents);
					}
					break;
				case "TerminalEvent":
					List<TerminalEvent> dbTerminalEvents = new ArrayList<TerminalEvent>();
					TerminalEvents gTerminalEvents = (TerminalEvents)telemetryRowGPBData.getContent();
					List<TerminalEvents.TerminalEvent> devTerminalEvents = gTerminalEvents.getTerminalEventList();
					for (TerminalEvents.TerminalEvent gponTerminalEvent : devTerminalEvents) {
						TerminalEvent portTrafficRaw = new TerminalEvent();
						portTrafficRaw.setDevIp(devIp);
						portTrafficRaw.setCollectTime(telemetryRowGPBData.getTimestamp());
						portTrafficRaw.setBrowseTool(gponTerminalEvent.getBrowseTool());
						portTrafficRaw.setClientMacAddress(gponTerminalEvent.getClientMacAddress());
						portTrafficRaw.setEventTime(new Date(gponTerminalEvent.getEventTime()*1L));
						portTrafficRaw.setTerminalType(gponTerminalEvent.getTerminalType());
						dbTerminalEvents.add(portTrafficRaw);
					}
					if(dbTerminalEvents.size() > 0){
						TerminalEventMapper portTrafficRawMapper = ApplicationContextUtil.getBean(TerminalEventMapper.class);
						portTrafficRawMapper.batchInsert(tableName, dbTerminalEvents);
					}
					break;
				case "UserIdentityEvent":
					List<UserIdentityEvent> dbUserIdentityEvents = new ArrayList<UserIdentityEvent>();
					UserIdentityEvents gUserIdentityEvents = (UserIdentityEvents)telemetryRowGPBData.getContent();
					List<UserIdentityEvents.UserIdentityEvent> devUserIdentityEvents = gUserIdentityEvents.getUserIdentityEventList();
					for (UserIdentityEvents.UserIdentityEvent gponUserIdentityEvent : devUserIdentityEvents) {
						UserIdentityEvent portTrafficRaw = new UserIdentityEvent();
						portTrafficRaw.setDevIp(devIp);
						portTrafficRaw.setCollectTime(telemetryRowGPBData.getTimestamp());
						portTrafficRaw.setAccount(gponUserIdentityEvent.getAccount());
						portTrafficRaw.setAppIdentify(gponUserIdentityEvent.getApplicationIdentify());
						portTrafficRaw.setClientMacAddress(gponUserIdentityEvent.getClientMacAddress());
						portTrafficRaw.setEventTime(new Date(gponUserIdentityEvent.getEventTime()*1L));
						portTrafficRaw.setMainType(gponUserIdentityEvent.getApplicationMainType());
						portTrafficRaw.setSubType(gponUserIdentityEvent.getApplicationSubType());
						portTrafficRaw.setTerminalType(gponUserIdentityEvent.getTerminalType());
						dbUserIdentityEvents.add(portTrafficRaw);
					}
					if(dbUserIdentityEvents.size() > 0){
						UserIdentityEventMapper portTrafficRawMapper = ApplicationContextUtil.getBean(UserIdentityEventMapper.class);
						portTrafficRawMapper.batchInsert(tableName, dbUserIdentityEvents);
					}
					break;
				/*case "GponPmOnuRemoteInfos":
					List<OnuRemoteInfo> dbOnuRemoteInfos = new ArrayList<OnuRemoteInfo>();
					GponPmOnuRemoteInfos gOnuRemoteInfos = (GponPmOnuRemoteInfos)telemetryRowGPBData.getContent();
					List<GponPmOnuRemoteInfo> devOnuRemoteInfos = gOnuRemoteInfos.getGponPmOnuRemoteInfoList();
					for (GponPmOnuRemoteInfo gponPmOnuRemoteInfo : devOnuRemoteInfos) {
						OnuRemoteInfo portTrafficRaw = new OnuRemoteInfo();
						portTrafficRaw.setDevIp(devIp);
						portTrafficRaw.setPortName(gponPmOnuRemoteInfo.getName());
						portTrafficRaw.setCollectTime(telemetryRowGPBData.getTimestamp());
						portTrafficRaw.setCorrectedBytes(gponPmOnuRemoteInfo.getDsFecCorrectedBytes());
						portTrafficRaw.setCorrectedWords(gponPmOnuRemoteInfo.getDsFecCorrectedWords());
						portTrafficRaw.setCpuOccup(gponPmOnuRemoteInfo.getCpuOccup());
						portTrafficRaw.setCpuTemp(gponPmOnuRemoteInfo.getCpuTemp());
						portTrafficRaw.setDroppedPackets(gponPmOnuRemoteInfo.getTcontQueueDroppedPackets());
						portTrafficRaw.setFecSeconds(gponPmOnuRemoteInfo.getDsFecSeconds());
						portTrafficRaw.setHecErrorCount(gponPmOnuRemoteInfo.getXgponGemHecErrorCount());
						portTrafficRaw.setKeyErrorCount(gponPmOnuRemoteInfo.getXgponGemKeyErrorCount());
						portTrafficRaw.setMemOccup(gponPmOnuRemoteInfo.getMemOccup());
						portTrafficRaw.setPassingPackets(gponPmOnuRemoteInfo.getTcontQueuePassingPackets());
						portTrafficRaw.setRecvErrorsPackets(gponPmOnuRemoteInfo.getOnuPonRecvErrorsPackets());
						portTrafficRaw.setRecvPackets(gponPmOnuRemoteInfo.getOnuPonRecvPackets());
						portTrafficRaw.setSendPackets(gponPmOnuRemoteInfo.getOnuPonSendPackets());
						portTrafficRaw.setTotalRxCodeWords(gponPmOnuRemoteInfo.getDsTotalRxCodeWords());
						portTrafficRaw.setUncorrectedWords(gponPmOnuRemoteInfo.getDsFecUncorrectedWords());
						dbOnuRemoteInfos.add(portTrafficRaw);
					}
					if(dbOnuRemoteInfos.size() > 0){
						OnuRemoteInfoMapper portTrafficRawMapper = ApplicationContextUtil.getBean(OnuRemoteInfoMapper.class);
						portTrafficRawMapper.batchInsert(tableName, dbOnuRemoteInfos);
					}
					break;*/
				default:
					break;
				}
			}
    	}
//        long granularity = telemetryMessage.getGranularity();
//        long receivedBytes = telemetryMessage.getReceivedBytes();
//        long sentBytes = telemetryMessage.getSentBytes();
//        /**
//         * 端口流量
//         * 定义：一个时间段内，经过流量监测对象传输的数据总量，具有方向性。
//         * 在没有指明方向时，“流量”等于两个方向传输的数据量之和，建议端口流量区分接收或发送的最大流量。
//         * 基本单位：兆比特（Mbit）。
//         * 计算公式：采集周期为15分钟时
//         * 收流量 =总接收字节数*8bit/1048576
//         * 发流量 =总发送字节数*8bit/1048576
//         * 总流量=收流量+发流量
//         * 说明：“流量”是一个累计值，一般情况下，其数值随采集时间延长而增加。
//         * 在分析“流量”时，需要指明统计的时间段或长度，如“时流量”、“日流量”、“周流量”或“月流量”等。
//         * 数据领域的字节长度计算以2的N次方方式计算，1M字节即220=1048576。
//         */
//        double receivedFlow = NumberUtil.div(NumberUtil.mul(receivedBytes, 8), 1048576);
//        double sentFlow = NumberUtil.div(NumberUtil.mul(sentBytes, 8), 1048576);
//        /**
//         * 端口流速
//         * 定义：在单位时间内，经过流量监测对象所传输的数据量，具有方向性。
//         * 基本单位：兆比特/秒（Mbit/s）。
//         * 计算公式：以15分钟采集周期为例，
//         * 收流速=15分钟的收流量/（15*60）
//         * 发流速=15分钟的发流量/（15*60）
//         * 流速= MAX（收流速，发流速）
//         * 说明：“流速”是一个瞬时值，一般情况下，其数值随时间变化而上下波动。
//         */
//        double receivedFlowRate = NumberUtil.div(receivedFlow, granularity);
//        double sentFlowRate = NumberUtil.div(sentFlow, granularity);
//        /**
//         * 端口的带宽利用率
//         * OLT端口带宽利用率定义：流量监测对象的流速与端口的物理带宽（Mbit/s）设定的峰值带宽（PIR，Mbit/s）的比值，具有方向性。
//         * ONU带宽利用率定义：流量监测对象的流速与ONU业务模板中的保障带宽比值（主要针对集团政企业客户、VIP客户、基站等）
//         * 基本单位：%
//         * 计算公式：
//         * 发方向带宽利用率 = 发流速/（端口物理带宽设定的峰值带宽配置值）
//         * 收方向带宽利用率 = 收流速/（端口物理带宽设定的峰值带宽配置值）
//         * 带宽利用率= MAX（收流速，发流速）/（端口物理带宽设定的峰值带宽配置值）
//         * 说明：“带宽利用率”是一个瞬时值，一般情况下，其数值随时间变化而上下波动。
//         */
//        // TODO:端口的物理带宽（Mbit/s）设定的峰值带宽（PIR，Mbit/s）如何获取？
//        double pir = 100D;
//        double receivedBandwidthUtilization = NumberUtil.div(receivedFlowRate, pir);
//        double sentBandwidthUtilization = NumberUtil.div(sentFlowRate, pir);
//
//        PortTrafficRaw portTrafficRaw = new PortTrafficRaw();
//        portTrafficRaw.setNodeId(telemetryMessage.getNodeId());
//        portTrafficRaw.setPortName(telemetryMessage.getPortName());
//        portTrafficRaw.setCollectTime(telemetryMessage.getCollectTime());
//        portTrafficRaw.setReceivedBytes(receivedBytes);
//        portTrafficRaw.setSentBytes(sentBytes);
//        portTrafficRaw.setReceivedFlow(receivedFlow);
//        portTrafficRaw.setSentFlow(sentFlow);
//        portTrafficRaw.setReceivedFlowRate(receivedFlowRate);
//        portTrafficRaw.setSentFlowRate(sentFlowRate);
//        portTrafficRaw.setReceivedBandwidthUtilization(receivedBandwidthUtilization);
//        portTrafficRaw.setSentBandwidthUtilization(sentBandwidthUtilization);
//        portTrafficRaw.setPacketLoss(telemetryMessage.getPacketLoss());
//        PortNameCheckMapper portNameCheckMapper = ApplicationContextUtil.getBean(PortNameCheckMapper.class);
//        PortNameCheck portNameCheck = portNameCheckMapper.selectByIndex(telemetryMessage.getNodeId(), telemetryMessage.getPortType(),
//                telemetryMessage.getPortName(), null);
//        if (portNameCheck != null) {
//            portTrafficRaw.setSubscriberId(portNameCheck.getSubscriberId());
//        }
    }
}
