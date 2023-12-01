package com.opos.cmn.an.j;

import android.text.TextUtils;
import com.opos.cmn.an.j.a.c;
import com.opos.cmn.an.j.b.e;
import com.opos.cmn.an.j.b.f;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/j/a.class */
public class a extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    private c f24573a;
    private com.opos.cmn.an.j.a.b b;

    /* renamed from: c  reason: collision with root package name */
    private ThreadLocal<f> f24574c;

    /* renamed from: com.opos.cmn.an.j.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/j/a$a.class */
    public static class C0622a {
        private com.opos.cmn.an.j.a.b g;
        private c h;
        private BlockingQueue<Runnable> i;

        /* renamed from: a  reason: collision with root package name */
        private int f24575a = 3;
        private int b = 5;

        /* renamed from: c  reason: collision with root package name */
        private int f24576c = 128;
        private int d = 60000;
        private String f = "cmn_thread";
        private int e = 5;

        public C0622a a(int i) {
            this.f24575a = i;
            return this;
        }

        public C0622a a(String str) {
            this.f = str;
            return this;
        }

        public C0622a a(BlockingQueue<Runnable> blockingQueue) {
            this.i = blockingQueue;
            return this;
        }

        public a a() {
            this.e = Math.max(1, Math.min(10, this.e));
            this.f = TextUtils.isEmpty(this.f) ? "cmn_thread" : this.f;
            if (this.i == null) {
                this.i = new LinkedBlockingQueue(this.f24576c);
            }
            return new a(this.f24575a, this.b, this.d, TimeUnit.MILLISECONDS, this.i, this.e, this.f, this.g, this.h);
        }

        public C0622a b(int i) {
            this.b = i;
            return this;
        }

        public C0622a c(int i) {
            this.d = i;
            return this;
        }
    }

    private a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, int i3, String str, com.opos.cmn.an.j.a.b bVar, c cVar) {
        super(i, i2, j, timeUnit, blockingQueue, new com.opos.cmn.an.j.b.a(str, i3), new ThreadPoolExecutor.DiscardPolicy());
        this.f24574c = new ThreadLocal<>();
        this.b = bVar;
        this.f24573a = cVar;
    }

    private void a() {
        synchronized (this) {
            this.f24574c.set(null);
        }
    }

    private f b() {
        f fVar;
        synchronized (this) {
            f fVar2 = this.f24574c.get();
            fVar = fVar2;
            if (fVar2 == null) {
                fVar = new f();
                fVar.b = this.f24573a;
                fVar.f24597c = this.b;
                fVar.d = com.opos.cmn.an.j.a.a.THREAD;
                this.f24574c.set(fVar);
            }
        }
        return fVar;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f b = b();
        b.e = runnable;
        super.execute(new e(b));
        a();
    }
}
