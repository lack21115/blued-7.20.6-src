package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/r.class */
final class r {
    public static boolean a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().equals(s.getFileMD5(file).toLowerCase());
    }

    public static boolean f(File file) {
        return file != null && file.exists() && file.length() > 0 && file.getName().endsWith(".apk");
    }
}
