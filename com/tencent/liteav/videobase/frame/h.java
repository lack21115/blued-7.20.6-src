package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.k;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/h.class */
public abstract class h<T extends k> {

    /* renamed from: a  reason: collision with root package name */
    final Deque<T> f22946a = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f22947c = false;
    private final g<T> d = (g<T>) new g<T>() { // from class: com.tencent.liteav.videobase.frame.h.1
        @Override // com.tencent.liteav.videobase.frame.g
        public final void a(T t) {
            h.this.b.release();
            synchronized (h.this) {
                if (h.this.f22947c) {
                    return;
                }
                h.this.f22946a.addFirst(t);
            }
        }
    };
    final Semaphore b = new Semaphore(1);

    private void c() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f22946a);
            this.f22946a.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final T a() throws InterruptedException {
        T removeFirst;
        this.b.acquire();
        synchronized (this) {
            removeFirst = !this.f22946a.isEmpty() ? this.f22946a.removeFirst() : a(this.d);
        }
        if (removeFirst.retain() != 1) {
            LiteavLog.e("LimitedFramePool", "invalid reference count for %s", removeFirst);
        }
        return removeFirst;
    }

    protected abstract T a(g<T> gVar);

    public final void b() {
        this.f22947c = true;
        c();
    }
}
