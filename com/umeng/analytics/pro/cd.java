package com.umeng.analytics.pro;

import java.io.Serializable;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/cd.class */
public class cd implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f40683a;
    public final byte b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40684c;
    private final boolean d;

    public cd(byte b) {
        this(b, false);
    }

    public cd(byte b, String str) {
        this.b = b;
        this.f40683a = true;
        this.f40684c = str;
        this.d = false;
    }

    public cd(byte b, boolean z) {
        this.b = b;
        this.f40683a = false;
        this.f40684c = null;
        this.d = z;
    }

    public boolean a() {
        return this.f40683a;
    }

    public String b() {
        return this.f40684c;
    }

    public boolean c() {
        return this.b == 12;
    }

    public boolean d() {
        byte b = this.b;
        return b == 15 || b == 13 || b == 14;
    }

    public boolean e() {
        return this.d;
    }
}
