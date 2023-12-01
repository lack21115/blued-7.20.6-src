package com.soft.blued.manager;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import java.util.Hashtable;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/manager/BroadcastReceiverManager.class */
public class BroadcastReceiverManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile BroadcastReceiverManager f16006a;

    /* renamed from: c  reason: collision with root package name */
    private Hashtable<String, BluedBroadcastReceiver> f16007c = new Hashtable<>();
    private Context b = AppInfo.d();

    private BroadcastReceiverManager() {
    }

    public static BroadcastReceiverManager a() {
        if (f16006a == null) {
            synchronized (BroadcastReceiverManager.class) {
                try {
                    if (f16006a == null) {
                        f16006a = new BroadcastReceiverManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f16006a;
    }

    private Context getContext() {
        if (this.b == null) {
            this.b = AppInfo.d();
        }
        return this.b;
    }

    public void registerReceiver(String str, BroadcastReceiverListener broadcastReceiverListener) {
        if (TextUtils.isEmpty(str) || broadcastReceiverListener == null) {
            return;
        }
        registerReceiver(new String[]{str}, broadcastReceiverListener);
    }

    public void registerReceiver(String[] strArr, BroadcastReceiverListener broadcastReceiverListener) {
        if (strArr == null || strArr.length == 0 || broadcastReceiverListener == null) {
            return;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = strArr[i2];
            if (this.f16007c.containsKey(str)) {
                BluedBroadcastReceiver bluedBroadcastReceiver = this.f16007c.get(str);
                BluedBroadcastReceiver bluedBroadcastReceiver2 = bluedBroadcastReceiver;
                if (bluedBroadcastReceiver == null) {
                    bluedBroadcastReceiver2 = new BluedBroadcastReceiver(getContext(), str);
                    this.f16007c.put(str, bluedBroadcastReceiver2);
                }
                bluedBroadcastReceiver2.a(broadcastReceiverListener);
            } else {
                BluedBroadcastReceiver bluedBroadcastReceiver3 = new BluedBroadcastReceiver(getContext(), str);
                bluedBroadcastReceiver3.a(broadcastReceiverListener);
                this.f16007c.put(str, bluedBroadcastReceiver3);
            }
            i = i2 + 1;
        }
    }
}
