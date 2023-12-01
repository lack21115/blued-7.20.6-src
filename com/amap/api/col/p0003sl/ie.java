package com.amap.api.col.p0003sl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;

/* renamed from: com.amap.api.col.3sl.ie  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ie.class */
public class ie {
    static final /* synthetic */ boolean a = !ie.class.desiredAssertionStatus();
    private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] f = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] g = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private ie() {
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, bArr.length);
        } catch (IOException e2) {
            if (!a) {
                throw new AssertionError(e2.getMessage());
            }
            str = null;
        }
        if (!a && str == null) {
            throw new AssertionError();
        }
        return str;
    }

    private static String a(byte[] bArr, int i) throws IOException {
        int i2;
        if (bArr != null) {
            if (i >= 0) {
                if (i + 0 <= bArr.length) {
                    int i3 = i / 3;
                    int i4 = 4;
                    if (i % 3 <= 0) {
                        i4 = 0;
                    }
                    int i5 = (i3 * 4) + i4;
                    byte[] bArr2 = new byte[i5];
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        i2 = i7;
                        if (i6 >= i - 2) {
                            break;
                        }
                        a(bArr, i6 + 0, 3, bArr2, i2);
                        i6 += 3;
                        i7 = i2 + 4;
                    }
                    int i8 = i2;
                    if (i6 < i) {
                        a(bArr, i6 + 0, i - i6, bArr2, i2);
                        i8 = i2 + 4;
                    }
                    byte[] bArr3 = bArr2;
                    if (i8 <= i5 - 1) {
                        bArr3 = new byte[i8];
                        System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, i8);
                    }
                    try {
                        return new String(bArr3, "US-ASCII");
                    } catch (UnsupportedEncodingException e2) {
                        return new String(bArr3);
                    }
                }
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", 0, Integer.valueOf(i), Integer.valueOf(bArr.length)));
            }
            throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(i)));
        }
        throw new NullPointerException("Cannot serialize a null array.");
    }

    public static byte[] a(String str) throws IOException {
        return b(str);
    }

    private static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3 = b;
        int i4 = 0;
        int i5 = i2 > 0 ? (bArr[i] << 24) >>> 8 : 0;
        int i6 = i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0;
        if (i2 > 2) {
            i4 = (bArr[i + 2] << 24) >>> 24;
        }
        int i7 = i5 | i6 | i4;
        if (i2 == 1) {
            bArr2[i3] = bArr3[i7 >>> 18];
            bArr2[i3 + 1] = bArr3[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = bArr3[i7 >>> 18];
            bArr2[i3 + 1] = bArr3[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = bArr3[i7 >>> 18];
            bArr2[i3 + 1] = bArr3[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = bArr3[i7 & 63];
            return bArr2;
        }
    }

    private static byte[] b(String str) throws IOException {
        byte[] bytes;
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayInputStream byteArrayInputStream3;
        GZIPInputStream gZIPInputStream2;
        if (str != null) {
            try {
                bytes = str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException e2) {
                bytes = str.getBytes();
            }
            byte[] b2 = b(bytes, bytes.length);
            if (b2.length < 4 || 35615 != ((b2[0] & 255) | ((b2[1] << 8) & 65280))) {
                return b2;
            }
            byte[] bArr = new byte[2048];
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byteArrayInputStream2 = new ByteArrayInputStream(b2);
                        try {
                            gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
                            while (true) {
                                try {
                                    int read = gZIPInputStream.read(bArr);
                                    if (read < 0) {
                                        break;
                                    }
                                    byteArrayOutputStream2.write(bArr, 0, read);
                                } catch (IOException e3) {
                                    e = e3;
                                    e = e;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    try {
                                        e.printStackTrace();
                                        byteArrayInputStream3 = byteArrayInputStream2;
                                        gZIPInputStream2 = gZIPInputStream;
                                        byteArrayOutputStream.close();
                                        bArr = b2;
                                        gZIPInputStream.close();
                                        byteArrayInputStream2.close();
                                        return bArr;
                                    } catch (Throwable th) {
                                        th = th;
                                        byteArrayInputStream = byteArrayInputStream2;
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception e4) {
                                        }
                                        try {
                                            gZIPInputStream.close();
                                        } catch (Exception e5) {
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                        } catch (Exception e6) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    byteArrayInputStream = byteArrayInputStream2;
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    th = th;
                                    byteArrayOutputStream.close();
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    throw th;
                                }
                            }
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            byteArrayInputStream3 = byteArrayInputStream2;
                            gZIPInputStream2 = gZIPInputStream;
                            byteArrayOutputStream2.close();
                            bArr = byteArray;
                        } catch (IOException e7) {
                            e = e7;
                            gZIPInputStream = null;
                        } catch (Throwable th3) {
                            gZIPInputStream = null;
                            byteArrayInputStream = byteArrayInputStream2;
                            th = th3;
                        }
                    } catch (IOException e8) {
                        e = e8;
                        byteArrayInputStream2 = null;
                        gZIPInputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    }
                } catch (IOException e9) {
                    e = e9;
                    byteArrayInputStream2 = null;
                    gZIPInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayInputStream = null;
                    gZIPInputStream = null;
                    byteArrayOutputStream = null;
                }
            } catch (Exception e10) {
                byteArrayInputStream2 = byteArrayInputStream3;
                gZIPInputStream = gZIPInputStream2;
            }
            try {
                gZIPInputStream.close();
            } catch (Exception e11) {
            }
            try {
                byteArrayInputStream2.close();
                return bArr;
            } catch (Exception e12) {
                return bArr;
            }
        }
        throw new NullPointerException("Input string was null.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x01d9, code lost:
        r0 = new byte[r11];
        java.lang.System.arraycopy((java.lang.Object) r0, 0, (java.lang.Object) r0, 0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01e7, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] b(byte[] r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ie.b(byte[], int):byte[]");
    }
}
