package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.SecurityLevel;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/GrpcAttributes.class */
public final class GrpcAttributes {
    public static final Attributes.Key<SecurityLevel> ATTR_SECURITY_LEVEL = Attributes.Key.create("io.grpc.internal.GrpcAttributes.securityLevel");
    public static final Attributes.Key<Attributes> ATTR_CLIENT_EAG_ATTRS = Attributes.Key.create("io.grpc.internal.GrpcAttributes.clientEagAttrs");

    private GrpcAttributes() {
    }
}
