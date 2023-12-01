package com.anythink.core.common.e;

import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/aj.class */
public final class aj {

    /* renamed from: a  reason: collision with root package name */
    public int f6636a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    private List<b> f6637c;

    public final b a() {
        b next;
        synchronized (this) {
            if (this.f6637c != null) {
                Iterator<b> it = this.f6637c.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                    }
                } while (next.d() > 0);
                boolean z = true;
                if (this.f6637c.indexOf(next) < this.f6637c.size() - 1) {
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
            if (this.f6637c != null && this.f6637c.size() > 0) {
                this.f6637c.remove(bVar);
            }
        }
    }

    public final void a(e eVar) {
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            this.f6636a = -1;
            this.b = eVar.X();
            if (this.f6637c != null) {
                for (b bVar : this.f6637c) {
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
            this.f6637c = arrayList;
        }
    }

    public final void a(List<b> list) {
        synchronized (this) {
            synchronized (this) {
                this.f6637c = list;
            }
        }
    }

    public final List<b> b() {
        synchronized (this) {
            ArrayList arrayList = null;
            if (this.f6637c != null) {
                for (b bVar : this.f6637c) {
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
            if (this.f6637c != null) {
                this.f6637c.clear();
                this.f6637c = null;
            }
        }
    }

    public final boolean d() {
        List<b> list = this.f6637c;
        return list != null && list.size() > 0;
    }
}
