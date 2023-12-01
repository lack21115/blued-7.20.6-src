package com.xiaomi.push;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ad.class */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f27553a = TimeZone.getTimeZone("Asia/Shanghai");

    public static int a() {
        return (int) (((m8447a() / 3600000) % 24) + 8);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static final long m8447a() {
        return Calendar.getInstance(f27553a).getTimeInMillis();
    }

    public static long b() {
        return m8447a() / 86400000;
    }
}
