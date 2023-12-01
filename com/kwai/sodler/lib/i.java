package com.kwai.sodler.lib;

import android.content.Context;
import com.kwai.sodler.lib.j;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/i.class */
public final class i extends j {
    private static volatile i aJQ;
    private j aJR;
    private ExecutorService aJS;
    private Map<String, a> aJT;
    private volatile boolean mHasInit;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/i$a.class */
    public static final class a {
        private final com.kwai.sodler.lib.a.f aJW;
        private final Future<com.kwai.sodler.lib.a.f> aei;

        public a(com.kwai.sodler.lib.a.f fVar, Future<com.kwai.sodler.lib.a.f> future) {
            this.aJW = fVar;
            this.aei = future;
        }

        public final void cancel() {
            this.aJW.cancel();
            this.aei.cancel(true);
        }
    }

    private i() {
        super(null, null, null, null, null, null);
        this.mHasInit = false;
    }

    public static i Jl() {
        if (aJQ == null) {
            synchronized (i.class) {
                try {
                    if (aJQ == null) {
                        aJQ = new i();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return aJQ;
    }

    private static ExecutorService Jm() {
        return new ThreadPoolExecutor(0, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwai.sodler.lib.i.1
            private final AtomicInteger poolNumber = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ksad-Sodler-" + this.poolNumber.getAndIncrement());
            }
        });
    }

    private void Jt() {
        if (!this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
    }

    private void a(String str, a aVar) {
        synchronized (this) {
            if (!this.mHasInit) {
                throw new RuntimeException("Sodler has not yet been init.");
            }
            Map<String, a> f = f(this.aJT);
            this.aJT = f;
            if (str != null) {
                f.put(str, aVar);
            }
        }
    }

    private a b(final com.kwai.sodler.lib.a.f fVar, final j.a aVar) {
        if (this.mHasInit) {
            a fN = fN(fVar.getId());
            if (fN != null) {
                fN.cancel();
            }
            fVar.a(this);
            a aVar2 = new a(fVar, this.aJS.submit(new Callable<com.kwai.sodler.lib.a.f>() { // from class: com.kwai.sodler.lib.i.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // java.util.concurrent.Callable
                /* renamed from: Ju */
                public com.kwai.sodler.lib.a.f call() {
                    return i.this.a(fVar, aVar);
                }
            }));
            a(fVar.getId(), aVar2);
            return aVar2;
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    private a fN(String str) {
        synchronized (this) {
            if (this.mHasInit) {
                Map<String, a> f = f(this.aJT);
                this.aJT = f;
                if (str != null) {
                    return f.get(str);
                }
                return null;
            }
            throw new RuntimeException("Sodler has not yet been init.");
        }
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.ext.c Jn() {
        if (this.mHasInit) {
            return this.aJR.Jn();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.d Jo() {
        if (this.mHasInit) {
            return this.aJR.Jo();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.g Jp() {
        if (this.mHasInit) {
            return this.aJR.Jp();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.c Jq() {
        if (this.mHasInit) {
            return this.aJR.Jq();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.b Jr() {
        if (this.mHasInit) {
            return this.aJR.Jr();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.ext.a Js() {
        if (this.mHasInit) {
            return this.aJR.Js();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j
    public final com.kwai.sodler.lib.a.f a(com.kwai.sodler.lib.a.f fVar, j.a aVar) {
        if (this.mHasInit) {
            com.kwai.sodler.lib.a.e JA = fVar.JA();
            j jVar = this.aJR;
            j jVar2 = JA;
            if (JA == null) {
                jVar2 = jVar;
            }
            return jVar.a(fVar.a(jVar2), aVar);
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    public final a a(com.kwai.sodler.lib.a.f fVar, int i) {
        return b(fVar, j.a.a(this, 16));
    }

    public final void a(Context context, com.kwai.sodler.lib.ext.c cVar) {
        synchronized (this) {
            if (!this.mHasInit) {
                d dVar = new d(context);
                e eVar = new e(context);
                c cVar2 = new c(context, cVar);
                b bVar = new b();
                this.aJS = Jm();
                this.aJR = new j(dVar, eVar, cVar2, bVar, cVar, new com.kwai.sodler.lib.ext.a());
                this.mHasInit = true;
                Jt();
            }
        }
    }

    public final void l(com.kwai.sodler.lib.a.f fVar) {
        a fN = fN(fVar.getId());
        if (fN != null) {
            fN.cancel();
        }
        a(fVar.getId(), (a) null);
    }
}
