package com.opos.mobad.q.a;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.opos.mobad.ad.i;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.a.a.a;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f27140a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.cmn.a.a f27141c;
    private b.InterfaceC0687b d;
    private InterfaceC0724a e;
    private boolean f;
    private AdItemData g;
    private MaterialData h;
    private boolean i;
    private long j;
    private int k;
    private boolean l;
    private int m;
    private int n = 0;

    /* renamed from: com.opos.mobad.q.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/a$a.class */
    public interface InterfaceC0724a extends i.b, a.b {
        void j_();
    }

    public a(Context context, String str, com.opos.mobad.cmn.a.a aVar, b.InterfaceC0687b interfaceC0687b, InterfaceC0724a interfaceC0724a) {
        this.f27140a = context;
        this.b = str;
        this.f27141c = aVar;
        this.d = interfaceC0687b;
        this.e = interfaceC0724a;
    }

    private void a(boolean z, int i, Map<String, String> map) {
        com.opos.mobad.cmn.a.b.d.a(this.f27140a, this.b, this.g, this.h, z, i, map);
    }

    private boolean a(int i, long j) {
        boolean z;
        try {
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdPresenter", "", (Throwable) e);
        }
        if (this.j < j) {
            if (j - this.j <= i * 60 * 1000) {
                z = true;
                com.opos.cmn.an.f.a.b("AdPresenter", "isValidClick=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("AdPresenter", "isValidClick=" + z);
        return z;
    }

    private boolean a(long j, int i) {
        long j2 = this.j;
        boolean z = j < j2 && j2 - j <= ((long) ((i * 60) * 1000));
        com.opos.cmn.an.f.a.b("AdPresenter", "isValidExpose=" + z);
        return z;
    }

    private void c() {
        MaterialData materialData = this.h;
        if (materialData != null) {
            com.opos.mobad.service.g.b.a(this.f27140a, materialData.o());
        } else {
            com.opos.cmn.an.f.a.c("AdPresenter", "close with null data");
        }
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f || a.this.e == null) {
                    return;
                }
                a.this.e.d();
            }
        });
    }

    public void a() {
        if (this.f) {
            return;
        }
        if (this.g != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("clientTemplateId", String.valueOf(this.k));
            com.opos.mobad.cmn.a.b.d.a(this.f27140a, this.g.b(), this.g.g(), "3", this.g.c(), "", hashMap);
        }
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.q.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.e != null) {
                    a.this.e.j_();
                }
            }
        });
    }

    public void a(final int i) {
        String b;
        String str;
        String c2;
        String a2;
        if (this.f) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("rsCode", "" + i);
        hashMap.put("clientTemplateId", String.valueOf(this.k));
        AdItemData adItemData = this.g;
        Context context = this.f27140a;
        if (adItemData == null) {
            str = this.b;
            b = "";
            c2 = "";
            a2 = "";
        } else {
            b = adItemData.b();
            str = this.b;
            c2 = this.g.c();
            a2 = this.g.a();
        }
        com.opos.mobad.cmn.a.b.d.a(context, b, str, "4", c2, a2, hashMap);
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.e != null) {
                    InterfaceC0724a interfaceC0724a = a.this.e;
                    interfaceC0724a.a(-1, "render fail code:" + i);
                }
            }
        });
    }

    public void a(View view) {
        if (this.f || this.i) {
            return;
        }
        this.i = true;
        this.g.k(com.opos.mobad.service.f.a.a().x());
        this.j = SystemClock.elapsedRealtime();
        HashMap hashMap = new HashMap();
        if (view != null) {
            com.opos.mobad.cmn.a.b.d.a(view, hashMap);
        }
        boolean a2 = a(this.g.N(), this.g.p());
        hashMap.put("clientTemplateId", String.valueOf(this.k));
        a(a2, this.n, hashMap);
        com.opos.mobad.service.g.b.a(this.f27140a, this.h.n());
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.e != null) {
                    a.this.e.a(a.this.g.J());
                }
            }
        });
    }

    public void a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar, final long j, Map<String, String> map, a.c cVar) {
        String str;
        if (this.f) {
            return;
        }
        if (map == null) {
            map = new HashMap();
        }
        if (aVar == com.opos.mobad.cmn.a.b.a.FloatLayerClickBt || aVar == com.opos.mobad.cmn.a.b.a.FloatLayerNonClickBt) {
            map.put("endTmType", "" + this.m);
        }
        boolean a2 = a(this.g.q(), SystemClock.elapsedRealtime());
        map.put("clientTemplateId", String.valueOf(this.k));
        if (this.l) {
            str = "2";
        } else {
            this.l = true;
            str = "1";
        }
        map.put("clickState", str);
        com.opos.mobad.cmn.a.a aVar2 = this.f27141c;
        if (aVar2 != null) {
            aVar2.a(this.g, a2, iArr, map, aVar, view, this.d, (com.opos.mobad.cmn.a.b) null, cVar);
        }
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.e != null) {
                    a.this.e.a(j);
                }
            }
        });
    }

    public void a(AdItemData adItemData, MaterialData materialData, int i, int i2) {
        this.n = 0;
        this.g = adItemData;
        this.h = materialData;
        this.i = false;
        this.k = i;
        this.m = i2;
        com.opos.mobad.cmn.a.a aVar = this.f27141c;
        if (aVar != null) {
            aVar.b(adItemData);
            this.f27141c.a(this.g);
        }
        this.l = false;
    }

    public void a(boolean z, int[] iArr) {
        if (this.f) {
            return;
        }
        com.opos.mobad.cmn.a.b.d.a(this.f27140a, this.b, z, this.g, this.h, (Map<String, String>) null, iArr);
        c();
    }

    public void b() {
        com.opos.mobad.cmn.service.pkginstall.b.a(this.f27140a).a(this.d);
        this.f = true;
        com.opos.mobad.cmn.a.a aVar = this.f27141c;
        if (aVar != null) {
            aVar.a();
        }
        this.f27141c = null;
    }

    public void b(int i) {
        this.n = i;
    }

    public void b(boolean z, int[] iArr) {
        if (this.f) {
            return;
        }
        com.opos.mobad.cmn.a.b.d.a(this.f27140a, this.b, this.g, this.h, iArr, z);
        c();
    }

    public void c(int i) {
        if (this.f) {
            return;
        }
        com.opos.mobad.cmn.a.b.d.a(this.f27140a, this.b, this.g, this.h, i);
    }

    public void d(int i) {
        String b;
        String str;
        String c2;
        String a2;
        if (this.f) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("rsCode", "" + i);
        hashMap.put("clientTemplateId", String.valueOf(this.k));
        AdItemData adItemData = this.g;
        Context context = this.f27140a;
        if (adItemData == null) {
            str = this.b;
            b = "";
            c2 = "";
            a2 = "";
        } else {
            b = adItemData.b();
            str = this.b;
            c2 = this.g.c();
            a2 = this.g.a();
        }
        com.opos.mobad.cmn.a.b.d.a(context, b, str, "5", c2, a2, hashMap);
    }
}
