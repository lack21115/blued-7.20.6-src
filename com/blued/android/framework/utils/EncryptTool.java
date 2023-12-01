package com.blued.android.framework.utils;

import com.blued.android.core.Hashids;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/EncryptTool.class */
public class EncryptTool {
    public static String a(String str) {
        String str2;
        String str3 = "";
        try {
            long[] a2 = new Hashids("1766", 6).a(str);
            int i = 0;
            String str4 = "";
            while (true) {
                str3 = str4;
                str2 = str4;
                if (i >= a2.length) {
                    break;
                }
                String str5 = str4;
                StringBuilder sb = new StringBuilder();
                String str6 = str4;
                sb.append(str4);
                String str7 = str4;
                sb.append(Long.toString(a2[i]));
                String str8 = str4;
                str4 = sb.toString();
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            str2 = str3;
        }
        return str2;
    }

    public static String b(String str) {
        try {
            return new Hashids("1766", 6).a(Long.valueOf(str).longValue());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(java.lang.String r3) {
        /*
            java.lang.String r0 = "SHA-1"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch: java.lang.Exception -> L16 java.security.NoSuchAlgorithmException -> L1e
            r4 = r0
            r0 = r4
            r1 = r3
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Exception -> L16 java.security.NoSuchAlgorithmException -> L1e
            r0.update(r1)     // Catch: java.lang.Exception -> L16 java.security.NoSuchAlgorithmException -> L1e
            r0 = r4
            byte[] r0 = r0.digest()     // Catch: java.lang.Exception -> L16 java.security.NoSuchAlgorithmException -> L1e
            r3 = r0
            goto L25
        L16:
            r3 = move-exception
            r0 = r3
            r0.printStackTrace()
            goto L23
        L1e:
            r3 = move-exception
            r0 = r3
            r0.printStackTrace()
        L23:
            r0 = 0
            r3 = r0
        L25:
            r0 = r3
            if (r0 == 0) goto L2e
            r0 = r3
            java.lang.String r0 = com.blued.android.framework.utils.AesCrypto.a(r0)
            return r0
        L2e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.utils.EncryptTool.c(java.lang.String):java.lang.String");
    }
}
