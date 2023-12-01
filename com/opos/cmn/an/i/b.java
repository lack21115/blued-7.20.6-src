package com.opos.cmn.an.i;

import java.lang.Thread;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/i/b.class */
public class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static b f24566a = new b();
    private Thread.UncaughtExceptionHandler b;

    private b() {
    }

    public static b a() {
        return f24566a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("thread=");
        sb.append(thread != null ? thread.toString() : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.d("ThreadCrashHandler", sb.toString(), th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
