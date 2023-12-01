package com.tencent.qmsp.sdk.g.e;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/e/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f24945a;
    public long b = System.currentTimeMillis() + 86400000;

    /* renamed from: c  reason: collision with root package name */
    public String f24946c;

    public e(String str, int i) {
        this.f24946c = str;
        this.f24945a = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f24946c + "', code=" + this.f24945a + ", expired=" + this.b + '}';
    }
}
