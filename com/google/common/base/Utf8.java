package com.google.common.base;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/base/Utf8.class */
public final class Utf8 {
    private Utf8() {
    }

    public static int encodedLength(CharSequence charSequence) {
        int i;
        int i2;
        int length = charSequence.length();
        int i3 = 0;
        while (true) {
            i = i3;
            if (i >= length || charSequence.charAt(i) >= 128) {
                break;
            }
            i3 = i + 1;
        }
        int i4 = length;
        while (true) {
            i2 = i4;
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 = i4 + encodedLengthGeneral(charSequence, i);
                    break;
                }
                i4 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i2 + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int i2;
        int length = charSequence.length();
        int i3 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2 = i;
            } else {
                int i4 = i3 + 2;
                i3 = i4;
                i2 = i;
                if (55296 <= charAt) {
                    i3 = i4;
                    i2 = i;
                    if (charAt > 57343) {
                        continue;
                    } else if (Character.codePointAt(charSequence, i) == charAt) {
                        throw new IllegalArgumentException(unpairedSurrogateMsg(i));
                    } else {
                        i2 = i + 1;
                        i3 = i4;
                    }
                } else {
                    continue;
                }
            }
            i = i2 + 1;
        }
        return i3;
    }

    public static boolean isWellFormed(byte[] bArr) {
        return isWellFormed(bArr, 0, bArr.length);
    }

    public static boolean isWellFormed(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        Preconditions.checkPositionIndexes(i, i3, bArr.length);
        while (i < i3) {
            if (bArr[i] < 0) {
                return isWellFormedSlowPath(bArr, i, i3);
            }
            i++;
        }
        return true;
    }

    private static boolean isWellFormedSlowPath(byte[] bArr, int i, int i2) {
        byte b;
        while (i < i2) {
            int i3 = i + 1;
            byte b2 = bArr[i];
            i = i3;
            if (b2 < 0) {
                if (b2 < -32) {
                    if (i3 == i2 || b2 < -62) {
                        return false;
                    }
                    i = i3 + 1;
                    if (bArr[i3] > -65) {
                        return false;
                    }
                } else if (b2 < -16) {
                    int i4 = i3 + 1;
                    if (i4 >= i2 || (b = bArr[i3]) > -65) {
                        return false;
                    }
                    if (b2 == -32 && b < -96) {
                        return false;
                    }
                    if (b2 == -19 && -96 <= b) {
                        return false;
                    }
                    i = i4 + 1;
                    if (bArr[i4] > -65) {
                        return false;
                    }
                } else if (i3 + 2 >= i2) {
                    return false;
                } else {
                    int i5 = i3 + 1;
                    byte b3 = bArr[i3];
                    if (b3 > -65 || (((b2 << 28) + (b3 + 112)) >> 30) != 0) {
                        return false;
                    }
                    int i6 = i5 + 1;
                    if (bArr[i5] > -65) {
                        return false;
                    }
                    i = i6 + 1;
                    if (bArr[i6] > -65) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static String unpairedSurrogateMsg(int i) {
        return "Unpaired surrogate at index " + i;
    }
}
