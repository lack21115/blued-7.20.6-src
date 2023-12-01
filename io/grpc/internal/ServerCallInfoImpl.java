package io.grpc.internal;

import com.google.common.base.Objects;
import io.grpc.Attributes;
import io.grpc.MethodDescriptor;
import io.grpc.ServerStreamTracer;
import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/ServerCallInfoImpl.class */
final class ServerCallInfoImpl<ReqT, RespT> extends ServerStreamTracer.ServerCallInfo<ReqT, RespT> {
    private final Attributes attributes;
    private final String authority;
    private final MethodDescriptor<ReqT, RespT> methodDescriptor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerCallInfoImpl(MethodDescriptor<ReqT, RespT> methodDescriptor, Attributes attributes, @Nullable String str) {
        this.methodDescriptor = methodDescriptor;
        this.attributes = attributes;
        this.authority = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ServerCallInfoImpl) {
            ServerCallInfoImpl serverCallInfoImpl = (ServerCallInfoImpl) obj;
            boolean z = false;
            if (Objects.equal(this.methodDescriptor, serverCallInfoImpl.methodDescriptor)) {
                z = false;
                if (Objects.equal(this.attributes, serverCallInfoImpl.attributes)) {
                    z = false;
                    if (Objects.equal(this.authority, serverCallInfoImpl.authority)) {
                        z = true;
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // io.grpc.ServerStreamTracer.ServerCallInfo
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.grpc.ServerStreamTracer.ServerCallInfo
    @Nullable
    public String getAuthority() {
        return this.authority;
    }

    @Override // io.grpc.ServerStreamTracer.ServerCallInfo
    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return this.methodDescriptor;
    }

    public int hashCode() {
        return Objects.hashCode(this.methodDescriptor, this.attributes, this.authority);
    }
}
