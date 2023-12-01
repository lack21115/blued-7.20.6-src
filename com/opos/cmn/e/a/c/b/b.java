package com.opos.cmn.e.a.c.b;

import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/c/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f24783a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f24784c;

    public b(String str, boolean z, Object[] objArr) {
        this.f24783a = str;
        this.b = z;
        this.f24784c = objArr;
    }

    public String a() {
        return this.f24783a;
    }

    public boolean b() {
        return this.b;
    }

    public Object[] c() {
        return this.f24784c;
    }

    public String toString() {
        return "ToastParams{pkgName='" + this.f24783a + "', gbClick=" + this.b + ", objects=" + Arrays.toString(this.f24784c) + '}';
    }
}
