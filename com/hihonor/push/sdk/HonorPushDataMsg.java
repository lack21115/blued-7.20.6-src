package com.hihonor.push.sdk;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/HonorPushDataMsg.class */
public class HonorPushDataMsg {
    public static final int TYPE_MSG_NOTIFICATION = 1;
    public static final int TYPE_MSG_PASS = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f22277a = 1;
    public int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f22278c;
    public String d;

    public String getData() {
        return this.d;
    }

    public long getMsgId() {
        return this.f22278c;
    }

    public int getType() {
        return this.b;
    }

    public int getVersion() {
        return this.f22277a;
    }

    public void setData(String str) {
        this.d = str;
    }

    public void setMsgId(long j) {
        this.f22278c = j;
    }

    public void setType(int i) {
        this.b = i;
    }

    public void setVersion(int i) {
        this.f22277a = i;
    }
}
