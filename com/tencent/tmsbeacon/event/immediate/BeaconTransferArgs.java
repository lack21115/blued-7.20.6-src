package com.tencent.tmsbeacon.event.immediate;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/immediate/BeaconTransferArgs.class */
public abstract class BeaconTransferArgs {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f39577a;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f39578c = "";

    public BeaconTransferArgs(byte[] bArr) {
        this.f39577a = bArr;
    }

    public String getAppkey() {
        return this.b;
    }

    public abstract String getCommand();

    public byte[] getData() {
        return this.f39577a;
    }

    public String getEventCode() {
        return this.f39578c;
    }

    public void setAppkey(String str) {
        this.b = str;
    }

    public abstract void setCommand(String str);

    public void setData(byte[] bArr) {
        this.f39577a = bArr;
    }

    public void setEventCode(String str) {
        this.f39578c = str;
    }
}
