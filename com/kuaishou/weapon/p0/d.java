package com.kuaishou.weapon.p0;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/d.class */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f10206a = 2048;
    public static final String b = ".gz";

    public static void a(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr, 0, 2048);
                    if (read == -1) {
                        gZIPOutputStream2.flush();
                        gZIPOutputStream2.finish();
                        gZIPOutputStream2.close();
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Throwable th2) {
            gZIPOutputStream = null;
        }
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                bArr2 = null;
                try {
                    a(byteArrayInputStream, byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    bArr2 = byteArray;
                    byteArrayInputStream.close();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e) {
                    }
                    try {
                        byteArrayInputStream.close();
                        return byteArray;
                    } catch (Exception e2) {
                        return byteArray;
                    }
                } catch (Throwable th) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    return bArr2;
                }
            } catch (Throwable th2) {
                bArr2 = null;
            }
        } catch (Throwable th3) {
            bArr2 = null;
            byteArrayInputStream = null;
        }
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2;
        try {
            gZIPInputStream2 = new GZIPInputStream(inputStream);
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = gZIPInputStream2.read(bArr, 0, 2048);
                    if (read == -1) {
                        gZIPInputStream2.close();
                        try {
                            gZIPInputStream2.close();
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    outputStream.write(bArr, 0, read);
                }
            } catch (Exception e2) {
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (Exception e3) {
                    }
                }
            } catch (Throwable th) {
                gZIPInputStream = gZIPInputStream2;
                th = th;
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            gZIPInputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream = null;
        }
    }

    public static byte[] b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                byte[] bArr2 = bArr;
                try {
                    b(byteArrayInputStream, byteArrayOutputStream2);
                    bArr = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    bArr2 = bArr;
                    byteArrayInputStream.close();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e) {
                    }
                } catch (Throwable th) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    bArr = bArr2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    if (byteArrayInputStream == null) {
                        return bArr;
                    }
                    byteArrayInputStream.close();
                    return bArr;
                }
            } catch (Throwable th2) {
            }
        } catch (Throwable th3) {
            byteArrayInputStream = null;
        }
        try {
            byteArrayInputStream.close();
            return bArr;
        } catch (Exception e3) {
            return bArr;
        }
    }
}
