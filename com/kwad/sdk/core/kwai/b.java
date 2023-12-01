package com.kwad.sdk.core.kwai;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/kwai/b.class */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static byte[] a(String str, byte[] bArr) {
        return a(str.getBytes(UTF_8), bArr, 2);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, int i) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(i, secretKeySpec);
            return cipher.doFinal(bArr2);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            return new byte[0];
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, 1);
    }

    private static void e(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2;
        try {
            gZIPOutputStream2 = new GZIPOutputStream(outputStream);
        } catch (Throwable th) {
            th = th;
            gZIPOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    gZIPOutputStream2.finish();
                    gZIPOutputStream2.flush();
                    com.kwad.sdk.crash.utils.b.closeQuietly(gZIPOutputStream2);
                    return;
                }
                gZIPOutputStream2.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            gZIPOutputStream = gZIPOutputStream2;
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(gZIPOutputStream);
            throw th;
        }
    }

    private static void f(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        try {
            gZIPInputStream = new GZIPInputStream(inputStream);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(gZIPInputStream);
                        return;
                    }
                    outputStream.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(gZIPInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream = null;
        }
    }

    public static byte[] f(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                e(byteArrayInputStream, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] g(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                f(byteArrayInputStream, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
            byteArrayOutputStream = null;
        }
    }
}
