package a.a.a.a.a.a.j;

import a.a.a.a.a.a.j.f;
import a.a.a.a.a.e.h;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/c.class */
public class c extends f {

    /* renamed from: a  reason: collision with root package name */
    public e f1259a;
    public volatile a b;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/c$a.class */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<c> f1260a;

        public a(Looper looper, c cVar) {
            super(looper);
            this.f1260a = new WeakReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            c cVar = this.f1260a.get();
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
            eVar.c("ScreenDataTransfer", "EncoderHandler what:" + i + ",encoder=" + cVar);
            if (cVar == null) {
                a.a.a.a.a.e.e.f.d("ScreenDataTransfer", "EncoderHandler.handleMessage: encoder is null");
            } else if (i == 1) {
                cVar.d(((Boolean) obj).booleanValue());
            } else if (i == 2) {
                cVar.b();
            } else {
                throw new RuntimeException("Unhandled msg what=" + i);
            }
        }
    }

    public final void a() {
        a(this.w.f1271a);
        a.a.a.a.a.a.c cVar = this.v;
        if (cVar != null) {
            cVar.d();
        }
        this.y = 0L;
        a.a.a.a.a.e.e.f.c("ScreenDataTransfer", "startEncoding -");
        synchronized (this) {
            this.t = a.a.a.a.a.f.c.RUNNING;
            e();
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(int i) {
        synchronized (this) {
            e eVar = this.f1259a;
            if (eVar != null) {
                eVar.a(i);
            }
        }
    }

    public final void a(a.a.a.a.a.a.i.c cVar) {
        try {
            this.f1259a = new e(cVar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(f.a aVar) {
        synchronized (this) {
            if (aVar == null) {
                a.a.a.a.a.e.e.f.d("ScreenDataTransfer", "config is null when startEncoding");
            } else if (this.t == a.a.a.a.a.f.c.RUNNING) {
                a.a.a.a.a.e.e.f.d("ScreenDataTransfer", "startEncoding failed as already being running");
            } else if (this.t == a.a.a.a.a.f.c.STOPPING) {
                a.a.a.a.a.e.e.f.c("ScreenDataTransfer", "set pending action as START");
                this.u = a.a.a.a.a.f.a.START;
                this.x = aVar;
            } else if (this.t == a.a.a.a.a.f.c.STARTING) {
                if (this.u == a.a.a.a.a.f.a.STOP) {
                    a.a.a.a.a.e.e.f.c("ScreenDataTransfer", "set pending action as RESTART");
                    this.u = a.a.a.a.a.f.a.RESTART;
                    this.x = aVar;
                }
            } else {
                a.a.a.a.a.e.e.f.c("ScreenDataTransfer", "startEncoding +");
                this.w = aVar;
                this.t = a.a.a.a.a.f.c.STARTING;
                HandlerThread handlerThread = new HandlerThread("ScreenDataTransfer");
                handlerThread.start();
                this.b = new a(handlerThread.getLooper(), this);
                a();
            }
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public Surface b(f.a aVar) {
        a(aVar);
        e eVar = this.f1259a;
        if (eVar != null) {
            return eVar.e();
        }
        return null;
    }

    public final void b() {
        e eVar = this.f1259a;
        if (eVar != null) {
            eVar.a(false);
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void b(boolean z) {
        synchronized (this) {
            if (this.t == a.a.a.a.a.f.c.IDLE) {
                a.a.a.a.a.e.e.f.d("ScreenDataTransfer", "stopEncoding failed as not being running");
            } else if (this.t == a.a.a.a.a.f.c.STARTING) {
                a.a.a.a.a.e.e.f.c("ScreenDataTransfer", "set pending action as STOP");
                this.u = a.a.a.a.a.f.a.STOP;
            } else if (this.t == a.a.a.a.a.f.c.STOPPING) {
                if (this.u == a.a.a.a.a.f.a.START) {
                    a.a.a.a.a.e.e.f.d("ScreenDataTransfer", "clear pending start action");
                    this.u = a.a.a.a.a.f.a.NONE;
                }
            } else {
                a.a.a.a.a.e.e.f.c("ScreenDataTransfer", "stopEncoding +");
                this.t = a.a.a.a.a.f.c.STOPPING;
                this.b.sendMessage(this.b.obtainMessage(1, Boolean.valueOf(z)));
            }
        }
    }

    public final void c() {
        e eVar = this.f1259a;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void c(boolean z) {
        synchronized (this) {
            if (this.t == a.a.a.a.a.f.c.RUNNING && !a.a.a.a.a.a.j.a.a().b()) {
                this.y++;
                if (h.d() && this.y % 2 == 0) {
                    a.a.a.a.a.e.e.f.c("ScreenDataTransfer", "Drop the in frame");
                    f.a aVar = this.w;
                    if (aVar != null) {
                        aVar.f1271a.e().l++;
                        this.w.f1271a.e().w++;
                    }
                }
                this.b.sendMessage(this.b.obtainMessage(2));
            }
        }
    }

    public final void d(boolean z) {
        Looper.myLooper().quit();
        e eVar = this.f1259a;
        if (eVar != null && z) {
            eVar.a();
            this.f1259a.a(true);
        }
        c();
        a.a.a.a.a.a.c cVar = this.v;
        if (cVar != null) {
            cVar.a();
        }
        a.a.a.a.a.e.e.f.c("ScreenDataTransfer", "stopEncoding -");
        synchronized (this) {
            this.t = a.a.a.a.a.f.c.IDLE;
            e();
        }
    }
}
