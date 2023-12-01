package com.anythink.expressad.foundation.g.f;

import android.net.TrafficStats;
import android.os.SystemClock;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static long f7856a;
    private static long b;

    /* renamed from: c  reason: collision with root package name */
    private static long f7857c;

    /* renamed from: com.anythink.expressad.foundation.g.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/a$a.class */
    static final class C0146a {

        /* renamed from: a  reason: collision with root package name */
        private static a f7859a = new a((byte) 0);

        private C0146a() {
        }
    }

    private a() {
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0146a.f7859a;
    }

    public static long b() {
        return b;
    }

    private void c() {
        synchronized (this) {
            if (f7856a == 0) {
                f7856a = SystemClock.elapsedRealtime();
                f7857c = TrafficStats.getTotalRxBytes();
            }
        }
    }

    private void d() {
        synchronized (this) {
            if (f7856a != 0 && f7857c != 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - f7856a;
                if (elapsedRealtime != 0) {
                    try {
                        if (TrafficStats.getTotalRxBytes() != -1) {
                            long totalRxBytes = ((TrafficStats.getTotalRxBytes() - f7857c) * 1000) / elapsedRealtime;
                            if (totalRxBytes == 0) {
                                b = 1L;
                            } else {
                                b = totalRxBytes;
                            }
                        } else {
                            b = 0L;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                e();
            }
        }
    }

    private void e() {
        synchronized (this) {
            f7857c = 0L;
            f7856a = 0L;
        }
    }
}
