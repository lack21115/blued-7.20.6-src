package com.zx.a.I8b7;

import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/f0.class */
public class f0 {
    public static void a(File file) {
        File[] listFiles = file.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            File file2 = listFiles[i2];
            if (file2.isDirectory()) {
                a(new File(file2.getPath()));
            } else {
                file2.delete();
            }
            i = i2 + 1;
        }
        if (file.listFiles().length <= 0) {
            file.delete();
        }
    }
}
