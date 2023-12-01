package com.umeng.analytics.pro;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ck.class */
public class ck {

    /* renamed from: a  reason: collision with root package name */
    public final String f40699a;
    public final byte b;

    /* renamed from: c  reason: collision with root package name */
    public final short f40700c;

    public ck() {
        this("", (byte) 0, (short) 0);
    }

    public ck(String str, byte b, short s) {
        this.f40699a = str;
        this.b = b;
        this.f40700c = s;
    }

    public boolean a(ck ckVar) {
        return this.b == ckVar.b && this.f40700c == ckVar.f40700c;
    }

    public String toString() {
        return "<TField name:'" + this.f40699a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.f40700c) + SimpleComparison.GREATER_THAN_OPERATION;
    }
}
