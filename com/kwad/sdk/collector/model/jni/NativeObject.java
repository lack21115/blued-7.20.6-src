package com.kwad.sdk.collector.model.jni;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/model/jni/NativeObject.class */
public abstract class NativeObject {
    protected long mPtr;

    public abstract void destroy();

    public long getNativePtr() {
        return this.mPtr;
    }
}
