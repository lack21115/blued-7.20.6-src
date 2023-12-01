package com.anythink.expressad.exoplayer.k;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/ac.class */
public final class ac {

    /* renamed from: a  reason: collision with root package name */
    public static final long f4789a = Long.MAX_VALUE;
    private static final long b = 8589934592L;

    /* renamed from: c  reason: collision with root package name */
    private long f4790c;
    private long d;
    private volatile long e = com.anythink.expressad.exoplayer.b.b;

    public ac(long j) {
        c(j);
    }

    private long b() {
        return this.f4790c;
    }

    private long c() {
        if (this.e != com.anythink.expressad.exoplayer.b.b) {
            return this.e + this.d;
        }
        long j = this.f4790c;
        return j != Long.MAX_VALUE ? j : com.anythink.expressad.exoplayer.b.b;
    }

    private void c(long j) {
        synchronized (this) {
            a.b(this.e == com.anythink.expressad.exoplayer.b.b);
            this.f4790c = j;
        }
    }

    private static long d(long j) {
        return (j * 1000000) / 90000;
    }

    private void d() {
        this.e = com.anythink.expressad.exoplayer.b.b;
    }

    private static long e(long j) {
        return (j * 90000) / 1000000;
    }

    private void e() {
        synchronized (this) {
            while (this.e == com.anythink.expressad.exoplayer.b.b) {
                wait();
            }
        }
    }

    public final long a() {
        if (this.f4790c == Long.MAX_VALUE) {
            return 0L;
        }
        return this.e == com.anythink.expressad.exoplayer.b.b ? com.anythink.expressad.exoplayer.b.b : this.d;
    }

    public final long a(long j) {
        if (j == com.anythink.expressad.exoplayer.b.b) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        long j2 = j;
        if (this.e != com.anythink.expressad.exoplayer.b.b) {
            long j3 = (this.e * 90000) / 1000000;
            long j4 = (4294967296L + j3) / 8589934592L;
            long j5 = ((j4 - 1) * 8589934592L) + j;
            long j6 = j + (j4 * 8589934592L);
            j2 = j6;
            if (Math.abs(j5 - j3) < Math.abs(j6 - j3)) {
                j2 = j5;
            }
        }
        return b((j2 * 1000000) / 90000);
    }

    public final long b(long j) {
        if (j == com.anythink.expressad.exoplayer.b.b) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        if (this.e != com.anythink.expressad.exoplayer.b.b) {
            this.e = j;
        } else {
            long j2 = this.f4790c;
            if (j2 != Long.MAX_VALUE) {
                this.d = j2 - j;
            }
            synchronized (this) {
                this.e = j;
                notifyAll();
            }
        }
        return j + this.d;
    }
}
