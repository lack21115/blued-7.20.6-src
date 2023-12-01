package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.d;
import com.tencent.open.utils.Global;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f24545a;

    /* renamed from: c  reason: collision with root package name */
    protected static final b f24546c = new b(c(), c.m, c.g, c.h, c.f24541c, c.i, 10, c.e, c.n);
    private static boolean d = false;
    protected a b = new a(f24546c);

    private f() {
    }

    public static f a() {
        if (f24545a == null) {
            synchronized (f.class) {
                try {
                    if (f24545a == null) {
                        f24545a = new f();
                        d = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f24545a;
    }

    public static final void a(String str, String str2) {
        a().a(1, str, str2, null);
    }

    public static final void a(String str, String str2, Throwable th) {
        a().a(2, str, str2, th);
    }

    public static void b() {
        synchronized (f.class) {
            try {
                a().d();
                if (f24545a != null) {
                    f24545a = null;
                }
            } finally {
            }
        }
    }

    public static final void b(String str, String str2) {
        a().a(2, str, str2, null);
    }

    public static final void b(String str, String str2, Throwable th) {
        a().a(16, str, str2, th);
    }

    protected static File c() {
        String str = c.d;
        d.c b = d.b.b();
        return b != null && (b.c() > c.f ? 1 : (b.c() == c.f ? 0 : -1)) > 0 ? new File(Environment.getExternalStorageDirectory(), str) : new File(Global.getFilesDir(), str);
    }

    public static final void c(String str, String str2) {
        a().a(4, str, str2, null);
    }

    public static final void d(String str, String str2) {
        a().a(8, str, str2, null);
    }

    public static final void e(String str, String str2) {
        a().a(16, str, str2, null);
    }

    protected void a(int i, String str, String str2, Throwable th) {
        a aVar;
        if (d) {
            String packageName = Global.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                String str3 = packageName + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.b == null) {
                    return;
                }
                e.f24544a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                this.b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                d = false;
            }
        }
        e.f24544a.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (!d.a.a(c.b, i) || (aVar = this.b) == null) {
            return;
        }
        aVar.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
    }

    protected void d() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b.b();
            this.b = null;
        }
    }
}
