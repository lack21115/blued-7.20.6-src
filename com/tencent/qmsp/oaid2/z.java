package com.tencent.qmsp.oaid2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/z.class */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public int f38511a;
    public long b = System.currentTimeMillis() + 86400000;

    /* renamed from: c  reason: collision with root package name */
    public String f38512c;

    public z(String str, int i) {
        this.f38512c = str;
        this.f38511a = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f38512c + "', code=" + this.f38511a + ", expired=" + this.b + '}';
    }
}
