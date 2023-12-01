package com.anythink.core.common.k;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.util.UUID;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/j.class */
public final class j {
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File a(android.content.Context r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r6 = r0
            r0 = 0
            r9 = r0
            r0 = r6
            r1 = 18
            if (r0 < r1) goto L24
            r0 = r5
            r1 = 0
            java.io.File r0 = r0.getExternalFilesDir(r1)     // Catch: java.lang.Throwable -> L9f
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L24
            r0 = r7
            java.io.File r0 = a(r0)     // Catch: java.lang.Throwable -> L9f
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r8
            if (r0 == 0) goto L26
            r0 = r8
            return r0
        L24:
            r0 = 0
            r7 = r0
        L26:
            r0 = r7
            r8 = r0
            r0 = r7
            if (r0 != 0) goto L83
            r0 = r7
            r8 = r0
            r0 = r5
            boolean r0 = b(r0)
            if (r0 == 0) goto L83
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r1 = r1.getPath()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = java.io.File.separator
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r5
            java.lang.String r1 = r1.getPackageName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r7
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.io.File r0 = a(r0)
            r8 = r0
            long r0 = b()
            r1 = 31457280(0x1e00000, double:1.55419614E-316)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L77
            r0 = 1
            r6 = r0
            goto L79
        L77:
            r0 = 0
            r6 = r0
        L79:
            r0 = r6
            if (r0 != 0) goto L83
            r0 = r9
            r7 = r0
            goto L85
        L83:
            r0 = r8
            r7 = r0
        L85:
            r0 = r7
            r8 = r0
            r0 = r7
            if (r0 != 0) goto L9d
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r5
            java.io.File r2 = r2.getFilesDir()
            java.io.File r2 = r2.getAbsoluteFile()
            java.lang.String r2 = r2.getAbsolutePath()
            r1.<init>(r2)
            r8 = r0
        L9d:
            r0 = r8
            return r0
        L9f:
            r7 = move-exception
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.k.j.a(android.content.Context):java.io.File");
    }

    private static File a(File file) {
        StringBuilder sb = new StringBuilder();
        sb.append(UUID.randomUUID());
        File file2 = new File(file, sb.toString());
        if (file2.exists()) {
            file2.delete();
        }
        if (file2.mkdirs()) {
            file2.delete();
            return file.getAbsoluteFile();
        }
        return null;
    }

    private static String a(String str) {
        return f.a(str);
    }

    private static boolean a() {
        return b() > 31457280;
    }

    private static long b() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Error e) {
                return 0L;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    private static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean c() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }
}
