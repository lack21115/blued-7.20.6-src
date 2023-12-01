package com.opos.exoplayer.core;

import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f25065a;
    public static final UUID b;

    /* renamed from: c  reason: collision with root package name */
    public static final UUID f25066c;
    public static final UUID d;
    public static final UUID e;
    public static final UUID f;

    static {
        f25065a = com.opos.exoplayer.core.i.u.f25510a < 23 ? 1020 : 6396;
        b = new UUID(0L, 0L);
        f25066c = new UUID(1186680826959645954L, -5988876978535335093L);
        d = new UUID(-2129748144642739255L, 8654423357094679310L);
        e = new UUID(-1301668207276963122L, -6645017420763422227L);
        f = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long a(long j) {
        long j2 = j;
        if (j != com.anythink.expressad.exoplayer.b.b) {
            if (j == Long.MIN_VALUE) {
                return j;
            }
            j2 = j / 1000;
        }
        return j2;
    }

    public static long b(long j) {
        long j2 = j;
        if (j != com.anythink.expressad.exoplayer.b.b) {
            if (j == Long.MIN_VALUE) {
                return j;
            }
            j2 = j * 1000;
        }
        return j2;
    }
}
