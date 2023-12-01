package com.alipay.sdk.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.AlipayResultActivity;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.n;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4661a = "failed";
    public static final String b = "scheme_failed";

    /* renamed from: c  reason: collision with root package name */
    private Activity f4662c;
    private volatile IAlixPay d;
    private boolean f;
    private a g;
    private final com.alipay.sdk.sys.a h;
    private final Object e = IAlixPay.class;
    private ServiceConnection i = new f(this);
    private String j = null;
    private IRemoteServiceCallback k = new h(this);

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/e$a.class */
    public interface a {
        void a();

        void b();
    }

    public e(Activity activity, com.alipay.sdk.sys.a aVar, a aVar2) {
        this.f4662c = activity;
        this.h = aVar;
        this.g = aVar2;
    }

    private String a(String str, String str2, PackageInfo packageInfo) {
        String str3;
        JSONObject jSONObject;
        String str4;
        String str5;
        String str6;
        String str7 = str;
        int i = packageInfo != null ? packageInfo.versionCode : 0;
        String str8 = packageInfo != null ? packageInfo.versionName : "";
        c.b(com.alipay.sdk.cons.a.x, "pay bind or scheme");
        com.alipay.sdk.app.statistic.a.b(this.h, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.P, str2 + "|" + str8);
        String a2 = a(str7, str2, this.h);
        c.b(com.alipay.sdk.cons.a.x, "pay bind result: " + a2);
        Activity activity = this.f4662c;
        com.alipay.sdk.sys.a aVar = this.h;
        com.alipay.sdk.app.statistic.a.a(activity, aVar, str7, aVar.p);
        boolean c2 = com.alipay.sdk.data.a.j().c();
        if (f4661a.equals(a2) && "com.eg.android.AlipayGphone".equals(str2) && i > 125 && !c2) {
            com.alipay.sdk.app.statistic.a.a(this.h, com.alipay.sdk.app.statistic.c.b, "BSPNotStartByConfig");
        }
        if (f4661a.equals(a2) && "com.eg.android.AlipayGphone".equals(str2) && i > 125 && c2) {
            Activity activity2 = this.f4662c;
            String str9 = b;
            if (activity2 != null) {
                if (a(str2, activity2, this.h)) {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    String a3 = n.a(32);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    com.alipay.sdk.app.statistic.a.b(this.h, com.alipay.sdk.app.statistic.c.b, "BSPStart", a3 + "|" + elapsedRealtime);
                    a.C0050a.a(this.h, a3);
                    AlipayResultActivity.f4571a.put(a3, new g(this, countDownLatch));
                    try {
                        try {
                            String[] split = str7.split("&", -1);
                            int length = split.length;
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                jSONObject = null;
                                if (i3 >= length) {
                                    str4 = "";
                                    str5 = str4;
                                    str6 = null;
                                    break;
                                }
                                String str10 = split[i3];
                                if (str10.startsWith(com.alipay.sdk.sys.a.d)) {
                                    String substring = str10.substring(str10.indexOf("{"), str10.lastIndexOf(i.d) + 1);
                                    int indexOf = str10.indexOf(substring);
                                    str5 = str10.substring(0, indexOf);
                                    str4 = str10.substring(indexOf + substring.length());
                                    jSONObject = new JSONObject(substring);
                                    if (jSONObject.optString("sc").equals("h5tonative")) {
                                        jSONObject.put("sc", "h5tonative_scheme");
                                    } else {
                                        jSONObject.put("sc", "h5tonative_sdkscheme");
                                    }
                                    str6 = str10;
                                } else {
                                    i2 = i3 + 1;
                                }
                            }
                        } catch (Exception e) {
                            try {
                                com.alipay.sdk.app.statistic.a.a(this.h, com.alipay.sdk.app.statistic.c.b, "BSPSCReplaceEx", e, Base64.encodeToString(str.getBytes(), 2));
                            } catch (InterruptedException e2) {
                                com.alipay.sdk.app.statistic.a.a(this.h, com.alipay.sdk.app.statistic.c.b, "BSPWaiting", e2);
                                str9 = com.alipay.sdk.app.j.a(com.alipay.sdk.app.k.PAY_WAITTING.a(), com.alipay.sdk.app.k.PAY_WAITTING.b(), "");
                            }
                        }
                        if (TextUtils.isEmpty(str6)) {
                            throw new RuntimeException("empty ctx_args");
                        }
                        if (str7.indexOf(str6) == str7.lastIndexOf(str6)) {
                            str7 = str7.replace(str6, str5 + jSONObject.toString() + str4);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("sourcePid", Binder.getCallingPid());
                            jSONObject2.put(com.alipay.sdk.cons.b.d, str7);
                            jSONObject2.put("pkgName", this.f4662c.getPackageName());
                            jSONObject2.put(com.umeng.analytics.pro.d.aw, a3);
                            String encodeToString = Base64.encodeToString(jSONObject2.toString().getBytes("UTF-8"), 2);
                            Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path(com.igexin.push.core.b.p).appendQueryParameter("appId", "20000125");
                            appendQueryParameter.appendQueryParameter("mqpSchemePay", encodeToString);
                            try {
                                HashMap<String, String> a4 = com.alipay.sdk.sys.a.a(this.h);
                                a4.put("ts_scheme", String.valueOf(elapsedRealtime));
                                appendQueryParameter.appendQueryParameter("mqpLoc", new JSONObject(a4).toString());
                            } catch (Throwable th) {
                                com.alipay.sdk.app.statistic.a.a(this.h, com.alipay.sdk.app.statistic.c.b, "BSPLocEx", th);
                            }
                            String uri = appendQueryParameter.build().toString();
                            Intent intent = new Intent();
                            intent.setPackage(str2);
                            intent.addFlags(268435456);
                            intent.setData(Uri.parse(uri));
                            com.alipay.sdk.app.statistic.a.a(this.f4662c, this.h, str7, this.h.p);
                            this.f4662c.startActivity(intent);
                            com.alipay.sdk.data.a.j().a(this.h, this.f4662c.getApplicationContext());
                            c.b(com.alipay.sdk.cons.a.x, "pay scheme waiting " + uri);
                            countDownLatch.await();
                            String str11 = this.j;
                            try {
                                String str12 = l.a(this.h, str11).get(l.f4671a);
                                str3 = str12;
                                if (str12 == null) {
                                    str3 = com.igexin.push.core.b.l;
                                }
                            } catch (Throwable th2) {
                                com.alipay.sdk.app.statistic.a.a(this.h, com.alipay.sdk.app.statistic.c.b, "BSPStatEx", th2);
                                str3 = "unknown";
                            }
                            com.alipay.sdk.app.statistic.a.a(this.h, com.alipay.sdk.app.statistic.c.b, "BSPDone-" + str3);
                            if (TextUtils.isEmpty(str11)) {
                                com.alipay.sdk.app.statistic.a.a(this.h, com.alipay.sdk.app.statistic.c.b, "BSPEmpty");
                                return b;
                            }
                            return str11;
                        }
                        throw new RuntimeException("multi ctx_args");
                    } catch (Throwable th3) {
                        com.alipay.sdk.app.statistic.a.a(this.h, com.alipay.sdk.app.statistic.c.b, "BSPEx", th3);
                        return b;
                    }
                }
                return b;
            }
            return str9;
        }
        return a2;
    }

    private String a(String str, String str2, com.alipay.sdk.sys.a aVar) {
        Activity activity;
        String c2;
        String str3;
        Activity activity2;
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(n.a(str2));
        String a2 = n.a(this.f4662c, str2);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(elapsedRealtime);
        sb.append("|");
        sb.append(str != null ? str.length() : 0);
        com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.K, sb.toString());
        com.alipay.sdk.app.statistic.a.a(this.f4662c, aVar, str, aVar.p);
        try {
            if (com.alipay.sdk.data.a.j().h()) {
                com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.c.b, "stSrv", "skipped");
            } else {
                ComponentName startService = this.f4662c.getApplication().startService(intent);
                com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.c.b, "stSrv", startService != null ? startService.getPackageName() : com.igexin.push.core.b.l);
            }
            if (!this.f4662c.getApplicationContext().bindService(intent, this.i, 1)) {
                throw new Throwable("bindService fail");
            }
            synchronized (this.e) {
                if (this.d == null) {
                    try {
                        this.e.wait(com.alipay.sdk.data.a.j().a());
                    } catch (InterruptedException e) {
                        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.E, e);
                    }
                }
            }
            try {
            } catch (Throwable th) {
                try {
                    com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.A, th);
                    c2 = com.alipay.sdk.app.j.c();
                    try {
                        this.d.unregisterCallback(this.k);
                    } catch (Throwable th2) {
                        c.a(th2);
                    }
                    try {
                        this.f4662c.getApplicationContext().unbindService(this.i);
                    } catch (Throwable th3) {
                        c.a(th3);
                    }
                    com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.M, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.app.statistic.a.a(this.f4662c, aVar, str, aVar.p);
                    this.g = null;
                    this.k = null;
                    this.i = null;
                    this.d = null;
                    str3 = c2;
                    if (this.f) {
                        Activity activity3 = this.f4662c;
                        str3 = c2;
                        if (activity3 != null) {
                            activity2 = activity3;
                        }
                    }
                } finally {
                    try {
                        this.d.unregisterCallback(this.k);
                    } catch (Throwable th4) {
                        c.a(th4);
                    }
                    try {
                        this.f4662c.getApplicationContext().unbindService(this.i);
                    } catch (Throwable th5) {
                        c.a(th5);
                    }
                    com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.M, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.app.statistic.a.a(this.f4662c, aVar, str, aVar.p);
                    this.g = null;
                    this.k = null;
                    this.i = null;
                    this.d = null;
                    if (this.f && (activity = this.f4662c) != null) {
                        activity.setRequestedOrientation(0);
                        this.f = false;
                    }
                }
            }
            if (this.d == null) {
                String a3 = n.a(this.f4662c, str2);
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.x, a2 + "|" + a3);
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.L, "" + elapsedRealtime2);
            if (this.g != null) {
                this.g.a();
            }
            if (this.f4662c.getRequestedOrientation() == 0) {
                this.f4662c.setRequestedOrientation(1);
                this.f = true;
            }
            int version = this.d.getVersion();
            this.d.registerCallback(this.k);
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.N, "" + elapsedRealtime3);
            if (version >= 2) {
                HashMap<String, String> a4 = com.alipay.sdk.sys.a.a(aVar);
                a4.put("ts_bind", String.valueOf(elapsedRealtime));
                a4.put("ts_bend", String.valueOf(elapsedRealtime2));
                a4.put("ts_pay", String.valueOf(elapsedRealtime3));
                c2 = this.d.pay02(str, a4);
            } else {
                c2 = this.d.Pay(str);
            }
            try {
                this.d.unregisterCallback(this.k);
            } catch (Throwable th6) {
                c.a(th6);
            }
            try {
                this.f4662c.getApplicationContext().unbindService(this.i);
            } catch (Throwable th7) {
                c.a(th7);
            }
            com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.M, "" + SystemClock.elapsedRealtime());
            com.alipay.sdk.app.statistic.a.a(this.f4662c, aVar, str, aVar.p);
            this.g = null;
            this.k = null;
            this.i = null;
            this.d = null;
            str3 = c2;
            if (this.f) {
                Activity activity4 = this.f4662c;
                str3 = c2;
                if (activity4 != null) {
                    activity2 = activity4;
                    activity2.setRequestedOrientation(0);
                    this.f = false;
                    return c2;
                }
            }
            return str3;
        }
    }

    private void a(n.a aVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (aVar == null || (packageInfo = aVar.f4676a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.f4662c.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(this.h, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.V, th);
        }
        Thread.sleep(200L);
    }

    private static boolean a(String str, Context context, com.alipay.sdk.sys.a aVar) {
        try {
            Intent intent = new Intent(Intent.ACTION_MAIN, (Uri) null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) == null) {
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, "BSPDetectFail");
                return false;
            }
            return true;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, "BSPDetectFail", th);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
        if (r0 == null) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.e.a(java.lang.String):java.lang.String");
    }

    public void a() {
        this.f4662c = null;
    }
}
