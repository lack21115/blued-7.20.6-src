package com.opos.mobad.model.d;

import android.content.Context;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.opos.mobad.b.a.y;
import com.opos.mobad.model.d.m;
import com.opos.mobad.model.data.AdData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/e.class */
public class e extends a {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f12726c;
    private String d;
    private com.opos.mobad.model.b.d e;

    public e(Context context, String str, String str2, com.opos.mobad.model.b.c cVar, boolean z, m.a aVar) {
        super(context, str, cVar, z, new i(str, str2, true), aVar);
        this.b = context;
        this.f12726c = str;
        this.d = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x042f, code lost:
        if (r8 == null) goto L144;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v110, types: [com.opos.mobad.model.b.d] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.mobad.model.b.d a(com.opos.mobad.model.b.d r8, com.opos.mobad.model.d.q r9) {
        /*
            Method dump skipped, instructions count: 1103
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.d.e.a(com.opos.mobad.model.b.d, com.opos.mobad.model.d.q):com.opos.mobad.model.b.d");
    }

    private void a(final String str, String str2, final com.opos.mobad.model.b.c cVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e eVar;
                com.opos.mobad.model.b.b bVar;
                com.opos.mobad.model.b.d a2;
                e eVar2;
                AdData adData;
                if (com.opos.mobad.service.a.c.a().d()) {
                    com.opos.mobad.model.b.c cVar2 = cVar;
                    if (cVar2 == null || !com.opos.mobad.service.f.a.a(cVar2.i())) {
                        try {
                            a2 = c.a(e.this.b).a(str);
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.b("cAdLoader", "fail cache", e);
                            eVar = e.this;
                            bVar = new com.opos.mobad.model.b.b(-1, "unknown error.");
                        }
                        if (a2 == null) {
                            com.opos.cmn.an.f.a.b("cAdLoader", "cache null");
                            e.this.a(new AdData(10001, "net response is null."));
                            return;
                        } else if (System.currentTimeMillis() >= a2.i()) {
                            e.this.a(new com.opos.mobad.model.b.b(GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR, "now time over ad expire time."));
                            return;
                        } else {
                            com.opos.cmn.an.f.a.b("cAdLoader", "cache data:", a2);
                            if (a2 != null && a2.h() != null && a2.h().size() > 0) {
                                e eVar3 = e.this;
                                e.this.a(eVar3.a(a2, eVar3.f12710a));
                                return;
                            }
                            eVar = e.this;
                            bVar = new com.opos.mobad.model.b.b(10004, "adItemList is null.");
                            eVar.a(bVar);
                            return;
                        }
                    }
                    com.opos.cmn.an.f.a.b("cAdLoader", "cache but in childMode");
                    eVar2 = e.this;
                    adData = new AdData(10001, "net response is null.");
                } else {
                    com.opos.cmn.an.f.a.b("cAdLoader", "cache disable");
                    eVar2 = e.this;
                    adData = new AdData(10001, "net response is null.");
                }
                eVar2.a(adData);
            }
        });
    }

    @Override // com.opos.mobad.model.d.a
    protected void a(y yVar) {
    }

    @Override // com.opos.mobad.model.d.a
    public void a(com.opos.mobad.model.b.c cVar) {
        a(this.f12726c, this.d, cVar);
    }

    @Override // com.opos.mobad.model.d.a
    public void a(boolean z) {
        super.a(z);
    }

    public void k() {
        if (j() != 4 || this.e == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("cAdLoader", "cache origin cache");
        c a2 = c.a(this.b);
        String str = this.f12726c;
        com.opos.mobad.model.b.d dVar = this.e;
        a2.a(str, dVar, dVar.h());
    }
}
