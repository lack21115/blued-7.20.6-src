package com.kwad.sdk.core.kwai;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/kwai/c.class */
public final class c {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/kwai/c$a.class */
    public static final class a {
        private static final int[] afB;
        private final boolean afD;
        private final boolean afE = false;
        static final a afz = new a(false, false);
        static final a afA = new a(true, false);
        private static final int[] afC = new int[256];

        static {
            int[] iArr = new int[256];
            afB = iArr;
            Arrays.fill(iArr, -1);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= b.afH.length) {
                    break;
                }
                afB[b.afH[i2]] = i2;
                i = i2 + 1;
            }
            afB[61] = -2;
            Arrays.fill(afC, -1);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= b.afI.length) {
                    afC[61] = -2;
                    return;
                } else {
                    afC[b.afI[i4]] = i4;
                    i3 = i4 + 1;
                }
            }
        }

        private a(boolean z, boolean z2) {
            this.afD = z;
        }

        private int a(byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            int i5;
            int[] iArr = this.afD ? afC : afB;
            int i6 = i2 + 0;
            if (i6 == 0) {
                return 0;
            }
            if (i6 < 2) {
                if (this.afE && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.afE) {
                int i7 = i;
                int i8 = 0;
                while (true) {
                    i5 = i6;
                    if (i7 >= i2) {
                        break;
                    }
                    int i9 = i7 + 1;
                    int i10 = bArr[i7] & 255;
                    if (i10 == 61) {
                        i5 = i6 - ((i2 - i9) + 1);
                        break;
                    }
                    int i11 = i8;
                    if (iArr[i10] == -1) {
                        i11 = i8 + 1;
                    }
                    i8 = i11;
                    i7 = i9;
                }
                i3 = i5 - i8;
                i4 = 0;
            } else {
                i3 = i6;
                i4 = 0;
                if (bArr[i2 - 1] == 61) {
                    if (bArr[i2 - 2] == 61) {
                        i4 = 2;
                        i3 = i6;
                    } else {
                        i4 = 1;
                        i3 = i6;
                    }
                }
            }
            int i12 = i4;
            if (i4 == 0) {
                int i13 = i3 & 3;
                i12 = i4;
                if (i13 != 0) {
                    i12 = 4 - i13;
                }
            }
            return (((i3 + 3) / 4) * 3) - i12;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0066, code lost:
            if (r6[r0] == 61) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
            if (r14 != 18) goto L29;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int a(byte[] r6, int r7, int r8, byte[] r9) {
            /*
                Method dump skipped, instructions count: 434
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.kwai.c.a.a(byte[], int, int, byte[]):int");
        }

        public final byte[] decode(String str) {
            return decode(str.getBytes(c.ISO_8859_1));
        }

        public final byte[] decode(byte[] bArr) {
            int a2 = a(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[a2];
            int a3 = a(bArr, 0, bArr.length, bArr2);
            byte[] bArr3 = bArr2;
            if (a3 != a2) {
                bArr3 = Arrays.copyOf(bArr2, a3);
            }
            return bArr3;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/kwai/c$b.class */
    public static final class b {
        static final b afF = new b(false, null, -1, true);
        static final b afG = new b(true, null, -1, false);
        private static final char[] afH = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        private static final char[] afI = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private final boolean afD;
        private final byte[] afJ = null;
        private final int afK = -1;
        private final boolean afL;

        private b(boolean z, byte[] bArr, int i, boolean z2) {
            this.afD = z;
            this.afL = z2;
        }

        private int b(byte[] bArr, int i, int i2, byte[] bArr2) {
            char[] cArr = this.afD ? afI : afH;
            int i3 = ((i2 + 0) / 3) * 3;
            int i4 = i3 + 0;
            int i5 = this.afK;
            int i6 = i3;
            if (i5 > 0) {
                i6 = i3;
                if (i3 > (i5 / 4) * 3) {
                    i6 = (i5 / 4) * 3;
                }
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < i4) {
                int min = Math.min(i7 + i6, i4);
                int i9 = i7;
                int i10 = i8;
                while (i9 < min) {
                    int i11 = i9 + 1;
                    int i12 = i11 + 1;
                    int i13 = ((bArr[i9] & 255) << 16) | ((bArr[i11] & 255) << 8) | (bArr[i12] & 255);
                    int i14 = i10 + 1;
                    bArr2[i10] = (byte) cArr[(i13 >>> 18) & 63];
                    int i15 = i14 + 1;
                    bArr2[i14] = (byte) cArr[(i13 >>> 12) & 63];
                    int i16 = i15 + 1;
                    bArr2[i15] = (byte) cArr[(i13 >>> 6) & 63];
                    i10 = i16 + 1;
                    bArr2[i16] = (byte) cArr[i13 & 63];
                    i9 = i12 + 1;
                }
                int i17 = ((min - i7) / 3) * 4;
                int i18 = i8 + i17;
                i8 = i18;
                if (i17 == this.afK) {
                    i8 = i18;
                    if (min < i2) {
                        byte[] bArr3 = this.afJ;
                        int length = bArr3.length;
                        int i19 = 0;
                        while (true) {
                            i8 = i18;
                            if (i19 < length) {
                                bArr2[i18] = bArr3[i19];
                                i19++;
                                i18++;
                            }
                        }
                    }
                }
                i7 = min;
            }
            int i20 = i8;
            if (i7 < i2) {
                int i21 = i7 + 1;
                int i22 = bArr[i7] & 255;
                int i23 = i8 + 1;
                bArr2[i8] = (byte) cArr[i22 >> 2];
                if (i21 == i2) {
                    int i24 = i23 + 1;
                    bArr2[i23] = (byte) cArr[(i22 << 4) & 63];
                    i20 = i24;
                    if (this.afL) {
                        int i25 = i24 + 1;
                        bArr2[i24] = 61;
                        bArr2[i25] = 61;
                        return i25 + 1;
                    }
                } else {
                    int i26 = bArr[i21] & 255;
                    int i27 = i23 + 1;
                    bArr2[i23] = (byte) cArr[((i22 << 4) & 63) | (i26 >> 4)];
                    int i28 = i27 + 1;
                    bArr2[i27] = (byte) cArr[(i26 << 2) & 63];
                    i20 = i28;
                    if (this.afL) {
                        bArr2[i28] = 61;
                        i20 = i28 + 1;
                    }
                }
            }
            return i20;
        }

        private final int ba(int i) {
            int i2;
            if (this.afL) {
                i2 = ((i + 2) / 3) * 4;
            } else {
                int i3 = i % 3;
                i2 = ((i / 3) * 4) + (i3 == 0 ? 0 : i3 + 1);
            }
            int i4 = this.afK;
            int i5 = i2;
            if (i4 > 0) {
                i5 = i2 + (((i2 - 1) / i4) * this.afJ.length);
            }
            return i5;
        }

        public final byte[] encode(byte[] bArr) {
            int ba = ba(bArr.length);
            byte[] bArr2 = new byte[ba];
            int b = b(bArr, 0, bArr.length, bArr2);
            return b != ba ? Arrays.copyOf(bArr2, b) : bArr2;
        }

        public final String encodeToString(byte[] bArr) {
            byte[] encode = encode(bArr);
            return new String(encode, 0, 0, encode.length);
        }
    }

    public static String bW(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "sDAkk/dS" + new String(vH().encode(str.getBytes()), com.kwad.sdk.crash.utils.a.UTF_8);
    }

    public static String bX(String str) {
        return TextUtils.isEmpty(str) ? "" : str.startsWith("sDAkk/dS") ? new String(vJ().decode(str.substring(8)), com.kwad.sdk.crash.utils.a.UTF_8) : str;
    }

    public static boolean bY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("sDAkk/dS");
    }

    public static b vH() {
        return b.afF;
    }

    public static b vI() {
        return b.afG;
    }

    public static a vJ() {
        return a.afz;
    }

    public static a vK() {
        return a.afA;
    }
}
