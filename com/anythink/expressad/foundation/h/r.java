package com.anythink.expressad.foundation.h;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.util.UUID;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/r.class */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    static boolean f5130a = false;
    static String b = "";

    /* renamed from: c  reason: collision with root package name */
    public static char[] f5131c = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', 'r'};
    private static final String d = "common-exception";
    private static final String e = "SameSDCardTool";
    private static boolean f = false;
    private static int g = -1;
    private static int h = -1;
    private static int i = -1;
    private static int j = -1;
    private static String k;

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

    public static String a() {
        return k;
    }

    public static void a(Context context) {
        if (f) {
            return;
        }
        try {
            b = context.getFilesDir().getAbsolutePath() + File.separator;
            if (context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0) {
                f5130a = true;
            } else {
                f5130a = false;
            }
            b(context);
        } catch (Exception e2) {
            try {
                b = context.getFilesDir().getAbsolutePath() + File.separator;
                b(context);
            } catch (Exception e3) {
            }
        }
        f = true;
    }

    public static boolean a(long j2) {
        return e() > j2;
    }

    private static void b(Context context) {
        String c2 = c(context);
        k = c2;
        com.anythink.expressad.foundation.g.c.d.a(new com.anythink.expressad.foundation.g.c.b(c2));
        com.anythink.expressad.foundation.g.c.d.a().b();
    }

    public static boolean b() {
        try {
            return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
        } catch (Exception e2) {
            o.d("", "hasSDCard is failed");
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b0, code lost:
        if (r7.exists() == false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c(android.content.Context r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r6 = r0
            r0 = 0
            r9 = r0
            r0 = r6
            r1 = 18
            if (r0 < r1) goto L28
            r0 = r5
            r1 = 0
            java.io.File r0 = r0.getExternalFilesDir(r1)     // Catch: java.lang.Throwable -> L1f
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L28
            r0 = r7
            java.io.File r0 = a(r0)     // Catch: java.lang.Throwable -> L1f
            r7 = r0
            goto L2a
        L1f:
            r7 = move-exception
            java.lang.String r0 = "common-exception"
            java.lang.String r1 = "hasSDCard is failed"
            r2 = r7
            com.anythink.expressad.foundation.h.o.b(r0, r1, r2)
        L28:
            r0 = 0
            r7 = r0
        L2a:
            r0 = r7
            r8 = r0
            boolean r0 = com.anythink.expressad.foundation.h.r.f5130a
            if (r0 == 0) goto La4
            r0 = r7
            r8 = r0
            r0 = r7
            if (r0 != 0) goto L89
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
            java.lang.String r1 = "Android"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = java.io.File.separator
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = "data"
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
        L89:
            long r0 = e()
            r1 = 31457280(0x1e00000, double:1.55419614E-316)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L98
            r0 = 1
            r6 = r0
            goto L9a
        L98:
            r0 = 0
            r6 = r0
        L9a:
            r0 = r6
            if (r0 != 0) goto La4
            r0 = r9
            r7 = r0
            goto La6
        La4:
            r0 = r8
            r7 = r0
        La6:
            r0 = r7
            if (r0 == 0) goto Lb3
            r0 = r7
            r8 = r0
            r0 = r7
            boolean r0 = r0.exists()
            if (r0 != 0) goto Lbb
        Lb3:
            r0 = r5
            java.io.File r0 = r0.getFilesDir()
            java.io.File r0 = r0.getAbsoluteFile()
            r8 = r0
        Lbb:
            r0 = r8
            java.lang.String r0 = r0.getAbsolutePath()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.h.r.c(android.content.Context):java.lang.String");
    }

    private static boolean c() {
        return f5130a;
    }

    private static int d() {
        try {
            Context d2 = com.anythink.expressad.foundation.b.a.b().d();
            long longValue = ((Long) v.b(d2, "freeExternalSize", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || h == -1) {
                h = Long.valueOf((e() / 1000) / 1000).intValue();
                v.a(d2, "freeExternalSize", Long.valueOf(currentTimeMillis));
            }
        } catch (Throwable th) {
            o.b(e, th.getMessage(), th);
        }
        return h;
    }

    private static long d(Context context) {
        try {
            String absolutePath = context.getFilesDir().getAbsolutePath();
            StatFs statFs = new StatFs(absolutePath);
            statFs.restat(absolutePath);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e2) {
            return 0L;
        }
    }

    private static long e() {
        if (b()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    private static boolean f() {
        return e() > 31457280;
    }

    private static int g() {
        if (g == -1) {
            try {
                g = new Long((h() / 1000) / 1000).intValue();
            } catch (Throwable th) {
                o.b(e, th.getMessage(), th);
            }
        }
        return g;
    }

    private static long h() {
        if (b()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    private static int i() {
        try {
            Context d2 = com.anythink.expressad.foundation.b.a.b().d();
            long longValue = ((Long) v.b(d2, "TotalDataSize", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || i == -1) {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                i = Long.valueOf(((statFs.getBlockCount() * statFs.getBlockSize()) / 1000) / 1000).intValue();
                v.a(d2, "TotalDataSize", Long.valueOf(currentTimeMillis));
            }
        } catch (Throwable th) {
            o.b(e, th.getMessage(), th);
        }
        return i;
    }

    private static int j() {
        try {
            Context d2 = com.anythink.expressad.foundation.b.a.b().d();
            long longValue = ((Long) v.b(d2, "FreeDataSize", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || j == -1) {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                j = Long.valueOf(((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1000) / 1000).intValue();
                v.a(d2, "FreeDataSize", Long.valueOf(currentTimeMillis));
            }
        } catch (Throwable th) {
            o.b(e, th.getMessage(), th);
        }
        return j;
    }

    private static long k() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    private static long l() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }
}
