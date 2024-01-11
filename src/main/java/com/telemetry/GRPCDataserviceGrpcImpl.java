package com.telemetry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class GRPCDataserviceGrpcImpl extends gRPCDataserviceGrpc.gRPCDataserviceImplBase{
	@Autowired
    private PublishDispatcher dispatcher;
	/*private static Class targetClazz;
	private static Field targetField;
	static {
	    Class[] classes = ServerCalls.class.getDeclaredClasses();
	    for(Class clazz : classes) {
	        if("io.grpc.stub.ServerCalls$ServerCallStreamObserverImpl".equals(clazz.getName())) {
	            targetClazz = clazz;
	            break;
	        }
	    }
	    try {
	        targetField = targetClazz.getDeclaredField("call");
	        targetField.setAccessible(true);
	    } catch (NoSuchFieldException e) {
	        e.printStackTrace();
	    }
	}*/
	public GRPCDataserviceGrpcImpl() {
//		ipHashMap.clear();
//		sourceDatas.clear();
//		dataCount = 0;
	}

	@Override
	public  StreamObserver<GrpcDialout.serviceArgs> dataPublish(final StreamObserver<GrpcDialout.serviceArgs> responseObsv) {
		
		return new StreamObserver<GrpcDialout.serviceArgs>() {

	            @Override
	            public void onNext(GrpcDialout.serviceArgs request) {
	            	try{
	            		/* String clicentIp="";
	            		 try {
	         	          
	         	             String adress = ((ServerCall) targetField.get(responseObsv)).getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR).toString();
	         	            clicentIp = adress.split(":")[0];
	         	            if(clicentIp.contains("/") || clicentIp.contains("\\")){
	         	            	clicentIp= clicentIp.substring(1);
	         	            }
	         	        } catch (IllegalAccessException e) {
	         	            log.error(e.getMessage());
	         	        }*/
	            		dispatcher.addSubscribeResponse(request);
//	            		System.out.println(request.getData().toString());
	            	} catch (Exception e) {
//	            		log.error("dataPublish onNext:" + e);
	            		log.error("dataPublish onNext:"+e.getMessage());
	            	}
	            }

	            @Override
	            public void onError(Throwable throwable) {
//	            	log.info("dataPublish cancelled :" + throwable + "; message:" + throwable.getMessage());
	            	log.error("====dataPublish errr=====:"+throwable.getMessage());
	            }

	            @Override
	            public void onCompleted() {
	                responseObsv.onCompleted();
	            }
	        };
	}
	
}