package com.blued.android.framework.utils.upload.qiniu;

import android.os.Handler;
import android.os.HandlerThread;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.NetworkUtils;
import java.util.Random;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/UploadProcessManager.class */
public class UploadProcessManager {

    /* renamed from: a  reason: collision with root package name */
    private double f10156a;

    /* renamed from: c  reason: collision with root package name */
    private long f10157c;
    private long d;
    private long e;
    private Runnable f;
    private boolean g;
    private IUpdateProcessListener h;
    private double i;
    private Handler j;
    private HandlerThread k;
    private Object l = new Object();
    private double m = 1.0d;
    private Random n = new Random(1);
    private double b = 0.0d;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/UploadProcessManager$IUpdateProcessListener.class */
    public interface IUpdateProcessListener {
        void a(int i);
    }

    public UploadProcessManager(IUpdateProcessListener iUpdateProcessListener) {
        this.g = false;
        this.h = iUpdateProcessListener;
        long currentTimeMillis = System.currentTimeMillis();
        this.f10157c = currentTimeMillis;
        this.d = currentTimeMillis;
        this.e = currentTimeMillis;
        this.g = false;
        d();
    }

    private void a(Runnable runnable) {
        synchronized (this) {
            if (this.j != null) {
                this.j.removeCallbacks(runnable);
            }
        }
    }

    private void a(Runnable runnable, long j) {
        synchronized (this) {
            if (this.j != null) {
                this.j.removeCallbacks(runnable);
                this.j.postDelayed(runnable, j);
            }
        }
    }

    private void b(double d) {
        a("updateProcess | process：" + d);
        if ((d - this.b >= 1.0d || d == 99.0d) && d <= 100.0d) {
            a("updateProcess | currentProcess：" + this.b);
            this.b = d;
            i();
            IUpdateProcessListener iUpdateProcessListener = this.h;
            if (iUpdateProcessListener != null) {
                iUpdateProcessListener.a((int) this.b);
            }
        }
    }

    private void d() {
        j();
        Runnable runnable = new Runnable() { // from class: com.blued.android.framework.utils.upload.qiniu.UploadProcessManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (NetworkUtils.b()) {
                    UploadProcessManager.this.f();
                } else {
                    UploadProcessManager.this.e();
                }
            }
        };
        this.f = runnable;
        a(runnable, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a("stopProcessSmoothness");
        a(this.f);
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        double nextInt;
        if (this.g) {
            e();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.d;
        if (currentTimeMillis >= 200) {
            a("autoIncrementProcess | 需要自增处理 currentProcess:" + b() + " | realProcess:" + this.f10156a);
            if (this.f10156a > 0.0d) {
                g();
                a("预估每秒增加的进度：" + (this.i * 1000.0d) + "%");
            } else {
                if (currentTimeMillis > 5000) {
                    nextInt = this.n.nextInt(6);
                    this.i = nextInt / 5000.0d;
                } else {
                    nextInt = this.n.nextInt(5);
                    this.i = nextInt / 1000.0d;
                }
                a("随机每秒增加：" + nextInt + "%");
                a("自增每秒增加的进度：" + (this.i * 1000.0d) + "%");
            }
            this.m = this.i * (System.currentTimeMillis() - this.e);
            a("autoIncrementProcess | 增加进度：" + this.m + "%");
            double b = b() + this.m;
            if (b > 99.0d) {
                b(99.0d);
                e();
                return;
            }
            b(b);
        }
        a(this.f, 200L);
    }

    private double g() {
        long currentTimeMillis = System.currentTimeMillis() - this.f10157c;
        this.i = (100.0d - b()) / ((((long) ((100 * currentTimeMillis) / this.f10156a)) - currentTimeMillis) * 1.0d);
        a("autoIncrementProcess | averageProcess：" + this.i);
        return this.i;
    }

    private void h() {
        this.d = System.currentTimeMillis();
    }

    private void i() {
        this.e = System.currentTimeMillis();
    }

    private void j() {
        if (this.k == null) {
            this.k = new HandlerThread("UploadTaskHandle");
        }
        HandlerThread handlerThread = this.k;
        if (handlerThread != null) {
            handlerThread.start();
            a("mHandlerThread.start()!!!");
        }
        if (this.j == null) {
            this.j = new Handler(this.k.getLooper());
        }
    }

    private void k() {
        synchronized (this) {
            a("stopHandle()!!!");
            if (this.k != null) {
                this.k.quit();
                this.k = null;
            }
            this.j = null;
        }
    }

    public void a() {
        this.g = true;
        e();
    }

    public void a(double d) {
        this.f10156a = d;
        a("setCurrentProcess | realProcess：" + this.f10156a);
        if (this.f10156a > b()) {
            h();
            b(this.f10156a);
        }
    }

    protected void a(String str) {
        if (AppInfo.m()) {
            Logger.c(MediaSender.f10132a, str);
        }
    }

    public double b() {
        return this.b;
    }

    public void c() {
        this.g = true;
    }
}
