package com.zx.a.I8b7;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/m.class */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f28456a = true;

    public static void a(String str) {
        if (f28456a) {
            StringBuilder a2 = m2.a("--- ");
            a2.append(str == null ? com.igexin.push.core.b.l : str);
            a2.append(" ---");
            Log.d("zx-DebugMode", a2.toString());
        }
        String str2 = str;
        if (str == null) {
            str2 = com.igexin.push.core.b.l;
        }
        z1.a(str2);
    }

    public static void b(String str) {
        if (f28456a) {
            StringBuilder a2 = m2.a("--- ");
            String str2 = str;
            if (str == null) {
                str2 = com.igexin.push.core.b.l;
            }
            a2.append(str2);
            a2.append(" ---");
            Log.e("zx-DebugMode", a2.toString());
        }
    }
}
