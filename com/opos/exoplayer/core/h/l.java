package com.opos.exoplayer.core.h;

import android.content.Context;
import android.net.Uri;
import com.anythink.expressad.exoplayer.j.y;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/l.class */
public final class l implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11769a;
    private final t<? super g> b;

    /* renamed from: c  reason: collision with root package name */
    private final g f11770c;
    private g d;
    private g e;
    private g f;
    private g g;
    private g h;
    private g i;
    private g j;

    public l(Context context, t<? super g> tVar, g gVar) {
        this.f11769a = context.getApplicationContext();
        this.b = tVar;
        this.f11770c = (g) com.opos.exoplayer.core.i.a.a(gVar);
    }

    private g c() {
        if (this.d == null) {
            this.d = new p(this.b);
        }
        return this.d;
    }

    private g d() {
        if (this.e == null) {
            this.e = new c(this.f11769a, this.b);
        }
        return this.e;
    }

    private g e() {
        if (this.f == null) {
            this.f = new e(this.f11769a, this.b);
        }
        return this.f;
    }

    private g f() {
        if (this.g == null) {
            try {
                this.g = (g) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                com.opos.cmn.an.f.a.c("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.g == null) {
                this.g = this.f11770c;
            }
        }
        return this.g;
    }

    private g g() {
        if (this.h == null) {
            this.h = new f();
        }
        return this.h;
    }

    private g h() {
        if (this.i == null) {
            this.i = new s(this.f11769a, this.b);
        }
        return this.i;
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i, int i2) {
        return this.j.a(bArr, i, i2);
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) {
        g e;
        com.opos.exoplayer.core.i.a.b(this.j == null);
        String scheme = iVar.f11761a.getScheme();
        if (u.a(iVar.f11761a)) {
            if (!iVar.f11761a.getPath().startsWith("/android_asset/")) {
                e = c();
            }
            e = d();
        } else {
            if (!"asset".equals(scheme)) {
                e = "content".equals(scheme) ? e() : "rtmp".equals(scheme) ? f() : "data".equals(scheme) ? g() : y.f4779a.equals(scheme) ? h() : this.f11770c;
            }
            e = d();
        }
        this.j = e;
        return this.j.a(iVar);
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        g gVar = this.j;
        if (gVar == null) {
            return null;
        }
        return gVar.a();
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        g gVar = this.j;
        if (gVar != null) {
            try {
                gVar.b();
            } finally {
                this.j = null;
            }
        }
    }
}
