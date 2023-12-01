package com.tencent.tmsbeacon.event.immediate;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/immediate/BeaconTransferResult.class */
public class BeaconTransferResult {

    /* renamed from: a  reason: collision with root package name */
    private int f39579a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f39580c;
    private String d;

    public byte[] getBizBuffer() {
        return this.f39580c;
    }

    public int getBizCode() {
        return this.b;
    }

    public String getBizMsg() {
        return this.d;
    }

    public int getCode() {
        return this.f39579a;
    }

    public void setBizBuffer(byte[] bArr) {
        this.f39580c = bArr;
    }

    public void setBizCode(int i) {
        this.b = i;
    }

    public void setBizMsg(String str) {
        this.d = str;
    }

    public void setCode(int i) {
        this.f39579a = i;
    }

    public String toString() {
        return "BeaconTransferResult{returnCode=" + this.f39579a + ", bizReturnCode=" + this.b + ", bizMsg='" + this.d + "'}";
    }
}
