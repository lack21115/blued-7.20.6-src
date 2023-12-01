package com.efs.sdk.memoryinfo;

import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/memoryinfo/f.class */
public final class f {
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b2, code lost:
        r11 = java.lang.Long.parseLong(r0.group());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long a() {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.memoryinfo.f.a():long");
    }

    public static long a(Debug.MemoryInfo memoryInfo) {
        if (Build.VERSION.SDK_INT >= 23) {
            String memoryStat = memoryInfo.getMemoryStat("summary.graphics");
            try {
                if (TextUtils.isEmpty(memoryStat)) {
                    return 0L;
                }
                return Long.parseLong(memoryStat);
            } catch (Exception e) {
                return 0L;
            }
        }
        return 0L;
    }

    public static void a(String str, Throwable th) {
        if (a.DEBUG) {
            Log.e("MemoryCollect", str, th);
        }
    }
}
