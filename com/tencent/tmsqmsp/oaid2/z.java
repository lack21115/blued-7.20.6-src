package com.tencent.tmsqmsp.oaid2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/z.class */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public int f39670a;
    public long b = System.currentTimeMillis() + 86400000;

    /* renamed from: c  reason: collision with root package name */
    public String f39671c;

    public z(String str, int i) {
        this.f39671c = str;
        this.f39670a = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f39671c + "', code=" + this.f39670a + ", expired=" + this.b + '}';
    }
}
