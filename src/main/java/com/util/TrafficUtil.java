package com.util;


import java.util.ArrayList;
/*import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;*/
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RBuckets;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

import com.genew.traffic.pojo.TempData;

public class TrafficUtil {
    public static final String TABLE_NAME_OLT_PORT_TRAFFIC_RAW = "olt_port_traffic_raw";
    public static final String TABLE_NAME_ETHERNETKPI_RAW = "ethernet_kpi_raw";
    public static final String TABLE_NAME_FLOWKPI_RAW = "flow_kpi_raw";
    public static final String TABLE_NAME_OLTTRANSCEIVER_RAW = "olt_transceiver_raw";
    public static final String TABLE_NAME_ONULINEQUALITY_RAW = "onu_line_quality_raw";
    public static final String TABLE_NAME_ONULOCALINFO_RAW = "onu_local_info_raw";
    public static final String TABLE_NAME_ONUREMOTEINFO_RAW = "onu_remote_info_raw";
    public static final String TABLE_NAME_ONUTRAFFIC_RAW = "onu_traffic_raw";
    public static final String TABLE_NAME_ONUTRANCSEIVER_RAW = "onu_transceiver_raw";
    public static final String TABLE_NAME_QUEUEKPI_RAW = "queue_kpi_raw";
    
    private static HashMap<String, String> pathToRawTableNameMap = new HashMap<>();

    static {

        pathToRawTableNameMap.put("an-gpon-pm-olt-traffic:GponPmOltTraffics", TABLE_NAME_OLT_PORT_TRAFFIC_RAW);
        pathToRawTableNameMap.put("an-gpon-pm-olt-traffic:GponPmOltChannelTraffics", TABLE_NAME_OLT_PORT_TRAFFIC_RAW);
        pathToRawTableNameMap.put("an-ethernet-kpi:EthernetPortKpiRecords", TABLE_NAME_ETHERNETKPI_RAW);
        pathToRawTableNameMap.put("an-bb-queue-kpi:QueueKpiRecords", TABLE_NAME_QUEUEKPI_RAW);
        pathToRawTableNameMap.put("an-gpon-pm-onu-traffic:GponPmOnuTraffics", TABLE_NAME_ONUTRAFFIC_RAW);
        pathToRawTableNameMap.put("an-bb-service-flow-kpi:ServiceFlowKpiRecords", TABLE_NAME_FLOWKPI_RAW);
        pathToRawTableNameMap.put("an-gpon-pm-olt-transceivers:GponOltTransceivers", TABLE_NAME_OLTTRANSCEIVER_RAW);
        pathToRawTableNameMap.put("an-gpon-pm-onu-line-quality:GponPmOnuLineQualitys", TABLE_NAME_ONULINEQUALITY_RAW);
        pathToRawTableNameMap.put("an-gpon-pm-onu-local-info:GponPmOnuLocalInfos", TABLE_NAME_ONULOCALINFO_RAW);
        pathToRawTableNameMap.put("an-gpon-onu-transceivers:GponOnuTransceivers", TABLE_NAME_ONUTRANCSEIVER_RAW);
        pathToRawTableNameMap.put("an-gpon-pm-onu-remote-info:GponPmOnuRemoteInfos", TABLE_NAME_ONUREMOTEINFO_RAW);
        
        pathToRawTableNameMap.put("gn-dns-kpi-index:DnsKpiIndexes", "dns_kpi_index");
        pathToRawTableNameMap.put("gn-http-delay-kpi-index:HttpDelayKpiIndexes", "http_delay_kpi_index");
        pathToRawTableNameMap.put("gn-http-kpi-index:HttpKpiIndexes", "http_kpi_index");
        pathToRawTableNameMap.put("gn-rtp-kpi-index:RtpKpiIndexes", "rtp_kpi_index");
        pathToRawTableNameMap.put("gn-tcp-connect-index:TcpConnectIndexes", "tcp_connect_index");
        pathToRawTableNameMap.put("gn-tcp-kpi-index:TcpKpiIndexes", "tcp_kpi_index");
        pathToRawTableNameMap.put("gn-udp-kpi-index:UdpKpiIndexes", "udp_kpi_index");
        
        pathToRawTableNameMap.put("gn-port-traffic-statistics:PortTrafficStatistics", "port_traffic_statistics");
        pathToRawTableNameMap.put("gn-pppoe-event:PppoeEvent", "pppoe_event");
        pathToRawTableNameMap.put("gn-pppoe-kpi-event:PppoeKpiEvent", "pppoe_kpi_event");
        pathToRawTableNameMap.put("gn-terminal-event:TerminalEvent", "terminal_event");
        pathToRawTableNameMap.put("gn-user-identity-event:UserIdentityEvent", "user_identity_event");
        
    }

    public static String getTableNameByPath(String path){
    	return pathToRawTableNameMap.get(path);
    }
public static void main(String[] args) {
//    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
//    	 System.out.println("当前日期时间：" + dateFormat.format(new Date(1695090716235L)));
    	 Config config = new Config();
         
         SingleServerConfig singleServerConfig = config.useSingleServer();
         singleServerConfig.setAddress("redis://192.168.2.231:6379");
         singleServerConfig.setPassword("`123qwer");
         
         Redisson redisson = (Redisson) Redisson.create(config);
         Map<String, List<TempData>> buckets = redisson.getBuckets().get("1");
         if (buckets.size() == 0) {
         	Map<String, List<TempData>> tempMap = new HashMap<String, List<TempData>>();
         	/*List<TempData> tmpDatas = new ArrayList<TempData>();
         	tmpDatas.add(data);
         	tempMap.put(data.getTableName(), tmpDatas);
         	redisson.getBuckets().set(tempMap);*/
         } else {
         	//校验名称是否相同
         	List<TempData> temps = buckets.get("1");
         	for (TempData tempData : temps) {
 				/*if(data.getTableName().equals(tempData.getTempName())){
 					 //模板名称相同
 		        	List<ErrorReason> errorList = TekviewExceptionUtils.addErrorReason("添加五元模板失败,名称相同",
 		        			data.getTempName());
 					throw new TekviewRuntimeException(ErrorReason.OPERATE_EXCEPTION, errorList);
 				}*/
 			}
//         	temps.add(data);
         	redisson.getBuckets().set(buckets);
         }
//       setLocation(redisson,"LTMac-50:7b:9d:a4:4f:d10","d9");
//		 setLocation(redisson,"LTMac-50:7b:9d:a4:4f:d8","d8");
//		 setLocation(redisson,"LTMac-50:7b:9d:a4:4f:d7","v-ani.0.1.1.3");
//		 setLocation(redisson,"LTMac-50:7b:9d:a4:4f:d6","d6");
        
//        System.out.println(getLocation(redisson,"LTMac-00:1c:82:11:41:a1"));
//         getMap(redisson);
	}
    
   /* public static void setLocation( Redisson redisson,String key,String value){
	    RBucket<String> bucket = null;
	    try {
	        bucket = redisson.getBucket(key);
	    } catch (Exception e) {
	        System.out.println("Failed to connect to redis."+e.getMessage());
	    }
	    if (bucket != null && !bucket.isExists()) {
                bucket.set(value, 3600, TimeUnit.SECONDS);
	    }else{
	    	 System.out.println("vlue is exists in redis.");
	    }
    }
    
    public static void setMap( Redisson redisson,DnsKpiIndex value){
    	Map<String, List<DnsKpiIndex>> buckets = redisson.getBuckets().get(value.getClientIp());
	    if (buckets.size() == 0) {
        	Map<String, List<DnsKpiIndex>> tempMap = new HashMap<String, List<DnsKpiIndex>>();
        	List<DnsKpiIndex> tmpDatas = new ArrayList<DnsKpiIndex>();
        	tmpDatas.add(value);
        	tempMap.put(value.getClientIp(), tmpDatas);
        	redisson.getBuckets().set(tempMap);
        } else {
        	//校验名称是否相同
        	List<DnsKpiIndex> temps = buckets.get(value.getClientIp());
        	for (DnsKpiIndex tempData : temps) {
				if(value.getClientLocation().equals(tempData.getClientLocation())){
					 //模板名称相同
		        	List<ErrorReason> errorList = TekviewExceptionUtils.addErrorReason("添加五元模板失败,名称相同",
		        			data.getTempName());
					throw new TekviewRuntimeException(ErrorReason.OPERATE_EXCEPTION, errorList);
					System.out.println("添加失败,已有数据");
					return;
				}
			}
        	temps.add(value);
//        	buckets.put(value.getClientIp(), temps);
        	redisson.getBuckets().set(buckets);
        }
    }
    
    public static void delMap( Redisson redisson,DnsKpiIndex value){
    	Map<String, List<DnsKpiIndex>> buckets = redisson.getBuckets().get(value.getClientIp());
	    if (buckets.size() > 0) {
	    	List<DnsKpiIndex> temps = buckets.get(value.getClientIp());
	    	for (DnsKpiIndex tempData : temps) {
	    		if(value.getClientLocation().equals(tempData.getClientLocation())){
	    			temps.remove(tempData);
	    			System.out.println("删除成功");
	    			redisson.getBuckets().set(buckets);
	    			break;
	    		}
	    	}
	    	if(temps.size() == 0)redisson.getKeys().delete(value.getClientIp());
        }
    }
    
    public static String getLocation(Redisson redisson,String key){
		String location = "";
	    RBucket<String> bucket = null;
	    try {
	        bucket = redisson.getBucket(key);
	    } catch (Exception e) {
	    	 System.out.println("Failed to connect to redis."+e.getMessage());
	    }
	    if (bucket != null && bucket.isExists()) {
//	                bucket.set(treeNeNode, Constants.CACHE_TIMEOUT, TimeUnit.SECONDS);
	    	location =  bucket.get();
	    }else{
	    	 System.out.println("not find from redis:"+key);
	    }
	    
	    return location;
    }
    
    public static void getMap(Redisson redisson){
    	Map<String, List<DnsKpiIndex>> loadedBuckets = redisson.getBuckets().get("tempData1");
    	System.out.println(loadedBuckets.size());
    	
      }*/
}
