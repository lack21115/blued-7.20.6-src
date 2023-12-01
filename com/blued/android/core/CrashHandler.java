package com.blued.android.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import java.lang.Thread;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/CrashHandler.class */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private Context a;
    private CrashInfoInterface b;
    private Thread.UncaughtExceptionHandler c;

    private boolean a() {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("bd_crash", 0);
        long j = sharedPreferences.getLong("crash_time", 0L);
        int i = sharedPreferences.getInt("crash_count", 0);
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 1;
        boolean z = false;
        if (currentTimeMillis - j <= 10000) {
            int i3 = i + 1;
            z = false;
            i2 = i3;
            if (i3 >= 3) {
                z = true;
                i2 = i3;
            }
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("crash_time", currentTimeMillis);
        edit.putInt("crash_count", i2);
        edit.commit();
        return z;
    }

    private boolean a(Throwable th) {
        if (a()) {
            return false;
        }
        if (th == null) {
            return true;
        }
        th.printStackTrace();
        CrashInfoInterface crashInfoInterface = this.b;
        if (crashInfoInterface != null) {
            crashInfoInterface.a(th);
        }
        AppMethods.a(AppInfo.d(), th, AppMethods.a("crash"), this.b);
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Process.killProcess(Process.myPid());
        return true;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (a(th) || (uncaughtExceptionHandler = this.c) == null) {
            System.exit(16);
        } else {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
