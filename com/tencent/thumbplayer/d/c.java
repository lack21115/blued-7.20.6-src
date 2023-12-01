package com.tencent.thumbplayer.d;

import com.tencent.thumbplayer.d.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/d/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<a>> f39299a = new CopyOnWriteArrayList<>();

    public void a(a aVar) {
        CopyOnWriteArrayList<WeakReference<a>> copyOnWriteArrayList;
        if (aVar == null || (copyOnWriteArrayList = this.f39299a) == null || copyOnWriteArrayList.contains(aVar)) {
            return;
        }
        this.f39299a.add(new WeakReference<>(aVar));
    }

    public void a(b.a aVar) {
        CopyOnWriteArrayList<WeakReference<a>> copyOnWriteArrayList = this.f39299a;
        if (copyOnWriteArrayList != null) {
            Iterator<WeakReference<a>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a aVar2 = it.next().get();
                if (aVar2 != null) {
                    aVar2.a(aVar);
                }
            }
        }
    }
}
