package com.anythink.expressad.exoplayer.a;

import android.net.NetworkInfo;
import android.view.Surface;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.g;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.m;
import com.anythink.expressad.exoplayer.v;
import java.io.IOException;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/a/b.class */
public interface b {

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/a/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f4315a;
        public final ae b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4316c;
        public final s.a d;
        public final long e;
        public final long f;
        public final long g;

        public a(long j, ae aeVar, int i, s.a aVar, long j2, long j3, long j4) {
            this.f4315a = j;
            this.b = aeVar;
            this.f4316c = i;
            this.d = aVar;
            this.e = j2;
            this.f = j3;
            this.g = j4;
        }
    }

    void a();

    void a(a aVar);

    void a(a aVar, int i);

    void a(a aVar, int i, int i2);

    void a(a aVar, int i, long j, long j2);

    void a(a aVar, int i, m mVar);

    void a(a aVar, int i, String str);

    void a(a aVar, NetworkInfo networkInfo);

    void a(a aVar, Surface surface);

    void a(a aVar, com.anythink.expressad.exoplayer.g.a aVar2);

    void a(a aVar, g gVar);

    void a(a aVar, t.c cVar);

    void a(a aVar, com.anythink.expressad.exoplayer.i.g gVar);

    void a(a aVar, v vVar);

    void a(a aVar, IOException iOException);

    void a(a aVar, Exception exc);

    void a(a aVar, boolean z);

    void a(a aVar, boolean z, int i);

    void b();

    void b(a aVar);

    void b(a aVar, int i);

    void b(a aVar, int i, int i2);

    void b(a aVar, t.c cVar);

    void b(a aVar, boolean z);

    void c();

    void c(a aVar);

    void c(a aVar, int i);

    void d();

    void d(a aVar);

    void d(a aVar, int i);

    void e(a aVar);

    void e(a aVar, int i);

    void f(a aVar);

    void f(a aVar, int i);

    void g(a aVar);

    void g(a aVar, int i);

    void h(a aVar);
}
