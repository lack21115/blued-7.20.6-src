package com.tencent.beacon.event.immediate;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/immediate/BeaconTransferArgs.class */
public abstract class BeaconTransferArgs {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f21368a;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f21369c = "";

    public BeaconTransferArgs(byte[] bArr) {
        this.f21368a = bArr;
    }

    public String getAppkey() {
        return this.b;
    }

    public abstract String getCommand();

    public byte[] getData() {
        return this.f21368a;
    }

    public String getEventCode() {
        return this.f21369c;
    }

    public void setAppkey(String str) {
        this.b = str;
    }

    public abstract void setCommand(String str);

    public void setData(byte[] bArr) {
        this.f21368a = bArr;
    }

    public void setEventCode(String str) {
        this.f21369c = str;
    }
}
