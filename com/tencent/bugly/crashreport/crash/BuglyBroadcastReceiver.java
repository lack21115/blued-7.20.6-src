package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/crash/BuglyBroadcastReceiver.class */
public class BuglyBroadcastReceiver extends BroadcastReceiver {
    private static BuglyBroadcastReceiver d;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f35139c;
    private boolean e = true;

    /* renamed from: a  reason: collision with root package name */
    private IntentFilter f35138a = new IntentFilter();

    private boolean a(Context context, Intent intent) {
        synchronized (this) {
            if (context != null && intent != null) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    if (this.e) {
                        this.e = false;
                        return true;
                    }
                    String b = com.tencent.bugly.crashreport.common.info.b.b(this.b);
                    x.c("is Connect BC " + b, new Object[0]);
                    x.a("network %s changed to %s", this.f35139c, b);
                    if (b == null) {
                        this.f35139c = null;
                        return true;
                    }
                    String str = this.f35139c;
                    this.f35139c = b;
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
                    u a3 = u.a();
                    com.tencent.bugly.crashreport.common.info.a a4 = com.tencent.bugly.crashreport.common.info.a.a(context);
                    if (a2 == null || a3 == null || a4 == null) {
                        x.d("not inited BC not work", new Object[0]);
                        return true;
                    }
                    if (!b.equals(str)) {
                        if (currentTimeMillis - a3.a(c.f35162a) > 30000) {
                            x.a("try to upload crash on network changed.", new Object[0]);
                            c a5 = c.a();
                            if (a5 != null) {
                                a5.a(0L);
                            }
                        }
                        if (currentTimeMillis - a3.a(1001) > 30000) {
                            x.a("try to upload userinfo on network changed.", new Object[0]);
                            com.tencent.bugly.crashreport.biz.b.f35123a.b();
                        }
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public static BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            try {
                if (d == null) {
                    d = new BuglyBroadcastReceiver();
                }
                buglyBroadcastReceiver = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return buglyBroadcastReceiver;
    }

    public void addFilter(String str) {
        synchronized (this) {
            if (!this.f35138a.hasAction(str)) {
                this.f35138a.addAction(str);
            }
            x.c("add action %s", str);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void register(Context context) {
        synchronized (this) {
            this.b = context;
            z.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        x.a(BuglyBroadcastReceiver.d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                        synchronized (this) {
                            BuglyBroadcastReceiver.this.b.registerReceiver(BuglyBroadcastReceiver.d, BuglyBroadcastReceiver.this.f35138a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public void unregister(Context context) {
        synchronized (this) {
            try {
                x.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
                context.unregisterReceiver(this);
                this.b = context;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }
}
