package com.opos.mobad.f.a.a;

import android.content.Context;
import com.opos.mobad.ad.b;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/g.class */
public class g<T extends com.opos.mobad.ad.b> extends i<T> implements m<T> {

    /* renamed from: a  reason: collision with root package name */
    protected com.opos.mobad.f.a.b.a<T> f12343a;
    private List<T> d;
    private T g;
    private int h;
    private int i;
    private Context j;
    private AtomicBoolean k;

    public g(Context context, String str, int i, com.opos.mobad.f.a.c.a aVar, List<e.a> list, e.a aVar2, long j, int i2, com.opos.mobad.f.a.b.b<T> bVar, b.a aVar3) {
        super(str, i, aVar, list, aVar2, j, i2, bVar, aVar3);
        this.h = 0;
        this.i = 0;
        this.k = new AtomicBoolean(false);
        this.j = context;
        this.f12343a = bVar;
        this.d = new ArrayList(list.size());
        this.h = com.opos.cmn.an.h.f.a.b(context);
        this.i = com.opos.cmn.an.h.f.a.a(context, 57.0f);
    }

    private boolean g(int i) {
        return i == 2 && this.k.get();
    }

    private void h() {
        com.opos.cmn.an.f.a.b("delegator", "clearCacheDestroyAd size =" + this.d.size());
        if (this.d.isEmpty()) {
            return;
        }
        for (T t : this.d) {
            t.b();
        }
        this.d.clear();
    }

    @Override // com.opos.mobad.f.a.a.m
    public void a(int i, int i2) {
        if (i == this.h && i2 == this.i) {
            return;
        }
        com.opos.cmn.an.f.a.a("SyncStateController", "BannerSizeChange w=" + i + ",h =" + i2);
        this.i = i2;
        this.h = i;
        this.k.compareAndSet(false, true);
    }

    @Override // com.opos.mobad.f.a.a.i
    protected void a(e.a aVar, T t) {
        this.b.put(Integer.valueOf(aVar.f13613a), t);
        this.f12352c.put(Integer.valueOf(aVar.f13613a), aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0058, code lost:
        if (r0.d() == 2) goto L21;
     */
    @Override // com.opos.mobad.f.a.a.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(java.lang.String r6, java.util.List<java.lang.Integer> r7, int r8) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.f.a.a.g.a(java.lang.String, java.util.List, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.f.a.a.i
    public boolean a(T t, int i) {
        if (g(i)) {
            com.opos.cmn.an.f.a.b("SyncStateController", "is channel enable but size change");
            return false;
        }
        return super.a((g<T>) t, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.f.a.a.i
    public boolean a(Map.Entry<Integer, T> entry, T t) {
        if (entry != null) {
            if (!com.opos.mobad.service.f.b().a(entry.getKey().intValue())) {
                return false;
            }
            if (!super.a((Map.Entry<Integer, Map.Entry<Integer, T>>) entry, (Map.Entry<Integer, T>) t) && g(entry.getKey().intValue())) {
                com.opos.cmn.an.f.a.a("SyncStateController", "channel need to load because of size changed ");
                return true;
            }
        }
        return super.a((Map.Entry<Integer, Map.Entry<Integer, T>>) entry, (Map.Entry<Integer, T>) t);
    }

    @Override // com.opos.mobad.f.a.a.i, com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        if (!this.f12352c.isEmpty()) {
            this.f12352c.clear();
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.f.a.a.i
    public void c(String str, int i) {
        h();
        T t = this.g;
        if (t != null) {
            this.d.add(t);
        }
        this.g = this.b.get(Integer.valueOf(i));
        super.c(str, i);
    }
}
