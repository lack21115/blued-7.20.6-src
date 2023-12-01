package com.efs.sdk.base.core.util;

import android.content.ContentResolver;
import android.content.Context;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f21786a = "efs";
    private static File b;

    public static File a(Context context) {
        File dir = context.getDir(f21786a, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    public static File a(Context context, String str) {
        return new File(g(context, str), "efs_cst");
    }

    public static void a(String str) {
        f21786a = str;
    }

    public static File b(Context context, String str) {
        return new File(g(context, str), "efs_config");
    }

    public static File c(Context context, String str) {
        return new File(g(context, str), "efs_flow");
    }

    public static File d(Context context, String str) {
        File file = new File(g(context, str), "ready");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File e(Context context, String str) {
        File file = new File(d(context, str), String.valueOf(ProcessUtil.myPid()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File f(Context context, String str) {
        File file = new File(g(context, str), ContentResolver.SYNC_EXTRAS_UPLOAD);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File g(Context context, String str) {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        b = a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        File file = new File(b, str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
