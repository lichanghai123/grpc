package com.telemetry;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.google.protobuf.ByteString;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import com.telemetry.AnBbQueueKpi.QueueKpiRecords;
import com.telemetry.AnBbQueueKpi.QueueKpiRecords.QueueKpiRecord;
import com.telemetry.AnBbServiceFlowKpi.ServiceFlowKpiRecords;
import com.telemetry.AnBbServiceFlowKpi.ServiceFlowKpiRecords.ServiceFlowKpiRecord;
import com.telemetry.AnEthernetKpi.EthernetPortKpiRecords.EthernetPortKpiRecord;
import com.telemetry.AnGponOnuTransceivers.GponOnuTransceivers;
import com.telemetry.AnGponOnuTransceivers.GponOnuTransceivers.GponOnuTransceiver;
import com.telemetry.AnGponPmOltTraffic.GponPmOltChannelTraffics.GponPmOltChannelTraffic;
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
import com.telemetry.AnGponPmOnuTraffic.GponPmOnuTraffics.GponPmOnuTraffic;
import com.telemetry.GnPortTrafficStatistics.PortTrafficStatistics;
import com.telemetry.GnPortTrafficStatistics.PortTrafficStatistics.PortTrafficStatistic;
import com.telemetry.GnUdpKpiIndex.UdpKpiIndexes;
import com.telemetry.GnUdpKpiIndex.UdpKpiIndexes.UdpKpiIndex;
import com.telemetry.TelemetryOuterClass.Telemetry;
import com.telemetry.TelemetryOuterClass.TelemetryGPBTable;
import com.telemetry.gRPCDataserviceGrpc.gRPCDataserviceStub;

public class GrpcClient {
	final static CountDownLatch finishLatch = new CountDownLatch(1);
	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("172.28.73.106", 50021).usePlaintext().build();
		
		gRPCDataserviceStub stub = gRPCDataserviceGrpc.newStub(channel);
		
		
		 // 启动一个定时任务，每秒钟向客户端发送一条消息
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            int count = 0;

//            @Override
//            public void run() {
//                String message = "Message " + count++;
//                System.out.println("Sending message: " + message);

               
                
                StreamObserver<GrpcDialout.serviceArgs> streamObserver = new StreamObserver<GrpcDialout.serviceArgs>() {


                    @Override
                    public void onNext(GrpcDialout.serviceArgs uppercaseStudentInfo) {
                        System.out.println("client recevies:"+uppercaseStudentInfo.getReqId());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                    	System.out.println("errer");
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("finished......");
                        finishLatch.countDown();
                    }
                };
 
                StreamObserver<GrpcDialout.serviceArgs> requestObserver = stub.dataPublish(streamObserver);
                try {

                    for (int i = 0; i < 10; ++i) {
                    	/*GponPmOltTraffic traffic = GponPmOltTraffic.newBuilder().setName("gpon1").setPortRxBytes(2L).setPortRxRate(122).build();
                    	GponPmOltTraffic traffic1 = GponPmOltTraffic.newBuilder().setName("gpon2").setPortRxBytes(4L).setPortRxRate(123).build();
                    	GponPmOltTraffic traffic2 = GponPmOltTraffic.newBuilder().setName("gpon3").setPortRxBytes(6L).setPortRxRate(112).build();
                    	ByteString traffics= AnGponPmOltTraffic.GponPmOltTraffics.newBuilder().addPmOltTraffic(traffic).addPmOltTraffic(traffic1).addPmOltTraffic(traffic2).build().toByteString();
                    	TelemetryGPBTable table = TelemetryOuterClass.TelemetryGPBTable.newBuilder().addRow(com.telemetry.TelemetryOuterClass.TelemetryRowGPB.newBuilder().setTimestamp(new Date().getTime()).setContent(traffics)).build();
                    	Telemetry telemetry = TelemetryOuterClass.Telemetry.newBuilder().setSensorPath("an-gpon-pm-olt-traffic:GponPmOltTraffics").setDataGpb(table).build();
                    	 GrpcDialout.serviceArgs request = GrpcDialout.serviceArgs.newBuilder().setReqId(11).setData(telemetry.toByteString()).setErrors("sucessful").build();
                        requestObserver.onNext(request);*/
                    	/*GponPmOltChannelTraffic traffic = GponPmOltChannelTraffic.newBuilder().setName("xpon2").setPortRxBytes(2L).setPortRxRate(122).setChannel(1).build();
                    	GponPmOltChannelTraffic traffic1 = GponPmOltChannelTraffic.newBuilder().setName("xpon3").setPortRxBytes(2L).setPortRxRate(122).setChannel(2).build();
                    	GponPmOltChannelTraffic traffic2 = GponPmOltChannelTraffic.newBuilder().setName("xpon4").setPortRxBytes(2L).setPortRxRate(122).setChannel(3).build();
                    	ByteString traffics= AnGponPmOltTraffic.GponPmOltChannelTraffics.newBuilder().addPmOltChannelTraffic(traffic).addPmOltChannelTraffic(traffic1).addPmOltChannelTraffic(traffic2).build().toByteString();
                    	TelemetryGPBTable table = TelemetryOuterClass.TelemetryGPBTable.newBuilder().addRow(com.telemetry.TelemetryOuterClass.TelemetryRowGPB.newBuilder().setTimestamp(new Date().getTime()).setContent(traffics)).build();
                    	Telemetry telemetry = TelemetryOuterClass.Telemetry.newBuilder().setSensorPath("an-gpon-pm-olt-traffic:GponPmOltChannelTraffics").setDataGpb(table).build();
                    	 GrpcDialout.serviceArgs request = GrpcDialout.serviceArgs.newBuilder().setReqId(11).setData(telemetry.toByteString()).setErrors("sucessful").build();
                        requestObserver.onNext(request);*/
                    	/*EthernetPortKpiRecord traffic = EthernetPortKpiRecord.newBuilder().setName("xpon2").setPortRxBytes(2L).setPortRxRate(122).build();
                    	EthernetPortKpiRecord traffic1 = EthernetPortKpiRecord.newBuilder().setName("xpon3").setPortRxBytes(2L).setPortRxRate(122).build();
                    	EthernetPortKpiRecord traffic2 = EthernetPortKpiRecord.newBuilder().setName("xpon4").setPortRxBytes(2L).setPortRxRate(122).build();
                    	ByteString traffics= AnEthernetKpi.EthernetPortKpiRecords.newBuilder().addEthernetPortKpiRecord(traffic).addEthernetPortKpiRecord(traffic1).addEthernetPortKpiRecord(traffic2).build().toByteString();
                    	TelemetryGPBTable table = TelemetryOuterClass.TelemetryGPBTable.newBuilder().addRow(com.telemetry.TelemetryOuterClass.TelemetryRowGPB.newBuilder().setTimestamp(new Date().getTime()).setContent(traffics)).build();
                    	Telemetry telemetry = TelemetryOuterClass.Telemetry.newBuilder().setSensorPath("an-ethernet-kpi:EthernetPortKpiRecords").setDataGpb(table).build();
                    	 GrpcDialout.serviceArgs request = GrpcDialout.serviceArgs.newBuilder().setReqId(11).setData(telemetry.toByteString()).setErrors("sucessful").build();
                        requestObserver.onNext(request);*/
                    	/*UdpKpiIndex traffic1 = GnUdpKpiIndex.UdpKpiIndexes.UdpKpiIndex.newBuilder().setClientLocation("aaa").setClientMacAddress("50:7b:9d:a4:4f:d8").build();
                    	ByteString traffics= UdpKpiIndexes.newBuilder().addUdpKpiIndex(traffic1).build().toByteString();
                    	TelemetryGPBTable table = TelemetryOuterClass.TelemetryGPBTable.newBuilder().addRow(com.telemetry.TelemetryOuterClass.TelemetryRowGPB.newBuilder().setTimestamp(new Date().getTime()).setContent(traffics)).build();
                    	Telemetry telemetry = TelemetryOuterClass.Telemetry.newBuilder().setSensorPath("gn-udp-kpi-index:UdpKpiIndexes").setNodeIdStr("172.28.73.106").setDataGpb(table).build();
                    	 GrpcDialout.serviceArgs request = GrpcDialout.serviceArgs.newBuilder().setReqId(11).setData(telemetry.toByteString()).setErrors("sucessful").build();
                        requestObserver.onNext(request);*/
                        
                        PortTrafficStatistic traffic1 = GnPortTrafficStatistics.PortTrafficStatistics.PortTrafficStatistic.newBuilder().setPacketSniffRate(111).setSniffBytesCnt(233).build();
                    	ByteString traffics= PortTrafficStatistics.newBuilder().addPortTrafficStatistic(traffic1).build().toByteString();
                    	TelemetryGPBTable table = TelemetryOuterClass.TelemetryGPBTable.newBuilder().addRow(com.telemetry.TelemetryOuterClass.TelemetryRowGPB.newBuilder().setTimestamp(new Date().getTime()).setContent(traffics)).build();
                    	Telemetry telemetry = TelemetryOuterClass.Telemetry.newBuilder().setSensorPath("gn-port-traffic-statistics:PortTrafficStatistics").setNodeIdStr("172.28.73.106").setDataGpb(table).build();
                    	 GrpcDialout.serviceArgs request = GrpcDialout.serviceArgs.newBuilder().setReqId(11).setData(telemetry.toByteString()).setErrors("sucessful").build();
                        requestObserver.onNext(request);
                    	/*GponPmOnuTraffic traffic = GponPmOnuTraffic.newBuilder().setName("xpon2").setRxPeakRate(123).setTxPeakRate(23).build();
                    	GponPmOnuTraffic traffic1 = GponPmOnuTraffic.newBuilder().setName("xpon3").setRxPeakRate(232).setTxPeakRate(43).build();
                    	GponPmOnuTraffic traffic2 = GponPmOnuTraffic.newBuilder().setName("xpon4").setRxPeakRate(232).setTxPeakRate(43).build();
                    	ByteString traffics= GponPmOnuTraffics.newBuilder().addGponPmOnuTraffic(traffic).addGponPmOnuTraffic(traffic1).addGponPmOnuTraffic(traffic2).build().toByteString();
                    	TelemetryGPBTable table = TelemetryOuterClass.TelemetryGPBTable.newBuilder().addRow(com.telemetry.TelemetryOuterClass.TelemetryRowGPB.newBuilder().setTimestamp(new Date().getTime()).setContent(traffics)).build();
                    	Telemetry telemetry = TelemetryOuterClass.Telemetry.newBuilder().setSensorPath("an-gpon-pm-onu-traffic:GponPmOnuTraffics").setDataGpb(table).build();
                    	 GrpcDialout.serviceArgs request = GrpcDialout.serviceArgs.newBuilder().setReqId(11).setData(telemetry.toByteString()).setErrors("sucessful").build();
                        requestObserver.onNext(request);*/
                    	/*ServiceFlowKpiRecord traffic = ServiceFlowKpiRecord.newBuilder().setName("xpon2").setDownstreamFlowDropCnt(122).setDownstreamFlowDropRateMin(324).build();
                    	ServiceFlowKpiRecord traffic1 = ServiceFlowKpiRecord.newBuilder().setName("xpon3").setDownstreamFlowDropCnt(122).setDownstreamFlowDropRateMin(324).build();
                    	ServiceFlowKpiRecord traffic2 = ServiceFlowKpiRecord.newBuilder().setName("xpon4").setDownstreamFlowDropCnt(122).setDownstreamFlowDropRateMin(324).build();
                    	ByteString traffics= ServiceFlowKpiRecords.newBuilder().addServiceFlowKpiRecord(traffic).addServiceFlowKpiRecord(traffic1).addServiceFlowKpiRecord(traffic2).build().toByteString();
                    	TelemetryGPBTable table = TelemetryOuterClass.TelemetryGPBTable.newBuilder().addRow(com.telemetry.TelemetryOuterClass.TelemetryRowGPB.newBuilder().setTimestamp(new Date().getTime()).setContent(traffics)).build();
                    	Telemetry telemetry = TelemetryOuterClass.Telemetry.newBuilder().setSensorPath("an-bb-service-flow-kpi:ServiceFlowKpiRecords").setDataGpb(table).build();
                    	 GrpcDialout.serviceArgs request = GrpcDialout.serviceArgs.newBuilder().setReqId(11).setData(telemetry.toByteString()).setErrors("sucessful").build();
                        requestObserver.onNext(request);*/
                    	/*GponOltTransceiver traffic = GponOltTransceiver.newBuilder().setName("xpon2").setChannel1IdleRssi(232).setChannel1TxPower(123).build();
                    	GponOltTransceiver traffic1 = GponOltTransceiver.newBuilder().setName("xpon3").setChannel1IdleRssi(232).setChannel1TxPower(123).build();
                    	GponOltTransceiver traffic2 = GponOltTransceiver.newBuilder().setName("xpon4").setChannel1IdleRssi(232).setChannel1TxPower(123).build();
                    	ByteString traffics= GponOltTransceivers.newBuilder().addGponOltTransceiver(traffic).addGponOltTransceiver(traffic1).addGponOltTransceiver(traffic2).build().toByteString();
                    	TelemetryGPBTable table = TelemetryOuterClass.TelemetryGPBTable.newBuilder().addRow(com.telemetry.TelemetryOuterClass.TelemetryRowGPB.newBuilder().setTimestamp(new Date().getTime()).setContent(traffics)).build();
                    	Telemetry telemetry = TelemetryOuterClass.Telemetry.newBuilder().setSensorPath("an-gpon-pm-olt-transceivers:GponOltTransceivers").setDataGpb(table).build();
                    	 GrpcDialout.serviceArgs request = GrpcDialout.serviceArgs.newBuilder().setReqId(11).setData(telemetry.toByteString()).setErrors("sucessful").build();
                        requestObserver.onNext(request);*/
                    	/*GponPmOnuLineQuality traffic = GponPmOnuLineQuality.newBuilder().setName("xpon2").setDgiAlarmCount(232).setDownstreamBipErrorCount(543).build();
                    	GponPmOnuLineQuality traffic1 = GponPmOnuLineQuality.newBuilder().setName("xpon3").setDgiAlarmCount(232).setDownstreamBipErrorCount(543).build();
                    	GponPmOnuLineQuality traffic2 = GponPmOnuLineQuality.newBuilder().setName("xpon4").setDgiAlarmCount(232).setDownstreamBipErrorCount(543).build();
                    	ByteString traffics= GponPmOnuLineQualitys.newBuilder().addGponPmOnuLineQuality(traffic).addGponPmOnuLineQuality(traffic1).addGponPmOnuLineQuality(traffic2).build().toByteString();
                    	TelemetryGPBTable table = TelemetryOuterClass.TelemetryGPBTable.newBuilder().addRow(com.telemetry.TelemetryOuterClass.TelemetryRowGPB.newBuilder().setTimestamp(new Date().getTime()).setContent(traffics)).build();
                    	Telemetry telemetry = TelemetryOuterClass.Telemetry.newBuilder().setSensorPath("an-gpon-pm-onu-line-quality:GponPmOnuLineQualitys").setDataGpb(table).build();
                    	 GrpcDialout.serviceArgs request = GrpcDialout.serviceArgs.newBuilder().setReqId(11).setData(telemetry.toByteString()).setErrors("sucessful").build();
                        requestObserver.onNext(request);*/
                    	/*GponPmOnuLocalInfo traffic = GponPmOnuLocalInfo.newBuilder().setName("xpon2").setLastDownCause(232).setOnlineDuration(23).build();
                    	GponPmOnuLocalInfo traffic1 = GponPmOnuLocalInfo.newBuilder().setName("xpon3").setLastDownCause(232).setOnlineDuration(23).build();
                    	GponPmOnuLocalInfo traffic2 = GponPmOnuLocalInfo.newBuilder().setName("xpon4").setLastDownCause(232).setOnlineDuration(23).build();
                    	ByteString traffics= GponPmOnuLocalInfos.newBuilder().addGponPmOnuLocalInfo(traffic).addGponPmOnuLocalInfo(traffic1).addGponPmOnuLocalInfo(traffic2).build().toByteString();
                    	TelemetryGPBTable table = TelemetryOuterClass.TelemetryGPBTable.newBuilder().addRow(com.telemetry.TelemetryOuterClass.TelemetryRowGPB.newBuilder().setTimestamp(new Date().getTime()).setContent(traffics)).build();
                    	Telemetry telemetry = TelemetryOuterClass.Telemetry.newBuilder().setSensorPath("an-gpon-pm-onu-local-info:GponPmOnuLocalInfos").setDataGpb(table).build();
                    	 GrpcDialout.serviceArgs request = GrpcDialout.serviceArgs.newBuilder().setReqId(11).setData(telemetry.toByteString()).setErrors("sucessful").build();
                        requestObserver.onNext(request);*/
                    	/*GponOnuTransceiver traffic = GponOnuTransceiver.newBuilder().setName("xpon2").setOpticalUnitLaserBiasCurrent(11).setModuleType(1).build();
                    	GponOnuTransceiver traffic1 = GponOnuTransceiver.newBuilder().setName("xpon3").setOpticalUnitLaserBiasCurrent(143).setModuleType(1).build();
                    	GponOnuTransceiver traffic2 = GponOnuTransceiver.newBuilder().setName("xpon4").setOpticalUnitLaserBiasCurrent(15684).setModuleType(1).build();
                    	ByteString traffics= GponOnuTransceivers.newBuilder().addGponOnuTransceiver(traffic).addGponOnuTransceiver(traffic1).addGponOnuTransceiver(traffic2).build().toByteString();
                    	TelemetryGPBTable table = TelemetryOuterClass.TelemetryGPBTable.newBuilder().addRow(com.telemetry.TelemetryOuterClass.TelemetryRowGPB.newBuilder().setTimestamp(new Date().getTime()).setContent(traffics)).build();
                    	Telemetry telemetry = TelemetryOuterClass.Telemetry.newBuilder().setSensorPath("an-gpon-onu-transceivers:GponOnuTransceivers").setDataGpb(table).build();
                    	 GrpcDialout.serviceArgs request = GrpcDialout.serviceArgs.newBuilder().setReqId(11).setData(telemetry.toByteString()).setErrors("sucessful").build();
                        requestObserver.onNext(request);*/
                    	/*GponPmOnuRemoteInfo traffic = GponPmOnuRemoteInfo.newBuilder().setName("xpon2").setCpuOccup(22).setCpuTemp(11).build();
                    	GponPmOnuRemoteInfo traffic1 = GponPmOnuRemoteInfo.newBuilder().setName("xpon3").setCpuOccup(22).setCpuTemp(11).build();
                    	GponPmOnuRemoteInfo traffic2 = GponPmOnuRemoteInfo.newBuilder().setName("xpon4").setCpuOccup(22).setCpuTemp(11).build();
                    	ByteString traffics= GponPmOnuRemoteInfos.newBuilder().addGponPmOnuRemoteInfo(traffic).addGponPmOnuRemoteInfo(traffic1).addGponPmOnuRemoteInfo(traffic2).build().toByteString();
                    	TelemetryGPBTable table = TelemetryOuterClass.TelemetryGPBTable.newBuilder().addRow(com.telemetry.TelemetryOuterClass.TelemetryRowGPB.newBuilder().setTimestamp(new Date().getTime()).setContent(traffics)).build();
                    	Telemetry telemetry = TelemetryOuterClass.Telemetry.newBuilder().setSensorPath("an-gpon-pm-onu-remote-info:GponPmOnuRemoteInfos").setDataGpb(table).build();
                    	 GrpcDialout.serviceArgs request = GrpcDialout.serviceArgs.newBuilder().setReqId(11).setData(telemetry.toByteString()).setErrors("sucessful").build();
                        requestObserver.onNext(request);*/
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                // Mark the end of requests
                requestObserver.onCompleted();
  
//            }
//        }, 0, 1000);
		
		
        finishLatch.await(600, TimeUnit.MINUTES);
	}
}
