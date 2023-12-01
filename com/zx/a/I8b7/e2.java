package com.zx.a.I8b7;

import android.content.Context;
import android.os.Handler;
import com.zx.a.I8b7.c3;
import com.zx.a.I8b7.o2;
import com.zx.a.I8b7.r2;
import com.zx.module.annotation.Java2C;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/e2.class */
public class e2 {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f42124a = new AtomicBoolean(false);

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/e2$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f42125a;

        public a(Context context) {
            this.f42125a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                t2.b(this.f42125a);
                try {
                    e2.a().a();
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                n2.a(th2, m2.a("ZXCore init failed: "));
                e2.f42124a.set(false);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/e2$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final e2 f42126a = new e2();
    }

    public static o2 a() {
        Handler handler = r2.f42192a;
        r2 r2Var = r2.a.f42193a;
        if (r2Var.b()) {
            throw new RuntimeException("请先调用 ZXManager.checkPermission() 检查用户是否已授权");
        }
        if (r2Var.a()) {
            AtomicBoolean atomicBoolean = o2.e;
            return o2.e.f42161a;
        }
        throw new RuntimeException("用户未授权");
    }

    public static void a(Context context) {
        try {
            if (f42124a.getAndSet(true)) {
                return;
            }
            AtomicInteger atomicInteger = c3.f42112c;
            c3.c.f42114a.b.execute(new a(context));
        } catch (Throwable th) {
            f42124a.set(false);
            m.b("ZXManager.init failed:" + th);
        }
    }

    public static final e2 b() {
        if (f42124a.get()) {
            return b.f42126a;
        }
        throw new IllegalStateException("ZXManager not init, should init firstly");
    }

    @Java2C.Method2C
    public native String a(String str, String str2) throws Throwable;
}
