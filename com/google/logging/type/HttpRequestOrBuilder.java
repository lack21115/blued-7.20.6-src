package com.google.logging.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-8110460-dex2jar.jar:com/google/logging/type/HttpRequestOrBuilder.class */
public interface HttpRequestOrBuilder extends MessageOrBuilder {
    long getCacheFillBytes();

    boolean getCacheHit();

    boolean getCacheLookup();

    boolean getCacheValidatedWithOriginServer();

    Duration getLatency();

    DurationOrBuilder getLatencyOrBuilder();

    String getProtocol();

    ByteString getProtocolBytes();

    String getReferer();

    ByteString getRefererBytes();

    String getRemoteIp();

    ByteString getRemoteIpBytes();

    String getRequestMethod();

    ByteString getRequestMethodBytes();

    long getRequestSize();

    String getRequestUrl();

    ByteString getRequestUrlBytes();

    long getResponseSize();

    String getServerIp();

    ByteString getServerIpBytes();

    int getStatus();

    String getUserAgent();

    ByteString getUserAgentBytes();

    boolean hasLatency();
}
