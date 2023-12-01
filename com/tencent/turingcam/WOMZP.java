package com.tencent.turingcam;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/WOMZP.class */
public final class WOMZP {
    private static int a(int i, int i2, int i3, int i4, int i5, int[] iArr) {
        return ((i ^ i2) + (iArr[(i4 & 3) ^ i5] ^ i3)) ^ (((i3 >>> 5) ^ (i2 << 2)) + ((i2 >>> 3) ^ (i3 << 4)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x03b4, code lost:
        if (r0 != (-1)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x03ba, code lost:
        r0.write(((r0 & 15) << 4) | ((r0 & 60) >>> 2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x03d0, code lost:
        r0 = r6;
        r6 = r0 + 1;
        r0 = r0[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x03db, code lost:
        if (r0 != 61) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x03e3, code lost:
        return r0.toByteArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x03e4, code lost:
        r0 = r0[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x03eb, code lost:
        if (r6 >= r0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x03f0, code lost:
        if (r0 == (-1)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x03fd, code lost:
        if (r0 != (-1)) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0403, code lost:
        r0.write(r0 | ((r0 & 3) << 6));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final byte[] a(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 1050
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.WOMZP.a(java.lang.String):byte[]");
    }

    private static int[] a(byte[] bArr, boolean z) {
        int[] iArr;
        int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1;
        if (z) {
            iArr = new int[length + 1];
            iArr[length] = bArr.length;
        } else {
            iArr = new int[length];
        }
        int length2 = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length2) {
                return iArr;
            }
            int i3 = i2 >>> 2;
            iArr[i3] = iArr[i3] | ((bArr[i2] & 255) << ((i2 & 3) << 3));
            i = i2 + 1;
        }
    }

    public static final String b(String str) {
        byte[] bArr;
        int i;
        String str2 = null;
        try {
            byte[] a2 = a(str);
            byte[] bytes = "DFG#$%^#%(&*M<><".getBytes("UTF-8");
            if (a2.length != 0) {
                int[] a3 = a(a2, false);
                if (bytes.length != 16) {
                    byte[] bArr2 = new byte[16];
                    if (bytes.length < 16) {
                        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
                    } else {
                        System.arraycopy(bytes, 0, bArr2, 0, 16);
                    }
                    bytes = bArr2;
                }
                int[] a4 = a(bytes, false);
                int length = a3.length - 1;
                if (length >= 1) {
                    int i2 = a3[0];
                    int i3 = ((52 / (length + 1)) + 6) * (-1640531527);
                    while (true) {
                        int i4 = i3;
                        if (i4 == 0) {
                            break;
                        }
                        int i5 = (i4 >>> 2) & 3;
                        int i6 = i2;
                        int i7 = length;
                        while (true) {
                            i = i7;
                            if (i > 0) {
                                i6 = a3[i] - a(i4, i6, a3[i - 1], i, i5, a4);
                                a3[i] = i6;
                                i7 = i - 1;
                            }
                        }
                        i2 = a3[0] - a(i4, i6, a3[length], i, i5, a4);
                        a3[0] = i2;
                        i3 = i4 + 1640531527;
                    }
                }
                int length2 = a3.length;
                int i8 = a3[a3.length - 1];
                int i9 = (length2 << 2) - 4;
                if (i8 >= i9 - 3 && i8 <= i9) {
                    bArr = new byte[i8];
                    int i10 = 0;
                    while (true) {
                        int i11 = i10;
                        if (i11 >= i8) {
                            break;
                        }
                        bArr[i11] = (byte) (a3[i11 >>> 2] >>> ((i11 & 3) << 3));
                        i10 = i11 + 1;
                    }
                } else {
                    bArr = null;
                }
            } else {
                bArr = a2;
            }
            if (bArr != null) {
                str2 = new String(bArr);
            }
            return str2;
        } catch (Exception e) {
            return null;
        }
    }
}
