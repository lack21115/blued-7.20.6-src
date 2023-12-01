package com.youzan.spiderman.html;

import com.youzan.spiderman.html.h;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private l f41829a;
    private HtmlResponse b;

    /* renamed from: c  reason: collision with root package name */
    private HtmlResponse f41830c;
    private boolean d;
    private AtomicBoolean e = new AtomicBoolean(false);
    private long f;

    public c(l lVar) {
        this.f41829a = lVar;
        b(System.currentTimeMillis());
    }

    public final HtmlResponse a(f fVar) {
        g a2;
        HtmlResponse htmlResponse = this.f41830c;
        if (htmlResponse != null) {
            return htmlResponse;
        }
        if (this.b != null) {
            g a3 = h.a.f41839a.a(this.f41829a.c());
            if (a3 != null && fVar.a(a3)) {
                return this.b;
            }
            this.b = null;
        }
        if (!this.d) {
            this.d = true;
            if (this.b == null && (a2 = h.a.f41839a.a(this.f41829a.c())) != null && fVar.a(a2)) {
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
                return this.f41830c;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public final void a(HtmlCallback htmlCallback) {
        if (this.e.compareAndSet(false, true)) {
            if (this.f41830c == null) {
                this.f41830c = new b(this.f41829a).a();
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
            if (this.f41830c != null) {
                htmlCallback.onSuccess(this.f41829a.a(), this.f41830c.getHeader(), this.f41830c.getContentStream(), this.f41830c.getEncoding());
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
        this.f41830c = null;
        this.d = false;
        this.e.set(false);
        this.f = j;
    }
}
