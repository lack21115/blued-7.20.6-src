package com.qiniu.android.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/Crc32.class */
public final class Crc32 {
    public static long bytes(byte[] bArr) {
        return bytes(bArr, 0, bArr.length);
    }

    public static long bytes(byte[] bArr, int i, int i2) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i, i2);
        return crc32.getValue();
    }

    public static long file(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[65536];
        CRC32 crc32 = new CRC32();
        while (true) {
            try {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                fileInputStream.close();
            }
        }
        return crc32.getValue();
    }
}
