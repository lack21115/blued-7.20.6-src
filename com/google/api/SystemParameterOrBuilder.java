package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/SystemParameterOrBuilder.class */
public interface SystemParameterOrBuilder extends MessageOrBuilder {
    String getHttpHeader();

    ByteString getHttpHeaderBytes();

    String getName();

    ByteString getNameBytes();

    String getUrlQueryParameter();

    ByteString getUrlQueryParameterBytes();
}
