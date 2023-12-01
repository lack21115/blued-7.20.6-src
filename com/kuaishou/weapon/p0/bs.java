package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/bs.class */
public class bs {

    /* renamed from: a  reason: collision with root package name */
    private static String f23761a;

    public static String a(int i) {
        int nextInt;
        StringBuilder sb = new StringBuilder();
        int i2 = i;
        if (i < 3) {
            i2 = 3;
        }
        SecureRandom secureRandom = new SecureRandom();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return sb.toString();
            }
            int nextInt2 = secureRandom.nextInt(3);
            if (nextInt2 != 0) {
                if (nextInt2 == 1) {
                    nextInt = secureRandom.nextInt(25) + 65;
                } else if (nextInt2 == 2) {
                    nextInt = secureRandom.nextInt(25) + 97;
                }
                sb.append((char) nextInt);
            } else {
                sb.append(secureRandom.nextInt(10));
            }
            i3 = i4 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00cb A[Catch: all -> 0x00e3, TRY_LEAVE, TryCatch #0 {all -> 0x00e3, blocks: (B:4:0x0003, B:6:0x000c, B:10:0x0015, B:12:0x003a, B:22:0x005e, B:24:0x0064, B:27:0x0070, B:29:0x00cb, B:20:0x0052), top: B:41:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bs.a(android.content.Context):java.lang.String");
    }

    public static String a(Context context, String str, String str2) {
        try {
            String uuid = UUID.randomUUID().toString();
            String packageName = context != null ? context.getPackageName() : "";
            String a2 = f.a(str + str2 + packageName + uuid);
            return TextUtils.isEmpty(a2) ? "" : a2;
        } catch (Throwable th) {
            return "";
        }
    }
}
