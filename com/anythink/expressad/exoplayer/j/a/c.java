package com.anythink.expressad.exoplayer.j.a;

import android.net.Uri;
import com.anythink.expressad.exoplayer.j.a.a;
import com.anythink.expressad.exoplayer.j.r;
import com.anythink.expressad.exoplayer.j.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/c.class */
public final class c implements com.anythink.expressad.exoplayer.j.h {

    /* renamed from: a  reason: collision with root package name */
    public static final long f4716a = 2097152;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f4717c = 2;
    public static final int d = 4;
    public static final int e = 0;
    public static final int f = 1;
    private static final int g = -1;
    private static final long h = 102400;
    private boolean A;
    private long B;
    private long C;
    private final com.anythink.expressad.exoplayer.j.a.a i;
    private final com.anythink.expressad.exoplayer.j.h j;
    private final com.anythink.expressad.exoplayer.j.h k;
    private final com.anythink.expressad.exoplayer.j.h l;
    private final b m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private com.anythink.expressad.exoplayer.j.h q;
    private boolean r;
    private Uri s;
    private Uri t;
    private int u;
    private String v;
    private long w;
    private long x;
    private e y;
    private boolean z;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/c$a.class */
    public @interface a {
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/c$b.class */
    public interface b {
        void a();

        void b();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.anythink.expressad.exoplayer.j.a.c$c  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/c$c.class */
    public @interface InterfaceC0068c {
    }

    public c(com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar) {
        this(aVar, hVar, 0, (byte) 0);
    }

    private c(com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar, int i) {
        this(aVar, hVar, i, (byte) 0);
    }

    private c(com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar, int i, byte b2) {
        this(aVar, hVar, new r(), new com.anythink.expressad.exoplayer.j.a.b(aVar), i, null);
    }

    private c(com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.j.h hVar2, com.anythink.expressad.exoplayer.j.g gVar, int i, b bVar) {
        this.i = aVar;
        this.j = hVar2;
        this.n = (i & 1) != 0;
        this.o = (i & 2) != 0;
        this.p = (i & 4) != 0;
        this.l = hVar;
        this.k = new z(hVar, gVar);
        this.m = bVar;
    }

    private static Uri a(com.anythink.expressad.exoplayer.j.a.a aVar, String str, Uri uri) {
        i c2 = aVar.c(str);
        Uri uri2 = null;
        String a2 = c2.a("exo_redir", (String) null);
        if (a2 != null) {
            uri2 = Uri.parse(a2);
        }
        return uri2 == null ? uri : uri2;
    }

    private void a(boolean z) {
        e a2;
        long j;
        com.anythink.expressad.exoplayer.j.k kVar;
        com.anythink.expressad.exoplayer.j.h hVar;
        if (this.A) {
            a2 = null;
        } else if (this.n) {
            try {
                a2 = this.i.a(this.v, this.w);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            a2 = this.i.b(this.v, this.w);
        }
        if (a2 == null) {
            hVar = this.l;
            kVar = new com.anythink.expressad.exoplayer.j.k(this.s, this.w, this.x, this.v, this.u);
        } else if (a2.d) {
            Uri fromFile = Uri.fromFile(a2.e);
            long j2 = this.w - a2.b;
            long j3 = a2.f4719c - j2;
            long j4 = this.x;
            long j5 = j3;
            if (j4 != -1) {
                j5 = Math.min(j3, j4);
            }
            kVar = new com.anythink.expressad.exoplayer.j.k(fromFile, this.w, j2, j5, this.v, this.u);
            hVar = this.j;
        } else {
            if (a2.a()) {
                j = this.x;
            } else {
                long j6 = a2.f4719c;
                long j7 = this.x;
                j = j6;
                if (j7 != -1) {
                    j = Math.min(j6, j7);
                }
            }
            kVar = new com.anythink.expressad.exoplayer.j.k(this.s, this.w, j, this.v, this.u);
            hVar = this.k;
            if (hVar == null) {
                hVar = this.l;
                this.i.a(a2);
                a2 = null;
            }
        }
        this.C = (this.A || hVar != this.l) ? Long.MAX_VALUE : this.w + h;
        if (z) {
            com.anythink.expressad.exoplayer.k.a.b(e());
            if (hVar == this.l) {
                return;
            }
            try {
                h();
            } catch (Throwable th) {
                if (a2.b()) {
                    this.i.a(a2);
                }
                throw th;
            }
        }
        if (a2 != null && a2.b()) {
            this.y = a2;
        }
        this.q = hVar;
        this.r = kVar.g == -1;
        long a3 = hVar.a(kVar);
        k kVar2 = new k();
        if (this.r && a3 != -1) {
            this.x = a3;
            j.a(kVar2, this.w + a3);
        }
        if (d()) {
            Uri a4 = this.q.a();
            this.t = a4;
            if (true ^ this.s.equals(a4)) {
                j.a(kVar2, this.t);
            } else {
                kVar2.a("exo_redir");
            }
        }
        if (g()) {
            this.i.a(this.v, kVar2);
        }
    }

    private static boolean a(IOException iOException) {
        while (iOException != null) {
            if ((iOException instanceof com.anythink.expressad.exoplayer.j.i) && ((com.anythink.expressad.exoplayer.j.i) iOException).b == 0) {
                return true;
            }
            iOException = iOException.getCause();
        }
        return false;
    }

    private int b(com.anythink.expressad.exoplayer.j.k kVar) {
        if (this.o && this.z) {
            return 0;
        }
        return (this.p && kVar.g == -1) ? 1 : -1;
    }

    private void b(IOException iOException) {
        if (f() || (iOException instanceof a.C0067a)) {
            this.z = true;
        }
    }

    private void c() {
        this.x = 0L;
        if (g()) {
            this.i.d(this.v, this.w);
        }
    }

    private boolean d() {
        return !f();
    }

    private boolean e() {
        return this.q == this.l;
    }

    private boolean f() {
        return this.q == this.j;
    }

    private boolean g() {
        return this.q == this.k;
    }

    private void h() {
        com.anythink.expressad.exoplayer.j.h hVar = this.q;
        if (hVar == null) {
            return;
        }
        try {
            hVar.b();
        } finally {
            this.q = null;
            this.r = false;
            e eVar = this.y;
            if (eVar != null) {
                this.i.a(eVar);
                this.y = null;
            }
        }
    }

    private static void i() {
    }

    private void j() {
        if (this.m == null || this.B <= 0) {
            return;
        }
        this.i.c();
        this.B = 0L;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        boolean z;
        if (i2 == 0) {
            return 0;
        }
        if (this.x == 0) {
            return -1;
        }
        try {
            if (this.w >= this.C) {
                a(true);
            }
            int a2 = this.q.a(bArr, i, i2);
            if (a2 == -1) {
                if (this.r) {
                    c();
                    return a2;
                }
                if (this.x <= 0) {
                    if (this.x == -1) {
                    }
                }
                h();
                a(false);
                return a(bArr, i, i2);
            }
            if (f()) {
                this.B += a2;
            }
            long j = a2;
            this.w += j;
            if (this.x != -1) {
                this.x -= j;
                return a2;
            }
            return a2;
        } catch (IOException e2) {
            if (this.r) {
                Throwable th = e2;
                while (true) {
                    Throwable th2 = th;
                    z = false;
                    if (th2 != null) {
                        if ((th2 instanceof com.anythink.expressad.exoplayer.j.i) && ((com.anythink.expressad.exoplayer.j.i) th2).b == 0) {
                            z = true;
                            break;
                        }
                        th = th2.getCause();
                    } else {
                        break;
                    }
                }
                if (z) {
                    c();
                    return -1;
                }
            }
            b(e2);
            throw e2;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(com.anythink.expressad.exoplayer.j.k kVar) {
        try {
            this.v = f.a(kVar);
            Uri uri = kVar.f4745c;
            this.s = uri;
            Uri uri2 = null;
            String a2 = this.i.c(this.v).a("exo_redir", (String) null);
            if (a2 != null) {
                uri2 = Uri.parse(a2);
            }
            if (uri2 == null) {
                uri2 = uri;
            }
            this.t = uri2;
            this.u = kVar.i;
            this.w = kVar.f;
            boolean z = true;
            if ((this.o && this.z) ? false : (this.p && kVar.g == -1) ? true : true) {
                z = false;
            }
            this.A = z;
            if (kVar.g == -1 && !this.A) {
                long b2 = this.i.b(this.v);
                this.x = b2;
                if (b2 != -1) {
                    long j = b2 - kVar.f;
                    this.x = j;
                    if (j <= 0) {
                        throw new com.anythink.expressad.exoplayer.j.i();
                    }
                }
                a(false);
                return this.x;
            }
            this.x = kVar.g;
            a(false);
            return this.x;
        } catch (IOException e2) {
            b(e2);
            throw e2;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        return this.t;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.s = null;
        this.t = null;
        if (this.m != null && this.B > 0) {
            this.i.c();
            this.B = 0L;
        }
        try {
            h();
        } catch (IOException e2) {
            b(e2);
            throw e2;
        }
    }
}
