package io.grpc.protobuf;

import com.google.protobuf.Descriptors;
import javax.annotation.CheckReturnValue;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/protobuf/ProtoMethodDescriptorSupplier.class */
public interface ProtoMethodDescriptorSupplier extends ProtoServiceDescriptorSupplier {
    @CheckReturnValue
    Descriptors.MethodDescriptor getMethodDescriptor();
}
