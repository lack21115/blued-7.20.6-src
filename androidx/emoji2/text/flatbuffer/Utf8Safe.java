package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/Utf8Safe.class */
public final class Utf8Safe extends Utf8 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/Utf8Safe$UnpairedSurrogateException.class */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    private static int a(CharSequence charSequence) {
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
                    i2 = i4 + a(charSequence, i);
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

    private static int a(CharSequence charSequence, int i) {
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
                    } else if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new UnpairedSurrogateException(i, length);
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

    private static int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        char charAt;
        int length = charSequence.length();
        int i7 = i2 + i;
        int i8 = 0;
        while (true) {
            i3 = i8;
            if (i3 >= length || (i6 = i3 + i) >= i7 || (charAt = charSequence.charAt(i3)) >= 128) {
                break;
            }
            bArr[i6] = (byte) charAt;
            i8 = i3 + 1;
        }
        if (i3 == length) {
            return i + length;
        }
        int i9 = i + i3;
        int i10 = i3;
        while (i10 < length) {
            char charAt2 = charSequence.charAt(i10);
            if (charAt2 < 128 && i9 < i7) {
                i4 = i9 + 1;
                bArr[i9] = (byte) charAt2;
            } else if (charAt2 < 2048 && i9 <= i7 - 2) {
                int i11 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 >>> 6) | 960);
                i4 = i11 + 1;
                bArr[i11] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 >= 55296 && 57343 >= charAt2) || i9 > i7 - 3) {
                if (i9 > i7 - 4) {
                    if (55296 > charAt2 || charAt2 > 57343 || ((i5 = i10 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i5)))) {
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i9);
                    }
                    throw new UnpairedSurrogateException(i10, length);
                }
                int i12 = i10 + 1;
                if (i12 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i12);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i13 = i9 + 1;
                        bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                        int i14 = i13 + 1;
                        bArr[i13] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i15 = i14 + 1;
                        bArr[i14] = (byte) (((codePoint >>> 6) & 63) | 128);
                        bArr[i15] = (byte) ((codePoint & 63) | 128);
                        i10 = i12;
                        i4 = i15 + 1;
                    } else {
                        i10 = i12;
                    }
                }
                throw new UnpairedSurrogateException(i10 - 1, length);
            } else {
                int i16 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 >>> '\f') | 480);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i4 = i17 + 1;
                bArr[i17] = (byte) ((charAt2 & '?') | 128);
            }
            i10++;
            i9 = i4;
        }
        return i9;
    }

    private static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i3 = 0;
        while (true) {
            i = i3;
            if (i >= length) {
                break;
            }
            i2 = position;
            try {
                char charAt = charSequence.charAt(i);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i, (byte) charAt);
                i3 = i + 1;
            } catch (IndexOutOfBoundsException e) {
                i = i;
                int position2 = byteBuffer.position();
                int max = Math.max(i, (i2 - byteBuffer.position()) + 1);
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i) + " at index " + (position2 + max));
            }
        }
        if (i == length) {
            byteBuffer.position(position + i);
            return;
        }
        int i4 = position;
        int i5 = i;
        while (true) {
            int i6 = i4 + i5;
            if (i >= length) {
                byteBuffer.position(i6);
                return;
            }
            char charAt2 = charSequence.charAt(i);
            if (charAt2 >= 128) {
                if (charAt2 >= 2048) {
                    if (charAt2 >= 55296 && 57343 >= charAt2) {
                        int i7 = i + 1;
                        if (i7 == length) {
                            break;
                        }
                        int i8 = i6;
                        try {
                            char charAt3 = charSequence.charAt(i7);
                            if (!Character.isSurrogatePair(charAt2, charAt3)) {
                                i = i7;
                                break;
                            }
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i9 = i6 + 1;
                            i8 = i9;
                            try {
                                byteBuffer.put(i6, (byte) ((codePoint >>> 18) | 240));
                                int i10 = i9 + 1;
                                byteBuffer.put(i9, (byte) (((codePoint >>> 12) & 63) | 128));
                                i6 = i10 + 1;
                                byteBuffer.put(i10, (byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put(i6, (byte) ((codePoint & 63) | 128));
                                i = i7;
                            } catch (IndexOutOfBoundsException e2) {
                                i2 = i8;
                                i = i7;
                                int position22 = byteBuffer.position();
                                int max2 = Math.max(i, (i2 - byteBuffer.position()) + 1);
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i) + " at index " + (position22 + max2));
                            }
                        } catch (IndexOutOfBoundsException e3) {
                        }
                    } else {
                        int i11 = i6 + 1;
                        byteBuffer.put(i6, (byte) ((charAt2 >>> '\f') | 224));
                        i6 = i11 + 1;
                        byteBuffer.put(i11, (byte) (((charAt2 >>> 6) & 63) | 128));
                        byteBuffer.put(i6, (byte) ((charAt2 & '?') | 128));
                    }
                } else {
                    int i12 = i6 + 1;
                    try {
                        byteBuffer.put(i6, (byte) ((charAt2 >>> 6) | 192));
                        byteBuffer.put(i12, (byte) ((charAt2 & '?') | 128));
                        i6 = i12;
                    } catch (IndexOutOfBoundsException e4) {
                        i2 = i12;
                        int position222 = byteBuffer.position();
                        int max22 = Math.max(i, (i2 - byteBuffer.position()) + 1);
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i) + " at index " + (position222 + max22));
                    }
                }
            } else {
                byteBuffer.put(i6, (byte) charAt2);
            }
            i++;
            i4 = i6;
            i5 = 1;
        }
        throw new UnpairedSurrogateException(i, length);
    }

    public static String decodeUtf8Array(byte[] bArr, int i, int i2) {
        int i3;
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (true) {
                i3 = i5;
                if (i >= i4) {
                    break;
                }
                byte b = bArr[i];
                if (!Utf8.DecodeUtil.a(b)) {
                    break;
                }
                i++;
                Utf8.DecodeUtil.a(b, cArr, i3);
                i5 = i3 + 1;
            }
            int i6 = i;
            int i7 = i3;
            while (i6 < i4) {
                int i8 = i6 + 1;
                byte b2 = bArr[i6];
                if (Utf8.DecodeUtil.a(b2)) {
                    Utf8.DecodeUtil.a(b2, cArr, i7);
                    i7++;
                    i6 = i8;
                    while (i6 < i4) {
                        byte b3 = bArr[i6];
                        if (!Utf8.DecodeUtil.a(b3)) {
                            break;
                        }
                        i6++;
                        Utf8.DecodeUtil.a(b3, cArr, i7);
                        i7++;
                    }
                } else if (Utf8.DecodeUtil.b(b2)) {
                    if (i8 >= i4) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    Utf8.DecodeUtil.a(b2, bArr[i8], cArr, i7);
                    i6 = i8 + 1;
                    i7++;
                } else if (Utf8.DecodeUtil.c(b2)) {
                    if (i8 >= i4 - 1) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    int i9 = i8 + 1;
                    Utf8.DecodeUtil.a(b2, bArr[i8], bArr[i9], cArr, i7);
                    i6 = i9 + 1;
                    i7++;
                } else if (i8 >= i4 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                } else {
                    int i10 = i8 + 1;
                    byte b4 = bArr[i8];
                    int i11 = i10 + 1;
                    Utf8.DecodeUtil.a(b2, b4, bArr[i10], bArr[i11], cArr, i7);
                    i6 = i11 + 1;
                    i7 = i7 + 1 + 1;
                }
            }
            return new String(cArr, 0, i7);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i, int i2) {
        int i3;
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (true) {
                i3 = i5;
                if (i >= i4) {
                    break;
                }
                byte b = byteBuffer.get(i);
                if (!Utf8.DecodeUtil.a(b)) {
                    break;
                }
                i++;
                Utf8.DecodeUtil.a(b, cArr, i3);
                i5 = i3 + 1;
            }
            int i6 = i;
            int i7 = i3;
            while (i6 < i4) {
                int i8 = i6 + 1;
                byte b2 = byteBuffer.get(i6);
                if (Utf8.DecodeUtil.a(b2)) {
                    Utf8.DecodeUtil.a(b2, cArr, i7);
                    i7++;
                    i6 = i8;
                    while (i6 < i4) {
                        byte b3 = byteBuffer.get(i6);
                        if (!Utf8.DecodeUtil.a(b3)) {
                            break;
                        }
                        i6++;
                        Utf8.DecodeUtil.a(b3, cArr, i7);
                        i7++;
                    }
                } else if (Utf8.DecodeUtil.b(b2)) {
                    if (i8 >= i4) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    Utf8.DecodeUtil.a(b2, byteBuffer.get(i8), cArr, i7);
                    i6 = i8 + 1;
                    i7++;
                } else if (Utf8.DecodeUtil.c(b2)) {
                    if (i8 >= i4 - 1) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    int i9 = i8 + 1;
                    Utf8.DecodeUtil.a(b2, byteBuffer.get(i8), byteBuffer.get(i9), cArr, i7);
                    i6 = i9 + 1;
                    i7++;
                } else if (i8 >= i4 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                } else {
                    int i10 = i8 + 1;
                    byte b4 = byteBuffer.get(i8);
                    int i11 = i10 + 1;
                    Utf8.DecodeUtil.a(b2, b4, byteBuffer.get(i10), byteBuffer.get(i11), cArr, i7);
                    i6 = i11 + 1;
                    i7 = i7 + 1 + 1;
                }
            }
            return new String(cArr, 0, i7);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) throws IllegalArgumentException {
        return byteBuffer.hasArray() ? decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2) : decodeUtf8Buffer(byteBuffer, i, i2);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            a(charSequence, byteBuffer);
            return;
        }
        int arrayOffset = byteBuffer.arrayOffset();
        byteBuffer.position(a(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence charSequence) {
        return a(charSequence);
    }
}
