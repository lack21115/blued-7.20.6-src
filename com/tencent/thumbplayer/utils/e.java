package com.tencent.thumbplayer.utils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private Object f39429a = null;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private Throwable f39430c = null;

    private void b(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        while (j > 0) {
            try {
                wait(j);
                break;
            } catch (InterruptedException e) {
                z = true;
                j -= System.currentTimeMillis() - currentTimeMillis;
                TPLogUtil.i("TPFutureResult", "getResult wait has InterruptedException, remainTime:".concat(String.valueOf(j)));
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public Object a(long j) {
        Object obj;
        synchronized (this) {
            if (!this.b) {
                b(j);
            }
            if (this.f39430c != null) {
                throw this.f39430c;
            }
            obj = this.f39429a;
        }
        return obj;
    }

    public void a(Object obj) {
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.f39429a = obj;
            this.b = true;
            notifyAll();
        }
    }

    public void a(Throwable th) {
        synchronized (this) {
            if (th != null) {
                this.f39430c = th;
                this.b = true;
                notifyAll();
            }
        }
    }
}
