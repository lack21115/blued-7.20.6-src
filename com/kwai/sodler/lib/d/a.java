package com.kwai.sodler.lib.d;

import android.os.Build;
import android.os.Process;
import com.bun.miitmdid.core.Utils;
import com.kwad.sdk.utils.s;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/d/a.class */
public final class a {
    private static String aLd;
    private static String aLe;
    private static final Map<String, String> aLf;

    static {
        HashMap hashMap = new HashMap();
        aLf = hashMap;
        hashMap.put("mips", "mips");
        aLf.put("mips64", "mips64");
        aLf.put(Utils.CPU_ABI_X86, Utils.CPU_ABI_X86);
        aLf.put("x86_64", "x86_64");
        aLf.put("arm64", "arm64-v8a");
    }

    private static boolean is64Bit() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Process.is64Bit();
        }
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 21) {
            Boolean bool = null;
            try {
                bool = (Boolean) s.a(s.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            z = false;
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public static String tz() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
