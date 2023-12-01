package com.tencent.tinker.commons.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/util/DigestUtil.class */
public final class DigestUtil {
    private DigestUtil() {
        throw new UnsupportedOperationException();
    }

    public static long getCRC32(File file) throws IOException {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                long crc32 = getCRC32(bufferedInputStream);
                IOHelper.closeQuietly(bufferedInputStream);
                return crc32;
            } catch (Throwable th) {
                th = th;
                IOHelper.closeQuietly(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    public static long getCRC32(InputStream inputStream) throws IOException {
        CRC32 crc32 = new CRC32();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return crc32.getValue();
            }
            crc32.update(bArr, 0, read);
        }
    }

    public static long getCRC32(byte[] bArr, int i, int i2) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i, i2);
        return crc32.getValue();
    }
}
