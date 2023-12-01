package com.zego.zegoavkit2.hardwaremonitor;

import android.content.Context;
import android.os.Process;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/hardwaremonitor/ZegoHardwareMonitor.class */
public final class ZegoHardwareMonitor {
    private static double[] cpuUsage = {0.0d, 0.0d};
    private static boolean isFirst = true;
    private static ZegoCPUUtils zegoCPUUtils = null;

    public static void getCpuUsage() {
        if (!isFirst) {
            cpuUsage = zegoCPUUtils.getCpuUsage();
            return;
        }
        isFirst = false;
        ZegoCPUUtils zegoCPUUtils2 = new ZegoCPUUtils();
        zegoCPUUtils = zegoCPUUtils2;
        zegoCPUUtils2.getCpuUsage();
    }

    public static double getMEMTotal(Context context) {
        return ZegoMEMUtils.getMemInfo()[0];
    }

    public static double getMEMUsage(Context context) {
        return ZegoMEMUtils.getPSS(context, Process.myPid())[2] / 1024.0d;
    }

    public static double getProcessCPUUsage() {
        return cpuUsage[0];
    }

    public static double getSystemCPUUsage() {
        return cpuUsage[1];
    }

    public static double getSystemMEMUsage(Context context) {
        long[] memInfo = ZegoMEMUtils.getMemInfo();
        double d = memInfo[0];
        double d2 = 0.0d;
        for (int i = 1; i < memInfo.length; i++) {
            d2 += memInfo[i];
        }
        return d - d2;
    }

    public static void updateCpuUsage() {
        getCpuUsage();
    }
}
