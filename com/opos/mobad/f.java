package com.opos.mobad;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.opos.mobad.ad.c;
import com.opos.mobad.ad.c.j;
import com.opos.mobad.ad.c.m;
import com.opos.mobad.ad.c.n;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.s;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f.class */
public class f implements com.opos.mobad.ad.c {
    private static final String[] j;

    /* renamed from: a  reason: collision with root package name */
    protected final com.opos.mobad.cmn.a.d f12317a;
    protected com.opos.mobad.q.a.h b;

    /* renamed from: c  reason: collision with root package name */
    protected com.opos.mobad.cmn.b.c f12318c;
    private AtomicBoolean d = new AtomicBoolean(false);
    private Context e;
    private String f;
    private String g;
    private boolean h;
    private d i;

    static {
        if (com.opos.mobad.cmn.a.b.f.l()) {
            j = new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.INTERNET"};
        } else {
            j = new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.INTERNET", "android.permission.QUERY_ALL_PACKAGES"};
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(com.opos.mobad.q.a.h hVar, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.activity.webview.a aVar, com.opos.mobad.cmn.b.c cVar) {
        this.b = hVar;
        this.f12318c = cVar;
        this.f12317a = dVar;
        com.opos.mobad.cmn.service.a.a().a(dVar, aVar);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.a.a a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.b bVar) {
        if (a() && b.f11998a.booleanValue()) {
            return new com.opos.mobad.a.d(activity, str2, z, this.f12317a, bVar, this.f12318c);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.b.a a(Activity activity, String str, String str2, com.opos.mobad.ad.b.b bVar) {
        if (a() && b.b.booleanValue()) {
            return new com.opos.mobad.interstitial.b(activity, str2, this.f12317a, bVar, this.b);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.b.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.b.d dVar) {
        if (a() && b.b.booleanValue()) {
            return new com.opos.mobad.g.a(activity, str2, this.f12317a, this.b, dVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public c.a a(Context context) {
        if (com.opos.mobad.cmn.a.b.f.d()) {
            if (com.opos.cmn.i.i.a(this.e, j)) {
                StringBuilder sb = new StringBuilder();
                sb.append("content://");
                sb.append(context.getPackageName());
                sb.append(".MobFileProvider");
                return !com.opos.cmn.i.b.a(context, Uri.parse(sb.toString())) ? new c.a(false, "com.heytap.msp.mobad.api.MobFileProvider don't find in AndroidManifest.xml.") : new c.a(true, "");
            }
            return new c.a(false, "don't have some need normal permission.");
        }
        return new c.a(false, "sdk not support android sdk version <19 .");
    }

    public com.opos.mobad.ad.c.c a(Context context, String str, String str2, int i, m mVar) {
        if (a() && b.f11999c.booleanValue()) {
            return new com.opos.mobad.h.c(com.opos.mobad.service.b.a(context), str2, i, this.f12317a, mVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.c a(Context context, String str, String str2, com.opos.mobad.ad.c.f fVar) {
        if (a() && b.f11999c.booleanValue()) {
            return new com.opos.mobad.h.c(com.opos.mobad.service.b.a(context), str2, this.f12317a, fVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.g a(Context context, String str, String str2, int i, int i2, j jVar, com.opos.mobad.ad.privacy.a aVar) {
        if (a() && b.f11999c.booleanValue()) {
            return new com.opos.mobad.h.d(com.opos.mobad.service.b.a(context), str2, this.f12317a, jVar, aVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public n a(Context context, s sVar, String str, String str2, o oVar) {
        if (a() && b.f11999c.booleanValue()) {
            return new com.opos.mobad.h.e(com.opos.mobad.service.b.a(context), str2, sVar, this.f12317a, oVar, this.f12318c);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.d.b bVar) {
        if (a() && b.d.booleanValue()) {
            return new com.opos.mobad.j.a(com.opos.mobad.service.b.a(context), str2, this.f12317a, this.b, bVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.a a(Context context, String str, String str2, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar) {
        if (a() && b.e.booleanValue()) {
            return new com.opos.mobad.k.a(context, str2, this.f12317a, cVar, fVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.b a(Activity activity, String str, String str2, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar) {
        if (a() && b.e.booleanValue()) {
            return new com.opos.mobad.k.c(activity, str2, this.f12317a, cVar, fVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public void a(Context context, String str, String str2, String str3, boolean z) {
        String str4;
        if (context == null || TextUtils.isEmpty(str)) {
            str4 = "init with null content or appId ";
        } else if (a(context).f11982a) {
            if (this.d.compareAndSet(false, true)) {
                this.e = context.getApplicationContext();
                this.f = str;
                this.g = str2;
                this.h = z;
                d dVar = new d();
                this.i = dVar;
                dVar.a(context, str);
                return;
            }
            return;
        } else {
            str4 = "init but fail";
        }
        com.opos.cmn.an.f.a.b("", str4);
    }

    protected boolean a() {
        return this.e != null;
    }

    @Override // com.opos.mobad.ad.c
    public void b() {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a();
        }
    }
}
