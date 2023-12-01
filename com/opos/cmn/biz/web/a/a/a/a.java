package com.opos.cmn.biz.web.a.a.a;

import java.lang.Thread;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/a/a/a/a.class */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static a f24707a = new a();
    private Thread.UncaughtExceptionHandler b;

    private a() {
    }

    public static a a() {
        return f24707a;
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
