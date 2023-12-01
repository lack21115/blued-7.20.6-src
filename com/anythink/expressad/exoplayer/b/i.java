package com.anythink.expressad.exoplayer.b;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.anythink.expressad.exoplayer.k.af;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/i.class */
final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7194a = 0;
    private static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f7195c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5000;
    private static final int g = 10000000;
    private static final int h = 500000;
    private static final int i = 500000;
    private final a j;
    private int k;
    private long l;
    private long m;
    private long n;
    private long o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/i$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final AudioTrack f7196a;
        private final AudioTimestamp b = new AudioTimestamp();

        /* renamed from: c  reason: collision with root package name */
        private long f7197c;
        private long d;
        private long e;

        public a(AudioTrack audioTrack) {
            this.f7196a = audioTrack;
        }

        public final boolean a() {
            boolean timestamp = this.f7196a.getTimestamp(this.b);
            if (timestamp) {
                long j = this.b.framePosition;
                if (this.d > j) {
                    this.f7197c++;
                }
                this.d = j;
                this.e = j + (this.f7197c << 32);
            }
            return timestamp;
        }

        public final long b() {
            return this.b.nanoTime / 1000;
        }

        public final long c() {
            return this.e;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/i$b.class */
    @interface b {
    }

    public i(AudioTrack audioTrack) {
        if (af.f7632a >= 19) {
            this.j = new a(audioTrack);
            e();
            return;
        }
        this.j = null;
        a(3);
    }

    private void a(int i2) {
        this.k = i2;
        if (i2 == 0) {
            this.n = 0L;
            this.o = -1L;
            this.l = System.nanoTime() / 1000;
            this.m = 5000L;
        } else if (i2 == 1) {
            this.m = 5000L;
        } else if (i2 == 2 || i2 == 3) {
            this.m = 10000000L;
        } else if (i2 != 4) {
            throw new IllegalStateException();
        } else {
            this.m = 500000L;
        }
    }

    public final void a() {
        a(4);
    }

    public final boolean a(long j) {
        a aVar = this.j;
        boolean z = false;
        if (aVar != null) {
            if (j - this.n < this.m) {
                return false;
            }
            this.n = j;
            boolean a2 = aVar.a();
            int i2 = this.k;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                throw new IllegalStateException();
                            }
                        } else if (a2) {
                            e();
                        }
                    } else if (!a2) {
                        e();
                    }
                } else if (!a2) {
                    e();
                } else if (this.j.c() > this.o) {
                    a(2);
                }
            } else if (a2) {
                z = false;
                if (this.j.b() >= this.l) {
                    this.o = this.j.c();
                    a(1);
                }
            } else if (j - this.l > 500000) {
                a(3);
            }
            z = a2;
        }
        return z;
    }

    public final void b() {
        if (this.k == 4) {
            e();
        }
    }

    public final boolean c() {
        int i2 = this.k;
        return i2 == 1 || i2 == 2;
    }

    public final boolean d() {
        return this.k == 2;
    }

    public final void e() {
        if (this.j != null) {
            a(0);
        }
    }

    public final long f() {
        a aVar = this.j;
        return aVar != null ? aVar.b() : com.anythink.expressad.exoplayer.b.b;
    }

    public final long g() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.c();
        }
        return -1L;
    }
}
