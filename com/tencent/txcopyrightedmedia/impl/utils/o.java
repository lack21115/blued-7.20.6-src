package com.tencent.txcopyrightedmedia.impl.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f40129a;
    public ExecutorService b;
    private final Set<Long> d = new HashSet();
    private final Object e = new Object();

    /* renamed from: c  reason: collision with root package name */
    public boolean f40130c = true;

    public final boolean a(final Runnable runnable, int i) {
        ExecutorService executorService;
        synchronized (o.class) {
            try {
                if (this.f40130c) {
                    if (this.f40129a == null) {
                        this.f40129a = Executors.newFixedThreadPool(6);
                    }
                    if (this.b == null) {
                        this.b = Executors.newCachedThreadPool();
                    }
                    Runnable runnable2 = new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.o.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            boolean add;
                            long id = Thread.currentThread().getId();
                            synchronized (o.this.e) {
                                add = o.this.d.add(Long.valueOf(id));
                            }
                            if (add) {
                                Thread.currentThread().setName("ame-threadpool-".concat(String.valueOf(id)));
                            }
                            runnable.run();
                        }
                    };
                    if (i == 0) {
                        executorService = this.f40129a;
                    } else if (i != 1) {
                        return false;
                    } else {
                        executorService = this.b;
                    }
                    executorService.submit(runnable2);
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
            }
        }
    }
}
