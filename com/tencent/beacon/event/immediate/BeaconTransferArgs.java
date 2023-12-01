package com.tencent.beacon.event.immediate;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/immediate/BeaconTransferArgs.class */
public abstract class BeaconTransferArgs {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f35059a;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f35060c = "";

    public BeaconTransferArgs(byte[] bArr) {
        this.f35059a = bArr;
    }

    public String getAppkey() {
        return this.b;
    }

    public abstract String getCommand();

    public byte[] getData() {
        return this.f35059a;
    }

    public String getEventCode() {
        return this.f35060c;
    }

    public void setAppkey(String str) {
        this.b = str;
    }

    public abstract void setCommand(String str);

    public void setData(byte[] bArr) {
        this.f35059a = bArr;
    }

    public void setEventCode(String str) {
        this.f35060c = str;
    }
}
