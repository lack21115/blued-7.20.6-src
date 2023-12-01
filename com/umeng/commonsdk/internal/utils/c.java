package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/utils/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40873a = "BatteryUtils";
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static Context f40874c;
    private BroadcastReceiver d;

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/utils/c$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f40876a = new c();

        private a() {
        }
    }

    private c() {
        this.d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                        int i = 0;
                        int intExtra = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                        int intExtra2 = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);
                        int intExtra3 = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
                        int intExtra4 = intent.getIntExtra("status", 0);
                        int i2 = -1;
                        if (intExtra4 != 1) {
                            i2 = intExtra4 != 2 ? intExtra4 != 4 ? intExtra4 != 5 ? -1 : 2 : 0 : 1;
                        }
                        int intExtra5 = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
                        if (intExtra5 == 1) {
                            i = 1;
                        } else if (intExtra5 == 2) {
                            i = 2;
                        }
                        b bVar = new b();
                        bVar.f40871a = intExtra;
                        bVar.b = intExtra2;
                        bVar.d = i2;
                        bVar.f40872c = intExtra3;
                        bVar.e = i;
                        bVar.f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, 32771, com.umeng.commonsdk.internal.b.a(c.f40874c).a(), bVar);
                        c.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(c.f40874c, th);
                }
            }
        };
    }

    public static c a(Context context) {
        if (f40874c == null && context != null) {
            f40874c = context.getApplicationContext();
        }
        return a.f40876a;
    }

    public boolean a() {
        boolean z;
        synchronized (this) {
            z = b;
        }
        return z;
    }

    public void b() {
        synchronized (this) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
                f40874c.registerReceiver(this.d, intentFilter);
                b = true;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f40874c, th);
            }
        }
    }

    public void c() {
        synchronized (this) {
            try {
                f40874c.unregisterReceiver(this.d);
                b = false;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f40874c, th);
            }
        }
    }
}
