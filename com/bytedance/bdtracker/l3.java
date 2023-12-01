package com.bytedance.bdtracker;

import android.util.Log;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/l3.class */
public class l3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f21253a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f21254c = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

    public l3(Runnable runnable, String str) {
        this.f21253a = runnable;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f21253a.run();
        } catch (Exception e) {
            StringBuilder a2 = a.a("Thread:");
            a2.append(this.b);
            a2.append(" exception\n");
            a2.append(this.f21254c);
            z2.a(a2.toString(), e);
        }
    }
}
