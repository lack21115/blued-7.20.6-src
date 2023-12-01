package com.bytedance.pangle.e;

import android.os.Build;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.log.ZeusLogger;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/d.class */
public final class d implements f.a {
    private static boolean a(String str, String str2) {
        try {
            return a.a(b.a(str, str2, b.b));
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d1672829046108dc(java.lang.String r5) {
        /*
        L0:
            r0 = 74
            r6 = r0
            r0 = 55
            r7 = r0
        L6:
            r0 = r6
            switch(r0) {
                case 72: goto L0;
                case 73: goto L23;
                case 74: goto L40;
                default: goto L20;
            }
        L20:
            goto L8e
        L23:
            r0 = r7
            switch(r0) {
                case 94: goto L85;
                case 95: goto L5f;
                case 96: goto L5f;
                default: goto L40;
            }
        L40:
            r0 = r7
            switch(r0) {
                case 55: goto L85;
                case 56: goto L85;
                case 57: goto L5f;
                default: goto L5c;
            }
        L5c:
            goto L85
        L5f:
            r0 = r5
            char[] r0 = r0.toCharArray()
            r5 = r0
            r0 = 0
            r6 = r0
        L66:
            r0 = r6
            r1 = r5
            int r1 = r1.length
            if (r0 >= r1) goto L7c
            r0 = r5
            r1 = r6
            r2 = r5
            r3 = r6
            char r2 = r2[r3]
            r3 = r6
            r2 = r2 ^ r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L66
        L7c:
            java.lang.String r0 = new java.lang.String
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            return r0
        L85:
            r0 = 73
            r6 = r0
            r0 = 96
            r7 = r0
            goto L6
        L8e:
            r0 = 72
            r6 = r0
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.e.d.d1672829046108dc(java.lang.String):java.lang.String");
    }

    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i) {
        String b = com.bytedance.pangle.d.c.b(str, i);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(b)));
        String c2 = com.bytedance.pangle.d.c.c(str, i);
        String str2 = c2 + File.separator + "compFully" + b.b(b);
        String str3 = c2 + File.separator + b.a(b);
        if (a(b, str2)) {
            File file = new File(str2);
            if (file.exists()) {
                file.renameTo(new File(str3));
            }
            CharSequence charSequence = Build.VERSION.SDK_INT >= 26 ? ShareConstants.ODEX_SUFFIX : ShareConstants.DEX_SUFFIX;
            File file2 = new File(str2.replace(charSequence, ".vdex"));
            if (file2.exists()) {
                file2.renameTo(new File(str3.replace(charSequence, ".vdex")));
            }
            boolean a2 = b.a(str3);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(a2)));
            return a2;
        }
        return false;
    }
}
