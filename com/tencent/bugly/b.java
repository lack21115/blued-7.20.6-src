package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blued.das.live.LiveProtos;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f21417a = true;
    public static List<a> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f21418c;
    private static p d;
    private static boolean e;

    public static void a(Context context) {
        synchronized (b.class) {
            try {
                a(context, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (b.class) {
            try {
                if (e) {
                    x.d("[init] initial Multi-times, ignore this.", new Object[0]);
                } else if (context == null) {
                    Log.w(x.f21723a, "[init] context of init() is null, check it.");
                } else {
                    com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
                    if (a(a2)) {
                        f21417a = false;
                        return;
                    }
                    String f = a2.f();
                    if (f == null) {
                        Log.e(x.f21723a, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
                    } else {
                        a(context, f, a2.v, buglyStrategy);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        byte[] bArr;
        synchronized (b.class) {
            try {
                if (e) {
                    x.d("[init] initial Multi-times, ignore this.", new Object[0]);
                } else if (context == null) {
                    Log.w(x.f21723a, "[init] context is null, check it.");
                } else if (str == null) {
                    Log.e(x.f21723a, "init arg 'crashReportAppID' should not be null!");
                } else {
                    e = true;
                    if (z) {
                        f21418c = true;
                        x.b = true;
                        x.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                        x.e("--------------------------------------------------------------------------------------------", new Object[0]);
                        x.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                        x.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                        x.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                        x.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                        x.e("--------------------------------------------------------------------------------------------", new Object[0]);
                        x.b("[init] Open debug mode of Bugly.", new Object[0]);
                    }
                    x.a(" crash report start initializing...", new Object[0]);
                    x.b("[init] Bugly start initializing...", new Object[0]);
                    x.a("[init] Bugly complete version: v%s", "3.3.3");
                    Context a2 = z.a(context);
                    com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(a2);
                    a3.o();
                    y.a(a2);
                    d = p.a(a2, b);
                    u.a(a2);
                    com.tencent.bugly.crashreport.common.strategy.a a4 = com.tencent.bugly.crashreport.common.strategy.a.a(a2, b);
                    n a5 = n.a(a2);
                    if (a(a3)) {
                        f21417a = false;
                        return;
                    }
                    a3.a(str);
                    x.a("[param] Set APP ID:%s", str);
                    if (buglyStrategy != null) {
                        String appVersion = buglyStrategy.getAppVersion();
                        if (!TextUtils.isEmpty(appVersion)) {
                            String str2 = appVersion;
                            if (appVersion.length() > 100) {
                                str2 = appVersion.substring(0, 100);
                                x.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, str2);
                            }
                            a3.k = str2;
                            x.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
                        }
                        try {
                            if (buglyStrategy.isReplaceOldChannel()) {
                                String appChannel = buglyStrategy.getAppChannel();
                                if (!TextUtils.isEmpty(appChannel)) {
                                    String str3 = appChannel;
                                    if (appChannel.length() > 100) {
                                        str3 = appChannel.substring(0, 100);
                                        x.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, str3);
                                    }
                                    d.a(LiveProtos.Event.LIVE_SCREEN_BARRAGE_CLICK_VALUE, "app_channel", str3.getBytes(), (o) null, false);
                                    a3.m = str3;
                                }
                            } else {
                                Map<String, byte[]> a6 = d.a(LiveProtos.Event.LIVE_SCREEN_BARRAGE_CLICK_VALUE, (o) null, true);
                                if (a6 != null && (bArr = a6.get("app_channel")) != null) {
                                    a3.m = new String(bArr);
                                }
                            }
                            x.a("[param] Set App channel: %s", a3.m);
                        } catch (Exception e2) {
                            if (f21418c) {
                                e2.printStackTrace();
                            }
                        }
                        String appPackageName = buglyStrategy.getAppPackageName();
                        if (!TextUtils.isEmpty(appPackageName)) {
                            String str4 = appPackageName;
                            if (appPackageName.length() > 100) {
                                str4 = appPackageName.substring(0, 100);
                                x.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, str4);
                            }
                            a3.f21439c = str4;
                            x.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
                        }
                        String deviceID = buglyStrategy.getDeviceID();
                        if (deviceID != null) {
                            String str5 = deviceID;
                            if (deviceID.length() > 100) {
                                str5 = deviceID.substring(0, 100);
                                x.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, str5);
                            }
                            a3.c(str5);
                            x.a("[param] Set device ID: %s", str5);
                        }
                        a3.e = buglyStrategy.isUploadProcess();
                        y.f21725a = buglyStrategy.isBuglyLogUpload();
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= b.size()) {
                            break;
                        }
                        if (a5.a(b.get(i2).id)) {
                            b.get(i2).init(a2, z, buglyStrategy);
                        }
                        i = i2 + 1;
                    }
                    com.tencent.bugly.crashreport.biz.b.a(a2, buglyStrategy);
                    a4.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
                    x.b("[init] Bugly initialization finished.", new Object[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(a aVar) {
        synchronized (b.class) {
            try {
                if (!b.contains(aVar)) {
                    b.add(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean a(com.tencent.bugly.crashreport.common.info.a aVar) {
        List<String> list = aVar.p;
        aVar.getClass();
        return list != null && list.contains("bugly");
    }
}
