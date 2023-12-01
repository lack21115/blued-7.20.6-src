package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.p;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/f.class */
public interface f {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/f$a.class */
    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(Throwable th) {
            super(th);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/f$b.class */
    public static final class b extends Exception {

        /* renamed from: a  reason: collision with root package name */
        public final int f11336a;

        public b(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.f11336a = i;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/f$c.class */
    public interface c {
        void a();

        void a(int i);

        void a(int i, long j, long j2);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/f$d.class */
    public static final class d extends Exception {

        /* renamed from: a  reason: collision with root package name */
        public final int f11337a;

        public d(int i) {
            super("AudioTrack write failed: " + i);
            this.f11337a = i;
        }
    }

    long a(boolean z);

    p a(p pVar);

    void a();

    void a(float f);

    void a(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6);

    void a(com.opos.exoplayer.core.a.b bVar);

    void a(c cVar);

    boolean a(int i);

    boolean a(ByteBuffer byteBuffer, long j);

    void b();

    void b(int i);

    void c();

    boolean d();

    boolean e();

    p f();

    void g();

    void h();

    void i();

    void j();
}
