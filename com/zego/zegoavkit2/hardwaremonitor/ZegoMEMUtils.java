package com.zego.zegoavkit2.hardwaremonitor;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/hardwaremonitor/ZegoMEMUtils.class */
public class ZegoMEMUtils {
    public static long[] getHeap() {
        long[] heapNative = getHeapNative();
        long[] heapDalvik = getHeapDalvik();
        return new long[]{heapNative[0], heapNative[1], heapDalvik[0], heapDalvik[1], heapNative[0] + heapDalvik[0], heapNative[1] + heapDalvik[1]};
    }

    public static long[] getHeapDalvik() {
        return new long[]{Runtime.getRuntime().totalMemory() >> 10, (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) >> 10};
    }

    public static long[] getHeapNative() {
        return new long[]{Debug.getNativeHeapSize() >> 10, Debug.getNativeHeapAllocatedSize() >> 10};
    }

    public static long[] getMemInfo() {
        long[] jArr = new long[4];
        try {
            Method method = Class.forName("android.os.Process").getMethod("readProcLines", String.class, String[].class, long[].class);
            long[] jArr2 = new long[4];
            jArr2[0] = 30;
            jArr2[1] = -30;
            String str = new String("/proc/meminfo");
            if (method != null) {
                method.invoke(null, str, new String[]{"MemTotal:", "MemFree:", "Buffers:", "Cached:"}, jArr2);
                for (int i = 0; i < 4; i++) {
                    jArr[i] = jArr2[i] / 1024;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jArr;
    }

    public static long[] getPSS(Context context, int i) {
        long[] jArr = new long[3];
        if (i < 0) {
            jArr[0] = 0;
            jArr[1] = 0;
            jArr[2] = 0;
            return jArr;
        }
        try {
            Debug.MemoryInfo memoryInfo = ((ActivityManager) context.getSystemService("activity")).getProcessMemoryInfo(new int[]{i})[0];
            jArr[0] = memoryInfo.nativePss;
            jArr[1] = memoryInfo.dalvikPss;
            jArr[2] = memoryInfo.getTotalPss();
            return jArr;
        } catch (Exception e) {
            e.printStackTrace();
            return jArr;
        }
    }

    public static long[] getPrivDirty(Context context, int i) {
        Debug.MemoryInfo memoryInfo = ((ActivityManager) context.getSystemService("activity")).getProcessMemoryInfo(new int[]{i})[0];
        return new long[]{memoryInfo.nativePrivateDirty, memoryInfo.dalvikPrivateDirty, memoryInfo.getTotalPrivateDirty()};
    }
}
