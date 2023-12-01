package com.opos.cmn.b.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/b/c/a.class */
public final class a {
    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("GZipTool", "safeClose", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.Closeable] */
    private static boolean a(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        boolean z;
        if (inputStream == null || outputStream == null) {
            return false;
        }
        byte[] bArr = null;
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream, false);
                try {
                    bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (-1 == read) {
                            break;
                        }
                        gZIPOutputStream.write(bArr, 0, read);
                    }
                    gZIPOutputStream.finish();
                    gZIPOutputStream.flush();
                    z = true;
                    a(gZIPOutputStream);
                } catch (Exception e) {
                    e = e;
                    bArr = gZIPOutputStream;
                    com.opos.cmn.an.f.a.c("GZipTool", "compress", e);
                    z = false;
                    if (gZIPOutputStream != null) {
                        a(gZIPOutputStream);
                        z = false;
                    }
                    a(inputStream);
                    a(outputStream);
                    return z;
                } catch (Throwable th) {
                    bArr = gZIPOutputStream;
                    th = th;
                    if (bArr != null) {
                        a((Closeable) bArr);
                    }
                    a(inputStream);
                    a(outputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                gZIPOutputStream = null;
            }
            a(inputStream);
            a(outputStream);
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (a(byteArrayInputStream, byteArrayOutputStream)) {
                return byteArrayOutputStream.toByteArray();
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.Closeable] */
    private static boolean b(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        boolean z;
        if (inputStream == null || outputStream == null) {
            return false;
        }
        byte[] bArr = null;
        try {
            try {
                gZIPInputStream = new GZIPInputStream(inputStream);
                try {
                    bArr = new byte[4096];
                    while (true) {
                        int read = gZIPInputStream.read(bArr);
                        if (-1 == read) {
                            break;
                        }
                        outputStream.write(bArr, 0, read);
                    }
                    outputStream.flush();
                    z = true;
                    a(gZIPInputStream);
                } catch (Exception e) {
                    e = e;
                    bArr = gZIPInputStream;
                    com.opos.cmn.an.f.a.c("GZipTool", "decompress", e);
                    z = false;
                    if (gZIPInputStream != null) {
                        a(gZIPInputStream);
                        z = false;
                    }
                    a(inputStream);
                    a(outputStream);
                    return z;
                } catch (Throwable th) {
                    bArr = gZIPInputStream;
                    th = th;
                    if (bArr != null) {
                        a((Closeable) bArr);
                    }
                    a(inputStream);
                    a(outputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                gZIPInputStream = null;
            }
            a(inputStream);
            a(outputStream);
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] b(byte[] bArr) {
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (b(byteArrayInputStream, byteArrayOutputStream)) {
                return byteArrayOutputStream.toByteArray();
            }
            return null;
        }
        return null;
    }
}
