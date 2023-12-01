package com.efs.sdk.pa;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/pa/PATraceListener.class */
public interface PATraceListener {
    void onAnrTrace();

    void onCheck(boolean z);

    void onUnexcept(Object obj);
}
