package com.alipay.sdk.encrypt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/encrypt/c.class */
public class c {
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(byte[] r5) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 193
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.encrypt.c.a(byte[]):byte[]");
    }

    public static byte[] b(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream2;
        Throwable th;
        try {
            ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream3);
                try {
                    byte[] bArr2 = new byte[4096];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = gZIPInputStream.read(bArr2, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayInputStream2 = byteArrayInputStream3;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e) {
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e2) {
                            }
                            try {
                                byteArrayInputStream2.close();
                            } catch (Exception e3) {
                            }
                            throw th;
                        }
                    }
                    byteArrayOutputStream2.flush();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e4) {
                    }
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e5) {
                    }
                    try {
                        byteArrayInputStream3.close();
                        return byteArray;
                    } catch (Exception e6) {
                        return byteArray;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayInputStream2 = byteArrayInputStream3;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th4) {
                byteArrayInputStream = byteArrayInputStream3;
                th = th4;
                Throwable th5 = th;
                gZIPInputStream = null;
                byteArrayOutputStream = null;
                byteArrayInputStream2 = byteArrayInputStream;
                th = th5;
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream2.close();
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayInputStream = null;
        }
    }
}
