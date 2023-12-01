package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import com.igexin.assist.util.AssistUtils;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l1111l111111Il/l111l1111llIl.class */
public class l111l1111llIl {
    private static final long l1111l111111Il = 150;
    private l111l1111lI1l l111l11111I1l;
    private final Context l111l11111lIl;

    public l111l1111llIl() {
    }

    public l111l1111llIl(Context context) {
        l1111l111111Il l1111l111111il;
        this.l111l11111lIl = context;
        if (context != null) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains("asus")) {
                l1111l111111il = new l1111l111111Il(this.l111l11111lIl);
            } else if (lowerCase.contains(AssistUtils.BRAND_HW)) {
                l1111l111111il = new l111l11111lIl(this.l111l11111lIl);
            } else if (lowerCase.contains("lenovo")) {
                l1111l111111il = new l111l11111I1l(this.l111l11111lIl);
            } else if (lowerCase.contains(AssistUtils.BRAND_MZ)) {
                l1111l111111il = new l111l11111Il(this.l111l11111lIl);
            } else if (lowerCase.contains("nubia")) {
                l1111l111111il = new l111l1111l1Il(this.l111l11111lIl);
            } else if (lowerCase.contains("oneplus")) {
                l1111l111111il = new l111l1111lIl(this.l111l11111lIl);
            } else if (lowerCase.contains(AssistUtils.BRAND_OPPO)) {
                l1111l111111il = new l11l1111lIIl(this.l111l11111lIl);
            } else if (lowerCase.contains("samsung")) {
                l1111l111111il = new l11l1111I11l(this.l111l11111lIl);
            } else if (lowerCase.contains(AssistUtils.BRAND_VIVO)) {
                l1111l111111il = new l11l1111I1l(this.l111l11111lIl);
            } else if (lowerCase.contains(AssistUtils.BRAND_XIAOMI)) {
                l1111l111111il = new l11l1111I1ll(this.l111l11111lIl);
            } else if (lowerCase.contains("zte")) {
                l1111l111111il = new l11l1111Il(this.l111l11111lIl);
            }
            this.l111l11111I1l = l1111l111111il;
        }
        l1111l111111il = null;
        this.l111l11111I1l = l1111l111111il;
    }

    private l111l1111lI1l l111l11111I1l() {
        if (this.l111l11111lIl == null) {
            return null;
        }
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        if (lowerCase.contains("asus")) {
            return new l1111l111111Il(this.l111l11111lIl);
        }
        if (lowerCase.contains(AssistUtils.BRAND_HW)) {
            return new l111l11111lIl(this.l111l11111lIl);
        }
        if (lowerCase.contains("lenovo")) {
            return new l111l11111I1l(this.l111l11111lIl);
        }
        if (lowerCase.contains(AssistUtils.BRAND_MZ)) {
            return new l111l11111Il(this.l111l11111lIl);
        }
        if (lowerCase.contains("nubia")) {
            return new l111l1111l1Il(this.l111l11111lIl);
        }
        if (lowerCase.contains("oneplus")) {
            return new l111l1111lIl(this.l111l11111lIl);
        }
        if (lowerCase.contains(AssistUtils.BRAND_OPPO)) {
            return new l11l1111lIIl(this.l111l11111lIl);
        }
        if (lowerCase.contains("samsung")) {
            return new l11l1111I11l(this.l111l11111lIl);
        }
        if (lowerCase.contains(AssistUtils.BRAND_VIVO)) {
            return new l11l1111I1l(this.l111l11111lIl);
        }
        if (lowerCase.contains(AssistUtils.BRAND_XIAOMI)) {
            return new l11l1111I1ll(this.l111l11111lIl);
        }
        if (lowerCase.contains("zte")) {
            return new l11l1111Il(this.l111l11111lIl);
        }
        return null;
    }

    public static Map<String, Integer> l111l11111lIl() {
        HashMap hashMap = new HashMap();
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return hashMap;
        }
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            if (registerReceiver == null) {
                return hashMap;
            }
            int intExtra = registerReceiver.getIntExtra("status", 0);
            int intExtra2 = registerReceiver.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            int intExtra3 = registerReceiver.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
            int intExtra4 = registerReceiver.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
            int intExtra5 = registerReceiver.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);
            hashMap.put("status", Integer.valueOf(intExtra));
            hashMap.put(BatteryManager.EXTRA_LEVEL, Integer.valueOf(intExtra2));
            hashMap.put(BatteryManager.EXTRA_SCALE, Integer.valueOf(intExtra3));
            hashMap.put("temp", Integer.valueOf(intExtra4));
            hashMap.put("vol", Integer.valueOf(intExtra5));
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    public final String l1111l111111Il() {
        l111l1111lI1l l111l1111li1l = this.l111l11111I1l;
        return l111l1111li1l == null ? "" : l111l1111li1l.l1111l111111Il(150L);
    }
}
