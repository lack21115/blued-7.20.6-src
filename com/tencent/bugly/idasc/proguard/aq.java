package com.tencent.bugly.idasc.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/aq.class */
public final class aq extends BroadcastReceiver {
    private static aq d;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f21561c;
    private boolean e = true;

    /* renamed from: a  reason: collision with root package name */
    private IntentFilter f21560a = new IntentFilter();

    public static aq a() {
        aq aqVar;
        synchronized (aq.class) {
            try {
                if (d == null) {
                    d = new aq();
                }
                aqVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aqVar;
    }

    private boolean a(Context context, Intent intent) {
        synchronized (this) {
            if (context != null && intent != null) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    if (this.e) {
                        this.e = false;
                        return true;
                    }
                    String c2 = ab.c(this.b);
                    al.c("is Connect BC ".concat(String.valueOf(c2)), new Object[0]);
                    al.a("network %s changed to %s", this.f21561c, String.valueOf(c2));
                    if (c2 == null) {
                        this.f21561c = null;
                        return true;
                    }
                    String str = this.f21561c;
                    this.f21561c = c2;
                    long currentTimeMillis = System.currentTimeMillis();
                    ac a2 = ac.a();
                    ai a3 = ai.a();
                    aa a4 = aa.a(context);
                    if (a2 == null || a3 == null || a4 == null) {
                        al.d("not inited BC not work", new Object[0]);
                        return true;
                    }
                    if (!c2.equals(str) && currentTimeMillis - a3.a(at.f21570a) > 30000) {
                        al.a("try to upload crash on network changed.", new Object[0]);
                        at a5 = at.a();
                        if (a5 != null) {
                            a5.a(0L);
                        }
                        al.a("try to upload userinfo on network changed.", new Object[0]);
                        s.b.b();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public final void a(Context context) {
        synchronized (this) {
            this.b = context;
            ap.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.aq.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        al.a(aq.d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                        synchronized (this) {
                            aq.this.b.registerReceiver(aq.d, aq.this.f21560a, "com.tencent.bugly.idasc.BuglyBroadcastReceiver.permission", null);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public final void a(String str) {
        synchronized (this) {
            if (!this.f21560a.hasAction(str)) {
                this.f21560a.addAction(str);
            }
            al.c("add action %s", str);
        }
    }

    public final void b(Context context) {
        synchronized (this) {
            try {
                al.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
                context.unregisterReceiver(this);
                this.b = context;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }
}
