package com.tencent.thumbplayer.tplayer.plugins;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/plugins/c.class */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f25719a = new CopyOnWriteArrayList<>();

    @Override // com.tencent.thumbplayer.tplayer.plugins.a
    public void a() {
    }

    @Override // com.tencent.thumbplayer.tplayer.plugins.a
    public void a(int i, int i2, int i3, String str, Object obj) {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = this.f25719a;
        if (copyOnWriteArrayList != null) {
            Iterator<a> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(i, i2, i3, str, obj);
                }
            }
        }
    }

    @Override // com.tencent.thumbplayer.tplayer.plugins.b
    public void a(a aVar) {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = this.f25719a;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.contains(aVar)) {
            return;
        }
        aVar.a();
        this.f25719a.add(aVar);
    }

    @Override // com.tencent.thumbplayer.tplayer.plugins.a
    public void b() {
    }

    @Override // com.tencent.thumbplayer.tplayer.plugins.b
    public void c() {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = this.f25719a;
        if (copyOnWriteArrayList != null) {
            Iterator<a> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.b();
                }
            }
            this.f25719a.clear();
        }
        this.f25719a = null;
    }
}
