package com.opos.mobad.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.ad.c.r;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/c.class */
public class c extends b implements com.opos.mobad.ad.c.c, b.InterfaceC0687b {
    private Handler l;

    public c(Context context, String str, int i, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.c.f fVar) {
        super(context, str, i, dVar, fVar);
        this.l = new Handler(Looper.getMainLooper());
    }

    public c(Context context, String str, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.c.f fVar) {
        super(context, str, dVar, fVar);
        this.l = new Handler(Looper.getMainLooper());
    }

    private List<com.opos.mobad.ad.c.d> a(AdData adData) {
        ArrayList arrayList;
        List<AdItemData> f;
        if (adData != null && (f = adData.f()) != null && f.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<AdItemData> it = f.iterator();
            while (true) {
                arrayList = arrayList2;
                if (!it.hasNext()) {
                    break;
                }
                AdItemData next = it.next();
                if (next != null) {
                    arrayList2.add(new com.opos.mobad.h.b.a(this.f26159a, this, next));
                }
            }
        } else {
            arrayList = null;
        }
        com.opos.cmn.an.f.a.b("InterNativeAd", "adDataToINativeAdDataList =", arrayList);
        return arrayList;
    }

    private void a(final MaterialData materialData) {
        if (this.d) {
            return;
        }
        this.l.post(new Runnable() { // from class: com.opos.mobad.h.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (materialData == null || 2 != c.this.j) {
                    return;
                }
                com.opos.cmn.an.f.a.b("InterNativeAd", "notifyRewardIfNeed pkgNameTime=" + materialData.H());
                if (!c.this.a(materialData.k(), materialData.H())) {
                    c.this.c().b(materialData.k(), 1);
                    return;
                }
                c.this.c().a(materialData.k());
                com.opos.mobad.cmn.a.b.f.a(c.this.f26159a, materialData.k(), com.opos.cmn.b.a.a.c());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0707a c0707a) {
        if (c0707a != null && c0707a.f26482a.a() == 1) {
            com.opos.mobad.service.a.a().a(this.b, 4, c0707a.b.f(), c0707a.b.b(), c0707a.f26483c.aa(), c0707a.b.a(), c0707a.b.J());
            a(new q(-1, com.opos.cmn.a.a(-1)));
        } else if (c0707a == null) {
            b().a(new q(-1, "unknown error."));
        } else if (System.currentTimeMillis() <= c0707a.f26482a.h()) {
            a(c0707a.f26482a, a(c0707a.f26482a));
        } else {
            com.opos.cmn.an.f.a.d("InterNativeAd", "now time over ad expire time.");
            a(new q(GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR, "now time over ad expire time."));
        }
    }

    private void b(r rVar) {
        com.opos.cmn.an.f.a.b("InterNativeAd", "fetchNativeAd");
        this.k = com.opos.cmn.i.f.a();
        com.opos.mobad.model.b.a(this.f26159a).a(this.f26159a, this.b, 4, this.k, (int) (rVar != null ? rVar.f25674a : 30000L), new b.a() { // from class: com.opos.mobad.h.c.1
            @Override // com.opos.mobad.model.b.a
            public void a(int i, final a.C0707a c0707a) {
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.h.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.d) {
                            return;
                        }
                        c.this.a(c0707a);
                    }
                });
            }

            @Override // com.opos.mobad.model.b.a
            public void a(final int i, final String str, AdData adData) {
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.h.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.d) {
                            return;
                        }
                        c.this.a(new q(i, str));
                    }
                });
            }
        }, com.opos.mobad.model.b.f26381a);
    }

    private boolean e() {
        boolean a2 = com.opos.mobad.service.f.c().a(this.b);
        if (!a2) {
            com.opos.mobad.service.d.b.a().a(this.b);
        }
        return a2;
    }

    @Override // com.opos.mobad.ad.c.c
    public void a() {
        com.opos.cmn.an.f.a.b("InterNativeAd", "destroyAd");
        if (!com.opos.mobad.cmn.a.b.f.e() || this.d) {
            return;
        }
        this.i = null;
        com.opos.mobad.cmn.service.pkginstall.b.a(this.f26159a).a(this);
        if (this.h != null) {
            this.h.a();
        }
        this.d = true;
    }

    @Override // com.opos.mobad.model.c.a
    public void a(int i, String str, AdData adData, Object... objArr) {
    }

    @Override // com.opos.mobad.ad.c.c
    public void a(r rVar) {
        com.opos.mobad.ad.c.f b;
        q qVar;
        com.opos.cmn.an.f.a.b("InterNativeAd", "loadAd nativeAdParams=", rVar);
        if (!com.opos.mobad.cmn.a.b.f.e()) {
            b = b();
            qVar = new q(11005, b(11005));
        } else if (this.d) {
            return;
        } else {
            if (e()) {
                int a2 = a(4);
                if (a2 == 0) {
                    b(rVar);
                    return;
                } else {
                    a(new q(a2, b(a2)));
                    return;
                }
            }
            b = b();
            qVar = new q(-1, "inter error request");
        }
        b.a(qVar);
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0687b
    public void a(final AdItemData adItemData, final String str) {
        if (adItemData != null) {
            try {
                if (com.opos.cmn.an.c.a.a(str)) {
                    return;
                }
                com.opos.cmn.an.f.a.b("InterNativeAd", "notifyInstallCompletedEvent pkgName=" + str);
                if (this.d) {
                    return;
                }
                this.l.post(new Runnable() { // from class: com.opos.mobad.h.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.opos.cmn.an.f.a.b("InterNativeAd", "notifyInstallCompleted pkgName=" + str);
                        try {
                            c.this.c().a(str);
                            if (1 == c.this.j) {
                                if (!c.this.a(str, adItemData.i().get(0).H())) {
                                    c.this.c().b(str, 1);
                                    return;
                                }
                                c.this.c().a(str);
                                com.opos.mobad.cmn.a.b.f.a(c.this.f26159a, str, com.opos.cmn.b.a.a.c());
                            }
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.a("InterNativeAd", "", (Throwable) e);
                        }
                    }
                });
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterNativeAd", "", (Throwable) e);
            }
        }
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.cmn.a.b.a aVar, View view) {
        if (1 == this.j) {
            adItemData.g(2);
        } else if (2 == this.j) {
            adItemData.g(4);
        }
        this.g.a(adItemData, z, iArr, map, aVar, view, this, (com.opos.mobad.cmn.a.b) null);
    }

    public boolean a(AdItemData adItemData, MaterialData materialData) {
        boolean z = false;
        if (adItemData != null) {
            z = false;
            if (materialData != null) {
                boolean z2 = false;
                z = false;
                try {
                    if (!com.opos.cmn.an.c.a.a(materialData.k())) {
                        boolean a2 = com.opos.mobad.cmn.a.b.f.a(this.f26159a, adItemData, materialData, (int[]) null);
                        z = a2;
                        if (a2) {
                            z2 = a2;
                            a(materialData);
                            z = a2;
                        }
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("InterNativeAd", "", (Throwable) e);
                    z = z2;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchApp pkgName=");
        sb.append(materialData != null ? materialData.k() : com.igexin.push.core.b.l);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("InterNativeAd", sb.toString());
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0029, code lost:
        if (com.opos.cmn.b.a.a.c() >= (com.opos.mobad.cmn.a.b.f.d(r7.f26159a, r8) + ((r9 * 60) * 1000))) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r8, int r9) {
        /*
            r7 = this;
            r0 = 0
            r1 = r7
            android.content.Context r1 = r1.f26159a     // Catch: java.lang.Exception -> L32
            r2 = r8
            long r1 = com.opos.mobad.cmn.a.b.f.d(r1, r2)     // Catch: java.lang.Exception -> L32
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L2c
            long r0 = com.opos.cmn.b.a.a.c()     // Catch: java.lang.Exception -> L32
            r10 = r0
            r0 = r7
            android.content.Context r0 = r0.f26159a     // Catch: java.lang.Exception -> L32
            r1 = r8
            long r0 = com.opos.mobad.cmn.a.b.f.d(r0, r1)     // Catch: java.lang.Exception -> L32
            r12 = r0
            r0 = r10
            r1 = r12
            r2 = r9
            r3 = 60
            int r2 = r2 * r3
            r3 = 1000(0x3e8, float:1.401E-42)
            int r2 = r2 * r3
            long r2 = (long) r2
            long r1 = r1 + r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L3e
        L2c:
            r0 = 1
            r14 = r0
            goto L41
        L32:
            r15 = move-exception
            java.lang.String r0 = "InterNativeAd"
            java.lang.String r1 = ""
            r2 = r15
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L3e:
            r0 = 0
            r14 = r0
        L41:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r15 = r0
            r0 = r15
            java.lang.String r1 = "canReward pkgName="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r15
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r15
            java.lang.String r1 = ",result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r15
            r1 = r14
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "InterNativeAd"
            r1 = r15
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r14
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.h.c.a(java.lang.String, int):boolean");
    }

    public void b(AdItemData adItemData) {
        this.g.b(adItemData);
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0687b
    public void b(AdItemData adItemData, String str) {
        if (adItemData != null && adItemData.i() != null) {
            a(adItemData.i().get(0));
        }
        com.opos.cmn.an.f.a.b("InterNativeAd", "notifyLaunchEvent pkgName:" + str);
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0687b
    public void c(AdItemData adItemData, String str) {
        if (adItemData != null && adItemData.i() != null) {
            a(adItemData.i().get(0));
        }
        com.opos.cmn.an.f.a.b("InterNativeAd", "notifyLaunchEventFromWeb pkgName:" + str);
    }

    public boolean d() {
        return this.d;
    }
}
