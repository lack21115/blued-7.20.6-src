package com.tencent.tmsqmsp.sdk.g.e;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/e/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f39786a;
    public long b = System.currentTimeMillis() + 86400000;

    /* renamed from: c  reason: collision with root package name */
    public String f39787c;

    public e(String str, int i) {
        this.f39787c = str;
        this.f39786a = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f39787c + "', code=" + this.f39786a + ", expired=" + this.b + '}';
    }
}
