package com.xiaomi.push;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/iz.class */
public class iz {

    /* renamed from: a  reason: collision with root package name */
    public final byte f41543a;

    /* renamed from: a  reason: collision with other field name */
    public final String f886a;

    /* renamed from: a  reason: collision with other field name */
    public final short f887a;

    public iz() {
        this("", (byte) 0, (short) 0);
    }

    public iz(String str, byte b, short s) {
        this.f886a = str;
        this.f41543a = b;
        this.f887a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f886a + "' type:" + ((int) this.f41543a) + " field-id:" + ((int) this.f887a) + SimpleComparison.GREATER_THAN_OPERATION;
    }
}
