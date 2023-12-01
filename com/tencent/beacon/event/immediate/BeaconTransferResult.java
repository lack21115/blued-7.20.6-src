package com.tencent.beacon.event.immediate;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/immediate/BeaconTransferResult.class */
public class BeaconTransferResult {

    /* renamed from: a  reason: collision with root package name */
    private int f35061a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f35062c;
    private String d;

    public byte[] getBizBuffer() {
        return this.f35062c;
    }

    public int getBizCode() {
        return this.b;
    }

    public String getBizMsg() {
        return this.d;
    }

    public int getCode() {
        return this.f35061a;
    }

    public void setBizBuffer(byte[] bArr) {
        this.f35062c = bArr;
    }

    public void setBizCode(int i) {
        this.b = i;
    }

    public void setBizMsg(String str) {
        this.d = str;
    }

    public void setCode(int i) {
        this.f35061a = i;
    }

    public String toString() {
        return "BeaconTransferResult{returnCode=" + this.f35061a + ", bizReturnCode=" + this.b + ", bizMsg='" + this.d + "'}";
    }
}
