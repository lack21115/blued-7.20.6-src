package com.efs.sdk.base.protocol;

/* loaded from: source-5961304-dex2jar.jar:com/efs/sdk/base/protocol/AbsLog.class */
public abstract class AbsLog implements ILogProtocol {
    private String cp = "none";

    /* renamed from: de  reason: collision with root package name */
    private byte f21798de = 1;
    private String logType;

    public AbsLog(String str) {
        this.logType = str;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLogType() {
        return this.logType;
    }

    public boolean isCp() {
        return !this.cp.equals("none");
    }

    public boolean isDe() {
        return this.f21798de != 1;
    }

    public void setCp(String str) {
        this.cp = str;
    }

    public void setDe(byte b) {
        this.f21798de = b;
    }
}
