package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/el.class */
public class el {

    /* renamed from: a  reason: collision with root package name */
    private static a f41374a;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, hq> f389a;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/el$a.class */
    public interface a {
        void uploader(Context context, hk hkVar);
    }

    public static int a(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    public static int a(Enum r3) {
        if (r3 != null) {
            if (r3 instanceof hg) {
                return r3.ordinal() + 1001;
            }
            if (r3 instanceof hq) {
                return r3.ordinal() + 2001;
            }
            if (r3 instanceof ew) {
                return r3.ordinal() + 3001;
            }
            return -1;
        }
        return -1;
    }

    public static Config a(Context context) {
        boolean a2 = com.xiaomi.push.service.ba.a(context).a(hl.PerfUploadSwitch.a(), false);
        boolean a3 = com.xiaomi.push.service.ba.a(context).a(hl.EventUploadNewSwitch.a(), false);
        int a4 = com.xiaomi.push.service.ba.a(context).a(hl.PerfUploadFrequency.a(), 86400);
        return Config.getBuilder().setEventUploadSwitchOpen(a3).setEventUploadFrequency(com.xiaomi.push.service.ba.a(context).a(hl.EventUploadFrequency.a(), 86400)).setPerfUploadSwitchOpen(a2).setPerfUploadFrequency(a4).build(context);
    }

    public static EventClientReport a(Context context, String str, String str2, int i, long j, String str3) {
        EventClientReport a2 = a(str);
        a2.eventId = str2;
        a2.eventType = i;
        a2.eventTime = j;
        a2.eventContent = str3;
        return a2;
    }

    public static EventClientReport a(String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = str;
        return eventClientReport;
    }

    public static PerfClientReport a() {
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = 1000;
        perfClientReport.reportType = 1000;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    public static PerfClientReport a(Context context, int i, long j, long j2) {
        PerfClientReport a2 = a();
        a2.code = i;
        a2.perfCounts = j;
        a2.perfLatencies = j2;
        return a2;
    }

    public static hk a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hk hkVar = new hk();
        hkVar.d("category_client_report_data");
        hkVar.a("push_sdk_channel");
        hkVar.a(1L);
        hkVar.b(str);
        hkVar.a(true);
        hkVar.b(System.currentTimeMillis());
        hkVar.g(context.getPackageName());
        hkVar.e("com.xiaomi.xmsf");
        hkVar.f(com.xiaomi.push.service.bz.a());
        hkVar.c("quality_support");
        return hkVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hq m11714a(String str) {
        if (f389a == null) {
            synchronized (hq.class) {
                try {
                    if (f389a == null) {
                        f389a = new HashMap();
                        hq[] values = hq.values();
                        int length = values.length;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= length) {
                                break;
                            }
                            hq hqVar = values[i2];
                            f389a.put(hqVar.f583a.toLowerCase(), hqVar);
                            i = i2 + 1;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        hq hqVar2 = f389a.get(str.toLowerCase());
        return hqVar2 != null ? hqVar2 : hq.Invalid;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m11715a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m11716a(Context context) {
        ClientReportClient.updateConfig(context, a(context));
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new ej(context), new ek(context));
    }

    private static void a(Context context, hk hkVar) {
        if (m11717a(context.getApplicationContext())) {
            com.xiaomi.push.service.ca.a(context.getApplicationContext(), hkVar);
            return;
        }
        a aVar = f41374a;
        if (aVar != null) {
            aVar.uploader(context, hkVar);
        }
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            for (String str : list) {
                hk a2 = a(context, str);
                if (!com.xiaomi.push.service.bz.a(a2, false)) {
                    a(context, a2);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d(th.getMessage());
        }
    }

    public static void a(a aVar) {
        f41374a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m11717a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }
}
