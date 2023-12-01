package com.cmic.gen.sdk.tencent.b;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.cmic.gen.sdk.tencent.e.c;
import com.cmic.gen.sdk.tencent.e.g;
import com.cmic.gen.sdk.tencent.e.m;
import java.lang.reflect.Method;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f21613a;
    private static long b;

    /* renamed from: c  reason: collision with root package name */
    private C0329a f21614c = null;

    /* renamed from: com.cmic.gen.sdk.tencent.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/b/a$a.class */
    public static class C0329a {

        /* renamed from: a  reason: collision with root package name */
        private int f21615a = -1;
        private int b = -1;

        public int a() {
            return this.b;
        }
    }

    private a() {
    }

    public static a a() {
        if (f21613a == null) {
            f21613a = new a();
        }
        return f21613a;
    }

    private void a(Context context, boolean z) {
        if (Build.VERSION.SDK_INT < 22) {
            this.f21614c.f21615a = -1;
            return;
        }
        SubscriptionManager from = SubscriptionManager.from(context.getApplicationContext());
        if (from != null) {
            try {
                if (this.f21614c.f21615a == -1 && Build.VERSION.SDK_INT >= 24) {
                    this.f21614c.b = SubscriptionManager.getDefaultDataSubscriptionId();
                    c.b("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = " + this.f21614c.b);
                    return;
                }
            } catch (Exception e) {
                c.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
            }
            try {
                Object invoke = from.getClass().getMethod("getDefaultDataSubId", new Class[0]).invoke(from, new Object[0]);
                if ((invoke instanceof Integer) || (invoke instanceof Long)) {
                    this.f21614c.b = ((Integer) invoke).intValue();
                    c.b("UMCTelephonyManagement", "android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = " + this.f21614c.b);
                    return;
                }
            } catch (Exception e2) {
                c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
            }
            try {
                Object invoke2 = from.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]).invoke(from, new Object[0]);
                if ((invoke2 instanceof Integer) || (invoke2 instanceof Long)) {
                    this.f21614c.b = ((Integer) invoke2).intValue();
                    c.b("UMCTelephonyManagement", "反射getDefaultDataSubscriptionId适配成功: dataSubId = " + this.f21614c.b);
                }
            } catch (Exception e3) {
                c.a("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0141, code lost:
        if (r10 == null) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.gen.sdk.tencent.b.a.b(android.content.Context):void");
    }

    private int c(Context context) {
        TelephonyManager telephonyManager;
        if (!g.a(context, "android.permission.READ_PHONE_STATE") || (telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone")) == null) {
            return -1;
        }
        if (m.d()) {
            try {
                Method method = telephonyManager.getClass().getMethod("getDataNetworkType", Integer.TYPE);
                c.b("UMCTelephonyManagement", "data dataNetworkType defaultDataSubId = " + this.f21614c.b);
                int intValue = ((Integer) method.invoke(telephonyManager, Integer.valueOf(this.f21614c.b))).intValue();
                c.b("UMCTelephonyManagement", "data dataNetworkType ---------" + intValue);
                int i = intValue;
                if (intValue == 0) {
                    i = intValue;
                    if (Build.VERSION.SDK_INT >= 24) {
                        c.b("UMCTelephonyManagement", "data dataNetworkType ---->=N " + intValue);
                        i = telephonyManager.getDataNetworkType();
                    }
                }
                return i;
            } catch (Exception e) {
                c.a("UMCTelephonyManagement", "data dataNetworkType ----反射出错-----");
                e.printStackTrace();
                return -1;
            }
        }
        return telephonyManager.getDataNetworkType();
    }

    public String a(Context context) {
        switch (c(context)) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "1";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "2";
            case 13:
            case 18:
            case 19:
                return "3";
            case 20:
                return "4";
            default:
                return "0";
        }
    }

    public void a(Context context, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis() - b;
        if (currentTimeMillis >= 5000 || currentTimeMillis <= 0) {
            this.f21614c = new C0329a();
            if (z2) {
                a(context, z);
                if (m.e() && m.d()) {
                    c.b("UMCTelephonyManagement", "华为手机兼容性处理");
                    if (this.f21614c.b == 0 || this.f21614c.b == 1) {
                        if (this.f21614c.f21615a == -1) {
                            C0329a c0329a = this.f21614c;
                            c0329a.f21615a = c0329a.b;
                        }
                        this.f21614c.b = -1;
                    }
                    if ((this.f21614c.f21615a != -1 || this.f21614c.b != -1) && Build.VERSION.SDK_INT >= 21) {
                        b(context);
                    }
                }
                b = System.currentTimeMillis();
            }
        }
    }

    public C0329a b() {
        C0329a c0329a = this.f21614c;
        C0329a c0329a2 = c0329a;
        if (c0329a == null) {
            c0329a2 = new C0329a();
        }
        return c0329a2;
    }
}
