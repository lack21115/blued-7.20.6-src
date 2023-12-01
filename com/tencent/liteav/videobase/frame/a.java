package com.tencent.liteav.videobase.frame;

import android.os.SystemClock;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.k;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/a.class */
public abstract class a<T extends k> {

    /* renamed from: a  reason: collision with root package name */
    private static final long f36627a = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: c  reason: collision with root package name */
    private final Map<InterfaceC0936a, Deque<T>> f36628c = new HashMap();
    private volatile boolean d = false;
    private final com.tencent.liteav.base.b.a e = new com.tencent.liteav.base.b.a(f36627a);
    private final g<T> f = new g(this) { // from class: com.tencent.liteav.videobase.frame.b

        /* renamed from: a  reason: collision with root package name */
        private final a f36629a;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.f36629a = this;
        }

        @Override // com.tencent.liteav.videobase.frame.g
        public final void a(k kVar) {
            a.a(this.f36629a, kVar);
        }
    };
    private final String b = null;

    /* renamed from: com.tencent.liteav.videobase.frame.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/frame/a$a.class */
    public interface InterfaceC0936a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(a aVar, k kVar) {
        if (kVar == 0) {
            return;
        }
        synchronized (aVar.f36628c) {
            if (aVar.d) {
                aVar.a((a) kVar);
                return;
            }
            Deque<T> b = aVar.b(aVar.b((a) kVar));
            kVar.updateLastUsedTimestamp(SystemClock.elapsedRealtime());
            b.addFirst(kVar);
            aVar.c();
        }
    }

    private Deque<T> b(InterfaceC0936a interfaceC0936a) {
        Deque<T> deque = this.f36628c.get(interfaceC0936a);
        LinkedList linkedList = deque;
        if (deque == null) {
            linkedList = new LinkedList();
            this.f36628c.put(interfaceC0936a, linkedList);
        }
        return linkedList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        T peekLast;
        if (this.e.a()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ArrayList<k> arrayList = new ArrayList();
            synchronized (this.f36628c) {
                for (Deque<T> deque : this.f36628c.values()) {
                    while (!deque.isEmpty() && ((peekLast = deque.peekLast()) == null || elapsedRealtime - peekLast.getLastUsedTimestamp() >= f36627a)) {
                        deque.pollLast();
                        arrayList.add(peekLast);
                    }
                }
            }
            for (k kVar : arrayList) {
                a((a<T>) kVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T a(InterfaceC0936a interfaceC0936a) {
        T removeFirst;
        synchronized (this.f36628c) {
            Deque<T> b = b(interfaceC0936a);
            removeFirst = !b.isEmpty() ? b.removeFirst() : null;
        }
        c();
        T t = removeFirst;
        if (removeFirst == null) {
            t = a(this.f, interfaceC0936a);
        }
        if (t.retain() != 1) {
            LiteavLog.e("FramePool", "invalid reference count for %s", t);
        }
        return t;
    }

    protected abstract T a(g<T> gVar, InterfaceC0936a interfaceC0936a);

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        ArrayList<k> arrayList = new ArrayList();
        synchronized (this.f36628c) {
            for (Deque<T> deque : this.f36628c.values()) {
                arrayList.addAll(deque);
            }
            this.f36628c.clear();
        }
        for (k kVar : arrayList) {
            a((a<T>) kVar);
        }
    }

    protected abstract void a(T t);

    protected abstract InterfaceC0936a b(T t);

    public void b() {
        this.d = true;
        a();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.d) {
            return;
        }
        LiteavLog.e("FramePool", "%s must call destroy() before finalize()!\n%s", getClass().getName(), this.b);
    }
}
