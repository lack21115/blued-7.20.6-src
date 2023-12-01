package io.grpc.protobuf;

import com.google.protobuf.Descriptors;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/protobuf/ProtoServiceDescriptorSupplier.class */
public interface ProtoServiceDescriptorSupplier extends ProtoFileDescriptorSupplier {
    Descriptors.ServiceDescriptor getServiceDescriptor();
}
