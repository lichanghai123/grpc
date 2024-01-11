package com.telemetry;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.grpc.Server;
import io.grpc.ServerBuilder;




/**
 * @author LiuCheng
 * @date 2021/6/24 14:59
 */
@Configuration
public class TelemetryServerConfig {
	@Value("${server.grpc.port}")
    private int grpcPort;
    @Bean
    public Server server(GRPCDataserviceGrpcImpl telemetryGnmiImpl) throws Exception {
        return ServerBuilder.forPort(grpcPort).addService(telemetryGnmiImpl).build().start();
    }
    /*@Bean
    public NettyServer server() throws Exception {
    	NettyServer server = new NettyServer();
    	server.run();
    	return server;
    }*/
}
