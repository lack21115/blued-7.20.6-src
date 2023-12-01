package com.blued.android.framework.utils;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import java.io.File;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/UriUtils.class */
public class UriUtils {
    public static Uri a(File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(AppUtils.a(), AppUtils.a().getPackageName() + ".fileprovider", file);
    }

    public static Uri a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(new File(str));
    }
}
