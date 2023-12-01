package com.meizu.flyme.openidsdk;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/flyme/openidsdk/ValueData.class */
public class ValueData {

    /* renamed from: a  reason: collision with root package name */
    public String f24195a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public long f24196c = System.currentTimeMillis() + 86400000;

    public ValueData(String str, int i) {
        this.f24195a = str;
        this.b = i;
    }

    public native String toString();
}
