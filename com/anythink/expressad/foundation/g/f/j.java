package com.anythink.expressad.foundation.g.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5082a = j.class.getSimpleName();
    private Context b;
    private Set<i> d = new HashSet();
    private ExecutorService e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());
    private AtomicInteger f = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    private c f5083c = new d(new Handler(Looper.getMainLooper()));

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/j$a.class */
    public interface a {
        boolean a(i<?> iVar);
    }

    public j(Context context) {
        this.b = context.getApplicationContext();
    }

    private int a() {
        return this.f.incrementAndGet();
    }

    private void a(a aVar) {
        synchronized (this) {
            for (i iVar : this.d) {
                if (aVar.a(iVar)) {
                    iVar.e();
                }
            }
        }
    }

    private void a(final Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        a(new a() { // from class: com.anythink.expressad.foundation.g.f.j.1
            @Override // com.anythink.expressad.foundation.g.f.j.a
            public final boolean a(i<?> iVar) {
                return iVar.b() == obj;
            }
        });
    }

    public final void a(final i iVar) {
        iVar.a(this);
        synchronized (this) {
            this.d.add(iVar);
        }
        iVar.a(this.f.incrementAndGet());
        this.e.execute(new Runnable() { // from class: com.anythink.expressad.foundation.g.f.j.2
            @Override // java.lang.Runnable
            public final void run() {
                Context unused = j.this.b;
                new h(null, j.this.f5083c).a(iVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(i iVar) {
        synchronized (this) {
            this.d.remove(iVar);
        }
    }
}
