package com.kwad.sdk.g;

import com.alipay.sdk.widget.j;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/g/a.class */
public final class a {
    private static List<String> aub;
    private static volatile boolean auc;

    /* renamed from: com.kwad.sdk.g.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/g/a$a.class */
    public static class C0574a extends com.kwad.sdk.core.response.kwai.a {
        public long aud;
        public long aue;
        public long auf;
        public String aug;
        public String auh;
        public String aui;
        public String sdkVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/g/a$b.class */
    public static final class b {
        private String aug;
        private String auh;
        private String aui;
        private String sdkVersion;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String a(b bVar) {
            return "exit&" + bVar.aug + "&" + bVar.auh + "&" + bVar.aui + "&" + bVar.sdkVersion;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String c(String str, String str2, String str3, String str4) {
            return str + "&" + str2 + "&" + str3 + "&" + str4 + "&" + KsAdSDKImpl.get().getSDKVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b ee(String str) {
            String[] split = str.split("&");
            b bVar = new b();
            bVar.aug = split[1];
            bVar.auh = split[2];
            bVar.aui = split[3];
            bVar.sdkVersion = split[4];
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void AZ() {
        synchronized (a.class) {
            try {
                List<C0574a> Bb = Bb();
                if (!Bb.isEmpty()) {
                    com.kwad.sdk.core.d.b.d("DynamicRunMonitor", "monitorInfoList:" + Bb);
                    JSONObject jSONObject = new JSONObject();
                    t.putValue(jSONObject, "monitor_info_list", Bb);
                    KSLoggerReporter.r(jSONObject);
                }
                auc = true;
                Ba();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void Ba() {
        List<String> list = aub;
        if (list == null) {
            return;
        }
        for (String str : list) {
            ec(str);
        }
        aub.clear();
    }

    private static List<C0574a> Bb() {
        synchronized (a.class) {
            try {
                ArrayList arrayList = new ArrayList();
                Map<String, ?> af = y.af(ServiceProvider.getContext(), "dynamic_monitor_info");
                if (af == null) {
                    return arrayList;
                }
                for (String str : af.keySet()) {
                    if (str.startsWith("enter")) {
                        Object obj = af.get(str);
                        long longValue = obj instanceof Long ? ((Long) obj).longValue() : 0L;
                        b ee = b.ee(str);
                        String a2 = b.a(ee);
                        Object obj2 = af.get(a2);
                        long longValue2 = longValue - (obj2 instanceof Long ? ((Long) obj2).longValue() : 0L);
                        long j = longValue2 > 0 ? longValue2 : 0L;
                        C0574a c0574a = new C0574a();
                        c0574a.aud = longValue;
                        c0574a.aue = j;
                        c0574a.auf = longValue2;
                        c0574a.aug = ee.aug;
                        c0574a.auh = ee.auh;
                        c0574a.aui = ee.aui;
                        c0574a.sdkVersion = ee.sdkVersion;
                        arrayList.add(c0574a);
                        y.ae("dynamic_monitor_info", str);
                        y.ae("dynamic_monitor_info", a2);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void U(String str, String str2) {
        e(str, str2, "other");
    }

    public static void V(String str, String str2) {
        f(str, str2, "other");
    }

    private static void b(String str, String str2, String str3, String str4) {
        String c2;
        synchronized (a.class) {
            try {
                c2 = b.c(str, str2, str3, str4);
            } catch (Throwable th) {
                try {
                    com.kwad.components.core.c.a.b(th);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (auc) {
                ec(c2);
            } else {
                ed(c2);
            }
        }
    }

    public static void e(String str, String str2, String str3) {
        b("enter", str, str2, str3);
    }

    private static void ec(String str) {
        synchronized (a.class) {
            try {
                long b2 = y.b("dynamic_monitor_info", str, 0L);
                com.kwad.sdk.core.d.b.d("DynamicRunMonitor", "increaseLocalCount: " + str + "--lastCount:" + b2);
                y.a("dynamic_monitor_info", str, b2 + 1);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void ed(String str) {
        if (aub == null) {
            aub = new CopyOnWriteArrayList();
        }
        com.kwad.sdk.core.d.b.d("DynamicRunMonitor", "saveToCache: " + str);
        aub.add(str);
    }

    public static void f(String str, String str2, String str3) {
        b(j.o, str, str2, str3);
    }

    public static void report() {
        g.schedule(new aw() { // from class: com.kwad.sdk.g.a.1
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                a.AZ();
            }
        }, 1L, TimeUnit.SECONDS);
    }
}
