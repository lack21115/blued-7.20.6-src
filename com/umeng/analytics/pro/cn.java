package com.umeng.analytics.pro;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/cn.class */
public final class cn {

    /* renamed from: a  reason: collision with root package name */
    public final String f40704a;
    public final byte b;

    /* renamed from: c  reason: collision with root package name */
    public final int f40705c;

    public cn() {
        this("", (byte) 0, 0);
    }

    public cn(String str, byte b, int i) {
        this.f40704a = str;
        this.b = b;
        this.f40705c = i;
    }

    public boolean a(cn cnVar) {
        return this.f40704a.equals(cnVar.f40704a) && this.b == cnVar.b && this.f40705c == cnVar.f40705c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof cn) {
            return a((cn) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f40704a + "' type: " + ((int) this.b) + " seqid:" + this.f40705c + SimpleComparison.GREATER_THAN_OPERATION;
    }
}
