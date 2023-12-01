package com.blued.android.core.image.util;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Md5;
import java.io.File;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/util/FileUtils.class */
public class FileUtils {
    public static File a(String str) {
        File b = b(AppInfo.d());
        if (b != null) {
            File file = new File(b, "img");
            if (file.exists()) {
                File file2 = new File(file, Md5.a(str.toLowerCase().trim()));
                if (file2.exists()) {
                    return file2;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static String a(Context context) {
        File b = b(context);
        if (b != null) {
            File file = new File(b, "image");
            if (file.exists() || file.mkdirs()) {
                return file.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    private static File b(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        File file = externalFilesDir;
        if (externalFilesDir == null) {
            file = context.getCacheDir();
        }
        return file;
    }
}
