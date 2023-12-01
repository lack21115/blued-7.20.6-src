package com.ss.android.downloadlib.utils;

import java.io.File;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/u.class */
public class u {
    public static long mb(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return mb(file, file.lastModified(), 0);
    }

    private static long mb(File file, long j, int i) {
        long j2 = j;
        if (file != null) {
            if (!file.exists()) {
                return j;
            }
            long max = Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 >= 50) {
                return max;
            }
            j2 = max;
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                j2 = max;
                if (listFiles != null) {
                    int length = listFiles.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        j2 = max;
                        if (i4 >= length) {
                            break;
                        }
                        max = Math.max(max, mb(listFiles[i4], max, i2));
                        i3 = i4 + 1;
                    }
                }
            }
        }
        return j2;
    }
}
