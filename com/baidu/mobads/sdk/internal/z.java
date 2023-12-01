package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/z.class */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6634a = "LoadRemoteDex";
    private static z i;
    private IXAdContainerFactory b;

    /* renamed from: c  reason: collision with root package name */
    private bl f6635c;
    private Runnable f;
    private Context g;
    private boolean k;
    private int d = 5000;
    private Handler e = new Handler(Looper.getMainLooper());
    private bq h = bq.a();
    private AtomicBoolean j = new AtomicBoolean(false);

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/z$a.class */
    public interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f6636a = 1;
        public static final int b = 2;

        void onFailure();

        void onSuccess();
    }

    private z() {
    }

    public static z a() {
        if (i == null) {
            synchronized (z.class) {
                try {
                    if (i == null) {
                        i = new z();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        bq bqVar = this.h;
        bqVar.a(f6634a, "加载dex失败原因=" + str);
        this.j.set(false);
        i();
        p.a().a(2);
    }

    private void f() {
        this.j.set(true);
        if (an.a()) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        synchronized (z.class) {
            try {
                try {
                    bl blVar = new bl(Class.forName(w.aC, true, getClass().getClassLoader()), this.g);
                    this.f6635c = blVar;
                    this.b = blVar.a();
                    k();
                } catch (Exception e) {
                    a("反射调用remote失败");
                }
            } finally {
            }
        }
    }

    private void h() {
        this.f = new aa(this);
        j();
        if (f.f6587a == null) {
            synchronized (bw.class) {
                try {
                    if (f.f6587a == null) {
                        f.f6587a = new bw(this.g);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (this.b != null) {
            k();
        } else if (f.f6587a == null) {
            this.h.a(f6634a, "BaiduXAdSDKContext.mApkLoader == null,not load apk");
        } else {
            this.h.a(f6634a, "start load apk");
            try {
                f.f6587a.a(new ab(this));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private void i() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.e.removeCallbacks(runnable);
        }
        this.f = null;
    }

    private void j() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.e.postDelayed(runnable, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.j.set(false);
        bj.a(this.g);
        i();
        p.a().a(1);
        ck.a(this.g).b();
        ck.a(this.g).a();
    }

    public void a(Context context, a aVar) {
        if (context == null) {
            this.h.c(f6634a, "init Context is null,error");
            return;
        }
        this.g = context.getApplicationContext();
        p.a().a(aVar);
        if (this.b != null) {
            k();
        } else if (this.j.get()) {
        } else {
            f();
        }
    }

    public Context b() {
        return this.g;
    }

    public IXAdContainerFactory c() {
        if (this.g == null) {
            return null;
        }
        if (this.b == null && !this.j.get()) {
            f();
        }
        return this.b;
    }

    public String d() {
        if (this.b != null) {
            return "_" + this.b.getRemoteVersion();
        }
        return "";
    }

    public boolean e() {
        return this.k;
    }
}
