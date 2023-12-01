package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/h.class */
public final class h {
    private static File ZB;

    private static File ar(Context context) {
        if (ZB == null) {
            ZB = d(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return ZB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                c(listFiles[i2]);
                i = i2 + 1;
            }
        }
        file.delete();
    }

    private static File d(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if ((!file.exists() || !file.isDirectory()) && com.kwad.sdk.api.a.bI.booleanValue()) {
            throw new RuntimeException("Can not ensureDir:" + file);
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(File file) {
        try {
            c(file);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File k(Context context, String str) {
        File ar2 = ar(context);
        return new File(ar2, "dynamic-" + System.currentTimeMillis() + "-" + str + ".apk");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(Context context, String str) {
        File ar2 = ar(context);
        return d(new File(ar2, "apk-" + str)).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File m(Context context, String str) {
        File ar2 = ar(context);
        return d(new File(ar2, "apk-" + str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String n(Context context, String str) {
        return new File(l(context, str), "dynamic.apk").getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String o(Context context, String str) {
        return d(new File(l(context, str), ShareConstants.DEX_PATH)).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String p(Context context, String str) {
        return d(new File(l(context, str), "libs")).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void q(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.api.kwai.a.submit(new Runnable() { // from class: com.kwad.sdk.api.loader.h.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    File[] listFiles = h.m(Context.this, str).getParentFile().listFiles();
                    if (listFiles == null || listFiles.length <= 0) {
                        return;
                    }
                    int length = listFiles.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            return;
                        }
                        File file = listFiles[i2];
                        if (g.q(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                            h.c(file);
                        }
                        i = i2 + 1;
                    }
                } catch (Exception e) {
                }
            }
        });
    }
}
