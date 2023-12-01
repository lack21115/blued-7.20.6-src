package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blued.das.live.LiveProtos;
import com.tencent.bugly.idasc.BuglyStrategy;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/p.class */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f35327a = true;
    public static List<o> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f35328c;
    private static w d;
    private static boolean e;

    public static void a(Context context) {
        synchronized (p.class) {
            try {
                a(context, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (p.class) {
            try {
                if (e) {
                    al.d("[init] initial Multi-times, ignore this.", new Object[0]);
                } else if (context == null) {
                    Log.w(al.b, "[init] context of init() is null, check it.");
                } else {
                    aa a2 = aa.a(context);
                    if (a(a2)) {
                        f35327a = false;
                        return;
                    }
                    String e2 = a2.e();
                    if (e2 == null) {
                        Log.e(al.b, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
                    } else {
                        a(context, e2, a2.D, buglyStrategy);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        byte[] bArr;
        synchronized (p.class) {
            try {
                if (e) {
                    al.d("[init] initial Multi-times, ignore this.", new Object[0]);
                } else if (context == null) {
                    Log.w(al.b, "[init] context is null, check it.");
                } else if (str == null) {
                    Log.e(al.b, "init arg 'crashReportAppID' should not be null!");
                } else {
                    e = true;
                    if (z) {
                        f35328c = true;
                        al.f35239c = true;
                        al.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                        al.e("--------------------------------------------------------------------------------------------", new Object[0]);
                        al.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                        al.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                        al.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                        al.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                        al.e("--------------------------------------------------------------------------------------------", new Object[0]);
                        al.b("[init] Open debug mode of Bugly.", new Object[0]);
                    }
                    al.a(" crash report start initializing...", new Object[0]);
                    al.b("[init] Bugly start initializing...", new Object[0]);
                    al.a("[init] Bugly complete version: v%s", "4.1.9.2");
                    Context a2 = ap.a(context);
                    aa a3 = aa.a(a2);
                    a3.o();
                    ao.a(a2);
                    d = w.a(a2, b);
                    ai.a(a2);
                    ac.a(a2, b);
                    u a4 = u.a(a2);
                    if (a(a3)) {
                        f35327a = false;
                        return;
                    }
                    a3.r = str;
                    a3.b("APP_ID", str);
                    al.a("[param] Set APP ID:%s", str);
                    if (buglyStrategy != null) {
                        String appVersion = buglyStrategy.getAppVersion();
                        if (!TextUtils.isEmpty(appVersion)) {
                            String str2 = appVersion;
                            if (appVersion.length() > 100) {
                                str2 = appVersion.substring(0, 100);
                                al.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, str2);
                            }
                            a3.o = str2;
                            al.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
                        }
                        try {
                            if (buglyStrategy.isReplaceOldChannel()) {
                                String appChannel = buglyStrategy.getAppChannel();
                                if (!TextUtils.isEmpty(appChannel)) {
                                    String str3 = appChannel;
                                    if (appChannel.length() > 100) {
                                        str3 = appChannel.substring(0, 100);
                                        al.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, str3);
                                    }
                                    d.a(LiveProtos.Event.LIVE_SCREEN_BARRAGE_CLICK_VALUE, "app_channel", str3.getBytes(), false);
                                    a3.s = str3;
                                }
                            } else {
                                Map<String, byte[]> a5 = d.a(LiveProtos.Event.LIVE_SCREEN_BARRAGE_CLICK_VALUE, (v) null);
                                if (a5 != null && (bArr = a5.get("app_channel")) != null) {
                                    a3.s = new String(bArr);
                                }
                            }
                            al.a("[param] Set App channel: %s", a3.s);
                        } catch (Exception e2) {
                            if (f35328c) {
                                e2.printStackTrace();
                            }
                        }
                        String appPackageName = buglyStrategy.getAppPackageName();
                        if (!TextUtils.isEmpty(appPackageName)) {
                            String str4 = appPackageName;
                            if (appPackageName.length() > 100) {
                                str4 = appPackageName.substring(0, 100);
                                al.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, str4);
                            }
                            a3.f35213c = str4;
                            al.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
                        }
                        String deviceID = buglyStrategy.getDeviceID();
                        if (deviceID != null) {
                            String str5 = deviceID;
                            if (deviceID.length() > 100) {
                                str5 = deviceID.substring(0, 100);
                                al.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, str5);
                            }
                            a3.a(str5);
                            al.a("[param] Set device ID: %s", str5);
                        }
                        String deviceModel = buglyStrategy.getDeviceModel();
                        if (deviceModel != null) {
                            a3.b(deviceModel);
                            al.a("[param] Set device model: %s", deviceModel);
                        }
                        a3.f = buglyStrategy.isUploadProcess();
                        ao.b = buglyStrategy.isBuglyLogUpload();
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= b.size()) {
                            break;
                        }
                        if (a4.b(b.get(i2).id)) {
                            b.get(i2).init(a2, z, buglyStrategy);
                        }
                        i = i2 + 1;
                    }
                    s.a(a2, buglyStrategy);
                    long appReportDelay = buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L;
                    final ac a6 = ac.a();
                    a6.f35217c.a(new Thread() { // from class: com.tencent.bugly.idasc.proguard.ac.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public final void run() {
                            StrategyBean strategyBean;
                            String str6;
                            try {
                                Map<String, byte[]> a7 = w.a().a(ac.f35216a, (v) null);
                                if (a7 != null) {
                                    byte[] bArr2 = a7.get("device");
                                    byte[] bArr3 = a7.get("gateway");
                                    if (bArr2 != null) {
                                        aa.a(ac.this.h).d(new String(bArr2));
                                    }
                                    if (bArr3 != null) {
                                        aa.a(ac.this.h).c(new String(bArr3));
                                    }
                                }
                                ac.this.g = ac.d();
                                if (ac.this.g != null) {
                                    if (ap.b(ac.i) || !ap.d(ac.i)) {
                                        ac.this.g.q = StrategyBean.f35196a;
                                        strategyBean = ac.this.g;
                                        str6 = StrategyBean.b;
                                    } else {
                                        ac.this.g.q = ac.i;
                                        strategyBean = ac.this.g;
                                        str6 = ac.i;
                                    }
                                    strategyBean.r = str6;
                                }
                            } catch (Throwable th) {
                                if (!al.a(th)) {
                                    th.printStackTrace();
                                }
                            }
                            ac acVar = ac.this;
                            acVar.a(acVar.g, false);
                        }
                    }, appReportDelay);
                    al.b("[init] Bugly initialization finished.", new Object[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(o oVar) {
        synchronized (p.class) {
            try {
                if (!b.contains(oVar)) {
                    b.add(oVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean a(aa aaVar) {
        List<String> list = aaVar.v;
        aaVar.getClass();
        return list != null && list.contains("bugly");
    }
}
