package com.opos.cmn.e.a.c.b;

import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/c/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f11095a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f11096c;

    public b(String str, boolean z, Object[] objArr) {
        this.f11095a = str;
        this.b = z;
        this.f11096c = objArr;
    }

    public String a() {
        return this.f11095a;
    }

    public boolean b() {
        return this.b;
    }

    public Object[] c() {
        return this.f11096c;
    }

    public String toString() {
        return "ToastParams{pkgName='" + this.f11095a + "', gbClick=" + this.b + ", objects=" + Arrays.toString(this.f11096c) + '}';
    }
}
