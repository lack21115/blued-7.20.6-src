package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.pangle.apm.ApmUtils;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.util.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/h.class */
public class h {
    private static volatile h d;

    /* renamed from: a  reason: collision with root package name */
    boolean f7823a;
    final List<ZeusPluginStateListener> b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    final List<ZeusPluginEventCallback> f7824c = new ArrayList();
    private final Handler e = new Handler(Looper.getMainLooper());

    public static h a() {
        if (d == null) {
            synchronized (h.class) {
                try {
                    if (d == null) {
                        d = new h();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    private static void b() {
        String str;
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && packageInfo.providers != null) {
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                int length = providerInfoArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return;
                    }
                    ProviderInfo providerInfo = providerInfoArr[i2];
                    if (!TextUtils.isEmpty(providerInfo.authority)) {
                        String str2 = providerInfo.authority;
                        if (str2.contains(Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                            if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                                str = providerInfo.processName.split(":")[1];
                                if (Zeus.getServerManagerHashMap().get(str) != null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) {
                                    Zeus.getServerManagerHashMap().put(str, providerInfo);
                                }
                            }
                            str = "main";
                            if (Zeus.getServerManagerHashMap().get(str) != null) {
                            }
                            Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                    i = i2 + 1;
                }
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Object[] c() {
        Object[] array;
        synchronized (this.f7824c) {
            array = !this.f7824c.isEmpty() ? this.f7824c.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    public final void a(final int i, final int i2, final String str, final int i3, final Throwable th) {
        Object[] c2 = c();
        int length = c2.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                return;
            }
            final Object obj = c2[i5];
            this.e.post(new Runnable() { // from class: com.bytedance.pangle.h.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i, i2, str, i3, th);
                    } catch (Throwable th2) {
                    }
                }
            });
            i4 = i5 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Application application, boolean z) {
        synchronized (this) {
            if (this.f7823a) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
                return;
            }
            a(3000, 0, null, -1, null);
            Zeus.setAppContext(application);
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.init();
            if (application == null) {
                throw new IllegalArgumentException("context must be not null !!!");
            }
            ZeusLogger.setDebug(globalParam.isDebug());
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
            com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.h.1
                @Override // java.lang.Runnable
                public final void run() {
                    j.b();
                }
            });
            if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
                com.bytedance.pangle.e.f.a();
            }
            if (z) {
                Zeus.onPrivacyAgreed();
            }
            com.bytedance.pangle.c.b a2 = com.bytedance.pangle.c.b.a();
            com.bytedance.pangle.c.a aVar = new com.bytedance.pangle.c.a() { // from class: com.bytedance.pangle.h.2
                @Override // com.bytedance.pangle.c.a
                public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                    JSONObject jSONObject4 = jSONObject;
                    if (jSONObject == null) {
                        jSONObject4 = new JSONObject();
                    }
                    JSONObject jSONObject5 = jSONObject2;
                    if (jSONObject2 == null) {
                        jSONObject5 = new JSONObject();
                    }
                    JSONObject jSONObject6 = jSONObject3;
                    if (jSONObject3 == null) {
                        jSONObject6 = new JSONObject();
                    }
                    String str2 = null;
                    if (Zeus.getAppApplication() != null) {
                        Zeus.getAppApplication();
                        str2 = com.bytedance.pangle.d.d.a(com.bytedance.pangle.d.d.a());
                    }
                    String packageName = Zeus.getAppApplication() != null ? Zeus.getAppApplication().getPackageName() : "";
                    String str3 = str2;
                    if (str2 == null) {
                        str3 = "unknown";
                    }
                    try {
                        jSONObject4.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.pangle.log.b.a(str3));
                        jSONObject4.putOpt("host_package_name", packageName);
                        Plugin plugin = Zeus.getPlugin(jSONObject4.optString("plugin_package_name", ""), false);
                        int i = -1;
                        if (plugin != null) {
                            i = plugin.getApiVersionCode();
                        }
                        jSONObject4.putOpt("plugin_api_version", com.bytedance.pangle.log.b.a(Integer.valueOf(i)));
                        jSONObject4.putOpt("zeus_sdk_version", com.bytedance.pangle.log.b.a("0.0.1-beta.4200.107-pangle"));
                        ZeusLogger.v(ZeusLogger.TAG_REPORTER, "eventName: " + str + "\ncategoryData:" + jSONObject4.toString(1) + "\nmetricData:" + jSONObject5.toString(1) + "\nlogExtrData:" + jSONObject6.toString(1));
                        IZeusReporter reporter = GlobalParam.getInstance().getReporter();
                        if (reporter != null) {
                            JSONObject jSONObject7 = new JSONObject();
                            Iterator<String> keys = jSONObject4.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                jSONObject7.putOpt(next, jSONObject4.opt(next));
                            }
                            Iterator<String> keys2 = jSONObject5.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                jSONObject7.putOpt(next2, jSONObject5.opt(next2));
                            }
                            Iterator<String> keys3 = jSONObject6.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                jSONObject7.putOpt(next3, jSONObject6.opt(next3));
                            }
                            reporter.report(str, jSONObject7);
                        }
                        ApmUtils.getApmInstance().monitorEvent(str, jSONObject4, jSONObject5, jSONObject6);
                    } catch (JSONException e) {
                        ZeusLogger.w(ZeusLogger.TAG_REPORTER, e.getMessage(), e);
                    }
                }
            };
            synchronized (a2.f7757a) {
                a2.f7757a.add(aVar);
            }
            if (!globalParam.isCloseFlipped()) {
                b.a();
            }
            if (Build.VERSION.SDK_INT == 29) {
                com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.h.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                        } catch (Throwable th) {
                        }
                    }
                });
            }
            if (i.i()) {
                try {
                    FieldUtils.writeField(com.bytedance.pangle.d.a.a(), "mHiddenApiWarningShown", Boolean.TRUE);
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
                } catch (Exception e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
                }
            }
            b();
            ContentProviderManager.getInstance().initSystemContentProviderInfo();
            com.bytedance.pangle.receiver.b.a(application);
            this.f7823a = true;
            a(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
        }
    }
}
