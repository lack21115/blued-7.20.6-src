package com.opos.mobad.h;

import android.content.Context;
import com.opos.mobad.ad.c.h;
import com.opos.mobad.ad.c.j;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.e.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/d.class */
public class d extends com.opos.mobad.l.e {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private Context f26196c;
    private String d;
    private com.opos.mobad.cmn.a.a e;
    private com.opos.mobad.ad.privacy.a f;

    public d(Context context, String str, com.opos.mobad.cmn.a.d dVar, j jVar, com.opos.mobad.ad.privacy.a aVar) {
        super(jVar);
        this.f26196c = context;
        this.e = new com.opos.mobad.cmn.a.a(context, str, dVar);
        this.d = str;
        this.f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<h> a(AdData adData) {
        ArrayList arrayList = new ArrayList();
        for (AdItemData adItemData : adData.f()) {
            if (adItemData != null) {
                arrayList.add(new com.opos.mobad.h.b.c(this.e, adItemData, this.f26196c, this.d, this.f.a()));
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.l.f
    public boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.f
    public boolean b(String str, int i) {
        this.b = 0;
        com.opos.mobad.model.b.a(this.f26196c.getApplicationContext()).a(this.f26196c, this.d, 4, str, i, new b.a() { // from class: com.opos.mobad.h.d.1
            @Override // com.opos.mobad.model.b.a
            public void a(int i2, a.C0707a c0707a) {
                if (c0707a == null || c0707a.f26482a.a() != 1) {
                    d.this.b = i2;
                    d.this.a(d.this.a(c0707a.f26482a));
                    return;
                }
                com.opos.mobad.service.a.a().a(d.this.d, 4, c0707a.b.f(), c0707a.b.b(), c0707a.f26483c.aa(), c0707a.b.a(), c0707a.b.J());
                d.this.b = c0707a.f26482a.c();
                d.this.a(-1, com.opos.cmn.a.a(-1));
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                if (adData != null) {
                    d.this.b = adData.c();
                }
                d.this.a(i2, str2);
            }
        }, com.opos.mobad.model.b.b);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.b;
    }
}
