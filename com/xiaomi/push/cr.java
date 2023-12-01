package com.xiaomi.push;

import java.net.InetSocketAddress;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cr.class */
public final class cr {

    /* renamed from: a  reason: collision with root package name */
    private int f27626a;

    /* renamed from: a  reason: collision with other field name */
    private String f216a;

    public cr(String str, int i) {
        this.f216a = str;
        this.f27626a = i;
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
    public static InetSocketAddress m8544a(String str, int i) {
        cr a2 = a(str, i);
        return new InetSocketAddress(a2.m8545a(), a2.a());
    }

    public final int a() {
        return this.f27626a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final String m8545a() {
        return this.f216a;
    }

    public final String toString() {
        if (this.f27626a > 0) {
            return this.f216a + ":" + this.f27626a;
        }
        return this.f216a;
    }
}
