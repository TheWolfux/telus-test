package com.redbirdcodes.todo.api.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: todo_api.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ToDoApiGrpc {

  private ToDoApiGrpc() {}

  public static final java.lang.String SERVICE_NAME = "todo.ToDoApi";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.Id,
      com.redbirdcodes.todo.api.grpc.ToDo> getGetToDoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetToDo",
      requestType = com.redbirdcodes.todo.api.grpc.Id.class,
      responseType = com.redbirdcodes.todo.api.grpc.ToDo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.Id,
      com.redbirdcodes.todo.api.grpc.ToDo> getGetToDoMethod() {
    io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.Id, com.redbirdcodes.todo.api.grpc.ToDo> getGetToDoMethod;
    if ((getGetToDoMethod = ToDoApiGrpc.getGetToDoMethod) == null) {
      synchronized (ToDoApiGrpc.class) {
        if ((getGetToDoMethod = ToDoApiGrpc.getGetToDoMethod) == null) {
          ToDoApiGrpc.getGetToDoMethod = getGetToDoMethod =
              io.grpc.MethodDescriptor.<com.redbirdcodes.todo.api.grpc.Id, com.redbirdcodes.todo.api.grpc.ToDo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetToDo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.redbirdcodes.todo.api.grpc.Id.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.redbirdcodes.todo.api.grpc.ToDo.getDefaultInstance()))
              .setSchemaDescriptor(new ToDoApiMethodDescriptorSupplier("GetToDo"))
              .build();
        }
      }
    }
    return getGetToDoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.Empty,
      com.redbirdcodes.todo.api.grpc.ToDo> getListToDosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListToDos",
      requestType = com.redbirdcodes.todo.api.grpc.Empty.class,
      responseType = com.redbirdcodes.todo.api.grpc.ToDo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.Empty,
      com.redbirdcodes.todo.api.grpc.ToDo> getListToDosMethod() {
    io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.Empty, com.redbirdcodes.todo.api.grpc.ToDo> getListToDosMethod;
    if ((getListToDosMethod = ToDoApiGrpc.getListToDosMethod) == null) {
      synchronized (ToDoApiGrpc.class) {
        if ((getListToDosMethod = ToDoApiGrpc.getListToDosMethod) == null) {
          ToDoApiGrpc.getListToDosMethod = getListToDosMethod =
              io.grpc.MethodDescriptor.<com.redbirdcodes.todo.api.grpc.Empty, com.redbirdcodes.todo.api.grpc.ToDo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListToDos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.redbirdcodes.todo.api.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.redbirdcodes.todo.api.grpc.ToDo.getDefaultInstance()))
              .setSchemaDescriptor(new ToDoApiMethodDescriptorSupplier("ListToDos"))
              .build();
        }
      }
    }
    return getListToDosMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.ToDo,
      com.redbirdcodes.todo.api.grpc.Empty> getSaveToDoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveToDo",
      requestType = com.redbirdcodes.todo.api.grpc.ToDo.class,
      responseType = com.redbirdcodes.todo.api.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.ToDo,
      com.redbirdcodes.todo.api.grpc.Empty> getSaveToDoMethod() {
    io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.ToDo, com.redbirdcodes.todo.api.grpc.Empty> getSaveToDoMethod;
    if ((getSaveToDoMethod = ToDoApiGrpc.getSaveToDoMethod) == null) {
      synchronized (ToDoApiGrpc.class) {
        if ((getSaveToDoMethod = ToDoApiGrpc.getSaveToDoMethod) == null) {
          ToDoApiGrpc.getSaveToDoMethod = getSaveToDoMethod =
              io.grpc.MethodDescriptor.<com.redbirdcodes.todo.api.grpc.ToDo, com.redbirdcodes.todo.api.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SaveToDo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.redbirdcodes.todo.api.grpc.ToDo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.redbirdcodes.todo.api.grpc.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ToDoApiMethodDescriptorSupplier("SaveToDo"))
              .build();
        }
      }
    }
    return getSaveToDoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.ToDo,
      com.redbirdcodes.todo.api.grpc.Empty> getUpdateToDoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateToDo",
      requestType = com.redbirdcodes.todo.api.grpc.ToDo.class,
      responseType = com.redbirdcodes.todo.api.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.ToDo,
      com.redbirdcodes.todo.api.grpc.Empty> getUpdateToDoMethod() {
    io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.ToDo, com.redbirdcodes.todo.api.grpc.Empty> getUpdateToDoMethod;
    if ((getUpdateToDoMethod = ToDoApiGrpc.getUpdateToDoMethod) == null) {
      synchronized (ToDoApiGrpc.class) {
        if ((getUpdateToDoMethod = ToDoApiGrpc.getUpdateToDoMethod) == null) {
          ToDoApiGrpc.getUpdateToDoMethod = getUpdateToDoMethod =
              io.grpc.MethodDescriptor.<com.redbirdcodes.todo.api.grpc.ToDo, com.redbirdcodes.todo.api.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateToDo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.redbirdcodes.todo.api.grpc.ToDo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.redbirdcodes.todo.api.grpc.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ToDoApiMethodDescriptorSupplier("UpdateToDo"))
              .build();
        }
      }
    }
    return getUpdateToDoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.Id,
      com.redbirdcodes.todo.api.grpc.Empty> getDeleteToDoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteToDo",
      requestType = com.redbirdcodes.todo.api.grpc.Id.class,
      responseType = com.redbirdcodes.todo.api.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.Id,
      com.redbirdcodes.todo.api.grpc.Empty> getDeleteToDoMethod() {
    io.grpc.MethodDescriptor<com.redbirdcodes.todo.api.grpc.Id, com.redbirdcodes.todo.api.grpc.Empty> getDeleteToDoMethod;
    if ((getDeleteToDoMethod = ToDoApiGrpc.getDeleteToDoMethod) == null) {
      synchronized (ToDoApiGrpc.class) {
        if ((getDeleteToDoMethod = ToDoApiGrpc.getDeleteToDoMethod) == null) {
          ToDoApiGrpc.getDeleteToDoMethod = getDeleteToDoMethod =
              io.grpc.MethodDescriptor.<com.redbirdcodes.todo.api.grpc.Id, com.redbirdcodes.todo.api.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteToDo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.redbirdcodes.todo.api.grpc.Id.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.redbirdcodes.todo.api.grpc.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ToDoApiMethodDescriptorSupplier("DeleteToDo"))
              .build();
        }
      }
    }
    return getDeleteToDoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ToDoApiStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ToDoApiStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ToDoApiStub>() {
        @java.lang.Override
        public ToDoApiStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ToDoApiStub(channel, callOptions);
        }
      };
    return ToDoApiStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ToDoApiBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ToDoApiBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ToDoApiBlockingStub>() {
        @java.lang.Override
        public ToDoApiBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ToDoApiBlockingStub(channel, callOptions);
        }
      };
    return ToDoApiBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ToDoApiFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ToDoApiFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ToDoApiFutureStub>() {
        @java.lang.Override
        public ToDoApiFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ToDoApiFutureStub(channel, callOptions);
        }
      };
    return ToDoApiFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Obtains an specific data using the id
     * </pre>
     */
    default void getToDo(com.redbirdcodes.todo.api.grpc.Id request,
        io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.ToDo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetToDoMethod(), responseObserver);
    }

    /**
     * <pre>
     * Obtains a list of data
     * </pre>
     */
    default void listToDos(com.redbirdcodes.todo.api.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.ToDo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListToDosMethod(), responseObserver);
    }

    /**
     * <pre>
     * Save new data
     * </pre>
     */
    default void saveToDo(com.redbirdcodes.todo.api.grpc.ToDo request,
        io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaveToDoMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update data
     * </pre>
     */
    default void updateToDo(com.redbirdcodes.todo.api.grpc.ToDo request,
        io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateToDoMethod(), responseObserver);
    }

    /**
     * <pre>
     * Delete data
     * </pre>
     */
    default void deleteToDo(com.redbirdcodes.todo.api.grpc.Id request,
        io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteToDoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ToDoApi.
   */
  public static abstract class ToDoApiImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ToDoApiGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ToDoApi.
   */
  public static final class ToDoApiStub
      extends io.grpc.stub.AbstractAsyncStub<ToDoApiStub> {
    private ToDoApiStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ToDoApiStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ToDoApiStub(channel, callOptions);
    }

    /**
     * <pre>
     * Obtains an specific data using the id
     * </pre>
     */
    public void getToDo(com.redbirdcodes.todo.api.grpc.Id request,
        io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.ToDo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetToDoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Obtains a list of data
     * </pre>
     */
    public void listToDos(com.redbirdcodes.todo.api.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.ToDo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getListToDosMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Save new data
     * </pre>
     */
    public void saveToDo(com.redbirdcodes.todo.api.grpc.ToDo request,
        io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveToDoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update data
     * </pre>
     */
    public void updateToDo(com.redbirdcodes.todo.api.grpc.ToDo request,
        io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateToDoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Delete data
     * </pre>
     */
    public void deleteToDo(com.redbirdcodes.todo.api.grpc.Id request,
        io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteToDoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ToDoApi.
   */
  public static final class ToDoApiBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ToDoApiBlockingStub> {
    private ToDoApiBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ToDoApiBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ToDoApiBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Obtains an specific data using the id
     * </pre>
     */
    public com.redbirdcodes.todo.api.grpc.ToDo getToDo(com.redbirdcodes.todo.api.grpc.Id request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetToDoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Obtains a list of data
     * </pre>
     */
    public java.util.Iterator<com.redbirdcodes.todo.api.grpc.ToDo> listToDos(
        com.redbirdcodes.todo.api.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getListToDosMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Save new data
     * </pre>
     */
    public com.redbirdcodes.todo.api.grpc.Empty saveToDo(com.redbirdcodes.todo.api.grpc.ToDo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveToDoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update data
     * </pre>
     */
    public com.redbirdcodes.todo.api.grpc.Empty updateToDo(com.redbirdcodes.todo.api.grpc.ToDo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateToDoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Delete data
     * </pre>
     */
    public com.redbirdcodes.todo.api.grpc.Empty deleteToDo(com.redbirdcodes.todo.api.grpc.Id request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteToDoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ToDoApi.
   */
  public static final class ToDoApiFutureStub
      extends io.grpc.stub.AbstractFutureStub<ToDoApiFutureStub> {
    private ToDoApiFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ToDoApiFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ToDoApiFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Obtains an specific data using the id
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.redbirdcodes.todo.api.grpc.ToDo> getToDo(
        com.redbirdcodes.todo.api.grpc.Id request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetToDoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Save new data
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.redbirdcodes.todo.api.grpc.Empty> saveToDo(
        com.redbirdcodes.todo.api.grpc.ToDo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveToDoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update data
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.redbirdcodes.todo.api.grpc.Empty> updateToDo(
        com.redbirdcodes.todo.api.grpc.ToDo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateToDoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Delete data
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.redbirdcodes.todo.api.grpc.Empty> deleteToDo(
        com.redbirdcodes.todo.api.grpc.Id request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteToDoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TO_DO = 0;
  private static final int METHODID_LIST_TO_DOS = 1;
  private static final int METHODID_SAVE_TO_DO = 2;
  private static final int METHODID_UPDATE_TO_DO = 3;
  private static final int METHODID_DELETE_TO_DO = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TO_DO:
          serviceImpl.getToDo((com.redbirdcodes.todo.api.grpc.Id) request,
              (io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.ToDo>) responseObserver);
          break;
        case METHODID_LIST_TO_DOS:
          serviceImpl.listToDos((com.redbirdcodes.todo.api.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.ToDo>) responseObserver);
          break;
        case METHODID_SAVE_TO_DO:
          serviceImpl.saveToDo((com.redbirdcodes.todo.api.grpc.ToDo) request,
              (io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_TO_DO:
          serviceImpl.updateToDo((com.redbirdcodes.todo.api.grpc.ToDo) request,
              (io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.Empty>) responseObserver);
          break;
        case METHODID_DELETE_TO_DO:
          serviceImpl.deleteToDo((com.redbirdcodes.todo.api.grpc.Id) request,
              (io.grpc.stub.StreamObserver<com.redbirdcodes.todo.api.grpc.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetToDoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.redbirdcodes.todo.api.grpc.Id,
              com.redbirdcodes.todo.api.grpc.ToDo>(
                service, METHODID_GET_TO_DO)))
        .addMethod(
          getListToDosMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.redbirdcodes.todo.api.grpc.Empty,
              com.redbirdcodes.todo.api.grpc.ToDo>(
                service, METHODID_LIST_TO_DOS)))
        .addMethod(
          getSaveToDoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.redbirdcodes.todo.api.grpc.ToDo,
              com.redbirdcodes.todo.api.grpc.Empty>(
                service, METHODID_SAVE_TO_DO)))
        .addMethod(
          getUpdateToDoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.redbirdcodes.todo.api.grpc.ToDo,
              com.redbirdcodes.todo.api.grpc.Empty>(
                service, METHODID_UPDATE_TO_DO)))
        .addMethod(
          getDeleteToDoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.redbirdcodes.todo.api.grpc.Id,
              com.redbirdcodes.todo.api.grpc.Empty>(
                service, METHODID_DELETE_TO_DO)))
        .build();
  }

  private static abstract class ToDoApiBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ToDoApiBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.redbirdcodes.todo.api.grpc.TodoApi.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ToDoApi");
    }
  }

  private static final class ToDoApiFileDescriptorSupplier
      extends ToDoApiBaseDescriptorSupplier {
    ToDoApiFileDescriptorSupplier() {}
  }

  private static final class ToDoApiMethodDescriptorSupplier
      extends ToDoApiBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ToDoApiMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ToDoApiGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ToDoApiFileDescriptorSupplier())
              .addMethod(getGetToDoMethod())
              .addMethod(getListToDosMethod())
              .addMethod(getSaveToDoMethod())
              .addMethod(getUpdateToDoMethod())
              .addMethod(getDeleteToDoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
