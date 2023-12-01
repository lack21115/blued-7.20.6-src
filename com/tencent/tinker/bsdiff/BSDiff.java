package com.tencent.tinker.bsdiff;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/bsdiff/BSDiff.class */
public class BSDiff {
    private static final byte[] MAGIC_BYTES = {77, 105, 99, 114, 111, 77, 115, 103};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.tinker.bsdiff.BSDiff$1EmuStackFrame  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/bsdiff/BSDiff$1EmuStackFrame.class */
    public class C1EmuStackFrame {
        int h;
        int len;
        int start;
        int stmRetLabel;
        int i = 0;
        int j = 0;
        int k = 0;
        int x = 0;
        int jj = 0;
        int kk = 0;

        C1EmuStackFrame(int i, int i2, int i3, int i4) {
            this.stmRetLabel = i;
            this.start = i2;
            this.len = i3;
            this.h = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/bsdiff/BSDiff$IntByRef.class */
    public static class IntByRef {
        private int value;

        private IntByRef() {
        }
    }

    public static void bsdiff(File file, File file2, File file3) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
        FileOutputStream fileOutputStream = new FileOutputStream(file3);
        try {
            fileOutputStream.write(bsdiff(bufferedInputStream, (int) file.length(), bufferedInputStream2, (int) file2.length()));
        } finally {
            fileOutputStream.close();
        }
    }

    public static byte[] bsdiff(InputStream inputStream, int i, InputStream inputStream2, int i2) throws IOException {
        byte[] bArr = new byte[i];
        BSUtil.readFromStream(inputStream, bArr, 0, i);
        inputStream.close();
        byte[] bArr2 = new byte[i2];
        BSUtil.readFromStream(inputStream2, bArr2, 0, i2);
        inputStream2.close();
        return bsdiff(bArr, i, bArr2, i2);
    }

    public static byte[] bsdiff(byte[] bArr, int i, byte[] bArr2, int i2) throws IOException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = i;
        int i11 = i10 + 1;
        int[] iArr = new int[i11];
        qsufsort(iArr, new int[i11], bArr, i10);
        byte[] bArr3 = new byte[i2];
        byte[] bArr4 = new byte[i2];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.write(MAGIC_BYTES);
        dataOutputStream.writeLong(-1L);
        dataOutputStream.writeLong(-1L);
        long j = i2;
        dataOutputStream.writeLong(j);
        dataOutputStream.flush();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(dataOutputStream);
        DataOutputStream dataOutputStream2 = new DataOutputStream(gZIPOutputStream);
        IntByRef intByRef = new IntByRef();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i12 < i2) {
            int i19 = i12 + i15;
            int i20 = i15;
            int i21 = 0;
            int i22 = i19;
            while (true) {
                if (i19 >= i2) {
                    i3 = i21;
                    i15 = i20;
                    break;
                }
                IntByRef intByRef2 = intByRef;
                int search = search(iArr, bArr, i, bArr2, i2, i19, 0, i, intByRef2);
                int i23 = i22;
                int i24 = i19;
                while (true) {
                    i9 = i21;
                    if (i23 >= i24 + search) {
                        break;
                    }
                    int i25 = i23 + i16;
                    i21 = i9;
                    if (i25 < i10) {
                        i21 = i9;
                        if (bArr[i25] == bArr2[i23]) {
                            i21 = i9 + 1;
                        }
                    }
                    i23++;
                }
                if (search == i9) {
                    i15 = search;
                    i3 = i9;
                    if (search != 0) {
                        break;
                    }
                }
                if (search > i9 + 8) {
                    i15 = search;
                    i3 = i9;
                    break;
                }
                int i26 = i24 + i16;
                i21 = i9;
                if (i26 < i10) {
                    i21 = i9;
                    if (bArr[i26] == bArr2[i24]) {
                        i21 = i9 - 1;
                    }
                }
                i22 = i23;
                i19 = i24 + 1;
                intByRef = intByRef2;
                i20 = search;
            }
            int i27 = i13;
            int i28 = i19;
            if (i15 != i3 || i28 == i2) {
                int i29 = 0;
                int i30 = 0;
                int i31 = 0;
                int i32 = 0;
                while (true) {
                    int i33 = i17 + i30;
                    if (i33 >= i28 || (i8 = i18 + i30) >= i10) {
                        break;
                    }
                    int i34 = i29;
                    if (bArr[i8] == bArr2[i33]) {
                        i34 = i29 + 1;
                    }
                    int i35 = i30 + 1;
                    i29 = i34;
                    i30 = i35;
                    if ((i34 * 2) - i35 > (i31 * 2) - i32) {
                        i31 = i34;
                        i32 = i35;
                        i29 = i34;
                        i30 = i35;
                    }
                }
                if (i28 < i2) {
                    int i36 = 1;
                    int i37 = 0;
                    int i38 = 0;
                    int i39 = 0;
                    while (true) {
                        int i40 = i39;
                        i4 = i37;
                        if (i28 < i17 + i36) {
                            break;
                        }
                        i4 = i37;
                        if (intByRef.value < i36) {
                            break;
                        }
                        int i41 = i38;
                        if (bArr[intByRef.value - i36] == bArr2[i28 - i36]) {
                            i41 = i38 + 1;
                        }
                        int i42 = i37;
                        int i43 = i40;
                        if ((i41 * 2) - i36 > (i40 * 2) - i37) {
                            i42 = i36;
                            i43 = i41;
                        }
                        i36++;
                        i37 = i42;
                        i38 = i41;
                        i39 = i43;
                    }
                } else {
                    i4 = 0;
                }
                int i44 = i17 + i32;
                int i45 = i28 - i4;
                if (i44 > i45) {
                    int i46 = i44 - i45;
                    int i47 = 0;
                    int i48 = 0;
                    int i49 = 0;
                    int i50 = 0;
                    while (i48 < i46) {
                        int i51 = i50;
                        if (bArr2[(i44 - i46) + i48] == bArr[((i18 + i32) - i46) + i48]) {
                            i51 = i50 + 1;
                        }
                        i50 = i51;
                        if (bArr2[i45 + i48] == bArr[(intByRef.value - i4) + i48]) {
                            i50 = i51 - 1;
                        }
                        int i52 = i47;
                        if (i50 > i47) {
                            i49 = i48 + 1;
                            i52 = i50;
                        }
                        i48++;
                        i47 = i52;
                    }
                    i32 += i49 - i46;
                    i4 -= i49;
                }
                int i53 = 0;
                while (true) {
                    int i54 = i53;
                    if (i54 >= i32) {
                        break;
                    }
                    bArr3[i27 + i54] = (byte) (bArr2[i17 + i54] - bArr[i18 + i54]);
                    i53 = i54 + 1;
                }
                int i55 = 0;
                while (true) {
                    int i56 = i55;
                    i5 = i28 - i4;
                    int i57 = i17 + i32;
                    i6 = i5 - i57;
                    if (i56 >= i6) {
                        break;
                    }
                    bArr4[i14 + i56] = bArr2[i57 + i56];
                    i55 = i56 + 1;
                }
                i14 += i6;
                dataOutputStream2.writeInt(i32);
                dataOutputStream2.writeInt(i6);
                dataOutputStream2.writeInt((intByRef.value - i4) - (i18 + i32));
                i18 = intByRef.value - i4;
                i10 = i;
                i17 = i5;
                i16 = intByRef.value - i28;
                i7 = i27 + i32;
            } else {
                i7 = i27;
            }
            i13 = i7;
            i12 = i28;
        }
        dataOutputStream2.flush();
        gZIPOutputStream.finish();
        int size = dataOutputStream.size() - 32;
        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(dataOutputStream);
        gZIPOutputStream2.write(bArr3, 0, i13);
        gZIPOutputStream2.finish();
        gZIPOutputStream2.flush();
        int size2 = dataOutputStream.size();
        GZIPOutputStream gZIPOutputStream3 = new GZIPOutputStream(dataOutputStream);
        gZIPOutputStream3.write(bArr4, 0, i14);
        gZIPOutputStream3.finish();
        gZIPOutputStream3.flush();
        dataOutputStream.close();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(32);
        DataOutputStream dataOutputStream3 = new DataOutputStream(byteArrayOutputStream2);
        dataOutputStream3.write(MAGIC_BYTES);
        dataOutputStream3.writeLong(size);
        dataOutputStream3.writeLong((size2 - size) - 32);
        dataOutputStream3.writeLong(j);
        dataOutputStream3.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
        System.arraycopy(byteArray2, 0, byteArray, 0, byteArray2.length);
        return byteArray;
    }

    public static void main(String[] strArr) throws IOException {
        bsdiff(new File("/Users/tomystang/bsdiff-test/old/classes.dex"), new File("/Users/tomystang/bsdiff-test/new/classes.dex"), new File("/Users/tomystang/bsdiff-test/test_bsdiff.diff"));
    }

    private static int matchlen(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int min = Math.min(i - i2, i3 - i4);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= min) {
                return min;
            }
            if (bArr[i2 + i6] != bArr2[i4 + i6]) {
                return i6;
            }
            i5 = i6 + 1;
        }
    }

    private static int memcmp(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = i - i2;
        int i6 = i3 - i4;
        int i7 = i5;
        if (i5 > i6) {
            i7 = i6;
        }
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= i7) {
                return 0;
            }
            int i10 = i9 + i2;
            byte b = bArr[i10];
            int i11 = i9 + i4;
            if (b != bArr2[i11]) {
                return bArr[i10] < bArr2[i11] ? -1 : 1;
            }
            i8 = i9 + 1;
        }
    }

    private static void qsufsort(int[] iArr, int[] iArr2, byte[] bArr, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr3 = new int[256];
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= i) {
                break;
            }
            int i8 = 255 & bArr[i7];
            iArr3[i8] = iArr3[i8] + 1;
            i6 = i7 + 1;
        }
        int i9 = 1;
        while (true) {
            int i10 = i9;
            if (i10 >= 256) {
                break;
            }
            iArr3[i10] = iArr3[i10] + iArr3[i10 - 1];
            i9 = i10 + 1;
        }
        int i11 = 255;
        while (true) {
            int i12 = i11;
            if (i12 <= 0) {
                break;
            }
            iArr3[i12] = iArr3[i12 - 1];
            i11 = i12 - 1;
        }
        iArr3[0] = 0;
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 >= i) {
                break;
            }
            int i15 = bArr[i14] & 255;
            int i16 = iArr3[i15] + 1;
            iArr3[i15] = i16;
            iArr[i16] = i14;
            i13 = i14 + 1;
        }
        iArr[0] = i;
        int i17 = 0;
        while (true) {
            int i18 = i17;
            if (i18 >= i) {
                break;
            }
            iArr2[i18] = iArr3[bArr[i18] & 255];
            i17 = i18 + 1;
        }
        iArr2[i] = 0;
        int i19 = 1;
        while (true) {
            int i20 = i19;
            if (i20 >= 256) {
                break;
            }
            if (iArr3[i20] == iArr3[i20 - 1] + 1) {
                iArr[iArr3[i20]] = -1;
            }
            i19 = i20 + 1;
        }
        iArr[0] = -1;
        int i21 = 1;
        while (true) {
            int i22 = i21;
            i2 = i + 1;
            if (iArr[0] == (-i2)) {
                break;
            }
            int i23 = 0;
            while (true) {
                i4 = i23;
                i5 = 0;
                while (i4 < i2) {
                    if (iArr[i4] < 0) {
                        i5 -= iArr[i4];
                        i4 -= iArr[i4];
                    } else {
                        if (i5 != 0) {
                            iArr[i4 - i5] = -i5;
                        }
                        int i24 = (iArr2[iArr[i4]] + 1) - i4;
                        split(iArr, iArr2, i4, i24, i22);
                        i23 = i4 + i24;
                    }
                }
                break;
            }
            if (i5 != 0) {
                iArr[i4 - i5] = -i5;
            }
            i21 = i22 + i22;
        }
        for (i3 = 0; i3 < i2; i3++) {
            iArr[iArr2[i3]] = i3;
        }
    }

    private static int search(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, IntByRef intByRef) {
        int i6 = i5 - i4;
        if (i6 >= 2) {
            int i7 = i4 + (i6 / 2);
            return memcmp(bArr, i, iArr[i7], bArr2, i2, i3) < 0 ? search(iArr, bArr, i, bArr2, i2, i3, i7, i5, intByRef) : search(iArr, bArr, i, bArr2, i2, i3, i4, i7, intByRef);
        }
        int matchlen = matchlen(bArr, i, iArr[i4], bArr2, i2, i3);
        int matchlen2 = matchlen(bArr, i, iArr[i5], bArr2, i2, i3);
        if (matchlen > matchlen2) {
            intByRef.value = iArr[i4];
            return matchlen;
        }
        intByRef.value = iArr[i5];
        return matchlen2;
    }

    private static void split(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        Stack stack = new Stack();
        stack.push(new C1EmuStackFrame(2, i, i2, i3));
        while (true) {
            int i4 = 0;
            while (!stack.empty()) {
                C1EmuStackFrame c1EmuStackFrame = (C1EmuStackFrame) stack.peek();
                if (i4 != 0) {
                    if (i4 != 1) {
                        i4 = c1EmuStackFrame.stmRetLabel;
                        stack.pop();
                    } else {
                        c1EmuStackFrame.i = 0;
                        while (c1EmuStackFrame.i < c1EmuStackFrame.kk - c1EmuStackFrame.jj) {
                            iArr2[iArr[c1EmuStackFrame.jj + c1EmuStackFrame.i]] = c1EmuStackFrame.kk - 1;
                            c1EmuStackFrame.i++;
                        }
                        if (c1EmuStackFrame.jj == c1EmuStackFrame.kk - 1) {
                            iArr[c1EmuStackFrame.jj] = -1;
                        }
                        if (c1EmuStackFrame.start + c1EmuStackFrame.len > c1EmuStackFrame.kk) {
                            stack.push(new C1EmuStackFrame(2, c1EmuStackFrame.kk, (c1EmuStackFrame.start + c1EmuStackFrame.len) - c1EmuStackFrame.kk, c1EmuStackFrame.h));
                        }
                        i4 = 2;
                    }
                } else if (c1EmuStackFrame.len < 16) {
                    int i5 = c1EmuStackFrame.start;
                    while (true) {
                        c1EmuStackFrame.k = i5;
                        if (c1EmuStackFrame.k >= c1EmuStackFrame.start + c1EmuStackFrame.len) {
                            break;
                        }
                        c1EmuStackFrame.j = 1;
                        c1EmuStackFrame.x = iArr2[iArr[c1EmuStackFrame.k] + c1EmuStackFrame.h];
                        c1EmuStackFrame.i = 1;
                        while (c1EmuStackFrame.k + c1EmuStackFrame.i < c1EmuStackFrame.start + c1EmuStackFrame.len) {
                            if (iArr2[iArr[c1EmuStackFrame.k + c1EmuStackFrame.i] + c1EmuStackFrame.h] < c1EmuStackFrame.x) {
                                c1EmuStackFrame.x = iArr2[iArr[c1EmuStackFrame.k + c1EmuStackFrame.i] + c1EmuStackFrame.h];
                                c1EmuStackFrame.j = 0;
                            }
                            if (iArr2[iArr[c1EmuStackFrame.k + c1EmuStackFrame.i] + c1EmuStackFrame.h] == c1EmuStackFrame.x) {
                                int i6 = iArr[c1EmuStackFrame.k + c1EmuStackFrame.j];
                                iArr[c1EmuStackFrame.k + c1EmuStackFrame.j] = iArr[c1EmuStackFrame.k + c1EmuStackFrame.i];
                                iArr[c1EmuStackFrame.k + c1EmuStackFrame.i] = i6;
                                c1EmuStackFrame.j++;
                            }
                            c1EmuStackFrame.i++;
                        }
                        c1EmuStackFrame.i = 0;
                        while (c1EmuStackFrame.i < c1EmuStackFrame.j) {
                            iArr2[iArr[c1EmuStackFrame.k + c1EmuStackFrame.i]] = (c1EmuStackFrame.k + c1EmuStackFrame.j) - 1;
                            c1EmuStackFrame.i++;
                        }
                        if (c1EmuStackFrame.j == 1) {
                            iArr[c1EmuStackFrame.k] = -1;
                        }
                        i5 = c1EmuStackFrame.k + c1EmuStackFrame.j;
                    }
                    i4 = 2;
                } else {
                    c1EmuStackFrame.x = iArr2[iArr[c1EmuStackFrame.start + (c1EmuStackFrame.len / 2)] + c1EmuStackFrame.h];
                    c1EmuStackFrame.jj = 0;
                    c1EmuStackFrame.kk = 0;
                    int i7 = c1EmuStackFrame.start;
                    while (true) {
                        c1EmuStackFrame.i = i7;
                        if (c1EmuStackFrame.i >= c1EmuStackFrame.start + c1EmuStackFrame.len) {
                            break;
                        }
                        if (iArr2[iArr[c1EmuStackFrame.i] + c1EmuStackFrame.h] < c1EmuStackFrame.x) {
                            c1EmuStackFrame.jj++;
                        }
                        if (iArr2[iArr[c1EmuStackFrame.i] + c1EmuStackFrame.h] == c1EmuStackFrame.x) {
                            c1EmuStackFrame.kk++;
                        }
                        i7 = c1EmuStackFrame.i + 1;
                    }
                    c1EmuStackFrame.jj += c1EmuStackFrame.start;
                    c1EmuStackFrame.kk += c1EmuStackFrame.jj;
                    c1EmuStackFrame.i = c1EmuStackFrame.start;
                    c1EmuStackFrame.j = 0;
                    c1EmuStackFrame.k = 0;
                    while (c1EmuStackFrame.i < c1EmuStackFrame.jj) {
                        if (iArr2[iArr[c1EmuStackFrame.i] + c1EmuStackFrame.h] < c1EmuStackFrame.x) {
                            c1EmuStackFrame.i++;
                        } else if (iArr2[iArr[c1EmuStackFrame.i] + c1EmuStackFrame.h] == c1EmuStackFrame.x) {
                            int i8 = iArr[c1EmuStackFrame.i];
                            iArr[c1EmuStackFrame.i] = iArr[c1EmuStackFrame.jj + c1EmuStackFrame.j];
                            iArr[c1EmuStackFrame.jj + c1EmuStackFrame.j] = i8;
                            c1EmuStackFrame.j++;
                        } else {
                            int i9 = iArr[c1EmuStackFrame.i];
                            iArr[c1EmuStackFrame.i] = iArr[c1EmuStackFrame.kk + c1EmuStackFrame.k];
                            iArr[c1EmuStackFrame.kk + c1EmuStackFrame.k] = i9;
                            c1EmuStackFrame.k++;
                        }
                    }
                    while (c1EmuStackFrame.jj + c1EmuStackFrame.j < c1EmuStackFrame.kk) {
                        if (iArr2[iArr[c1EmuStackFrame.jj + c1EmuStackFrame.j] + c1EmuStackFrame.h] == c1EmuStackFrame.x) {
                            c1EmuStackFrame.j++;
                        } else {
                            int i10 = iArr[c1EmuStackFrame.jj + c1EmuStackFrame.j];
                            iArr[c1EmuStackFrame.jj + c1EmuStackFrame.j] = iArr[c1EmuStackFrame.kk + c1EmuStackFrame.k];
                            iArr[c1EmuStackFrame.kk + c1EmuStackFrame.k] = i10;
                            c1EmuStackFrame.k++;
                        }
                    }
                    if (c1EmuStackFrame.jj > c1EmuStackFrame.start) {
                        stack.push(new C1EmuStackFrame(1, c1EmuStackFrame.start, c1EmuStackFrame.jj - c1EmuStackFrame.start, c1EmuStackFrame.h));
                    } else {
                        i4 = 1;
                    }
                }
            }
            return;
        }
    }
}
