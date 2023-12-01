package com.anythink.expressad.foundation.g.e;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/e/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f5014a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private long f5015c;

    public a(String str, long j) {
        this.f5014a = str;
        this.f5015c = j;
    }

    public a(String str, String str2) {
        this.f5014a = str;
        this.b = str2;
    }

    private void a(long j) {
        this.f5015c = j;
    }

    private void a(String str) {
        this.f5014a = str;
    }

    private void b(String str) {
        this.b = str;
    }

    public final String a() {
        return this.f5014a;
    }

    public final String b() {
        return this.b;
    }

    public final long c() {
        return this.f5015c;
    }
}
