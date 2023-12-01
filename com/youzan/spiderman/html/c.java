package com.youzan.spiderman.html;

import com.youzan.spiderman.html.h;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private l f28138a;
    private HtmlResponse b;

    /* renamed from: c  reason: collision with root package name */
    private HtmlResponse f28139c;
    private boolean d;
    private AtomicBoolean e = new AtomicBoolean(false);
    private long f;

    public c(l lVar) {
        this.f28138a = lVar;
        b(System.currentTimeMillis());
    }

    public final HtmlResponse a(f fVar) {
        g a2;
        HtmlResponse htmlResponse = this.f28139c;
        if (htmlResponse != null) {
            return htmlResponse;
        }
        if (this.b != null) {
            g a3 = h.a.f28148a.a(this.f28138a.c());
            if (a3 != null && fVar.a(a3)) {
                return this.b;
            }
            this.b = null;
        }
        if (!this.d) {
            this.d = true;
            if (this.b == null && (a2 = h.a.f28148a.a(this.f28138a.c())) != null && fVar.a(a2)) {
                this.b = com.youzan.spiderman.cache.b.a(a2);
            }
            HtmlResponse htmlResponse2 = this.b;
            if (htmlResponse2 != null) {
                return htmlResponse2;
            }
        }
        if (this.e.get()) {
            try {
                synchronized (this) {
                    wait(1000L);
                }
                return this.f28139c;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public final void a(HtmlCallback htmlCallback) {
        if (this.e.compareAndSet(false, true)) {
            if (this.f28139c == null) {
                this.f28139c = new b(this.f28138a).a();
                this.b = null;
            }
            this.e.set(false);
            synchronized (this) {
                notifyAll();
            }
        } else if (htmlCallback == null) {
            return;
        } else {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (htmlCallback != null) {
            if (this.f28139c != null) {
                htmlCallback.onSuccess(this.f28138a.a(), this.f28139c.getHeader(), this.f28139c.getContentStream(), this.f28139c.getEncoding());
            } else {
                htmlCallback.onFailed();
            }
        }
    }

    public final boolean a(long j) {
        return j - this.f > 180000;
    }

    public final void b(long j) {
        this.b = null;
        this.f28139c = null;
        this.d = false;
        this.e.set(false);
        this.f = j;
    }
}
