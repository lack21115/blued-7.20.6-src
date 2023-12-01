package com.tencent.beacon.base.net;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public String f34992a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public int f34993c;
    public String d;
    public Throwable e;

    public d(String str, String str2, int i, String str3) {
        this.f34992a = str;
        this.b = str2;
        this.f34993c = i;
        this.d = str3;
    }

    public d(String str, String str2, int i, String str3, Throwable th) {
        this.f34992a = str;
        this.b = str2;
        this.f34993c = i;
        this.d = str3;
        this.e = th;
    }

    public String toString() {
        return "NetFailure{requestType='" + this.f34992a + "', attaCode='" + this.b + "', responseCode=" + this.f34993c + ", msg='" + this.d + "', exception=" + this.e + '}';
    }
}
