package com.tencent.tmsbeacon.base.net;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public String f25832a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public int f25833c;
    public String d;
    public Throwable e;

    public d(String str, String str2, int i, String str3) {
        this.f25832a = str;
        this.b = str2;
        this.f25833c = i;
        this.d = str3;
    }

    public d(String str, String str2, int i, String str3, Throwable th) {
        this.f25832a = str;
        this.b = str2;
        this.f25833c = i;
        this.d = str3;
        this.e = th;
    }

    public String toString() {
        return "NetFailure{requestType='" + this.f25832a + "', attaCode='" + this.b + "', responseCode=" + this.f25833c + ", msg='" + this.d + "', exception=" + this.e + '}';
    }
}
