package com.opos.cmn.func.dl.base.a.a;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/a/a/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    com.opos.cmn.func.dl.base.f.a f24885a;
    public e[] b;

    /* renamed from: c  reason: collision with root package name */
    Context f24886c;

    public d(Context context, com.opos.cmn.func.dl.base.f.a aVar, int i) {
        this.f24885a = aVar;
        this.f24886c = context;
        this.b = new e[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            this.b[i3] = new e(this);
            aVar.f24924c.g().c().execute(this.b[i3]);
            i2 = i3 + 1;
        }
    }

    public final com.opos.cmn.func.dl.base.a.c a(int i) {
        return this.f24885a.b.get(Integer.valueOf(i));
    }

    public final void b(int i) {
        e[] eVarArr = this.b;
        int length = eVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            e eVar = eVarArr[i3];
            if (eVar.f24888c.containsKey(Integer.valueOf(i))) {
                ArrayList arrayList = new ArrayList();
                for (a aVar : eVar.d) {
                    if (aVar.b == i) {
                        arrayList.add(aVar);
                    }
                }
                eVar.d.removeAll(arrayList);
                com.opos.cmn.an.f.a.b(e.f24887a, "close buffer stream!downloadId:".concat(String.valueOf(i)));
                com.opos.cmn.func.dl.base.h.a.a(eVar.f24888c.remove(Integer.valueOf(i)));
            }
            i2 = i3 + 1;
        }
    }
}
