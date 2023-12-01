package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/c2.class */
public abstract class c2 extends f2 {

    /* renamed from: c  reason: collision with root package name */
    public volatile HandlerThread f3725c = null;
    public volatile a d = null;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/c2$a.class */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                c2.this.a(message);
            } catch (Throwable th) {
                if (g3.a()) {
                    c2.this.a();
                    int i = message.what;
                }
            }
        }
    }

    public void a(long j) {
        synchronized (this.b) {
            if (this.f3760a) {
                if (g3.a()) {
                    a();
                }
                c();
                b(j);
                this.f3760a = false;
            }
        }
    }

    public abstract void a(Message message) throws Exception;

    public boolean a(int i, long j) {
        boolean a2;
        synchronized (this.b) {
            a2 = c3.a(this.d, i, j);
        }
        return a2;
    }

    public boolean a(Message message, long j) {
        boolean a2;
        synchronized (this.b) {
            a2 = c3.a(this.d, message, j);
        }
        return a2;
    }

    public int b(Looper looper) {
        synchronized (this.b) {
            if (b()) {
                return -1;
            }
            this.f3760a = true;
            if (g3.a()) {
                a();
            }
            if (looper == null) {
                this.f3725c = new HandlerThread("th_" + a());
                this.f3725c.start();
                this.d = new a(this.f3725c.getLooper());
            } else {
                this.d = new a(looper);
            }
            return a(this.d.getLooper());
        }
    }

    public final void b(long j) {
        try {
            b3.a(this.f3725c, this.d, j, false);
            this.f3725c = null;
            this.d = null;
        } catch (Throwable th) {
            if (g3.a()) {
                a();
            }
        }
    }

    public Handler d() {
        a aVar;
        synchronized (this.b) {
            aVar = this.d;
        }
        return aVar;
    }

    public HandlerThread e() {
        HandlerThread handlerThread;
        synchronized (this.b) {
            handlerThread = this.f3725c;
        }
        return handlerThread;
    }

    public void f() {
        a(0L);
    }

    public int g() {
        return b((Looper) null);
    }
}
