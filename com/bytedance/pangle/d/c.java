package com.bytedance.pangle.d;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.g;
import com.bytedance.pangle.util.i;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/d/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static File f21370a;
    private static File b;

    /* renamed from: c  reason: collision with root package name */
    private static File f21371c;

    public static String a() {
        Application appApplication = Zeus.getAppApplication();
        if (b == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            File file = downloadDir;
            if (downloadDir == null) {
                File filesDir = appApplication.getFilesDir();
                file = new File(filesDir, ".pangle" + g.b);
            }
            b = file;
        }
        return a(b);
    }

    private static String a(File file) {
        if (file != null) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
        return null;
    }

    public static String a(String str) {
        return a(str);
    }

    public static String a(String str, int i) {
        d();
        File file = f21370a;
        String concat = "version-".concat(String.valueOf(i));
        int i2 = 0;
        while (i2 < 2) {
            String str2 = new String[]{str, concat}[i2];
            File file2 = file;
            if (!TextUtils.isEmpty(str2)) {
                file2 = new File(file, str2);
            }
            i2++;
            file = file2;
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    private static String a(String... strArr) {
        d();
        File file = f21370a;
        File file2 = file;
        if (strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                file2 = file;
                if (i >= length) {
                    break;
                }
                String str = strArr[i];
                File file3 = file;
                if (!TextUtils.isEmpty(str)) {
                    file3 = new File(file, str);
                }
                i++;
                file = file3;
            }
        }
        return a(file2);
    }

    public static String b() {
        Application appApplication = Zeus.getAppApplication();
        if (f21371c == null) {
            File filesDir = appApplication.getFilesDir();
            f21371c = new File(filesDir, ".pangle" + g.f21406a);
        }
        return a(f21371c);
    }

    public static String b(String str, int i) {
        return new File(a(str, "version-".concat(String.valueOf(i)), "apk"), "base-1.apk").getPath();
    }

    public static String c() {
        Application appApplication = Zeus.getAppApplication();
        try {
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                File externalFilesDir = appApplication.getExternalFilesDir(".pangle" + g.b);
                if (externalFilesDir != null) {
                    return a(externalFilesDir);
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(String str, int i) {
        return i.h() ? a(str, "version-".concat(String.valueOf(i)), "apk", ShareConstants.ANDROID_O_DEX_OPTIMIZE_PATH, com.bytedance.pangle.e.b.a()) : a(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String d(String str, int i) {
        return a(str, "version-".concat(String.valueOf(i)), "lib");
    }

    private static void d() {
        if (f21370a == null) {
            File filesDir = Zeus.getAppApplication().getFilesDir();
            File file = new File(filesDir, "pangle" + g.f21407c);
            f21370a = file;
            a(file);
        }
    }

    public static String e(String str, int i) {
        return new File(a(str, "version-".concat(String.valueOf(i)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String f(String str, int i) {
        return new File(a(str, "version-".concat(String.valueOf(i)), "apk")).getPath();
    }

    public static String g(String str, int i) {
        return new File(a(str, "version-".concat(String.valueOf(i)), "apk", "temp")).getPath();
    }

    public static String h(String str, int i) {
        return i.h() ? a(str, "version-".concat(String.valueOf(i)), "apk", "temp", ShareConstants.ANDROID_O_DEX_OPTIMIZE_PATH, com.bytedance.pangle.e.b.a()) : a(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String i(String str, int i) {
        return a(str, "version-".concat(String.valueOf(i)), "secondary-dexes");
    }
}
