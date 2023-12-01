package com.tencent.cloud.huiyansdkface.facelight.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f21876a;
    private final Runnable b;

    /* renamed from: c  reason: collision with root package name */
    private List<a> f21877c;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/d$a.class */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        boolean f21880a;
    }

    public d(int i) {
        this(i, null);
    }

    public d(int i, Runnable runnable) {
        this.f21877c = new ArrayList();
        if (i <= 0) {
            throw new IllegalArgumentException("resourceCount <= 0");
        }
        this.f21876a = new AtomicInteger(i);
        this.b = runnable;
    }

    private void b() {
        for (a aVar : Collections.unmodifiableList(this.f21877c)) {
            synchronized (this) {
                if (!aVar.f21880a) {
                    aVar.f21880a = true;
                    aVar.run();
                }
            }
        }
    }

    public void a(Runnable runnable) {
        if (this.f21876a.decrementAndGet() == 0) {
            if (runnable != null) {
                runnable.run();
            }
            Runnable runnable2 = this.b;
            if (runnable2 != null) {
                runnable2.run();
            }
            b();
        }
    }

    public boolean a() {
        return this.f21876a.get() <= 0;
    }
}
