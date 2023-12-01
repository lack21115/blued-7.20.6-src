package com.tencent.qmsp.oaid2;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/z.class */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public int f24820a;
    public long b = System.currentTimeMillis() + 86400000;

    /* renamed from: c  reason: collision with root package name */
    public String f24821c;

    public z(String str, int i) {
        this.f24821c = str;
        this.f24820a = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f24821c + "', code=" + this.f24820a + ", expired=" + this.b + '}';
    }
}
