package com.tencent.tinker.android.dex.util;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/util/FileUtils.class */
public final class FileUtils {
    private FileUtils() {
    }

    public static boolean hasArchiveSuffix(String str) {
        return str.endsWith(".zip") || str.endsWith(ShareConstants.JAR_SUFFIX) || str.endsWith(".apk");
    }

    public static byte[] readFile(File file) throws IOException {
        if (!file.exists()) {
            throw new RuntimeException(file + ": file not found");
        } else if (!file.isFile()) {
            throw new RuntimeException(file + ": not a file");
        } else if (!file.canRead()) {
            throw new RuntimeException(file + ": file not readable");
        } else {
            long length = file.length();
            int i = (int) length;
            if (i != length) {
                throw new RuntimeException(file + ": file too long");
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
            BufferedInputStream bufferedInputStream = null;
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr);
                        if (read > 0) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (Exception e) {
                            }
                        }
                    }
                    bufferedInputStream2.close();
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    bufferedInputStream = bufferedInputStream2;
                    th = th;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static byte[] readFile(String str) throws IOException {
        return readFile(new File(str));
    }

    public static byte[] readStream(InputStream inputStream) throws IOException {
        return readStream(inputStream, 32768);
    }

    public static byte[] readStream(InputStream inputStream, int i) throws IOException {
        int i2 = i;
        if (i <= 0) {
            i2 = 32768;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
