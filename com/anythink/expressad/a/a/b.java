package com.anythink.expressad.a.a;

import java.util.HashSet;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f6951a = 0;
    public static int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private String f6952c;
    private int d;
    private HashSet<String> e = new HashSet<>();
    private long f = System.currentTimeMillis();
    private com.anythink.expressad.foundation.d.c g;
    private String h;
    private int i;
    private boolean j;
    private boolean k;
    private int l;

    public b(String str, String str2) {
        this.f6952c = str;
        b(str2);
    }

    private String i() {
        return this.f6952c;
    }

    private HashSet<String> j() {
        return this.e;
    }

    public final void a(int i) {
        this.l = i;
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        this.g = cVar;
    }

    public final void a(String str) {
        this.h = str;
    }

    public final void a(boolean z) {
        this.j = z;
    }

    public final boolean a() {
        return this.j;
    }

    public final void b(int i) {
        this.i = i;
    }

    public final void b(String str) {
        this.d++;
        this.e.add(str);
    }

    public final void b(boolean z) {
        this.k = z;
    }

    public final boolean b() {
        return this.k;
    }

    public final int c() {
        return this.l;
    }

    public final int d() {
        return this.i;
    }

    public final String e() {
        return this.h;
    }

    public final com.anythink.expressad.foundation.d.c f() {
        return this.g;
    }

    public final int g() {
        return this.d;
    }

    public final long h() {
        return this.f;
    }
}
