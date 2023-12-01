package com.alibaba.mtl.appmonitor.e;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.s;
import com.alibaba.mtl.log.model.LogField;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/e/a.class */
public class a {
    private static final String TAG = null;
    private static a a;

    private a() {
    }

    public static a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (a == null) {
                    a = new a();
                }
                aVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        i.a(TAG, "[sendToUT]:", " args:", map);
        if (!com.alibaba.mtl.log.a.r) {
            map.put("_fuamf", "yes");
            s.send(map);
        } else if (map != null) {
            com.alibaba.mtl.log.a.a(map.get(LogField.PAGE.toString()), map.get(LogField.EVENTID.toString()), map.get(LogField.ARG1.toString()), map.get(LogField.ARG2.toString()), map.get(LogField.ARG3.toString()), map);
        }
    }
}
