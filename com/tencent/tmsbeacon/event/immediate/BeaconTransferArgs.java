package com.tencent.tmsbeacon.event.immediate;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/immediate/BeaconTransferArgs.class */
public abstract class BeaconTransferArgs {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f25886a;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f25887c = "";

    public BeaconTransferArgs(byte[] bArr) {
        this.f25886a = bArr;
    }

    public String getAppkey() {
        return this.b;
    }

    public abstract String getCommand();

    public byte[] getData() {
        return this.f25886a;
    }

    public String getEventCode() {
        return this.f25887c;
    }

    public void setAppkey(String str) {
        this.b = str;
    }

    public abstract void setCommand(String str);

    public void setData(byte[] bArr) {
        this.f25886a = bArr;
    }

    public void setEventCode(String str) {
        this.f25887c = str;
    }
}
