package com.tencent.liteav.base.system;

import com.tencent.liteav.base.Log;
import java.security.MessageDigest;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/o.class */
final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f22628a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Code restructure failed: missing block: B:103:0x032e, code lost:
        if (r10 == null) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0373 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0366 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0193 A[LOOP:0: B:65:0x018f->B:67:0x0193, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01dd A[LOOP:1: B:69:0x01d9->B:71:0x01dd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x029b A[Catch: all -> 0x02f5, Exception -> 0x02fc, TryCatch #13 {Exception -> 0x02fc, all -> 0x02f5, blocks: (B:77:0x026f, B:79:0x029b, B:80:0x02a0, B:80:0x02a0, B:81:0x02a3, B:83:0x02cc, B:84:0x02d1, B:84:0x02d1, B:85:0x02d4), top: B:134:0x026f }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02cc A[Catch: all -> 0x02f5, Exception -> 0x02fc, TryCatch #13 {Exception -> 0x02fc, all -> 0x02f5, blocks: (B:77:0x026f, B:79:0x029b, B:80:0x02a0, B:80:0x02a0, B:81:0x02a3, B:83:0x02cc, B:84:0x02d1, B:84:0x02d1, B:85:0x02d4), top: B:134:0x026f }] */
    /* JADX WARN: Type inference failed for: r0v74, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 914
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.system.o.a(java.lang.String):java.lang.String");
    }

    private static String b(String str) {
        if (str == null) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            char[] cArr = new char[digest.length << 1];
            int i = 0;
            for (int i2 = 0; i2 < digest.length; i2++) {
                int i3 = i + 1;
                cArr[i] = f22628a[(digest[i2] & 240) >>> 4];
                i = i3 + 1;
                cArr[i3] = f22628a[digest[i2] & 15];
            }
            return new String(cArr);
        } catch (Exception e) {
            Log.e("UUID", "stringToMd5 failed.", e);
            return "";
        }
    }
}
