package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/rpc/DebugInfoOrBuilder.class */
public interface DebugInfoOrBuilder extends MessageOrBuilder {
    String getDetail();

    ByteString getDetailBytes();

    String getStackEntries(int i);

    ByteString getStackEntriesBytes(int i);

    int getStackEntriesCount();

    List<String> getStackEntriesList();
}
