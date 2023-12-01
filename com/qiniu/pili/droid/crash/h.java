package com.qiniu.pili.droid.crash;

import android.content.Context;
import java.lang.Thread;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/h.class */
public class h implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final h f27482a = new h();
    private Thread.UncaughtExceptionHandler b;

    /* renamed from: c  reason: collision with root package name */
    private Context f27483c;

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a() {
        return f27482a;
    }

    private void b() {
        a aVar = new a(this.f27483c);
        aVar.a();
        aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        this.f27483c = context;
        this.b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        b();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        NativeCrashHandler.a().b();
        try {
            new i(this.f27483c).a(thread).a(th).d();
        } catch (Throwable th2) {
            this.b.uncaughtException(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
