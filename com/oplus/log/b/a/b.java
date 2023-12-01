package com.oplus.log.b.a;

import android.content.Context;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/b/a/b.class */
public final class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f24319a;
    private com.oplus.log.f.d b;

    public b(com.oplus.log.f.d dVar) {
        this.b = dVar;
    }

    public final void a(Context context) {
        this.f24319a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (this.b == null) {
            return;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        this.b.b(new com.oplus.log.b.b("crash_info", stringWriter.toString(), (byte) 5, thread.getName(), null));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f24319a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
