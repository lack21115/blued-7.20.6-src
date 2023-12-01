package com.kwad.sdk.crash.online.monitor.block;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.kwad.sdk.crash.online.monitor.block.report.BlockReportAction;
import com.kwad.sdk.crash.report.h;
import com.kwad.sdk.crash.report.request.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/online/monitor/block/e.class */
public final class e {
    public static void a(String str, long j, long j2, String str2, String str3, boolean z) {
        try {
            e(b(str, j, j2, str2, str3), false);
        } catch (Throwable th) {
        }
    }

    private static String b(String str, long j, long j2, String str2, String str3) {
        long j3;
        String str4 = str;
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", Log.getStackTraceString(e));
            j3 = j2;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String dM = dM(b.dH(str));
        str4 = dM;
        if (TextUtils.isEmpty(dM)) {
            return "";
        }
        str4 = dM;
        j3 = j2;
        if (j2 == 0) {
            j3 = 2000;
            str4 = dM;
        }
        return c(str4, j, j3, str2, str3).toJson().toString();
    }

    private static BlockEvent c(String str, long j, long j2, String str2, String str3) {
        BlockEvent blockEvent = new BlockEvent();
        blockEvent.blockDuration = j2;
        blockEvent.currentActivity = str2;
        blockEvent.processName = str3;
        BlockEvent.a aVar = new BlockEvent.a();
        aVar.arP = str;
        long j3 = j;
        if (j == 0) {
            j3 = System.currentTimeMillis();
        }
        aVar.arN = j3;
        aVar.repeatCount = (int) (j2 / blockEvent.blockLoopInterval);
        blockEvent.stackTraceSample.add(aVar);
        return blockEvent;
    }

    public static void d(String str, boolean z) {
        String dJ = dJ(str);
        if (TextUtils.isEmpty(dJ)) {
            return;
        }
        e(dJ, false);
    }

    private static String dJ(String str) {
        String dK = dK(b.dH(str));
        return !TextUtils.isEmpty(dK) ? c(dK, 0L, 2000L, "", "").toJson().toString() : "";
    }

    private static String dK(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = str;
        String str3 = str;
        try {
            if (str.contains("at ")) {
                str2 = str.substring(str.indexOf("at "));
            }
            String str4 = str2;
            String replaceAll = dL(str2.replaceAll("at ", "")).replaceAll("\\)", "\\)\n");
            String str5 = replaceAll;
            if (replaceAll.contains("\n")) {
                str5 = replaceAll.replaceAll("\n", "\n\tat ");
            }
            String str6 = str5;
            StringBuilder sb = new StringBuilder();
            String str7 = str5;
            sb.append(str5);
            String str8 = str5;
            sb.append("_");
            String str9 = str5;
            String replaceAll2 = sb.toString().replaceAll("\n\tat _", "\n");
            StringBuilder sb2 = new StringBuilder("\n\tat ");
            sb2.append(replaceAll2);
            str3 = replaceAll2;
            return sb2.toString();
        } catch (Exception e) {
            Log.e("perfMonitor.Reporter", Log.getStackTraceString(e));
            return str3;
        }
    }

    private static String dL(String str) {
        return str != null ? Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("") : "";
    }

    private static String dM(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = str;
        try {
            boolean startsWith = str.startsWith(" \n");
            StringBuilder sb = new StringBuilder("oldVersion:");
            sb.append(startsWith);
            com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", sb.toString());
            String str3 = str;
            if (startsWith) {
                String str4 = str;
                if (str.contains("at ")) {
                    str4 = str.substring(str.indexOf("at "));
                }
                String str5 = str4;
                String replaceAll = str4.replaceAll(":", "\\.");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(replaceAll);
                sb2.append("\n");
                str3 = sb2.toString();
            }
            String str6 = str3;
            String replaceAll2 = str3.replaceAll("at ", "").replaceAll(" ", "");
            String str7 = replaceAll2;
            if (replaceAll2.contains("\n")) {
                str7 = replaceAll2.replaceAll("\n", "\n\tat ");
            }
            String str8 = str7;
            StringBuilder sb3 = new StringBuilder();
            String str9 = str7;
            sb3.append(str7);
            String str10 = str7;
            sb3.append("_");
            String str11 = str7;
            String replaceAll3 = sb3.toString().replaceAll("\n\tat _", "\n");
            StringBuilder sb4 = new StringBuilder("\n\tat ");
            sb4.append(replaceAll3);
            str2 = replaceAll3;
            return sb4.toString();
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", Log.getStackTraceString(e));
            return str2;
        }
    }

    public static void dN(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "reportPrinterName:" + str);
        if (d.zV()) {
            c cVar = new c();
            cVar.arW = str;
            cVar.arY = a.zT();
            KSLoggerReporter.x(cVar.toJson());
        }
    }

    public static void dO(String str) {
        try {
            c cVar = new c();
            cVar.errorMsg = str;
            cVar.arY = a.zT();
            KSLoggerReporter.x(cVar.toJson());
        } catch (Exception e) {
        }
        com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", str);
    }

    private static void e(final String str, final boolean z) {
        g.execute(new aw() { // from class: com.kwad.sdk.crash.online.monitor.block.e.1
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z || e.sQ() == 1) {
                    com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "report now :" + str);
                    h.R("perf-block", str);
                    return;
                }
                BlockReportAction blockReportAction = new BlockReportAction(str);
                com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "write to db :" + blockReportAction.toJson().toString());
                final Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
                if (context == null) {
                    return;
                }
                com.kwad.sdk.crash.online.monitor.block.report.a.bn(context).e(blockReportAction);
                if (e.zX()) {
                    final List<f> wV = com.kwad.sdk.crash.online.monitor.block.report.a.bn(context).wV();
                    ArrayList arrayList = new ArrayList();
                    Iterator<f> it = wV.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((BlockReportAction) it.next()).msg);
                    }
                    h.a("perf-block", arrayList, new b.a() { // from class: com.kwad.sdk.crash.online.monitor.block.e.1.1
                        @Override // com.kwad.sdk.crash.report.request.b.a
                        public final void onError(int i, String str2) {
                            com.kwad.sdk.core.d.b.w("perfMonitor.Reporter", "errorCode:" + i + " errorMsg:" + str2);
                        }

                        @Override // com.kwad.sdk.crash.report.request.b.a
                        public final void onSuccess() {
                            com.kwad.sdk.crash.online.monitor.block.report.a.bn(context).o(wV);
                        }
                    });
                }
            }
        });
    }

    static /* synthetic */ int sQ() {
        return zW();
    }

    private static boolean wO() {
        int zW = zW();
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return false;
        }
        long size = com.kwad.sdk.crash.online.monitor.block.report.a.bn(context).size();
        com.kwad.sdk.core.d.b.d("perfMonitor.Reporter", "size:" + size + " limit:" + zW);
        return size >= ((long) zW);
    }

    private static int zW() {
        com.kwad.sdk.crash.online.monitor.kwai.a zU = d.zU();
        if (zU != null) {
            return zU.asl;
        }
        return 20;
    }

    static /* synthetic */ boolean zX() {
        return wO();
    }
}
