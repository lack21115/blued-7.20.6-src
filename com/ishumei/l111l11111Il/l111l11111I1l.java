package com.ishumei.l111l11111Il;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l11111I1l.class */
public final class l111l11111I1l {
    public static Map<String, Integer> l1111l111111Il() {
        HashMap hashMap = new HashMap();
        Context context = com.ishumei.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
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
}
