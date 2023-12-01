package com.efs.sdk.base.core.util.concurrent;

import com.efs.sdk.base.core.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/concurrent/d.class */
public class d<T> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private List<b<T>> f21796a = new ArrayList(5);
    private c<T> b;

    public d(c<T> cVar) {
        this.b = cVar;
    }

    public final T a() {
        T t;
        T t2 = null;
        try {
            Iterator<b<T>> it = this.f21796a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            T a2 = this.b.a();
            for (b<T> bVar : this.f21796a) {
                bVar.a(this.b, a2);
            }
            Iterator<b<T>> it2 = this.f21796a.iterator();
            while (true) {
                t2 = a2;
                t = a2;
                if (!it2.hasNext()) {
                    break;
                }
                it2.next().result(a2);
            }
        } catch (Throwable th) {
            Log.w("efs.util.concurrent", th);
            Iterator<b<T>> it3 = this.f21796a.iterator();
            while (true) {
                t = t2;
                if (!it3.hasNext()) {
                    break;
                }
                it3.next();
            }
        }
        return t;
    }

    public final void a(List<b<T>> list) {
        this.f21796a.addAll(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
