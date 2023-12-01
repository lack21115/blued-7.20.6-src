package cn.com.chinatelecom.account.api.c;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/c/e.class */
public abstract class e implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static Handler f4120c = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    private boolean f4121a = false;
    private long b;
    private a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/c/e$a.class */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private e f4122a;

        public a(e eVar) {
            this.f4122a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = this.f4122a;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    public e() {
    }

    public e(long j) {
        this.b = j;
    }

    private void e() {
        a aVar = new a(this);
        this.d = aVar;
        f4120c.postDelayed(aVar, this.b);
    }

    public abstract void a();

    public void a(boolean z) {
        this.f4121a = z;
    }

    public void b() {
    }

    public boolean c() {
        return this.f4121a;
    }

    public void d() {
        try {
            if (this.d != null) {
                f4120c.removeCallbacks(this.d);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b > 0) {
            e();
        }
        a();
    }
}
