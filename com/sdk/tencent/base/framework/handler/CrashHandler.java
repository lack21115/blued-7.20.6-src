package com.sdk.tencent.base.framework.handler;

import com.anythink.expressad.exoplayer.g.b.i;
import com.sdk.tencent.n.a;
import java.io.PrintStream;
import java.lang.Thread;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/base/framework/handler/CrashHandler.class */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static Thread.UncaughtExceptionHandler f14336a;

    public static void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        f14336a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        PrintStream printStream = System.out;
        printStream.println(i.f4519a + th);
        int i = a.f14375a;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f14336a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
