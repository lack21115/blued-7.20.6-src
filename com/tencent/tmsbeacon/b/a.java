package com.tencent.tmsbeacon.b;

import com.tencent.tmsbeacon.a.b.d;
import com.tencent.tmsbeacon.base.util.c;
import com.tencent.tmsbeacon.base.util.f;
import com.tencent.tmsqmsp.sdk.u.U;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f39489a = false;

    public static String a(int i) {
        synchronized (a.class) {
            try {
                if (!com.tencent.tmsbeacon.d.b.a().d()) {
                    return "";
                }
                String[] c2 = U.c(i);
                if (c2 == null) {
                    if (!f39489a) {
                        d.b().a("501", "[beaconId] jni execute error or load so fail!");
                        f39489a = true;
                    }
                    return "";
                }
                f.a(c2);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= c2.length) {
                        break;
                    }
                    c2[i3] = f.a(c2[i3]);
                    i2 = i3 + 1;
                }
                StringBuilder sb = new StringBuilder();
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= c2.length) {
                        sb.append("k10:");
                        sb.append(1);
                        c.a("[BeaconId] %s", sb);
                        return sb.toString();
                    }
                    if (i5 >= 9) {
                        sb.append("k");
                        sb.append(i5 + 2);
                        sb.append(":");
                        sb.append(c2[i5]);
                        sb.append(";");
                    } else {
                        sb.append("k");
                        sb.append(i5 + 1);
                        sb.append(":");
                        sb.append(c2[i5]);
                        sb.append(";");
                    }
                    i4 = i5 + 1;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
