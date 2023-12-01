package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.ByteString;
import okio._Base64Kt;
import okio._JvmPlatformKt;
import okio._UtilKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/internal/_ByteStringKt.class */
public final class _ByteStringKt {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Code restructure failed: missing block: B:837:0x000b, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:838:0x000b, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:799:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:802:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:805:0x022f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:820:0x0385 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:821:0x051c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int codePointIndexToCharIndex(byte[] r4, int r5) {
        /*
            Method dump skipped, instructions count: 1359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }

    public static final String commonBase64(ByteString byteString) {
        Intrinsics.e(byteString, "<this>");
        return _Base64Kt.encodeBase64$default(byteString.getData$okio(), null, 1, null);
    }

    public static final String commonBase64Url(ByteString byteString) {
        Intrinsics.e(byteString, "<this>");
        return _Base64Kt.encodeBase64(byteString.getData$okio(), _Base64Kt.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(ByteString byteString, ByteString other) {
        Intrinsics.e(byteString, "<this>");
        Intrinsics.e(other, "other");
        int size = byteString.size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= min) {
                if (size == size2) {
                    return 0;
                }
                return size < size2 ? -1 : 1;
            }
            int i3 = byteString.getByte(i2) & 255;
            int i4 = other.getByte(i2) & 255;
            if (i3 != i4) {
                return i3 < i4 ? -1 : 1;
            }
            i = i2 + 1;
        }
    }

    public static final void commonCopyInto(ByteString byteString, int i, byte[] target, int i2, int i3) {
        Intrinsics.e(byteString, "<this>");
        Intrinsics.e(target, "target");
        ArraysKt.a(byteString.getData$okio(), target, i2, i, i3 + i);
    }

    public static final ByteString commonDecodeBase64(String str) {
        Intrinsics.e(str, "<this>");
        byte[] decodeBase64ToArray = _Base64Kt.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    public static final ByteString commonDecodeHex(String str) {
        Intrinsics.e(str, "<this>");
        int i = 0;
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            int i2 = length - 1;
            if (i2 >= 0) {
                while (true) {
                    int i3 = i;
                    i = i3 + 1;
                    int i4 = i3 * 2;
                    bArr[i3] = (byte) ((decodeHexDigit(str.charAt(i4)) << 4) + decodeHexDigit(str.charAt(i4 + 1)));
                    if (i > i2) {
                        break;
                    }
                }
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException(Intrinsics.a("Unexpected hex string: ", (Object) str).toString());
    }

    public static final ByteString commonEncodeUtf8(String str) {
        Intrinsics.e(str, "<this>");
        ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(ByteString byteString, ByteString suffix) {
        Intrinsics.e(byteString, "<this>");
        Intrinsics.e(suffix, "suffix");
        return byteString.rangeEquals(byteString.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEndsWith(ByteString byteString, byte[] suffix) {
        Intrinsics.e(byteString, "<this>");
        Intrinsics.e(suffix, "suffix");
        return byteString.rangeEquals(byteString.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final boolean commonEquals(ByteString byteString, Object obj) {
        Intrinsics.e(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            return byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length);
        }
        return false;
    }

    public static final byte commonGetByte(ByteString byteString, int i) {
        Intrinsics.e(byteString, "<this>");
        return byteString.getData$okio()[i];
    }

    public static final int commonGetSize(ByteString byteString) {
        Intrinsics.e(byteString, "<this>");
        return byteString.getData$okio().length;
    }

    public static final int commonHashCode(ByteString byteString) {
        Intrinsics.e(byteString, "<this>");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    public static final String commonHex(ByteString byteString) {
        Intrinsics.e(byteString, "<this>");
        char[] cArr = new char[byteString.getData$okio().length * 2];
        byte[] data$okio = byteString.getData$okio();
        int length = data$okio.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = data$okio[i];
            i++;
            int i3 = i2 + 1;
            cArr[i2] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = getHEX_DIGIT_CHARS()[b & 15];
        }
        return StringsKt.a(cArr);
    }

    public static final int commonIndexOf(ByteString byteString, byte[] other, int i) {
        Intrinsics.e(byteString, "<this>");
        Intrinsics.e(other, "other");
        int length = byteString.getData$okio().length - other.length;
        int max = Math.max(i, 0);
        if (max <= length) {
            while (!_UtilKt.arrayRangeEquals(byteString.getData$okio(), max, other, 0, other.length)) {
                if (max == length) {
                    return -1;
                }
                max++;
            }
            return max;
        }
        return -1;
    }

    public static final byte[] commonInternalArray(ByteString byteString) {
        Intrinsics.e(byteString, "<this>");
        return byteString.getData$okio();
    }

    public static final int commonLastIndexOf(ByteString byteString, ByteString other, int i) {
        Intrinsics.e(byteString, "<this>");
        Intrinsics.e(other, "other");
        return byteString.lastIndexOf(other.internalArray$okio(), i);
    }

    public static final int commonLastIndexOf(ByteString byteString, byte[] other, int i) {
        Intrinsics.e(byteString, "<this>");
        Intrinsics.e(other, "other");
        int min = Math.min(_UtilKt.resolveDefaultParameter(byteString, i), byteString.getData$okio().length - other.length);
        if (min < 0) {
            return -1;
        }
        while (true) {
            int i2 = min - 1;
            if (_UtilKt.arrayRangeEquals(byteString.getData$okio(), min, other, 0, other.length)) {
                return min;
            }
            if (i2 < 0) {
                return -1;
            }
            min = i2;
        }
    }

    public static final ByteString commonOf(byte[] data) {
        Intrinsics.e(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.c(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(ByteString byteString, int i, ByteString other, int i2, int i3) {
        Intrinsics.e(byteString, "<this>");
        Intrinsics.e(other, "other");
        return other.rangeEquals(i2, byteString.getData$okio(), i, i3);
    }

    public static final boolean commonRangeEquals(ByteString byteString, int i, byte[] other, int i2, int i3) {
        Intrinsics.e(byteString, "<this>");
        Intrinsics.e(other, "other");
        return i >= 0 && i <= byteString.getData$okio().length - i3 && i2 >= 0 && i2 <= other.length - i3 && _UtilKt.arrayRangeEquals(byteString.getData$okio(), i, other, i2, i3);
    }

    public static final boolean commonStartsWith(ByteString byteString, ByteString prefix) {
        Intrinsics.e(byteString, "<this>");
        Intrinsics.e(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.size());
    }

    public static final boolean commonStartsWith(ByteString byteString, byte[] prefix) {
        Intrinsics.e(byteString, "<this>");
        Intrinsics.e(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.length);
    }

    public static final ByteString commonSubstring(ByteString byteString, int i, int i2) {
        Intrinsics.e(byteString, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString, i2);
        if (i >= 0) {
            if (resolveDefaultParameter <= byteString.getData$okio().length) {
                if (resolveDefaultParameter - i >= 0) {
                    return (i == 0 && resolveDefaultParameter == byteString.getData$okio().length) ? byteString : new ByteString(ArraysKt.a(byteString.getData$okio(), i, resolveDefaultParameter));
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    public static final ByteString commonToAsciiLowercase(ByteString byteString) {
        byte b;
        Intrinsics.e(byteString, "<this>");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= byteString.getData$okio().length) {
                return byteString;
            }
            byte b2 = byteString.getData$okio()[i2];
            byte b3 = (byte) 65;
            if (b2 < b3 || b2 > (b = (byte) 90)) {
                i = i2 + 1;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.c(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b2 + 32);
                int i3 = i2 + 1;
                while (true) {
                    int i4 = i3;
                    if (i4 >= copyOf.length) {
                        return new ByteString(copyOf);
                    }
                    byte b4 = copyOf[i4];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i4] = (byte) (b4 + 32);
                    }
                    i3 = i4 + 1;
                }
            }
        }
    }

    public static final ByteString commonToAsciiUppercase(ByteString byteString) {
        byte b;
        Intrinsics.e(byteString, "<this>");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= byteString.getData$okio().length) {
                return byteString;
            }
            byte b2 = byteString.getData$okio()[i2];
            byte b3 = (byte) 97;
            if (b2 < b3 || b2 > (b = (byte) 122)) {
                i = i2 + 1;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.c(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b2 - 32);
                int i3 = i2 + 1;
                while (true) {
                    int i4 = i3;
                    if (i4 >= copyOf.length) {
                        return new ByteString(copyOf);
                    }
                    byte b4 = copyOf[i4];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i4] = (byte) (b4 - 32);
                    }
                    i3 = i4 + 1;
                }
            }
        }
    }

    public static final byte[] commonToByteArray(ByteString byteString) {
        Intrinsics.e(byteString, "<this>");
        byte[] data$okio = byteString.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.c(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    public static final ByteString commonToByteString(byte[] bArr, int i, int i2) {
        Intrinsics.e(bArr, "<this>");
        _UtilKt.checkOffsetAndCount(bArr.length, i, i2);
        return new ByteString(ArraysKt.a(bArr, i, i2 + i));
    }

    public static final String commonToString(ByteString byteString) {
        ByteString byteString2 = byteString;
        Intrinsics.e(byteString2, "<this>");
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (codePointIndexToCharIndex != -1) {
            String utf8 = byteString.utf8();
            if (utf8 != null) {
                String substring = utf8.substring(0, codePointIndexToCharIndex);
                Intrinsics.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String a = StringsKt.a(StringsKt.a(StringsKt.a(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
                if (codePointIndexToCharIndex >= utf8.length()) {
                    return "[text=" + a + ']';
                }
                return "[size=" + byteString.getData$okio().length + " text=" + a + "…]";
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } else if (byteString.getData$okio().length <= 64) {
            return "[hex=" + byteString.hex() + ']';
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(byteString.getData$okio().length);
            sb.append(" hex=");
            int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString2, 64);
            if (!(resolveDefaultParameter <= byteString.getData$okio().length)) {
                throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
            }
            if (resolveDefaultParameter + 0 >= 0) {
                if (resolveDefaultParameter != byteString.getData$okio().length) {
                    byteString2 = new ByteString(ArraysKt.a(byteString.getData$okio(), 0, resolveDefaultParameter));
                }
                sb.append(byteString2.hex());
                sb.append("…]");
                return sb.toString();
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
    }

    public static final String commonUtf8(ByteString byteString) {
        Intrinsics.e(byteString, "<this>");
        String utf8$okio = byteString.getUtf8$okio();
        String str = utf8$okio;
        if (utf8$okio == null) {
            str = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
            byteString.setUtf8$okio(str);
        }
        return str;
    }

    public static final void commonWrite(ByteString byteString, Buffer buffer, int i, int i2) {
        Intrinsics.e(byteString, "<this>");
        Intrinsics.e(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i, i2);
    }

    public static final int decodeHexDigit(char c) {
        char c2;
        if ('0' <= c && c <= '9') {
            return c - '0';
        }
        if ('a' <= c && c <= 'f') {
            c2 = 'a';
        } else {
            if (!('A' <= c && c <= 'F')) {
                throw new IllegalArgumentException(Intrinsics.a("Unexpected hex digit: ", (Object) Character.valueOf(c)));
            }
            c2 = 'A';
        }
        return (c - c2) + 10;
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }
}
