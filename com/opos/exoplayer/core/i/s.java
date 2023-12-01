package com.opos.exoplayer.core.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/s.class */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private long f11820a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f11821c = com.anythink.expressad.exoplayer.b.b;

    public s(long j) {
        a(j);
    }

    public static long d(long j) {
        return (j * 1000000) / 90000;
    }

    public static long e(long j) {
        return (j * 90000) / 1000000;
    }

    public long a() {
        return this.f11820a;
    }

    public void a(long j) {
        synchronized (this) {
            a.b(this.f11821c == com.anythink.expressad.exoplayer.b.b);
            this.f11820a = j;
        }
    }

    public long b() {
        long j = -9223372036854775807L;
        if (this.f11821c != com.anythink.expressad.exoplayer.b.b) {
            return this.f11821c;
        }
        long j2 = this.f11820a;
        if (j2 != Long.MAX_VALUE) {
            j = j2;
        }
        return j;
    }

    public long b(long j) {
        if (j == com.anythink.expressad.exoplayer.b.b) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        long j2 = j;
        if (this.f11821c != com.anythink.expressad.exoplayer.b.b) {
            long e = e(this.f11821c);
            long j3 = (4294967296L + e) / 8589934592L;
            long j4 = ((j3 - 1) * 8589934592L) + j;
            long j5 = j + (j3 * 8589934592L);
            j2 = j5;
            if (Math.abs(j4 - e) < Math.abs(j5 - e)) {
                j2 = j4;
            }
        }
        return c(d(j2));
    }

    public long c() {
        long j = -9223372036854775807L;
        if (this.f11820a == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.f11821c != com.anythink.expressad.exoplayer.b.b) {
            j = this.b;
        }
        return j;
    }

    public long c(long j) {
        if (j == com.anythink.expressad.exoplayer.b.b) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        if (this.f11821c != com.anythink.expressad.exoplayer.b.b) {
            this.f11821c = j;
        } else {
            long j2 = this.f11820a;
            if (j2 != Long.MAX_VALUE) {
                this.b = j2 - j;
            }
            synchronized (this) {
                this.f11821c = j;
                notifyAll();
            }
        }
        return this.b + j;
    }

    public void d() {
        this.f11821c = com.anythink.expressad.exoplayer.b.b;
    }
}
