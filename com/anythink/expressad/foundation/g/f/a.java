package com.anythink.expressad.foundation.g.f;

import android.net.TrafficStats;
import android.os.SystemClock;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static long f5016a;
    private static long b;

    /* renamed from: c  reason: collision with root package name */
    private static long f5017c;

    /* renamed from: com.anythink.expressad.foundation.g.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/a$a.class */
    static final class C0075a {

        /* renamed from: a  reason: collision with root package name */
        private static a f5019a = new a((byte) 0);

        private C0075a() {
        }
    }

    private a() {
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0075a.f5019a;
    }

    public static long b() {
        return b;
    }

    private void c() {
        synchronized (this) {
            if (f5016a == 0) {
                f5016a = SystemClock.elapsedRealtime();
                f5017c = TrafficStats.getTotalRxBytes();
            }
        }
    }

    private void d() {
        synchronized (this) {
            if (f5016a != 0 && f5017c != 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - f5016a;
                if (elapsedRealtime != 0) {
                    try {
                        if (TrafficStats.getTotalRxBytes() != -1) {
                            long totalRxBytes = ((TrafficStats.getTotalRxBytes() - f5017c) * 1000) / elapsedRealtime;
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
            f5017c = 0L;
            f5016a = 0L;
        }
    }
}
