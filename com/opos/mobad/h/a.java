package com.opos.mobad.h;

import android.content.Context;
import android.view.View;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.model.d.g;
import com.opos.mobad.model.d.n;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/a.class */
public abstract class a implements com.opos.mobad.model.c.a {
    private static final String i = com.opos.cmn.an.a.b.a("b3Bwb191bmlvbl90b2tlbj0=");
    private static Map<String, Long> k = new ConcurrentHashMap();
    private static Map<String, Long> l = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    protected Context f26159a;
    protected String b;

    /* renamed from: c  reason: collision with root package name */
    protected n f26160c;
    protected boolean d;
    protected com.opos.mobad.cmn.a.a g;
    protected a.b h;
    private long j = com.igexin.push.config.c.j;
    protected long e = 0;
    protected long f = 0;

    public a(Context context, String str, com.opos.mobad.cmn.a.d dVar) {
        Context a2 = com.opos.mobad.service.b.a(context);
        this.f26159a = a2;
        this.b = str;
        this.f26160c = new g(a2, com.opos.mobad.model.b.a(context).a());
        this.g = new com.opos.mobad.cmn.a.a(this.f26159a, str, dVar);
        a.b a3 = com.opos.mobad.cmn.a.b.f.a(context, (View) null);
        this.h = a3;
        this.g.a(a3);
        a();
    }

    private void a() {
        com.opos.mobad.cmn.service.pkginstall.c.a().a(this.f26159a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i2) {
        return 0;
    }

    public void a(AdItemData adItemData) {
        if (adItemData != null) {
            try {
                MaterialData materialData = adItemData.i().get(0);
                if (materialData == null || materialData.n() == null || materialData.n().size() <= 0) {
                    return;
                }
                com.opos.mobad.service.g.b.a(this.f26159a, materialData.n());
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterBaseAd", "", (Throwable) e);
            }
        }
    }

    public void a(AdItemData adItemData, boolean z, Map<String, String> map) {
        if (adItemData != null) {
            try {
                MaterialData materialData = adItemData.i().get(0);
                if (materialData != null) {
                    this.g.a(adItemData);
                    com.opos.mobad.cmn.a.b.d.a(this.f26159a, this.b, adItemData, materialData, z, map);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterBaseAd", "", (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b(int i2) {
        return i2 != 10008 ? i2 != 11001 ? i2 != 11003 ? i2 != 11005 ? "" : "ads must display on android version after19" : "you request ad too often." : "ad has destroyed." : "ad has showed, please reload ad";
    }
}
