package com.tencent.tendinsv.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/a/c.class */
class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f25300a = "ulucu_huidian";
    private static final String b = "database";
    private static Context d;

    /* renamed from: c  reason: collision with root package name */
    private static final String f25301c = File.separator;
    private static File e = null;

    c() {
    }

    public static File a() {
        if (e == null) {
            Context context = d;
            e = a(context, b() + f25301c + "database");
        }
        return e;
    }

    private static File a(Context context, String str) {
        File file = !Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ? new File(context.getCacheDir(), str) : new File(Environment.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File a(File file, String str) {
        File file2 = new File(file, str);
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return file2;
        }
    }

    public static void a(Context context) {
        d = context;
    }

    private static String b() {
        return d != null ? "chuanglan" : f25300a;
    }
}
