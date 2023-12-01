package com.tencent.cloud.huiyansdkface.facelight.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f35567a;
    private final Runnable b;

    /* renamed from: c  reason: collision with root package name */
    private List<a> f35568c;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/d$a.class */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        boolean f35571a;
    }

    public d(int i) {
        this(i, null);
    }

    public d(int i, Runnable runnable) {
        this.f35568c = new ArrayList();
        if (i <= 0) {
            throw new IllegalArgumentException("resourceCount <= 0");
        }
        this.f35567a = new AtomicInteger(i);
        this.b = runnable;
    }

    private void b() {
        for (a aVar : Collections.unmodifiableList(this.f35568c)) {
            synchronized (this) {
                if (!aVar.f35571a) {
                    aVar.f35571a = true;
                    aVar.run();
                }
            }
        }
    }

    public void a(Runnable runnable) {
        if (this.f35567a.decrementAndGet() == 0) {
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
        return this.f35567a.get() <= 0;
    }
}
