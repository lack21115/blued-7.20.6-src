package com.anythink.china.common.c;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.anythink.china.common.d;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.f;
import java.io.File;
import java.util.UUID;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/c/b.class */
public final class b {
    private static final String a = "anythink_myoffer_download";

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
        File file = null;
        if (e() == null) {
            return null;
        }
        File file2 = null;
        if (Build.VERSION.SDK_INT >= 18) {
            file2 = null;
            try {
                File externalFilesDir = e().getExternalFilesDir(null);
                file2 = null;
                if (externalFilesDir != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(UUID.randomUUID());
                    File file3 = new File(externalFilesDir, sb.toString());
                    if (file3.exists()) {
                        file3.delete();
                    }
                    if (file3.mkdirs()) {
                        file3.delete();
                        file = externalFilesDir.getAbsoluteFile();
                    }
                    file2 = file;
                    if (file != null) {
                        file2 = file;
                        file2 = new File(file, a);
                    }
                }
            } catch (Throwable th) {
            }
        }
        File file4 = file2;
        if (file2 == null) {
            file4 = new File(e().getFilesDir().getAbsoluteFile() + File.separator + a);
        }
        return file4.getAbsolutePath();
    }

    public static String a(String str) {
        String a2 = a();
        if (a2 != null) {
            return a2 + File.separator + f.a(str);
        }
        return null;
    }

    private static String b(String str) {
        return f.a(str);
    }

    private static boolean b() {
        return c() > 104857600;
    }

    private static long c() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
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

    private static long d() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Error e) {
            return 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    private static Context e() {
        try {
            return n.a().g().getApplicationContext();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean f() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static boolean g() {
        Context e = e();
        if (e == null) {
            return false;
        }
        try {
            return e.getPackageManager().checkPermission(d.b, e.getPackageName()) == 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
