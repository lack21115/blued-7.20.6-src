package com.umeng.analytics.pro;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ck.class */
public class ck {

    /* renamed from: a  reason: collision with root package name */
    public final String f27008a;
    public final byte b;

    /* renamed from: c  reason: collision with root package name */
    public final short f27009c;

    public ck() {
        this("", (byte) 0, (short) 0);
    }

    public ck(String str, byte b, short s) {
        this.f27008a = str;
        this.b = b;
        this.f27009c = s;
    }

    public boolean a(ck ckVar) {
        return this.b == ckVar.b && this.f27009c == ckVar.f27009c;
    }

    public String toString() {
        return "<TField name:'" + this.f27008a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.f27009c) + SimpleComparison.GREATER_THAN_OPERATION;
    }
}
