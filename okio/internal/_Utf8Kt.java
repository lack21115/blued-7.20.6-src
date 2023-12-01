package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/internal/_Utf8Kt.class */
public final class _Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        Intrinsics.e(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        if (length > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                int i7 = i6 + 1;
                char charAt = str.charAt(i6);
                if (Intrinsics.a((int) charAt, 128) >= 0) {
                    int length2 = str.length();
                    int i8 = i6;
                    int i9 = i6;
                    while (i9 < length2) {
                        char charAt2 = str.charAt(i9);
                        if (Intrinsics.a((int) charAt2, 128) < 0) {
                            bArr[i8] = (byte) charAt2;
                            int i10 = i8 + 1;
                            int i11 = i9 + 1;
                            while (true) {
                                int i12 = i11;
                                int i13 = i10;
                                i9 = i12;
                                i8 = i13;
                                if (i12 < length2) {
                                    i9 = i12;
                                    i8 = i13;
                                    if (Intrinsics.a((int) str.charAt(i12), 128) < 0) {
                                        i10 = i13 + 1;
                                        bArr[i13] = (byte) str.charAt(i12);
                                        i11 = i12 + 1;
                                    }
                                }
                            }
                        } else {
                            if (Intrinsics.a((int) charAt2, 2048) < 0) {
                                byte b = (byte) ((charAt2 >> 6) | 192);
                                int i14 = i8 + 1;
                                bArr[i8] = b;
                                i = i14 + 1;
                                bArr[i14] = (byte) ((charAt2 & '?') | 128);
                            } else {
                                if (55296 <= charAt2 && charAt2 <= 57343) {
                                    if (Intrinsics.a((int) charAt2, (int) Character.MAX_HIGH_SURROGATE) <= 0 && length2 > (i2 = i9 + 1)) {
                                        char charAt3 = str.charAt(i2);
                                        if (56320 <= charAt3 && charAt3 <= 57343) {
                                            int charAt4 = ((charAt2 << '\n') + str.charAt(i2)) - 56613888;
                                            byte b2 = (byte) ((charAt4 >> 18) | 240);
                                            int i15 = i8 + 1;
                                            bArr[i8] = b2;
                                            byte b3 = (byte) (((charAt4 >> 12) & 63) | 128);
                                            int i16 = i15 + 1;
                                            bArr[i15] = b3;
                                            byte b4 = (byte) (((charAt4 >> 6) & 63) | 128);
                                            int i17 = i16 + 1;
                                            bArr[i16] = b4;
                                            i = i17 + 1;
                                            bArr[i17] = (byte) ((charAt4 & 63) | 128);
                                            i3 = i9;
                                            i4 = 2;
                                            i9 = i3 + i4;
                                            i8 = i;
                                        }
                                    }
                                    i = i8 + 1;
                                    bArr[i8] = 63;
                                } else {
                                    byte b5 = (byte) ((charAt2 >> '\f') | 224);
                                    int i18 = i8 + 1;
                                    bArr[i8] = b5;
                                    byte b6 = (byte) (((charAt2 >> 6) & 63) | 128);
                                    int i19 = i18 + 1;
                                    bArr[i18] = b6;
                                    i = i19 + 1;
                                    bArr[i19] = (byte) ((charAt2 & '?') | 128);
                                }
                            }
                            i3 = i9;
                            i4 = 1;
                            i9 = i3 + i4;
                            i8 = i;
                        }
                    }
                    byte[] copyOf = Arrays.copyOf(bArr, i8);
                    Intrinsics.c(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                    return copyOf;
                }
                bArr[i6] = (byte) charAt;
                if (i7 >= length) {
                    break;
                }
                i5 = i7;
            }
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.c(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }

    public static final String commonToUtf8String(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = i;
        Intrinsics.e(bArr, "<this>");
        if (i4 < 0 || i2 > bArr.length || i4 > i2) {
            throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i4 + " endIndex=" + i2);
        }
        char[] cArr = new char[i2 - i4];
        int i5 = 0;
        while (i4 < i2) {
            byte b = bArr[i4];
            if (b >= 0) {
                cArr[i5] = (char) b;
                int i6 = i5 + 1;
                int i7 = i4 + 1;
                while (true) {
                    int i8 = i7;
                    int i9 = i6;
                    i4 = i8;
                    i5 = i9;
                    if (i8 < i2) {
                        i4 = i8;
                        i5 = i9;
                        if (bArr[i8] >= 0) {
                            i6 = i9 + 1;
                            cArr[i9] = (char) bArr[i8];
                            i7 = i8 + 1;
                        }
                    }
                }
            } else {
                if ((b >> 5) == -2) {
                    int i10 = i4 + 1;
                    if (i2 <= i10) {
                        cArr[i5] = (char) 65533;
                        i5++;
                    } else {
                        byte b2 = bArr[i4];
                        byte b3 = bArr[i10];
                        if ((b3 & 192) == 128) {
                            int i11 = (b3 ^ 3968) ^ (b2 << 6);
                            if (i11 < 128) {
                                cArr[i5] = (char) 65533;
                                i5++;
                            } else {
                                cArr[i5] = (char) i11;
                                i5++;
                            }
                            Unit unit = Unit.f42314a;
                            i3 = 2;
                        } else {
                            cArr[i5] = (char) 65533;
                            i5++;
                        }
                    }
                    Unit unit2 = Unit.f42314a;
                    i3 = 1;
                } else if ((b >> 4) == -2) {
                    int i12 = i4 + 2;
                    if (i2 <= i12) {
                        int i13 = i5 + 1;
                        cArr[i5] = (char) 65533;
                        Unit unit3 = Unit.f42314a;
                        int i14 = i4 + 1;
                        i5 = i13;
                        if (i2 > i14) {
                            i5 = i13;
                            if (!((bArr[i14] & 192) == 128)) {
                                i5 = i13;
                            }
                            i3 = 2;
                        }
                        i3 = 1;
                    } else {
                        byte b4 = bArr[i4];
                        byte b5 = bArr[i4 + 1];
                        if ((b5 & 192) == 128) {
                            byte b6 = bArr[i12];
                            if ((b6 & 192) == 128) {
                                int i15 = ((b6 ^ (-123008)) ^ (b5 << 6)) ^ (b4 << 12);
                                if (i15 < 2048) {
                                    cArr[i5] = (char) 65533;
                                    i5++;
                                } else {
                                    if (55296 <= i15 && i15 <= 57343) {
                                        cArr[i5] = (char) 65533;
                                        i5++;
                                    } else {
                                        cArr[i5] = (char) i15;
                                        i5++;
                                    }
                                }
                                Unit unit4 = Unit.f42314a;
                                i3 = 3;
                            } else {
                                cArr[i5] = (char) 65533;
                                Unit unit5 = Unit.f42314a;
                                i5++;
                                i3 = 2;
                            }
                        } else {
                            cArr[i5] = (char) 65533;
                            Unit unit6 = Unit.f42314a;
                            i5++;
                            i3 = 1;
                        }
                    }
                } else if ((b >> 3) == -2) {
                    int i16 = i4 + 3;
                    if (i2 <= i16) {
                        int i17 = i5 + 1;
                        cArr[i5] = 65533;
                        Unit unit7 = Unit.f42314a;
                        int i18 = i4 + 1;
                        i5 = i17;
                        if (i2 > i18) {
                            if ((bArr[i18] & 192) == 128) {
                                int i19 = i4 + 2;
                                i5 = i17;
                                if (i2 > i19) {
                                    i5 = i17;
                                    if (!((bArr[i19] & 192) == 128)) {
                                        i5 = i17;
                                    }
                                    i3 = 3;
                                }
                                i3 = 2;
                            } else {
                                i5 = i17;
                            }
                        }
                        i3 = 1;
                    } else {
                        byte b7 = bArr[i4];
                        byte b8 = bArr[i4 + 1];
                        if ((b8 & 192) == 128) {
                            byte b9 = bArr[i4 + 2];
                            if ((b9 & 192) == 128) {
                                byte b10 = bArr[i16];
                                if ((b10 & 192) == 128) {
                                    int i20 = (((b10 ^ 3678080) ^ (b9 << 6)) ^ (b8 << 12)) ^ (b7 << 18);
                                    if (i20 > 1114111) {
                                        cArr[i5] = 65533;
                                        i5++;
                                    } else {
                                        if (55296 <= i20 && i20 <= 57343) {
                                            cArr[i5] = 65533;
                                            i5++;
                                        } else if (i20 < 65536) {
                                            cArr[i5] = 65533;
                                            i5++;
                                        } else if (i20 != 65533) {
                                            char c2 = (char) ((i20 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                            int i21 = i5 + 1;
                                            cArr[i5] = c2;
                                            i5 = i21 + 1;
                                            cArr[i21] = (char) ((i20 & 1023) + 56320);
                                        } else {
                                            cArr[i5] = 65533;
                                            i5++;
                                        }
                                    }
                                    Unit unit8 = Unit.f42314a;
                                    i3 = 4;
                                } else {
                                    cArr[i5] = 65533;
                                    Unit unit9 = Unit.f42314a;
                                    i5++;
                                    i3 = 3;
                                }
                            } else {
                                cArr[i5] = 65533;
                                Unit unit10 = Unit.f42314a;
                                i5++;
                                i3 = 2;
                            }
                        } else {
                            cArr[i5] = 65533;
                            Unit unit11 = Unit.f42314a;
                            i5++;
                            i3 = 1;
                        }
                    }
                } else {
                    cArr[i5] = 65533;
                    i4++;
                    i5++;
                }
                i4 += i3;
            }
        }
        return StringsKt.a(cArr, 0, i5);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }
}
