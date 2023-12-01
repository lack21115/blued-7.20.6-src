package com.opos.mobad.f;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.ad.c;
import com.opos.mobad.ad.c.g;
import com.opos.mobad.ad.c.j;
import com.opos.mobad.ad.c.n;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.s;
import com.opos.mobad.f.a.h;
import com.opos.mobad.service.a.e;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/d.class */
public class d implements com.opos.mobad.ad.c {

    /* renamed from: a  reason: collision with root package name */
    private final List<e.a> f26135a;
    private final e.a b;

    /* renamed from: c  reason: collision with root package name */
    private final b f26136c;
    private final long d;
    private com.opos.mobad.f.a.d.a e;

    public d(com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j, b bVar) {
        this.e = aVar;
        this.f26135a = list;
        this.b = aVar2;
        this.f26136c = bVar;
        this.d = j;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.a.a a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.b bVar) {
        return new com.opos.mobad.f.a.a(activity, str, this.e, false, bVar, this.f26135a, this.b, this.d, this.f26136c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.b.a a(Activity activity, String str, String str2, com.opos.mobad.ad.b.b bVar) {
        return new com.opos.mobad.f.a.d(activity, str, this.e, bVar, this.f26135a, this.b, this.d, this.f26136c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.b.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.b.d dVar) {
        return new com.opos.mobad.f.a.e(activity, str, this.e, dVar, z, this.f26135a, this.b, this.d, this.f26136c);
    }

    @Override // com.opos.mobad.ad.c
    public c.a a(Context context) {
        return new c.a(true, "");
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.c a(Context context, String str, String str2, com.opos.mobad.ad.c.f fVar) {
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public g a(Context context, String str, String str2, int i, int i2, j jVar, com.opos.mobad.ad.privacy.a aVar) {
        return new com.opos.mobad.f.a.f(context, str, this.e, jVar, this.f26135a, this.b, this.d, this.f26136c, aVar);
    }

    @Override // com.opos.mobad.ad.c
    public n a(Context context, s sVar, String str, String str2, o oVar) {
        return new com.opos.mobad.f.a.g(context, sVar, str, this.e, oVar, this.f26135a, this.b, this.d, this.f26136c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.d.b bVar) {
        return new h(context, str, this.e, bVar, false, this.f26135a, this.b, this.d, this.f26136c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.a a(Context context, String str, String str2, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar) {
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.b a(Activity activity, String str, String str2, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar) {
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public void a(Context context, String str, String str2, String str3, boolean z) {
    }

    @Override // com.opos.mobad.ad.c
    public void b() {
    }
}
