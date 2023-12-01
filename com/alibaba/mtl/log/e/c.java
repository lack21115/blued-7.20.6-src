package com.alibaba.mtl.log.e;

import java.io.UnsupportedEncodingException;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/c.class */
public class c {
    static final /* synthetic */ boolean H = !c.class.desiredAssertionStatus();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/c$a.class */
    public static abstract class a {
        public int op;
        public byte[] output;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/c$b.class */
    public static class b extends a {
        private static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private final int[] c;
        private int state;
        private int value;

        public b(int i, byte[] bArr) {
            this.output = bArr;
            this.c = (i & 8) == 0 ? a : b;
            this.state = 0;
            this.value = 0;
        }

        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7 = this.state;
            if (i7 == 6) {
                return false;
            }
            int i8 = i2 + i;
            int i9 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = this.c;
            int i10 = 0;
            int i11 = i9;
            int i12 = i;
            while (true) {
                i3 = i11;
                i4 = i10;
                if (i12 >= i8) {
                    break;
                }
                int i13 = i12;
                int i14 = i11;
                int i15 = i10;
                if (i7 == 0) {
                    while (true) {
                        int i16 = i12 + 4;
                        if (i16 > i8) {
                            break;
                        }
                        int i17 = (iArr[bArr[i12] & 255] << 18) | (iArr[bArr[i12 + 1] & 255] << 12) | (iArr[bArr[i12 + 2] & 255] << 6) | iArr[bArr[i12 + 3] & 255];
                        i11 = i17;
                        if (i17 < 0) {
                            break;
                        }
                        bArr2[i10 + 2] = (byte) i17;
                        bArr2[i10 + 1] = (byte) (i17 >> 8);
                        bArr2[i10] = (byte) (i17 >> 16);
                        i10 += 3;
                        i12 = i16;
                        i11 = i17;
                    }
                    i13 = i12;
                    i14 = i11;
                    i15 = i10;
                    if (i12 >= i8) {
                        i3 = i11;
                        i4 = i10;
                        break;
                    }
                }
                int i18 = iArr[bArr[i13] & 255];
                if (i7 != 0) {
                    if (i7 == 1) {
                        if (i18 < 0) {
                            i5 = i7;
                            i10 = i15;
                            if (i18 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i6 = i18 | (i14 << 6);
                    } else if (i7 == 2) {
                        if (i18 < 0) {
                            if (i18 == -2) {
                                bArr2[i15] = (byte) (i14 >> 4);
                                i10 = i15 + 1;
                                i5 = 4;
                            } else {
                                i5 = i7;
                                i10 = i15;
                                if (i18 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            }
                        }
                        i6 = i18 | (i14 << 6);
                    } else if (i7 != 3) {
                        if (i7 != 4) {
                            if (i7 != 5) {
                                i5 = i7;
                                i10 = i15;
                            } else {
                                i5 = i7;
                                i10 = i15;
                                if (i18 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            }
                        } else if (i18 == -2) {
                            i5 = i7 + 1;
                            i10 = i15;
                        } else {
                            i5 = i7;
                            i10 = i15;
                            if (i18 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                    } else if (i18 >= 0) {
                        i14 = i18 | (i14 << 6);
                        bArr2[i15 + 2] = (byte) i14;
                        bArr2[i15 + 1] = (byte) (i14 >> 8);
                        bArr2[i15] = (byte) (i14 >> 16);
                        i10 = i15 + 3;
                        i5 = 0;
                    } else if (i18 == -2) {
                        bArr2[i15 + 1] = (byte) (i14 >> 2);
                        bArr2[i15] = (byte) (i14 >> 10);
                        i10 = i15 + 2;
                        i5 = 5;
                    } else {
                        i5 = i7;
                        i10 = i15;
                        if (i18 != -1) {
                            this.state = 6;
                            return false;
                        }
                    }
                    i14 = i6;
                    i5 = i7 + 1;
                    i10 = i15;
                } else if (i18 >= 0) {
                    i6 = i18;
                    i14 = i6;
                    i5 = i7 + 1;
                    i10 = i15;
                } else {
                    i5 = i7;
                    i10 = i15;
                    if (i18 != -1) {
                        this.state = 6;
                        return false;
                    }
                }
                i12 = i13 + 1;
                i7 = i5;
                i11 = i14;
            }
            if (!z) {
                this.state = i7;
                this.value = i3;
                this.op = i4;
                return true;
            } else if (i7 == 1) {
                this.state = 6;
                return false;
            } else {
                if (i7 == 2) {
                    bArr2[i4] = (byte) (i3 >> 4);
                    i4++;
                } else if (i7 == 3) {
                    int i19 = i4 + 1;
                    bArr2[i4] = (byte) (i3 >> 10);
                    i4 = i19 + 1;
                    bArr2[i19] = (byte) (i3 >> 2);
                } else if (i7 == 4) {
                    this.state = 6;
                    return false;
                }
                this.state = i7;
                this.op = i4;
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.mtl.log.e.c$c  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/c$c.class */
    public static class C0004c extends a {
        static final /* synthetic */ boolean H = !c.class.desiredAssertionStatus();
        private static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        int D;
        private final byte[] c;
        private int count;
        private final byte[] d;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;

        public C0004c(int i, byte[] bArr) {
            this.output = bArr;
            this.do_padding = (i & 1) == 0;
            this.do_newline = (i & 2) == 0;
            this.do_cr = (i & 4) != 0;
            this.d = (i & 8) == 0 ? a : b;
            this.c = new byte[2];
            this.D = 0;
            this.count = this.do_newline ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:106:0x01cf A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x03fb  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x01b9 -> B:23:0x011c). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean process(byte[] r7, int r8, int r9, boolean r10) {
            /*
                Method dump skipped, instructions count: 1161
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.c.C0004c.process(byte[], int, int, boolean):boolean");
        }
    }

    private c() {
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        b bVar = new b(i3, new byte[(i2 * 3) / 4]);
        if (bVar.process(bArr, i, i2, true)) {
            if (bVar.op == bVar.output.length) {
                return bVar.output;
            }
            byte[] bArr2 = new byte[bVar.op];
            System.arraycopy((Object) bVar.output, 0, (Object) bArr2, 0, bVar.op);
            return bArr2;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        int i4;
        C0004c c0004c = new C0004c(i3, null);
        int i5 = (i2 / 3) * 4;
        if (c0004c.do_padding) {
            i4 = i5;
            if (i2 % 3 > 0) {
                i4 = i5 + 4;
            }
        } else {
            int i6 = i2 % 3;
            i4 = i6 != 1 ? i6 != 2 ? i5 : i5 + 3 : i5 + 2;
        }
        int i7 = i4;
        if (c0004c.do_newline) {
            i7 = i4;
            if (i2 > 0) {
                i7 = i4 + ((((i2 - 1) / 57) + 1) * (c0004c.do_cr ? 2 : 1));
            }
        }
        c0004c.output = new byte[i7];
        c0004c.process(bArr, i, i2, true);
        if (H || c0004c.op == i7) {
            return c0004c.output;
        }
        throw new AssertionError();
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
