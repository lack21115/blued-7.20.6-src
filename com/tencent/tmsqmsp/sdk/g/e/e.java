package com.tencent.tmsqmsp.sdk.g.e;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/e/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f26095a;
    public long b = System.currentTimeMillis() + 86400000;

    /* renamed from: c  reason: collision with root package name */
    public String f26096c;

    public e(String str, int i) {
        this.f26096c = str;
        this.f26095a = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f26096c + "', code=" + this.f26095a + ", expired=" + this.b + '}';
    }
}
