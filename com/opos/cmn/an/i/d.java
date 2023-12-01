package com.opos.cmn.an.i;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/i/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f24568a;
    public final ExecutorService b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f24569c;
    public final ExecutorService d;
    public final ExecutorService e;
    public final ScheduledExecutorService f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/i/d$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private ExecutorService f24570a;
        private ExecutorService b;

        /* renamed from: c  reason: collision with root package name */
        private ExecutorService f24571c;
        private ExecutorService d;
        private ExecutorService e;
        private ScheduledExecutorService f;

        private void b() {
            if (this.f24570a == null) {
                this.f24570a = com.opos.cmn.an.i.a.a();
            }
            if (this.b == null) {
                this.b = com.opos.cmn.an.i.a.b();
            }
            if (this.f24571c == null) {
                this.f24571c = com.opos.cmn.an.i.a.d();
            }
            if (this.d == null) {
                this.d = com.opos.cmn.an.i.a.c();
            }
            if (this.e == null) {
                this.e = com.opos.cmn.an.i.a.e();
            }
            if (this.f == null) {
                this.f = com.opos.cmn.an.i.a.f();
            }
        }

        public a a(ExecutorService executorService) {
            this.f24570a = executorService;
            return this;
        }

        public a a(ScheduledExecutorService scheduledExecutorService) {
            this.f = scheduledExecutorService;
            return this;
        }

        public d a() {
            b();
            return new d(this);
        }

        public a b(ExecutorService executorService) {
            this.b = executorService;
            return this;
        }

        public a c(ExecutorService executorService) {
            this.f24571c = executorService;
            return this;
        }

        public a d(ExecutorService executorService) {
            this.d = executorService;
            return this;
        }

        public a e(ExecutorService executorService) {
            this.e = executorService;
            return this;
        }
    }

    public d(a aVar) {
        this.f24568a = aVar.f24570a;
        this.b = aVar.b;
        this.f24569c = aVar.f24571c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
    }

    public String toString() {
        return "ThreadPoolParams{netExecutorService=" + this.f24568a + ", ioExecutorService=" + this.b + ", bizExecutorService=" + this.f24569c + ", dlExecutorService=" + this.d + ", singleExecutorService=" + this.e + ", scheduleExecutorService=" + this.f + '}';
    }
}
