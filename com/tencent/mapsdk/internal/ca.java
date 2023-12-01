package com.tencent.mapsdk.internal;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.internal.ra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca.class */
public class ca {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f23662a;
    private static e b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$a.class */
    public static final class a extends i<Void> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Runnable f23663c;

        public a(Runnable runnable) {
            this.f23663c = runnable;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            this.f23663c.run();
            return null;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$b.class */
    public static final class b implements Printer {
        @Override // android.util.Printer
        public void println(String str) {
            na.c(ma.s, str);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$c.class */
    public static abstract class c<T> implements Callback<T>, Runnable {
        @Override // com.tencent.map.tools.Callback
        public abstract void callback(T t);

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$d.class */
    public static class d extends HandlerThread {
        public static final String h = "tms-dsp";
        private static final int i = 1;
        private static final int j = 300;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f23664c;
        private volatile boolean d;
        private Handler e;
        private final ConcurrentLinkedQueue<b> f;
        private final List<b> g;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$d$a.class */
        public class a extends Handler {
            public a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                super.dispatchMessage(message);
                if (message.what == 1) {
                    try {
                        if (d.this.b()) {
                            d.this.e.sendEmptyMessageDelayed(1, 300L);
                        }
                    } catch (Throwable th) {
                        na.f("MSG_SYNC_CHECK ERR:", th);
                    }
                }
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$d$b.class */
        public class b<T> {
            public static final int j = 0;
            public static final int k = 1;
            public static final int l = 2;
            public static final int m = 3;
            public static final int n = 4;

            /* renamed from: a  reason: collision with root package name */
            private boolean f23666a;
            private f<T> b;

            /* renamed from: c  reason: collision with root package name */
            private final i<T> f23667c;
            private c<T> d;
            private Future<T> e;
            private T f;
            private int g;
            private int h;

            /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$d$b$a.class */
            public class a extends c<T> {
                public a() {
                }

                @Override // com.tencent.mapsdk.internal.ca.c, com.tencent.map.tools.Callback
                public void callback(T t) {
                    b.this.f = t;
                }
            }

            private b(i<T> iVar) {
                this.h = 0;
                this.f23667c = iVar;
                if (iVar == null || d.this.d) {
                    this.f23666a = true;
                }
            }

            public /* synthetic */ b(d dVar, i iVar, a aVar) {
                this(iVar);
            }

            public b<T> a(f<T> fVar) {
                if (fVar != null) {
                    d.this.f.add(this);
                    ra.b g = ra.g(ma.s);
                    g.a("dispatchHandler:" + d.this.e);
                    b((f) fVar);
                }
                return this;
            }

            public void a() {
                ra.g(ma.s).a(new Object[0]);
                this.f23666a = true;
                Future<T> future = this.e;
                if (future != null) {
                    future.cancel(false);
                }
                this.h = 4;
            }

            public void a(c<T> cVar) {
                this.d = cVar;
                e();
            }

            public void a(T t) {
                a((f) new g(t)).e();
            }

            public void a(T t, c<T> cVar) {
                a((f) new g(t)).a((c) cVar);
            }

            public void b() throws ExecutionException, InterruptedException {
                ra.g(ma.s).a(new Object[0]);
                Future<T> future = this.e;
                if (future == null || this.f23666a) {
                    return;
                }
                if (future.isDone()) {
                    this.h = 3;
                } else if (this.e.isCancelled()) {
                    this.f = this.e.get();
                    a();
                }
            }

            public void b(f<T> fVar) {
                this.b = fVar;
                i<T> iVar = this.f23667c;
                if (iVar != null) {
                    ((i) iVar).b = new a();
                }
            }

            public void b(T t) {
                if (d.this.d) {
                    return;
                }
                a((f) new h(t)).e();
            }

            public void b(T t, c<T> cVar) {
                if (d.this.d) {
                    return;
                }
                a((f) new h(t)).a((c) cVar);
            }

            public void c() {
                ra.g(ma.s).a("result:" + this.f, "userCallback:" + this.d);
                c<T> cVar = this.d;
                if (cVar != null) {
                    cVar.callback(this.f);
                }
            }

            public boolean d() {
                this.g++;
                ra.g(ma.s).a("try time:" + this.g);
                if (this.g < 2) {
                    this.f23666a = false;
                    e();
                    return true;
                }
                return false;
            }

            public void e() {
                ra.g(ma.s).a(new Object[0]);
                if (this.f23666a || d.this.d) {
                    ra.g(ma.s).a("cancelled...");
                    return;
                }
                this.h = 1;
                if (d.this.e != null) {
                    d.this.e.sendEmptyMessage(1);
                }
            }

            public void f() {
                i<T> iVar;
                ra.g(ma.s).a(new Object[0]);
                f<T> fVar = this.b;
                if (fVar != null && (iVar = this.f23667c) != null) {
                    this.e = fVar.a(iVar);
                }
                ra.g(ma.s).a(new Object[0]);
                this.h = 2;
            }
        }

        public d() {
            super(h);
            this.f = new ConcurrentLinkedQueue<>();
            this.g = new LinkedList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            b poll;
            if (!this.f.isEmpty() && (poll = this.f.poll()) != null && poll.h == 1) {
                poll.f();
                this.g.add(poll);
            }
            Iterator<b> it = this.g.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    int i2 = next.h;
                    if (i2 == 2) {
                        try {
                            next.b();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e2) {
                            e2.printStackTrace();
                        }
                    } else if (i2 == 3) {
                        next.c();
                        it.remove();
                    } else if (i2 == 4) {
                        if (next.d()) {
                            this.f.offer(next);
                        }
                        it.remove();
                    }
                }
            }
            return !this.g.isEmpty();
        }

        public <T> b<T> a(i<T> iVar) {
            b<T> bVar;
            synchronized (this) {
                ra.b g = ra.g(ma.s);
                g.a("prepared:" + this.b);
                if (!this.b && !this.f23664c && !this.d) {
                    start();
                    this.f23664c = true;
                }
                bVar = new b<>(this, iVar, null);
            }
            return bVar;
        }

        public void a() {
            Iterator<b> it = this.f.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    next.a();
                }
            }
            for (b bVar : this.g) {
                if (bVar != null) {
                    bVar.a();
                }
            }
            this.f.clear();
            this.g.clear();
            ra.g(ma.s).a("cancelAll...");
            Handler handler = this.e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }

        public void a(e eVar) {
            if (eVar != null) {
                eVar.a(h, this);
            }
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            this.b = true;
            this.e = new a(getLooper());
            ra.g(ma.s).a("looper is prepared...");
            this.e.sendEmptyMessage(1);
        }

        @Override // android.os.HandlerThread
        public boolean quit() {
            boolean quit = super.quit();
            if (quit) {
                a();
                this.d = true;
            }
            return quit;
        }

        @Override // android.os.HandlerThread
        public boolean quitSafely() {
            boolean quitSafely = super.quitSafely();
            if (quitSafely) {
                a();
                this.d = true;
            }
            return quitSafely;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$e.class */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, HandlerThread> f23668a = new HashMap();
        private final d b = new d();

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$e$a.class */
        public class a extends c<Map.Entry<String, HandlerThread>> {
            public final /* synthetic */ List b;

            public a(List list) {
                this.b = list;
            }

            @Override // com.tencent.mapsdk.internal.ca.c, com.tencent.map.tools.Callback
            /* renamed from: a */
            public void callback(Map.Entry<String, HandlerThread> entry) {
                HandlerThread value;
                if (entry == null || (value = entry.getValue()) == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    value.quitSafely();
                } else {
                    value.quit();
                }
                this.b.add(entry.getKey());
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$e$b.class */
        public class b extends c<String> {
            public b() {
            }

            @Override // com.tencent.mapsdk.internal.ca.c, com.tencent.map.tools.Callback
            /* renamed from: a */
            public void callback(String str) {
                if (str != null) {
                    e.this.f23668a.remove(str);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0033, code lost:
            if (r0.getThreadId() == (-1)) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.os.Looper a(java.lang.String r5) {
            /*
                r4 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = r0
                r1.<init>()
                r6 = r0
                r0 = r6
                java.lang.String r1 = "tms-"
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r6
                r1 = r5
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r6
                java.lang.String r0 = r0.toString()
                r7 = r0
                r0 = r4
                java.util.Map<java.lang.String, android.os.HandlerThread> r0 = r0.f23668a
                r1 = r7
                java.lang.Object r0 = r0.get(r1)
                android.os.HandlerThread r0 = (android.os.HandlerThread) r0
                r6 = r0
                r0 = r6
                if (r0 == 0) goto L36
                r0 = r6
                r5 = r0
                r0 = r6
                int r0 = r0.getThreadId()
                r1 = -1
                if (r0 != r1) goto L49
            L36:
                android.os.HandlerThread r0 = new android.os.HandlerThread
                r1 = r0
                r2 = r7
                r1.<init>(r2)
                r5 = r0
                r0 = r5
                r0.start()
                r0 = r4
                r1 = r7
                r2 = r5
                r0.a(r1, r2)
            L49:
                r0 = r5
                android.os.Looper r0 = r0.getLooper()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.ca.e.a(java.lang.String):android.os.Looper");
        }

        public d a() {
            return this.b;
        }

        public void a(String str, HandlerThread handlerThread) {
            if (handlerThread == null || str == null || str.isEmpty()) {
                return;
            }
            this.f23668a.put(str, handlerThread);
        }

        public void b() {
            this.b.a(this);
        }

        public void c() {
            if (this.f23668a.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Util.foreach(this.f23668a.entrySet(), new a(arrayList));
            Util.foreach(arrayList, new b());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$f.class */
    public interface f<T> {
        Future<T> a(i<T> iVar);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$g.class */
    public static class g<T> implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f23670a;

        public g(T t) {
            this.f23670a = t;
        }

        @Override // com.tencent.mapsdk.internal.ca.f
        public Future<T> a(i<T> iVar) {
            return h7.d().submit(iVar, this.f23670a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$h.class */
    public static class h<T> implements f<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f23671a;

        public h(T t) {
            this.f23671a = t;
        }

        @Override // com.tencent.mapsdk.internal.ca.f
        public Future<T> a(i<T> iVar) {
            return h7.e().submit(iVar, this.f23671a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ca$i.class */
    public static abstract class i<T> implements Runnable, Callable<T> {
        private c<T> b;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                T call = call();
                c<T> cVar = this.b;
                if (cVar != null) {
                    cVar.callback(call);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static {
        ra.f(ma.s);
        f23662a = new Handler(Looper.getMainLooper());
    }

    public static Looper a() {
        e eVar = b;
        if (eVar == null) {
            return null;
        }
        return eVar.a().getLooper();
    }

    public static Looper a(String str) {
        e eVar = b;
        if (eVar == null) {
            return null;
        }
        return eVar.a(str);
    }

    public static <T> d.b<T> a(i<T> iVar) {
        ra.g(ma.s).a(iVar);
        return b.a().a(iVar);
    }

    public static void a(e eVar) {
        if (eVar != null) {
            eVar.c();
        }
        f23662a.removeCallbacksAndMessages(null);
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        a((i) new a(runnable)).a((d.b) null);
    }

    public static void a(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        f23662a.postDelayed(runnable, j);
    }

    public static e b() {
        return new e();
    }

    public static void b(e eVar) {
        if (eVar == null) {
            return;
        }
        b = eVar;
        eVar.b();
        Looper looper = b.a().getLooper();
        if (looper != null) {
            looper.setMessageLogging(new b());
        }
    }

    public static void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            f23662a.post(runnable);
        } else {
            runnable.run();
        }
    }
}
