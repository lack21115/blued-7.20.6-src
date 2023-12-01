package com.autonavi.base.ae.gmap;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/ResourceCallback.class */
public class ResourceCallback {
    private long instance;
    private int requestId;

    public ResourceCallback() {
        this.instance = 0L;
        this.requestId = 0;
    }

    public ResourceCallback(long j, int i) {
        this.instance = 0L;
        this.requestId = 0;
        this.instance = j;
        this.requestId = i;
    }

    private static native void nativeCallCancel(int i);

    private static native void nativeCallFailed(long j, int i, String str);

    private static native void nativeCallSuccess(long j, int i, AMapAppResourceItem aMapAppResourceItem);

    public void callCancel() {
        nativeCallCancel(this.requestId);
    }

    public void callFailed(String str) {
        nativeCallFailed(this.instance, this.requestId, str);
    }

    public void callSuccess(AMapAppResourceItem aMapAppResourceItem) {
        nativeCallSuccess(this.instance, this.requestId, aMapAppResourceItem);
    }

    public long getInstance() {
        return this.instance;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public void setInstance(long j) {
        this.instance = j;
    }

    public void setRequestId(int i) {
        this.requestId = i;
    }
}
