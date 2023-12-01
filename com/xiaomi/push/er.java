package com.xiaomi.push;

import android.util.Pair;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/er.class */
public class er {

    /* renamed from: a  reason: collision with root package name */
    private static Vector<Pair<String, Long>> f27691a = new Vector<>();

    /* renamed from: a  reason: collision with other field name */
    private static ConcurrentHashMap<String, Long> f356a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f27691a) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < f27691a.size()) {
                    Pair<String, Long> elementAt = f27691a.elementAt(i2);
                    sb.append(elementAt.first);
                    sb.append(":");
                    sb.append(elementAt.second);
                    if (i2 < f27691a.size() - 1) {
                        sb.append(com.huawei.openalliance.ad.constant.t.aE);
                    }
                    i = i2 + 1;
                } else {
                    f27691a.clear();
                }
            }
        }
        return sb.toString();
    }
}
