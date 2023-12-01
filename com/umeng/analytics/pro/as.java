package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/as.class */
public class as {
    public static void a(byte[] bArr, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2;
        try {
            gZIPOutputStream2 = new GZIPOutputStream(outputStream);
        } catch (Throwable th) {
            th = th;
            gZIPOutputStream = null;
        }
        try {
            gZIPOutputStream2.write(bArr);
            ap.a(gZIPOutputStream2);
        } catch (Throwable th2) {
            gZIPOutputStream = gZIPOutputStream2;
            th = th2;
            try {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "gzip error: " + th.getMessage());
                ap.a(gZIPOutputStream);
            } catch (Throwable th3) {
                ap.a(gZIPOutputStream);
                throw th3;
            }
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null) {
            if (bArr2.length != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bArr.length) {
                        break;
                    }
                    bArr[i2] = (byte) ((bArr[i2] ^ bArr2[i2 % bArr2.length]) ^ (i2 & 255));
                    i = i2 + 1;
                }
            } else {
                return bArr;
            }
        }
        return bArr;
    }

    public static void b(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read == -1) {
                    ap.a(gZIPInputStream);
                    return;
                }
                outputStream.write(bArr2, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "unGzip error: " + th.getMessage());
                ap.a(gZIPInputStream);
            } catch (Throwable th3) {
                ap.a(gZIPInputStream);
                throw th3;
            }
        }
    }
}
