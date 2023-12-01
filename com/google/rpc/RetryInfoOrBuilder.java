package com.google.rpc;

import com.google.protobuf.Duration;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-8110460-dex2jar.jar:com/google/rpc/RetryInfoOrBuilder.class */
public interface RetryInfoOrBuilder extends MessageOrBuilder {
    Duration getRetryDelay();

    DurationOrBuilder getRetryDelayOrBuilder();

    boolean hasRetryDelay();
}
