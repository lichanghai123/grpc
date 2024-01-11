package com.telemetry;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.telemetry.GnDnsKpiIndex.DnsKpiIndexes;
import com.telemetry.GnHttpDelayKpiIndex.HttpDelayKpiIndexes;
import com.telemetry.GnHttpKpiIndex.HttpKpiIndexes;
import com.telemetry.GnPortTrafficStatistics.PortTrafficStatistics;
import com.telemetry.GnPppoeEvent.PppoeEvents;
import com.telemetry.GnPppoeKpiEvent.PppoeKpiEvents;
import com.telemetry.GnRtpKpiIndex.RtpKpiIndexes;
import com.telemetry.GnTcpConnectIndex.TcpConnectIndexes;
import com.telemetry.GnTcpKpiIndex.TcpKpiIndexes;
import com.telemetry.GnTerminalEvent.TerminalEvents;
import com.telemetry.GnUdpKpiIndex.UdpKpiIndexes;
import com.telemetry.GnUserIdentityEvent.UserIdentityEvents;
import com.telemetry.TelemetryOuterClass.Telemetry;
import com.telemetry.TelemetryOuterClass.TelemetryGPBTable;
import com.telemetry.TelemetryOuterClass.TelemetryRowGPB;
import com.util.GlobalExecutor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author LiuCheng
 * @date 2021/6/24 11:44
 */
@Component
@Slf4j
public class PublishDispatcher implements Runnable {
//	private SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 @Autowired
    private TelemetryMessageDispatcher telemetryMessageDispatcher;
    private BlockingQueue<GrpcDialout.serviceArgs> queue = new ArrayBlockingQueue<>(1024 * 1024);
//    private String clientIp;

    @PostConstruct
    public void init() {
    	GlobalExecutor.GRPC_NOTIFIER_EXECUTOR.execute(this);
    }

    public void addSubscribeResponse(GrpcDialout.serviceArgs response) {
        queue.offer(response);
//        this.clientIp = clientIp;
    }

    @Override
    public void run() {
        log.info("Publish dispatcher started.");

        for (; ; ) {
            try {
            	GrpcDialout.serviceArgs request = queue.take();
            	ByteString byteString = request.getData();
        		Telemetry telemetry = Telemetry.parseFrom(byteString.toByteArray());
        		if (telemetry == null) {
        			return ;
        		}
        		log.info(telemetry.getSensorPath()+"========node_id_str======:"+telemetry.getNodeIdStr());
        		
        		TelemetryGPBTable dataGpb = telemetry.getDataGpb();

        		if (dataGpb != null) {
            		int rowCount = dataGpb.getRowCount();
            		List<TelemetryRowGPBData> rowGPBDatas = new ArrayList<TelemetryRowGPBData>();
            		for (int i = 0; i < rowCount; i++) {
            			if(i==0)log.info(telemetry.getSensorPath()+"========timestamp======:"+dataGpb.getRow(i).getTimestamp());
            			TelemetryRowGPBData rowGPBData = copyTelemetryRowGPB(dataGpb.getRow(i), telemetry.getSensorPath());
            			if(rowGPBData !=null)rowGPBDatas.add(rowGPBData);
            		}
            		if(rowGPBDatas.size() > 0){
            			TelemetryGPBTableData tableData = new TelemetryGPBTableData();
            			tableData.setTableName(telemetry.getSensorPath());
            			tableData.setRowDatas(rowGPBDatas);
//            			tableData.setHostName(clientIp);
            			tableData.setHostName(telemetry.getNodeIdStr());
//            			System.out.println(tableData.getHostName()+":"+rowGPBDatas.size());
            			telemetryMessageDispatcher.addTelemetryMessage(tableData);
        			}
        		}
            } catch (Exception e) {
                log.error("Error while handling notifying event", e);
            }
        }
    }
    
    private TelemetryRowGPBData copyTelemetryRowGPB(TelemetryRowGPB rowGpb, String sensorPath) {
		TelemetryRowGPBData rowGPBData = null;
		
		if (rowGpb != null) {
//		long timestamp = rowGpb.getTimestamp();
//		String collectionTimestamp = "0";
			Object content = getObject(sensorPath, rowGpb);
			if(content == null)return rowGPBData;
			rowGPBData = new TelemetryRowGPBData();
			rowGPBData.setContent(content);
			try {
	//			collectionTimestamp = timestamp > 0 ? sd.format(new Date(timestamp)) : String.valueOf(timestamp);
				rowGPBData.setTimestamp(new Date(rowGpb.getTimestamp()*1L));
			} catch (Exception e) {
				rowGPBData.setTimestamp(new Date());
				log.error("copyTelemetryRowGPB timestampToString Exception : " + e.getMessage());
			}
//		rowGPBData.setContent(getObject(sensorPath, rowGpb));
		}
		return rowGPBData;
	}
	
	
	private Object getObject(String sensorPath, TelemetryRowGPB rowGpb) {
		Object object = null;
		try {
			switch (sensorPath) {
			case "gn-dns-kpi-index:DnsKpiIndexes":
				object = DnsKpiIndexes.parseFrom(rowGpb.getContent());
			break;
			case "gn-http-delay-kpi-index:HttpDelayKpiIndexes":
				object = HttpDelayKpiIndexes.parseFrom(rowGpb.getContent());
			break;
			case "gn-http-kpi-index:HttpKpiIndexes":
				object = HttpKpiIndexes.parseFrom(rowGpb.getContent());
			break;
			case "gn-rtp-kpi-index:RtpKpiIndexes":
				object = RtpKpiIndexes.parseFrom(rowGpb.getContent());
			break;
			case "gn-tcp-connect-index:TcpConnectIndexes":
				object = TcpConnectIndexes.parseFrom(rowGpb.getContent());
			break;
			case "gn-tcp-kpi-index:TcpKpiIndexes":
				object = TcpKpiIndexes.parseFrom(rowGpb.getContent());
				/*TcpKpiIndexes ins = (TcpKpiIndexes)object;
				if(ins != null && ins.getTcpKpiIndexList() !=null && ins.getTcpKpiIndexList().size()>0){
					TcpKpiIndex in = ins.getTcpKpiIndex(0);
					log.info("=======TCP data:"+in.getStartTime()+","+in.getEndTime()+"=========");
				}*/
			break;
			case "gn-udp-kpi-index:UdpKpiIndexes":
				object = UdpKpiIndexes.parseFrom(rowGpb.getContent());
				break;
			case "gn-port-traffic-statistics:PortTrafficStatistics":
				object = PortTrafficStatistics.parseFrom(rowGpb.getContent());
			break;
			case "gn-pppoe-event:PppoeEvent":
				object = PppoeEvents.parseFrom(rowGpb.getContent());
			break;
			case "gn-pppoe-kpi-event:PppoeKpiEvent":
				object = PppoeKpiEvents.parseFrom(rowGpb.getContent());
			break;
			case "gn-terminal-event:TerminalEvent":
				object = TerminalEvents.parseFrom(rowGpb.getContent());
			break;
			case "gn-user-identity-event:UserIdentityEvent":
				object = UserIdentityEvents.parseFrom(rowGpb.getContent());
			break;
			default:
				/*object = GnDnsReport.DnsReports.parseFrom(rowGpb.getContent());
				List<DnsReport> reports = ((DnsReports)object).getDnsReportList();
				if(reports !=null && reports.size() > 0){
					log.info("sensorPath : " + sensorPath + ", DnsReports size :" + reports.size());
					for (DnsReport dnsReport : reports) {
						log.info("clientLocation:"+dnsReport.getClientLocation()+"=====avgDelay:"+dnsReport.getAvgDelay());
					}
				}*/
				log.info("sensorPath : " + sensorPath + ",Not Support :");
			break;
			}
		} catch (InvalidProtocolBufferException e) {
			log.error("getObject InvalidProtocolBufferException : " + e.getMessage());
		}

		return object;
	}
}
