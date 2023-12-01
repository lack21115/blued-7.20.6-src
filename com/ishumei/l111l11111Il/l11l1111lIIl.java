package com.ishumei.l111l11111Il;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l11l1111lIIl.class */
public final class l11l1111lIIl {
    public static List<String> l1111l111111Il() {
        ArrayList arrayList = new ArrayList();
        try {
            Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
            if (context != null) {
                for (Sensor sensor : ((SensorManager) context.getSystemService("sensor")).getSensorList(-1)) {
                    arrayList.add(sensor.getType() + "," + sensor.getVendor());
                }
            }
            return arrayList;
        } catch (Exception e) {
            return arrayList;
        }
    }
}
