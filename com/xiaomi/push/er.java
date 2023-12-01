package com.xiaomi.push;

import android.util.Pair;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/er.class */
public class er {

    /* renamed from: a  reason: collision with root package name */
    private static Vector<Pair<String, Long>> f41382a = new Vector<>();

    /* renamed from: a  reason: collision with other field name */
    private static ConcurrentHashMap<String, Long> f403a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f41382a) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < f41382a.size()) {
                    Pair<String, Long> elementAt = f41382a.elementAt(i2);
                    sb.append(elementAt.first);
                    sb.append(":");
                    sb.append(elementAt.second);
                    if (i2 < f41382a.size() - 1) {
                        sb.append(";");
                    }
                    i = i2 + 1;
                } else {
                    f41382a.clear();
                }
            }
        }
        return sb.toString();
    }
}
