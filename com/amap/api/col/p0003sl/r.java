package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.col.p0003sl.s;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;

/* renamed from: com.amap.api.col.3sl.r  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/r.class */
public final class r extends Thread {
    private static int c = 0;
    private static int d = 3;
    private static long e = 30000;
    private static boolean g = false;
    private WeakReference<Context> a;
    private IAMapDelegate b;
    private a f = null;
    private Handler h = new Handler(Looper.getMainLooper()) { // from class: com.amap.api.col.3sl.r.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (r.g) {
                return;
            }
            if (r.this.f == null) {
                r rVar = r.this;
                rVar.f = new a(rVar.b, r.this.a == null ? null : (Context) r.this.a.get());
            }
            du.a().a(r.this.f);
        }
    };

    /* renamed from: com.amap.api.col.3sl.r$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/r$a.class */
    static final class a extends lc {
        private WeakReference<IAMapDelegate> a;
        private WeakReference<Context> b;
        private s c;

        public a(IAMapDelegate iAMapDelegate, Context context) {
            this.a = null;
            this.b = null;
            this.a = new WeakReference<>(iAMapDelegate);
            if (context != null) {
                this.b = new WeakReference<>(context);
            }
        }

        private void a() {
            final IAMapDelegate iAMapDelegate;
            WeakReference<IAMapDelegate> weakReference = this.a;
            if (weakReference == null || weakReference.get() == null || (iAMapDelegate = this.a.get()) == null || iAMapDelegate.getMapConfig() == null) {
                return;
            }
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.r.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    IAMapDelegate iAMapDelegate2 = iAMapDelegate;
                    if (iAMapDelegate2 == null || iAMapDelegate2.getMapConfig() == null) {
                        return;
                    }
                    MapConfig mapConfig = iAMapDelegate.getMapConfig();
                    mapConfig.setProFunctionAuthEnable(false);
                    if (mapConfig.isUseProFunction()) {
                        iAMapDelegate.setMapCustomEnable(mapConfig.isCustomStyleEnable(), true);
                        iAMapDelegate.reloadMapCustomStyle();
                        dc.a(a.this.b == null ? null : (Context) a.this.b.get(), "鉴权失败，当前key没有自定义纹理的使用权限，自定义纹理相关内容，将不会呈现！");
                    }
                }
            });
        }

        @Override // com.amap.api.col.p0003sl.lc
        public final void runTask() {
            s.a d;
            try {
                if (r.g) {
                    return;
                }
                if (this.c == null && this.b != null && this.b.get() != null) {
                    this.c = new s(this.b.get(), "");
                }
                r.b();
                if (r.c > r.d) {
                    r.e();
                    a();
                } else if (this.c == null || (d = this.c.d()) == null) {
                } else {
                    if (!d.d) {
                        a();
                    }
                    r.e();
                }
            } catch (Throwable th) {
                iw.c(th, "authForPro", "loadConfigData_uploadException");
                String str = dx.e;
                dy.b(str, "auth exception get data " + th.getMessage());
            }
        }
    }

    public r(Context context, IAMapDelegate iAMapDelegate) {
        this.a = null;
        if (context != null) {
            this.a = new WeakReference<>(context);
        }
        this.b = iAMapDelegate;
        f();
    }

    static /* synthetic */ int b() {
        int i = c;
        c = i + 1;
        return i;
    }

    static /* synthetic */ boolean e() {
        g = true;
        return true;
    }

    private static void f() {
        c = 0;
        g = false;
    }

    private void g() {
        if (g) {
            return;
        }
        int i = 0;
        while (i <= d) {
            i++;
            this.h.sendEmptyMessageDelayed(0, i * e);
        }
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        this.b = null;
        this.a = null;
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.h = null;
        this.f = null;
        f();
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            g();
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
            String str = dx.e;
            dy.b(str, "auth pro exception " + th.getMessage());
        }
    }
}
