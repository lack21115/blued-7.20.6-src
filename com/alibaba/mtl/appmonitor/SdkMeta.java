package com.alibaba.mtl.appmonitor;

import android.content.Context;
import com.alibaba.mtl.log.e.i;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/SdkMeta.class */
public class SdkMeta {
    public static final String SDK_VERSION = "2.5.1.3_for_bc";
    private static final Map<String, String> b;

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put("sdk-version", SDK_VERSION);
    }

    public static Map<String, String> getSDKMetaData() {
        com.alibaba.mtl.log.a.getContext();
        if (!b.containsKey("sdk-version")) {
            b.put("sdk-version", SDK_VERSION);
        }
        return b;
    }

    public static String getString(Context context, String str) {
        if (context == null) {
            return null;
        }
        int i = 0;
        try {
            i = context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Throwable th) {
            i.a("SdkMeta", "getString Id error", th);
        }
        if (i != 0) {
            return context.getString(i);
        }
        return null;
    }

    public static void setExtra(Map<String, String> map) {
        if (map != null) {
            b.putAll(map);
        }
    }
}
