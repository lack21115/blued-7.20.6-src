package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Build;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/y.class */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8974a = "dl_FileUtil";

    public static String a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getDataDir().getAbsolutePath();
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        int lastIndexOf = absolutePath.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? absolutePath : absolutePath.substring(0, lastIndexOf);
    }

    public static boolean a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e) {
            aa.d(f8974a, "makeDirectory Exception: " + e.getMessage());
            return false;
        }
    }

    public static boolean b(String str) {
        boolean z;
        boolean z2 = true;
        try {
            File file = new File(str);
            String[] list = file.list();
            if (file.isDirectory() && list != null && list.length > 0) {
                int length = list.length;
                int i = 0;
                boolean z3 = true;
                while (true) {
                    z2 = z3;
                    if (i >= length) {
                        break;
                    }
                    String str2 = list[i];
                    if (z3) {
                        z2 = z3;
                        try {
                            StringBuilder sb = new StringBuilder();
                            boolean z4 = z3;
                            sb.append(str);
                            boolean z5 = z3;
                            sb.append(File.separator);
                            boolean z6 = z3;
                            sb.append(str2);
                            boolean z7 = z3;
                            if (b(sb.toString())) {
                                z = true;
                                z3 = z;
                                i++;
                            }
                        } catch (Throwable th) {
                            th = th;
                            aa.b(f8974a, " delete err: " + th.getClass().getSimpleName());
                            return z2;
                        }
                    }
                    z = false;
                    z3 = z;
                    i++;
                }
            } else {
                z2 = true;
            }
            if (z2) {
                return file.delete();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? str : str.substring(0, lastIndexOf);
    }
}
