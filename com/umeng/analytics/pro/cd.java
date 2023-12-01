package com.umeng.analytics.pro;

import java.io.Serializable;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/cd.class */
public class cd implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f26992a;
    public final byte b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26993c;
    private final boolean d;

    public cd(byte b) {
        this(b, false);
    }

    public cd(byte b, String str) {
        this.b = b;
        this.f26992a = true;
        this.f26993c = str;
        this.d = false;
    }

    public cd(byte b, boolean z) {
        this.b = b;
        this.f26992a = false;
        this.f26993c = null;
        this.d = z;
    }

    public boolean a() {
        return this.f26992a;
    }

    public String b() {
        return this.f26993c;
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
