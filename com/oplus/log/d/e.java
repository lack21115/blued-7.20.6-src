package com.oplus.log.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/d/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f24357a = {"MemTotal:", "MemFree:", "Buffers:", "Cached:", "Active:", "Inactive:", "Dirty:"};
    public static final String[] b = {"VmLck:", "VmRSS:", "VmSize:", "VmExe:", "VmStk:", "VmLib", "Threads:"};

    public static Map<String, Long> a() {
        HashMap hashMap;
        HashMap hashMap2 = new HashMap();
        try {
            int i = 0;
            Method method = Class.forName("android.os.Process").getMethod("readProcLines", String.class, String[].class, long[].class);
            hashMap = hashMap2;
            if (method != null) {
                int length = f24357a.length;
                long[] jArr = new long[length];
                jArr[0] = 30;
                jArr[1] = -30;
                method.invoke(null, new String("/proc/meminfo"), f24357a, jArr);
                while (true) {
                    hashMap = hashMap2;
                    if (i >= length) {
                        break;
                    }
                    hashMap2.put(f24357a[i], Long.valueOf(jArr[i]));
                    i++;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            hashMap = null;
        }
        return hashMap;
    }
}
