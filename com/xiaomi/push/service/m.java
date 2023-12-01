package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/m.class */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Long> f27994a = new HashMap();

    private static void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList<String> arrayList = new ArrayList(f27994a.size());
        for (Map.Entry<String, Long> entry : f27994a.entrySet()) {
            if (elapsedRealtime - entry.getValue().longValue() > 60000) {
                arrayList.add(entry.getKey());
            }
        }
        for (String str : arrayList) {
            f27994a.remove(str);
        }
    }

    public static boolean a(byte[] bArr, String str) {
        boolean z = false;
        if (bArr == null || bArr.length <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        String a2 = com.xiaomi.push.bn.a(bArr);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        synchronized (f27994a) {
            if (f27994a.get(a2 + str) != null) {
                z = true;
            } else {
                f27994a.put(a2 + str, Long.valueOf(SystemClock.elapsedRealtime()));
            }
            a();
        }
        return z;
    }
}
