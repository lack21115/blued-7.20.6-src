package ar.com.hjg.pngj.pixels;

import java.nio.ByteOrder;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/pixels/DeflaterEstimatorLz4.class */
public final class DeflaterEstimatorLz4 {

    /* renamed from: a  reason: collision with root package name */
    static final ByteOrder f3628a = ByteOrder.nativeOrder();
    static final int b = Math.max(6, 2);

    static int a(int i) {
        return (i * (-1640531535)) >>> 19;
    }

    static int a(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    static int a(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i2 < i3 && bArr[i] == bArr[i2]) {
            i4++;
            i++;
            i2++;
        }
        return i4;
    }

    static int a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = i;
        int i7 = 0;
        while (true) {
            i5 = i7;
            if (i6 <= i3 || i2 <= i4) {
                break;
            }
            i6--;
            i2--;
            if (bArr[i6] != bArr[i2]) {
                break;
            }
            i7 = i5 + 1;
        }
        return i5;
    }

    static int a(short[] sArr, int i) {
        return sArr[i] & 65535;
    }

    static void a(short[] sArr, int i, int i2) {
        sArr[i] = (short) i2;
    }

    static int b(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0078, code lost:
        r0 = a(r6, r0, r10, r7, r9);
        r0 = r10 - r0;
        r0 = r0 - r0;
        r0 = r0 - r9;
        r0 = r8 + 1;
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a2, code lost:
        if (r0 < 15) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a5, code lost:
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ab, code lost:
        if (r0 <= 15) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00ae, code lost:
        r9 = r0 + ((r0 - 15) / 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ba, code lost:
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00be, code lost:
        r8 = r0;
        r10 = r9 + r0;
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00cc, code lost:
        r0 = r10 + 2;
        r0 = r9 + 4;
        r0 = a(r6, r8 + 4, r0, r0 - 5);
        r9 = r0 + r0;
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00f0, code lost:
        if (r0 < 15) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00f3, code lost:
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00fb, code lost:
        if (r0 < 270) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00fe, code lost:
        r8 = r0 + ((r0 - 15) / 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x010b, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0112, code lost:
        if (r9 <= r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0115, code lost:
        r7 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x011a, code lost:
        r0 = r9 - 2;
        a(r0, a(c(r6, r0)), r0 - r7);
        r0 = a(c(r6, r9));
        r0 = r7 + a(r0, r0);
        a(r0, r0, r9 - r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0157, code lost:
        if (c(r6, r9, r0) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0168, code lost:
        r10 = r8 + 1;
        r8 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int b(byte[] r6, int r7, int r8) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ar.com.hjg.pngj.pixels.DeflaterEstimatorLz4.b(byte[], int, int):int");
    }

    static int c(byte[] bArr, int i) {
        return f3628a == ByteOrder.BIG_ENDIAN ? a(bArr, i) : b(bArr, i);
    }

    static boolean c(byte[] bArr, int i, int i2) {
        return bArr[i] == bArr[i2] && bArr[i + 1] == bArr[i2 + 1] && bArr[i + 2] == bArr[i2 + 2] && bArr[i + 3] == bArr[i2 + 3];
    }

    public int a(byte[] bArr, int i, int i2) {
        if (i2 < 10) {
            return i2;
        }
        int i3 = ((i2 + 65546) - 1) / 65546;
        int i4 = i2 / i3;
        if (i4 >= 65546 || i4 * i3 > i2 || i3 < 1 || i4 < 1) {
            throw new RuntimeException("?? " + i2);
        }
        int i5 = 0;
        int i6 = i;
        int i7 = i2;
        int i8 = 0;
        while (i7 > 0) {
            int i9 = i7;
            if (i7 > i4) {
                i9 = i4;
            }
            i5 += b(bArr, i6, i9);
            i6 += i9;
            i8 += i9;
            i7 = i2 - i8;
        }
        return i8 == i2 ? i5 : (int) (((i5 / i8) * i2) + 0.5d);
    }
}
