package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/online/monitor/block/b.class */
public final class b {
    private static List<String> arR;
    private static List<String> arS;
    private static int arT = 5;

    public static void a(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        arR = new ArrayList();
        if (aVar.asf == null || aVar.asf.isEmpty()) {
            arR.add("com.kwad");
            arR.add("com.kwai");
            arR.add("com.ksad");
            arR.add("tkruntime");
            arR.add("tachikoma");
            arR.add("kuaishou");
        } else {
            arR.addAll(aVar.asf);
        }
        arT = aVar.ask;
        arS = new ArrayList();
        if (aVar.ase != null && !aVar.ase.isEmpty()) {
            arS.addAll(aVar.ase);
            return;
        }
        arS.add("android.");
        arS.add("androidx.");
        arS.add("org.");
        arS.add("java.");
    }

    private static boolean dF(String str) {
        List<String> list = arS;
        if (list == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dG(String str) {
        List<String> list = arR;
        if (list == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String dH(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\n");
        com.kwad.sdk.core.d.b.d("perfMonitor.Filter", "stacks after split:" + split.length);
        int length = split.length;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= length) {
                return "";
            }
            String str2 = split[i2];
            if (!z) {
                i = i4;
                if (dF(str2)) {
                    continue;
                    i2++;
                    i3 = i;
                }
            }
            if (i4 >= arT) {
                return "";
            }
            if (dG(str2)) {
                return str;
            }
            i = i4 + 1;
            z = true;
            i2++;
            i3 = i;
        }
    }
}
