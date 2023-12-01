package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/Utf8.class */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i) {
        boolean z = true;
        if (!(i >= 0 && i <= 31)) {
            if (127 <= i && i <= 159) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 192) == 128;
    }

    public static final int process2Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> yield) {
        Intrinsics.e(bArr, "<this>");
        Intrinsics.e(yield, "yield");
        int i3 = i + 1;
        if (i2 <= i3) {
            yield.invoke(65533);
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i3];
        if (!((b2 & 192) == 128)) {
            yield.invoke(65533);
            return 1;
        }
        int i4 = (b2 ^ 3968) ^ (b << 6);
        if (i4 < 128) {
            yield.invoke(65533);
            return 2;
        }
        yield.invoke(Integer.valueOf(i4));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> yield) {
        Intrinsics.e(bArr, "<this>");
        Intrinsics.e(yield, "yield");
        int i3 = i + 2;
        if (i2 <= i3) {
            yield.invoke(65533);
            int i4 = i + 1;
            if (i2 > i4) {
                boolean z = false;
                if ((bArr[i4] & 192) == 128) {
                    z = true;
                }
                return !z ? 1 : 2;
            }
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if (!((b2 & 192) == 128)) {
            yield.invoke(65533);
            return 1;
        }
        byte b3 = bArr[i3];
        if (!((b3 & 192) == 128)) {
            yield.invoke(65533);
            return 2;
        }
        int i5 = ((b3 ^ (-123008)) ^ (b2 << 6)) ^ (b << 12);
        if (i5 < 2048) {
            yield.invoke(65533);
            return 3;
        }
        boolean z2 = false;
        if (55296 <= i5) {
            z2 = false;
            if (i5 <= 57343) {
                z2 = true;
            }
        }
        if (z2) {
            yield.invoke(65533);
            return 3;
        }
        yield.invoke(Integer.valueOf(i5));
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> yield) {
        Intrinsics.e(bArr, "<this>");
        Intrinsics.e(yield, "yield");
        int i3 = i + 3;
        if (i2 <= i3) {
            yield.invoke(65533);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    int i5 = i + 2;
                    if (i2 > i5) {
                        boolean z = false;
                        if ((bArr[i5] & 192) == 128) {
                            z = true;
                        }
                        return !z ? 2 : 3;
                    }
                    return 2;
                }
                return 1;
            }
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if (!((b2 & 192) == 128)) {
            yield.invoke(65533);
            return 1;
        }
        byte b3 = bArr[i + 2];
        if (!((b3 & 192) == 128)) {
            yield.invoke(65533);
            return 2;
        }
        byte b4 = bArr[i3];
        if (!((b4 & 192) == 128)) {
            yield.invoke(65533);
            return 3;
        }
        int i6 = (((b4 ^ 3678080) ^ (b3 << 6)) ^ (b2 << 12)) ^ (b << 18);
        if (i6 > 1114111) {
            yield.invoke(65533);
            return 4;
        }
        boolean z2 = false;
        if (55296 <= i6) {
            z2 = false;
            if (i6 <= 57343) {
                z2 = true;
            }
        }
        if (z2) {
            yield.invoke(65533);
            return 4;
        } else if (i6 < 65536) {
            yield.invoke(65533);
            return 4;
        } else {
            yield.invoke(Integer.valueOf(i6));
            return 4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x013c, code lost:
        if (r9 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0286, code lost:
        if (r9 == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void processUtf16Chars(byte[] r4, int r5, int r6, kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.Unit> r7) {
        /*
            Method dump skipped, instructions count: 985
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final void processUtf8Bytes(String str, int i, int i2, Function1<? super Byte, Unit> yield) {
        int i3;
        Intrinsics.e(str, "<this>");
        Intrinsics.e(yield, "yield");
        while (i < i2) {
            char charAt = str.charAt(i);
            if (Intrinsics.a((int) charAt, 128) < 0) {
                yield.invoke(Byte.valueOf((byte) charAt));
                int i4 = i;
                while (true) {
                    int i5 = i4 + 1;
                    i = i5;
                    if (i5 < i2) {
                        i = i5;
                        if (Intrinsics.a((int) str.charAt(i5), 128) < 0) {
                            yield.invoke(Byte.valueOf((byte) str.charAt(i5)));
                            i4 = i5;
                        }
                    }
                }
            } else {
                if (Intrinsics.a((int) charAt, 2048) < 0) {
                    yield.invoke(Byte.valueOf((byte) ((charAt >> 6) | 192)));
                    yield.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                } else {
                    if (55296 <= charAt && charAt <= 57343) {
                        if (Intrinsics.a((int) charAt, (int) Character.MAX_HIGH_SURROGATE) <= 0 && i2 > (i3 = i + 1)) {
                            char charAt2 = str.charAt(i3);
                            boolean z = false;
                            if (56320 <= charAt2) {
                                z = false;
                                if (charAt2 <= 57343) {
                                    z = true;
                                }
                            }
                            if (z) {
                                int charAt3 = ((charAt << '\n') + str.charAt(i3)) - 56613888;
                                yield.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                                yield.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                                yield.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                                yield.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                                i += 2;
                            }
                        }
                        yield.invoke((byte) 63);
                    } else {
                        yield.invoke(Byte.valueOf((byte) ((charAt >> '\f') | 224)));
                        yield.invoke(Byte.valueOf((byte) (((charAt >> 6) & 63) | 128)));
                        yield.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                    }
                }
                i++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0139, code lost:
        if (r8 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0282, code lost:
        if (r8 == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void processUtf8CodePoints(byte[] r4, int r5, int r6, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r7) {
        /*
            Method dump skipped, instructions count: 946
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final long size(String str) {
        Intrinsics.e(str, "<this>");
        return size$default(str, 0, 0, 3, null);
    }

    public static final long size(String str, int i) {
        Intrinsics.e(str, "<this>");
        return size$default(str, i, 0, 2, null);
    }

    public static final long size(String str, int i, int i2) {
        long j;
        long j2;
        int i3;
        Intrinsics.e(str, "<this>");
        if (i >= 0) {
            if (!(i2 >= i)) {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
            }
            if (!(i2 <= str.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
            }
            long j3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    j = j3;
                    j2 = 1;
                } else {
                    if (charAt < 2048) {
                        i3 = 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i3 = 3;
                    } else {
                        int i4 = i + 1;
                        char charAt2 = i4 < i2 ? str.charAt(i4) : (char) 0;
                        if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                            j3++;
                            i = i4;
                        } else {
                            j3 += 4;
                            i += 2;
                        }
                    }
                    j = j3;
                    j2 = i3;
                }
                j3 = j + j2;
                i++;
            }
            return j3;
        }
        throw new IllegalArgumentException(Intrinsics.a("beginIndex < 0: ", (Object) Integer.valueOf(i)).toString());
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }
}
