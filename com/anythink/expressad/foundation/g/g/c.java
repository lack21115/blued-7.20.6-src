package com.anythink.expressad.foundation.g.g;

import android.content.Context;
import com.anythink.expressad.foundation.g.g.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/g/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    ThreadPoolExecutor f7935a;
    HashMap<Long, a> b;

    /* renamed from: c  reason: collision with root package name */
    WeakReference<Context> f7936c;

    public c(Context context) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        this.f7935a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.b = new HashMap<>();
        this.f7936c = new WeakReference<>(context);
    }

    private c(Context context, byte b) {
        int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(availableProcessors, availableProcessors, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        this.f7935a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.b = new HashMap<>();
        this.f7936c = new WeakReference<>(context);
    }

    public c(Context context, int i) {
        if (i == 0) {
            this.f7935a = new ThreadPoolExecutor(1, 5, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        } else {
            this.f7935a = new ThreadPoolExecutor(i, (i * 2) + 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        }
        this.f7935a.allowCoreThreadTimeOut(true);
        this.b = new HashMap<>();
        this.f7936c = new WeakReference<>(context);
    }

    private void b() {
        for (Map.Entry<Long, a> entry : this.b.entrySet()) {
            a value = entry.getValue();
            if (value.f7930c == a.EnumC0147a.PAUSE) {
                value.g();
            } else if (value.f7930c == a.EnumC0147a.READY) {
                this.f7935a.execute(value);
            }
        }
    }

    private void b(a aVar) {
        synchronized (this) {
            if (aVar != null) {
                if (this.b.containsKey(Long.valueOf(a.e()))) {
                    a aVar2 = this.b.get(Long.valueOf(a.e()));
                    if (aVar2 != null) {
                        aVar2.f();
                    }
                    this.b.remove(Long.valueOf(a.e()));
                }
            }
        }
    }

    private void b(final a aVar, final a.b bVar) {
        synchronized (this) {
            this.b.put(Long.valueOf(a.e()), aVar);
            aVar.d = new a.b() { // from class: com.anythink.expressad.foundation.g.g.c.1
                @Override // com.anythink.expressad.foundation.g.g.a.b
                public final void a(a.EnumC0147a enumC0147a) {
                    if (enumC0147a == a.EnumC0147a.CANCEL) {
                        c.this.b.remove(Long.valueOf(a.e()));
                    } else if (enumC0147a == a.EnumC0147a.FINISH) {
                        c.this.b.remove(Long.valueOf(a.e()));
                    } else if (enumC0147a == a.EnumC0147a.RUNNING && c.this.f7936c.get() == null) {
                        c.this.a();
                    }
                    a.b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(enumC0147a);
                    }
                }
            };
        }
    }

    public final void a() {
        synchronized (this) {
            try {
                for (Map.Entry<Long, a> entry : this.b.entrySet()) {
                    entry.getValue().f();
                }
                this.b.clear();
            } catch (Exception e) {
            }
        }
    }

    public final void a(a aVar) {
        b(aVar, null);
        this.f7935a.execute(aVar);
    }

    public final void a(a aVar, a.b bVar) {
        b(aVar, bVar);
        this.f7935a.execute(aVar);
    }
}
