package com.tencent.bugly.idasc.proguard;

import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/bf.class */
public final class bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final Handler f35292a;
    long d;
    private final String e;
    private final List<ba> f = new LinkedList();
    long b = 5000;
    private final long g = 5000;

    /* renamed from: c  reason: collision with root package name */
    boolean f35293c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(Handler handler, String str) {
        this.f35292a = handler;
        this.e = str;
    }

    private Thread e() {
        return this.f35292a.getLooper().getThread();
    }

    public final boolean a() {
        return !this.f35293c && SystemClock.uptimeMillis() >= this.d + this.b;
    }

    public final long b() {
        return SystemClock.uptimeMillis() - this.d;
    }

    public final List<ba> c() {
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f) {
            arrayList = new ArrayList(this.f.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f.size()) {
                    ba baVar = this.f.get(i2);
                    if (!baVar.e && currentTimeMillis - baVar.b < 200000) {
                        arrayList.add(baVar);
                        baVar.e = true;
                    }
                    i = i2 + 1;
                }
            }
        }
        return arrayList;
    }

    public final void d() {
        StringBuilder sb = new StringBuilder(1024);
        long nanoTime = System.nanoTime();
        try {
            StackTraceElement[] stackTrace = e().getStackTrace();
            if (stackTrace.length != 0) {
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    sb.append(stackTrace[i2]);
                    sb.append("\n");
                    i = i2 + 1;
                }
            } else {
                sb.append("Thread does not have stack trace.\n");
            }
        } catch (SecurityException e) {
            sb.append("getStackTrace() encountered:\n");
            sb.append(e.getMessage());
            sb.append("\n");
            al.a(e);
        }
        long nanoTime2 = System.nanoTime();
        ba baVar = new ba(sb.toString(), System.currentTimeMillis());
        baVar.d = nanoTime2 - nanoTime;
        String name = e().getName();
        if (name == null) {
            name = "";
        }
        baVar.f35284a = name;
        synchronized (this.f) {
            while (this.f.size() >= 32) {
                this.f.remove(0);
            }
            this.f.add(baVar);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f35293c = true;
        this.b = this.g;
    }
}
