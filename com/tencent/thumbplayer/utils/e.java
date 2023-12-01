package com.tencent.thumbplayer.utils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private Object f25738a = null;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private Throwable f25739c = null;

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
            if (this.f25739c != null) {
                throw this.f25739c;
            }
            obj = this.f25738a;
        }
        return obj;
    }

    public void a(Object obj) {
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.f25738a = obj;
            this.b = true;
            notifyAll();
        }
    }

    public void a(Throwable th) {
        synchronized (this) {
            if (th != null) {
                this.f25739c = th;
                this.b = true;
                notifyAll();
            }
        }
    }
}
