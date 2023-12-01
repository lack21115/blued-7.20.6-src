package com.android.dex.util;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/util/FileUtils.class */
public final class FileUtils {
    private FileUtils() {
    }

    public static boolean hasArchiveSuffix(String str) {
        return str.endsWith(".zip") || str.endsWith(ShareConstants.JAR_SUFFIX) || str.endsWith(".apk");
    }

    public static byte[] readFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    long length = file.length();
                    int i = (int) length;
                    if (i != length) {
                        throw new RuntimeException(file + ": file too long");
                    }
                    byte[] bArr = new byte[i];
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        int i2 = 0;
                        while (i > 0) {
                            int read = fileInputStream.read(bArr, i2, i);
                            if (read == -1) {
                                throw new RuntimeException(file + ": unexpected EOF");
                            }
                            i2 += read;
                            i -= read;
                        }
                        fileInputStream.close();
                        return bArr;
                    } catch (IOException e) {
                        throw new RuntimeException(file + ": trouble reading", e);
                    }
                }
                throw new RuntimeException(file + ": file not readable");
            }
            throw new RuntimeException(file + ": not a file");
        }
        throw new RuntimeException(file + ": file not found");
    }

    public static byte[] readFile(String str) {
        return readFile(new File(str));
    }
}
