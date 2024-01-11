package com.telemetry;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.0)",
    comments = "Source: grpc-dialout.proto")
public final class gRPCDataserviceGrpc {

  private gRPCDataserviceGrpc() {}

  public static final String SERVICE_NAME = "dialout.gRPCDataservice";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.telemetry.GrpcDialout.serviceArgs,
      com.telemetry.GrpcDialout.serviceArgs> getDataPublishMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "dataPublish",
      requestType = com.telemetry.GrpcDialout.serviceArgs.class,
      responseType = com.telemetry.GrpcDialout.serviceArgs.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.telemetry.GrpcDialout.serviceArgs,
      com.telemetry.GrpcDialout.serviceArgs> getDataPublishMethod() {
    io.grpc.MethodDescriptor<com.telemetry.GrpcDialout.serviceArgs, com.telemetry.GrpcDialout.serviceArgs> getDataPublishMethod;
    if ((getDataPublishMethod = gRPCDataserviceGrpc.getDataPublishMethod) == null) {
      synchronized (gRPCDataserviceGrpc.class) {
        if ((getDataPublishMethod = gRPCDataserviceGrpc.getDataPublishMethod) == null) {
          gRPCDataserviceGrpc.getDataPublishMethod = getDataPublishMethod =
              io.grpc.MethodDescriptor.<com.telemetry.GrpcDialout.serviceArgs, com.telemetry.GrpcDialout.serviceArgs>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "dataPublish"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.telemetry.GrpcDialout.serviceArgs.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.telemetry.GrpcDialout.serviceArgs.getDefaultInstance()))
              .setSchemaDescriptor(new gRPCDataserviceMethodDescriptorSupplier("dataPublish"))
              .build();
        }
      }
    }
    return getDataPublishMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static gRPCDataserviceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<gRPCDataserviceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<gRPCDataserviceStub>() {
        @java.lang.Override
        public gRPCDataserviceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new gRPCDataserviceStub(channel, callOptions);
        }
      };
    return gRPCDataserviceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static gRPCDataserviceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<gRPCDataserviceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<gRPCDataserviceBlockingStub>() {
        @java.lang.Override
        public gRPCDataserviceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new gRPCDataserviceBlockingStub(channel, callOptions);
        }
      };
    return gRPCDataserviceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static gRPCDataserviceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<gRPCDataserviceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<gRPCDataserviceFutureStub>() {
        @java.lang.Override
        public gRPCDataserviceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new gRPCDataserviceFutureStub(channel, callOptions);
        }
      };
    return gRPCDataserviceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class gRPCDataserviceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.telemetry.GrpcDialout.serviceArgs> dataPublish(
        io.grpc.stub.StreamObserver<com.telemetry.GrpcDialout.serviceArgs> responseObserver) {
      return asyncUnimplementedStreamingCall(getDataPublishMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDataPublishMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.telemetry.GrpcDialout.serviceArgs,
                com.telemetry.GrpcDialout.serviceArgs>(
                  this, METHODID_DATA_PUBLISH)))
          .build();
    }
  }

  /**
   */
  public static final class gRPCDataserviceStub extends io.grpc.stub.AbstractAsyncStub<gRPCDataserviceStub> {
    private gRPCDataserviceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected gRPCDataserviceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new gRPCDataserviceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.telemetry.GrpcDialout.serviceArgs> dataPublish(
        io.grpc.stub.StreamObserver<com.telemetry.GrpcDialout.serviceArgs> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getDataPublishMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class gRPCDataserviceBlockingStub extends io.grpc.stub.AbstractBlockingStub<gRPCDataserviceBlockingStub> {
    private gRPCDataserviceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected gRPCDataserviceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new gRPCDataserviceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class gRPCDataserviceFutureStub extends io.grpc.stub.AbstractFutureStub<gRPCDataserviceFutureStub> {
    private gRPCDataserviceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected gRPCDataserviceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new gRPCDataserviceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_DATA_PUBLISH = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final gRPCDataserviceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(gRPCDataserviceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DATA_PUBLISH:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.dataPublish(
              (io.grpc.stub.StreamObserver<com.telemetry.GrpcDialout.serviceArgs>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class gRPCDataserviceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    gRPCDataserviceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.telemetry.GrpcDialout.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("gRPCDataservice");
    }
  }

  private static final class gRPCDataserviceFileDescriptorSupplier
      extends gRPCDataserviceBaseDescriptorSupplier {
    gRPCDataserviceFileDescriptorSupplier() {}
  }

  private static final class gRPCDataserviceMethodDescriptorSupplier
      extends gRPCDataserviceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    gRPCDataserviceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (gRPCDataserviceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new gRPCDataserviceFileDescriptorSupplier())
              .addMethod(getDataPublishMethod())
              .build();
        }
      }
    }
    return result;
  }
}
