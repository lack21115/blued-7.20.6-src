package com.anythink.expressad.b;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f7118a;

    private a() {
    }

    private static a a() {
        if (f7118a == null) {
            synchronized (a.class) {
                try {
                    if (f7118a == null) {
                        f7118a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f7118a;
    }

    private void a(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                file.delete();
                return;
            } else {
                a(new File(listFiles[i2].getAbsolutePath()));
                i = i2 + 1;
            }
        }
    }

    private static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IOException("zipFilePath or destDirectory is null");
        }
        new c();
        c.a(str, str2);
    }
}
