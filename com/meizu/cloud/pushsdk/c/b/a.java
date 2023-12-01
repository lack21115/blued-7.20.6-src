package com.meizu.cloud.pushsdk.c.b;

import com.meizu.cloud.pushsdk.c.c.k;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/b/a.class */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private String f24016a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f24017c;
    private k d;

    public a() {
        this.b = 0;
    }

    public a(k kVar) {
        this.b = 0;
        this.d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.b = 0;
    }

    public k a() {
        return this.d;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.f24017c = str;
    }

    public int b() {
        return this.b;
    }

    public void b(String str) {
        this.f24016a = str;
    }

    public String c() {
        return this.f24016a;
    }
}
