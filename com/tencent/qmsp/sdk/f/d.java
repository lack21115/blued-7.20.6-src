package com.tencent.qmsp.sdk.f;

import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/f/d.class */
public class d {
    public static void a(String str, boolean z) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                a(listFiles[i2].getAbsolutePath(), z);
                i = i2 + 1;
            }
            if (z) {
                return;
            }
            file.delete();
        }
    }
}
