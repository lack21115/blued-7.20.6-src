package com.google.protobuf;

import com.google.protobuf.Value;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/ValueOrBuilder.class */
public interface ValueOrBuilder extends MessageOrBuilder {
    boolean getBoolValue();

    Value.KindCase getKindCase();

    ListValue getListValue();

    ListValueOrBuilder getListValueOrBuilder();

    NullValue getNullValue();

    int getNullValueValue();

    double getNumberValue();

    String getStringValue();

    ByteString getStringValueBytes();

    Struct getStructValue();

    StructOrBuilder getStructValueOrBuilder();

    boolean hasListValue();

    boolean hasStructValue();
}
