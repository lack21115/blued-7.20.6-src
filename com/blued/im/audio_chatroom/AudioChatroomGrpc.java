package com.blued.im.audio_chatroom;

import com.blued.im.audio_chatroom.AudioChatroomOuterClass;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Descriptors;
import io.grpc.BindableService;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.protobuf.ProtoFileDescriptorSupplier;
import io.grpc.protobuf.ProtoMethodDescriptorSupplier;
import io.grpc.protobuf.ProtoServiceDescriptorSupplier;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.stub.AbstractAsyncStub;
import io.grpc.stub.AbstractBlockingStub;
import io.grpc.stub.AbstractFutureStub;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomGrpc.class */
public final class AudioChatroomGrpc {
    private static final int METHODID_SEND = 0;
    public static final String SERVICE_NAME = "com.blued.im.audio_chatroom.AudioChatroom";
    private static volatile MethodDescriptor<AudioChatroomOuterClass.Request, AudioChatroomOuterClass.Response> getSendMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomGrpc$AudioChatroomBaseDescriptorSupplier.class */
    static abstract class AudioChatroomBaseDescriptorSupplier implements ProtoFileDescriptorSupplier, ProtoServiceDescriptorSupplier {
        AudioChatroomBaseDescriptorSupplier() {
        }

        @Override // io.grpc.protobuf.ProtoFileDescriptorSupplier
        public Descriptors.FileDescriptor getFileDescriptor() {
            return AudioChatroomOuterClass.getDescriptor();
        }

        @Override // io.grpc.protobuf.ProtoServiceDescriptorSupplier
        public Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("AudioChatroom");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomGrpc$AudioChatroomBlockingStub.class */
    public static final class AudioChatroomBlockingStub extends AbstractBlockingStub<AudioChatroomBlockingStub> {
        private AudioChatroomBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public AudioChatroomBlockingStub build(Channel channel, CallOptions callOptions) {
            return new AudioChatroomBlockingStub(channel, callOptions);
        }

        public AudioChatroomOuterClass.Response send(AudioChatroomOuterClass.Request request) {
            return (AudioChatroomOuterClass.Response) ClientCalls.blockingUnaryCall(getChannel(), AudioChatroomGrpc.getSendMethod(), getCallOptions(), request);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomGrpc$AudioChatroomFileDescriptorSupplier.class */
    public static final class AudioChatroomFileDescriptorSupplier extends AudioChatroomBaseDescriptorSupplier {
        AudioChatroomFileDescriptorSupplier() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomGrpc$AudioChatroomFutureStub.class */
    public static final class AudioChatroomFutureStub extends AbstractFutureStub<AudioChatroomFutureStub> {
        private AudioChatroomFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public AudioChatroomFutureStub build(Channel channel, CallOptions callOptions) {
            return new AudioChatroomFutureStub(channel, callOptions);
        }

        public ListenableFuture<AudioChatroomOuterClass.Response> send(AudioChatroomOuterClass.Request request) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(AudioChatroomGrpc.getSendMethod(), getCallOptions()), request);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomGrpc$AudioChatroomImplBase.class */
    public static abstract class AudioChatroomImplBase implements BindableService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(AudioChatroomGrpc.getServiceDescriptor()).addMethod(AudioChatroomGrpc.getSendMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).build();
        }

        public void send(AudioChatroomOuterClass.Request request, StreamObserver<AudioChatroomOuterClass.Response> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(AudioChatroomGrpc.getSendMethod(), streamObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomGrpc$AudioChatroomMethodDescriptorSupplier.class */
    public static final class AudioChatroomMethodDescriptorSupplier extends AudioChatroomBaseDescriptorSupplier implements ProtoMethodDescriptorSupplier {
        private final String methodName;

        AudioChatroomMethodDescriptorSupplier(String str) {
            this.methodName = str;
        }

        @Override // io.grpc.protobuf.ProtoMethodDescriptorSupplier
        public Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(this.methodName);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomGrpc$AudioChatroomStub.class */
    public static final class AudioChatroomStub extends AbstractAsyncStub<AudioChatroomStub> {
        private AudioChatroomStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public AudioChatroomStub build(Channel channel, CallOptions callOptions) {
            return new AudioChatroomStub(channel, callOptions);
        }

        public void send(AudioChatroomOuterClass.Request request, StreamObserver<AudioChatroomOuterClass.Response> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(AudioChatroomGrpc.getSendMethod(), getCallOptions()), request, streamObserver);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomGrpc$MethodHandlers.class */
    static final class MethodHandlers<Req, Resp> implements ServerCalls.BidiStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.UnaryMethod<Req, Resp> {
        private final int methodId;
        private final AudioChatroomImplBase serviceImpl;

        MethodHandlers(AudioChatroomImplBase audioChatroomImplBase, int i) {
            this.serviceImpl = audioChatroomImplBase;
            this.methodId = i;
        }

        @Override // io.grpc.stub.ServerCalls.BidiStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.ClientStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }

        @Override // io.grpc.stub.ServerCalls.ServerStreamingMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.UnaryMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId != 0) {
                throw new AssertionError();
            }
            this.serviceImpl.send((AudioChatroomOuterClass.Request) req, streamObserver);
        }
    }

    private AudioChatroomGrpc() {
    }

    public static MethodDescriptor<AudioChatroomOuterClass.Request, AudioChatroomOuterClass.Response> getSendMethod() {
        MethodDescriptor<AudioChatroomOuterClass.Request, AudioChatroomOuterClass.Response> methodDescriptor;
        MethodDescriptor<AudioChatroomOuterClass.Request, AudioChatroomOuterClass.Response> methodDescriptor2 = getSendMethod;
        if (methodDescriptor2 == null) {
            synchronized (AudioChatroomGrpc.class) {
                try {
                    MethodDescriptor<AudioChatroomOuterClass.Request, AudioChatroomOuterClass.Response> methodDescriptor3 = getSendMethod;
                    methodDescriptor = methodDescriptor3;
                    if (methodDescriptor3 == null) {
                        methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Send")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoUtils.marshaller(AudioChatroomOuterClass.Request.getDefaultInstance())).setResponseMarshaller(ProtoUtils.marshaller(AudioChatroomOuterClass.Response.getDefaultInstance())).setSchemaDescriptor(new AudioChatroomMethodDescriptorSupplier("Send")).build();
                        getSendMethod = methodDescriptor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return methodDescriptor;
        }
        return methodDescriptor2;
    }

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptor2;
        ServiceDescriptor serviceDescriptor3 = serviceDescriptor;
        if (serviceDescriptor3 == null) {
            synchronized (AudioChatroomGrpc.class) {
                try {
                    ServiceDescriptor serviceDescriptor4 = serviceDescriptor;
                    serviceDescriptor2 = serviceDescriptor4;
                    if (serviceDescriptor4 == null) {
                        serviceDescriptor2 = ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new AudioChatroomFileDescriptorSupplier()).addMethod(getSendMethod()).build();
                        serviceDescriptor = serviceDescriptor2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return serviceDescriptor2;
        }
        return serviceDescriptor3;
    }

    public static AudioChatroomBlockingStub newBlockingStub(Channel channel) {
        return (AudioChatroomBlockingStub) AudioChatroomBlockingStub.newStub(new AbstractStub.StubFactory<AudioChatroomBlockingStub>() { // from class: com.blued.im.audio_chatroom.AudioChatroomGrpc.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public AudioChatroomBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new AudioChatroomBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static AudioChatroomFutureStub newFutureStub(Channel channel) {
        return (AudioChatroomFutureStub) AudioChatroomFutureStub.newStub(new AbstractStub.StubFactory<AudioChatroomFutureStub>() { // from class: com.blued.im.audio_chatroom.AudioChatroomGrpc.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public AudioChatroomFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new AudioChatroomFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static AudioChatroomStub newStub(Channel channel) {
        return (AudioChatroomStub) AudioChatroomStub.newStub(new AbstractStub.StubFactory<AudioChatroomStub>() { // from class: com.blued.im.audio_chatroom.AudioChatroomGrpc.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public AudioChatroomStub newStub(Channel channel2, CallOptions callOptions) {
                return new AudioChatroomStub(channel2, callOptions);
            }
        }, channel);
    }
}
