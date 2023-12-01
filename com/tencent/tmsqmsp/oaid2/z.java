package com.tencent.tmsqmsp.oaid2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/z.class */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public int f25979a;
    public long b = System.currentTimeMillis() + 86400000;

    /* renamed from: c  reason: collision with root package name */
    public String f25980c;

    public z(String str, int i) {
        this.f25980c = str;
        this.f25979a = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f25980c + "', code=" + this.f25979a + ", expired=" + this.b + '}';
    }
}
