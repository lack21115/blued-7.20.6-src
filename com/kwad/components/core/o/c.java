package com.kwad.components.core.o;

import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/o/c.class */
public final class c extends InputStream {
    private InputStream Pj;
    private int Pk;
    private volatile float Pm;
    private volatile long Pn;
    private int Pg = -1;
    private int Ph = 10000;
    private long Pi = -1;
    private long Pl = -1;
    private int Po = 20480;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(InputStream inputStream, int i) {
        int i2 = i < 20480 ? 20480 : i;
        this.Pj = inputStream;
        this.Pm = i2 / 1000.0f;
    }

    private static long d(long j, long j2) {
        if (j <= 0) {
            return 0L;
        }
        if (j2 <= 0) {
            return -1L;
        }
        return j / j2;
    }

    private void pr() {
        this.Pg = 0;
        this.Pi = System.currentTimeMillis();
    }

    private void ps() {
        if (this.Pg < this.Ph) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.Pi;
        float f = this.Pg / this.Pm;
        this.Pn = d(this.Pk, currentTimeMillis - this.Pl);
        float f2 = (float) (currentTimeMillis - j);
        if (f > f2) {
            w(f - f2);
        }
        pr();
    }

    private static void w(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.Pj.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.Pj.close();
        b.a(this);
        this.Pl = -1L;
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        synchronized (this) {
            this.Pj.mark(i);
        }
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.Pj.markSupported();
    }

    public final long pq() {
        return this.Pn;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.Pl <= 0) {
            this.Pl = System.currentTimeMillis();
        }
        this.Pk++;
        if (b.Pe && b.Pd) {
            if (this.Pg < 0) {
                pr();
            }
            int read = this.Pj.read();
            this.Pg++;
            ps();
            return read;
        }
        return this.Pj.read();
    }

    @Override // java.io.InputStream
    public final void reset() {
        synchronized (this) {
            this.Pj.reset();
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        return this.Pj.skip(j);
    }
}
