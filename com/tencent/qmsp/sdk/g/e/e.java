package com.tencent.qmsp.sdk.g.e;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/e/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f38636a;
    public long b = System.currentTimeMillis() + 86400000;

    /* renamed from: c  reason: collision with root package name */
    public String f38637c;

    public e(String str, int i) {
        this.f38637c = str;
        this.f38636a = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f38637c + "', code=" + this.f38636a + ", expired=" + this.b + '}';
    }
}
