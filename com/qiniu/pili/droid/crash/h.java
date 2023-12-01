package com.qiniu.pili.droid.crash;

import android.content.Context;
import java.lang.Thread;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/h.class */
public class h implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final h f13794a = new h();
    private Thread.UncaughtExceptionHandler b;

    /* renamed from: c  reason: collision with root package name */
    private Context f13795c;

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a() {
        return f13794a;
    }

    private void b() {
        a aVar = new a(this.f13795c);
        aVar.a();
        aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        this.f13795c = context;
        this.b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        b();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        NativeCrashHandler.a().b();
        try {
            new i(this.f13795c).a(thread).a(th).d();
        } catch (Throwable th2) {
            this.b.uncaughtException(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
