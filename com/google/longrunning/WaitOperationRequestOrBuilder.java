package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-8110460-dex2jar.jar:com/google/longrunning/WaitOperationRequestOrBuilder.class */
public interface WaitOperationRequestOrBuilder extends MessageOrBuilder {
    String getName();

    ByteString getNameBytes();

    Duration getTimeout();

    DurationOrBuilder getTimeoutOrBuilder();

    boolean hasTimeout();
}
