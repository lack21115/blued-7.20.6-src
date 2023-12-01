package c.t.m.g;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/b3.class */
public class b3 {

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/b3$a.class */
    public static final class a extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HandlerThread f3712a;
        public final /* synthetic */ Handler b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f3713c;
        public final /* synthetic */ Timer d;

        public a(HandlerThread handlerThread, Handler handler, boolean z, Timer timer) {
            this.f3712a = handlerThread;
            this.b = handler;
            this.f3713c = z;
            this.d = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b3.b(this.f3712a, this.b, this.f3713c);
                if (this.d != null) {
                    this.d.cancel();
                }
            } catch (Throwable th) {
                g3.a();
            }
        }
    }

    public static void a(HandlerThread handlerThread, Handler handler, long j, boolean z) {
        if (handlerThread == null && handler == null) {
            return;
        }
        if (j <= 0) {
            b(handlerThread, handler, z);
            return;
        }
        Timer timer = new Timer("th_loc_tmp");
        timer.schedule(new a(handlerThread, handler, z, timer), j);
    }

    public static void b(HandlerThread handlerThread, Handler handler, boolean z) {
        if (z) {
            try {
                c3.b(handler);
            } catch (Throwable th) {
                g3.a();
                return;
            }
        }
        if (handlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
            } else {
                handlerThread.quit();
            }
        }
    }
}
