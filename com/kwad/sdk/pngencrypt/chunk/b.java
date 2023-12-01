package com.kwad.sdk.pngencrypt.chunk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/b.class */
public final class b {
    public static final byte[] awz = el("IHDR");
    public static final byte[] awA = el("PLTE");
    public static final byte[] awB = el("IDAT");
    public static final byte[] awC = el("IEND");
    private static byte[] awD = new byte[4096];
    public static Pattern awE = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");

    public static List<PngChunk> a(List<PngChunk> list, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (PngChunk pngChunk : list) {
            if (cVar.a(pngChunk)) {
                arrayList.add(pngChunk);
            }
        }
        return arrayList;
    }

    public static byte[] b(byte[] bArr, int i, int i2, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayInputStream byteArrayInputStream;
        InflaterInputStream inflaterInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            try {
                InflaterInputStream inflaterInputStream2 = new InflaterInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        i(inflaterInputStream2, byteArrayOutputStream2);
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                        return byteArray;
                    } catch (Exception e) {
                        e = e;
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        try {
                            com.kwad.sdk.core.d.b.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                            return new byte[0];
                        } catch (Throwable th) {
                            th = th;
                            com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream2 = null;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
                inflaterInputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
            inflaterInputStream = null;
        }
    }

    public static String d(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.awh);
    }

    public static String e(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.awi);
    }

    public static byte[] el(String str) {
        return str.getBytes(com.kwad.sdk.pngencrypt.n.awh);
    }

    public static boolean em(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    public static boolean en(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    public static boolean eo(String str) {
        return !Character.isUpperCase(str.charAt(3));
    }

    public static String i(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.awh);
    }

    public static String i(byte[] bArr, int i) {
        return (bArr == null || bArr.length < 8) ? "?" : d(bArr, 4, 4);
    }

    private static void i(InputStream inputStream, OutputStream outputStream) {
        synchronized (awD) {
            while (true) {
                int read = inputStream.read(awD);
                if (read > 0) {
                    outputStream.write(awD, 0, read);
                }
            }
        }
    }

    public static String j(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.awi);
    }
}
