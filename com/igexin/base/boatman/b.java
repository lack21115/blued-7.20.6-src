package com.igexin.base.boatman;

import com.igexin.base.boatman.receive.IBoatResult;
import com.igexin.base.boatman.receive.Site;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/boatman/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f23210a = new ReentrantLock();
    public final Map<String, Site> b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, List<a>> f23211c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <B, V> void a(Boater<B, V> boater, B b, IBoatResult<V> iBoatResult) {
        Site site = this.b.get(boater.getTag());
        if (site == null) {
            return;
        }
        site.onArrived(b, iBoatResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(Boater boater, Object obj) {
        String tag = boater.getTag();
        this.f23210a.lock();
        try {
            List<a> list = this.f23211c.get(tag);
            boolean z = false;
            if (list == null) {
                this.f23210a.unlock();
                return false;
            }
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().f23209a == obj) {
                    z = true;
                    it.remove();
                }
            }
            this.f23210a.unlock();
            return z;
        } catch (Throwable th) {
            this.f23210a.unlock();
            throw th;
        }
    }
}
