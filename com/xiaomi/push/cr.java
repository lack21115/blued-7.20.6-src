package com.xiaomi.push;

import java.net.InetSocketAddress;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cr.class */
public final class cr {

    /* renamed from: a  reason: collision with root package name */
    private int f41317a;

    /* renamed from: a  reason: collision with other field name */
    private String f263a;

    public cr(String str, int i) {
        this.f263a = str;
        this.f41317a = i;
    }

    public static cr a(String str, int i) {
        int lastIndexOf = str.lastIndexOf(":");
        String str2 = str;
        int i2 = i;
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
            } catch (NumberFormatException e) {
            }
            i2 = i;
        }
        return new cr(str2, i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static InetSocketAddress m11594a(String str, int i) {
        cr a2 = a(str, i);
        return new InetSocketAddress(a2.m11595a(), a2.a());
    }

    public final int a() {
        return this.f41317a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final String m11595a() {
        return this.f263a;
    }

    public final String toString() {
        if (this.f41317a > 0) {
            return this.f263a + ":" + this.f41317a;
        }
        return this.f263a;
    }
}
