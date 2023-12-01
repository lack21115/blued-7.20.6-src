package com.anythink.core.common.e;

import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/aj.class */
public final class aj {
    public int a;
    public String b;
    private List<b> c;

    public final b a() {
        b next;
        synchronized (this) {
            if (this.c != null) {
                Iterator<b> it = this.c.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                    }
                } while (next.d() > 0);
                boolean z = true;
                if (this.c.indexOf(next) < this.c.size() - 1) {
                    z = false;
                }
                next.a(z);
                return next;
            }
            return null;
        }
    }

    public final void a(b bVar) {
        synchronized (this) {
            if (this.c != null && this.c.size() > 0) {
                this.c.remove(bVar);
            }
        }
    }

    public final void a(e eVar) {
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            this.a = -1;
            this.b = eVar.X();
            if (this.c != null) {
                for (b bVar : this.c) {
                    if (bVar.j()) {
                        ATBaseAdAdapter e = bVar.e();
                        e.setTrackingInfo(eVar);
                        eVar.g(e.getNetworkPlacementId());
                        bVar.b(-1);
                        BaseAd f = bVar.f();
                        if (f != null) {
                            f.setTrackingInfo(eVar.N());
                        }
                        arrayList.add(bVar);
                    }
                }
            }
            this.c = arrayList;
        }
    }

    public final void a(List<b> list) {
        synchronized (this) {
            synchronized (this) {
                this.c = list;
            }
        }
    }

    public final List<b> b() {
        synchronized (this) {
            ArrayList arrayList = null;
            if (this.c != null) {
                for (b bVar : this.c) {
                    if (bVar.d() <= 0) {
                        ArrayList arrayList2 = arrayList;
                        if (arrayList == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(bVar);
                        arrayList = arrayList2;
                    }
                }
                return arrayList;
            }
            return null;
        }
    }

    public final void c() {
        synchronized (this) {
            if (this.c != null) {
                this.c.clear();
                this.c = null;
            }
        }
    }

    public final boolean d() {
        List<b> list = this.c;
        return list != null && list.size() > 0;
    }
}
