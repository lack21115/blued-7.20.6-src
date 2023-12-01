package com.huawei.hms.core.aidl;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/core/aidl/CodecLookup.class */
public final class CodecLookup {
    private CodecLookup() {
    }

    public static MessageCodec find(int i) {
        return i == 2 ? new a() : new MessageCodec();
    }
}
