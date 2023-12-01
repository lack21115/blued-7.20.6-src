package com.opos.mobad.f.a.a;

import android.content.Context;
import com.opos.mobad.ad.b;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/f.class */
public class f<T extends com.opos.mobad.ad.b> extends h<T> implements m<T> {

    /* renamed from: a  reason: collision with root package name */
    protected com.opos.mobad.f.a.b.a<T> f12341a;

    /* renamed from: c  reason: collision with root package name */
    private List<T> f12342c;
    private T d;
    private int g;
    private int h;
    private Context i;
    private AtomicBoolean j;

    public f(Context context, String str, int i, com.opos.mobad.f.a.c.a aVar, List<e.a> list, e.a aVar2, long j, com.opos.mobad.f.a.b.b<T> bVar, b.a aVar3) {
        super(str, i, aVar, list, aVar2, j, bVar, aVar3);
        this.d = null;
        this.g = 0;
        this.h = 0;
        this.j = new AtomicBoolean(false);
        this.i = context;
        this.f12341a = bVar;
        this.f12342c = new ArrayList(list.size());
        this.g = com.opos.cmn.an.h.f.a.b(context);
        this.h = com.opos.cmn.an.h.f.a.a(context, 57.0f);
    }

    private void h() {
        com.opos.cmn.an.f.a.b("delegator", "clearCacheDestroyAd size =" + this.f12342c.size());
        if (this.f12342c.isEmpty()) {
            return;
        }
        for (T t : this.f12342c) {
            t.b();
        }
        this.f12342c.clear();
    }

    private boolean i(int i) {
        return i == 2 && this.j.get();
    }

    @Override // com.opos.mobad.f.a.a.m
    public void a(int i, int i2) {
        if (i == this.g && i2 == this.h) {
            return;
        }
        this.h = i2;
        this.g = i;
        this.j.compareAndSet(false, true);
        h(2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x004c, code lost:
        if (r0.d() == 2) goto L12;
     */
    @Override // com.opos.mobad.f.a.a.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(java.lang.String r6, com.opos.mobad.service.a.e.a r7) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.f.a.a.f.a(java.lang.String, com.opos.mobad.service.a.e$a):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.f.a.a.h
    public boolean a(T t, int i) {
        if (i(i)) {
            com.opos.cmn.an.f.a.b("SyncStateController", "is channel enable but size change");
            return false;
        }
        return super.a((f<T>) t, i);
    }

    @Override // com.opos.mobad.f.a.a.h, com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.f.a.a.h
    public boolean b(int i, int i2, String str) {
        if (i(i)) {
            com.opos.cmn.an.f.a.a("delegator", "interceptToStartNext :" + i + ",code: " + i2 + ", msg:" + str);
            a(i, i2, str);
            return true;
        }
        return super.b(i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.mobad.f.a.a.h
    public void f(int i) {
        h();
        T t = this.d;
        if (t != null) {
            this.f12342c.add(t);
        }
        this.d = this.b.get(Integer.valueOf(i));
        super.f(i);
    }
}
