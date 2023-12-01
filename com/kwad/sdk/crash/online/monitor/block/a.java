package com.kwad.sdk.crash.online.monitor.block;

import android.os.Looper;
import android.util.Printer;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/online/monitor/block/a.class */
public final class a {
    private static volatile boolean arH;
    private static String arI;
    private static List<String> arJ;
    private static List<String> arK;
    private static volatile boolean arL;
    private static volatile boolean arM;

    public static void a(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        arJ = aVar.asg;
        arK = aVar.ash;
    }

    private static boolean a(List<String> list, boolean z) {
        String str;
        if (arH) {
            return false;
        }
        try {
            Printer printer = (Printer) s.d(Looper.getMainLooper(), "mLogging");
            if (printer == null) {
                com.kwad.sdk.core.d.b.d("perfMonitor.MonitorDetector", "printer not hook");
                return false;
            }
            arI = printer.getClass().getName();
            com.kwad.sdk.core.d.b.d("perfMonitor.MonitorDetector", "originPrinter name:" + printer.getClass().getName());
            if (z) {
                e.dN(arI);
            }
            Iterator<String> it = list.iterator();
            do {
                if (!it.hasNext()) {
                    return false;
                }
                str = new String(com.kwad.sdk.core.kwai.c.vJ().decode(it.next()));
                com.kwad.sdk.core.d.b.d("perfMonitor.MonitorDetector", "printer after:" + str);
            } while (!printer.getClass().getName().contains(str));
            com.kwad.sdk.core.d.b.d("perfMonitor.MonitorDetector", "printer monitor");
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e);
            arH = true;
            return false;
        }
    }

    public static boolean bi(boolean z) {
        List<String> list = arJ;
        return (list == null || list.isEmpty()) ? c("Y29tLnRlbmNlbnQubWF0cml4LnRyYWNlLmNvcmUuTG9vcGVyTW9uaXRvcg==", true) : a(arJ, true);
    }

    public static boolean bj(boolean z) {
        List<String> list = arK;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return a(arK, false);
    }

    private static boolean c(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return a(arrayList, z);
    }

    public static boolean zS() {
        if (arH) {
            return false;
        }
        try {
            return ((Printer) s.d(Looper.getMainLooper(), "mLogging")) != null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e);
            arH = true;
            return false;
        }
    }

    public static boolean zT() {
        if (arM) {
            return arL;
        }
        try {
            String str = new String(com.kwad.sdk.core.kwai.c.vJ().decode("Y29tLnRlbmNlbnQubWF0cml4Lk1hdHJpeA=="));
            com.kwad.sdk.core.d.b.d("perfMonitor.MonitorDetector", "hasMatrix after:" + str);
            if (Class.forName(str) != null) {
                return true;
            }
        } catch (ClassNotFoundException e) {
        }
        arL = false;
        arM = true;
        return arL;
    }
}
