package com.xiaomi.push;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/iz.class */
public class iz {

    /* renamed from: a  reason: collision with root package name */
    public final byte f27852a;

    /* renamed from: a  reason: collision with other field name */
    public final String f839a;

    /* renamed from: a  reason: collision with other field name */
    public final short f840a;

    public iz() {
        this("", (byte) 0, (short) 0);
    }

    public iz(String str, byte b, short s) {
        this.f839a = str;
        this.f27852a = b;
        this.f840a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f839a + "' type:" + ((int) this.f27852a) + " field-id:" + ((int) this.f840a) + SimpleComparison.GREATER_THAN_OPERATION;
    }
}
