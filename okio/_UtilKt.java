package okio;

import android.os.BatteryStats;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.internal._ByteStringKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/_UtilKt.class */
public final class _UtilKt {
    private static final Buffer.UnsafeCursor DEFAULT__new_UnsafeCursor = new Buffer.UnsafeCursor();
    private static final int DEFAULT__ByteString_size = -1234567890;

    public static final int and(byte b, int i) {
        return b & i;
    }

    public static final long and(byte b, long j) {
        return b & j;
    }

    public static final long and(int i, long j) {
        return i & j;
    }

    public static final boolean arrayRangeEquals(byte[] a2, int i, byte[] b, int i2, int i3) {
        Intrinsics.e(a2, "a");
        Intrinsics.e(b, "b");
        if (i3 <= 0) {
            return true;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            int i6 = i5 + 1;
            if (a2[i5 + i] != b[i5 + i2]) {
                return false;
            }
            if (i6 >= i3) {
                return true;
            }
            i4 = i6;
        }
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static final int getDEFAULT__ByteString_size() {
        return DEFAULT__ByteString_size;
    }

    public static final Buffer.UnsafeCursor getDEFAULT__new_UnsafeCursor() {
        return DEFAULT__new_UnsafeCursor;
    }

    public static /* synthetic */ void getDEFAULT__new_UnsafeCursor$annotations() {
    }

    public static final int leftRotate(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    public static final long minOf(int i, long j) {
        return Math.min(i, j);
    }

    public static final long minOf(long j, int i) {
        return Math.min(j, i);
    }

    public static final int resolveDefaultParameter(ByteString byteString, int i) {
        Intrinsics.e(byteString, "<this>");
        return i == DEFAULT__ByteString_size ? byteString.size() : i;
    }

    public static final Buffer.UnsafeCursor resolveDefaultParameter(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.e(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor unsafeCursor2 = unsafeCursor;
        if (unsafeCursor == DEFAULT__new_UnsafeCursor) {
            unsafeCursor2 = new Buffer.UnsafeCursor();
        }
        return unsafeCursor2;
    }

    public static final int reverseBytes(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static final long reverseBytes(long j) {
        return ((j & 255) << 56) | ((BatteryStats.STEP_LEVEL_MODIFIED_MODE_MASK & j) >>> 56) | ((BatteryStats.STEP_LEVEL_INITIAL_MODE_MASK & j) >>> 40) | ((BatteryStats.STEP_LEVEL_LEVEL_MASK & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((65280 & j) << 40);
    }

    public static final short reverseBytes(short s) {
        int i = s & 65535;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    public static final long rightRotate(long j, int i) {
        return (j << (64 - i)) | (j >>> i);
    }

    public static final int shl(byte b, int i) {
        return b << i;
    }

    public static final int shr(byte b, int i) {
        return b >> i;
    }

    public static final String toHexString(byte b) {
        return StringsKt.a(new char[]{_ByteStringKt.getHEX_DIGIT_CHARS()[(b >> 4) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[b & 15]});
    }

    public static final String toHexString(int i) {
        int i2;
        if (i == 0) {
            return "0";
        }
        char[] cArr = {_ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 28) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 24) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 20) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 16) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 12) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 8) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i >> 4) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[i & 15]};
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 >= 8 || cArr[i2] != '0') {
                break;
            }
            i3 = i2 + 1;
        }
        return StringsKt.a(cArr, i2, 8);
    }

    public static final String toHexString(long j) {
        if (j == 0) {
            return "0";
        }
        int i = 0;
        char[] cArr = {_ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 60) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 56) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 52) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 48) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 44) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 40) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 36) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 32) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 28) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 24) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 20) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 16) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 12) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 8) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j >> 4) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) (j & 15)]};
        while (i < 16 && cArr[i] == '0') {
            i++;
        }
        return StringsKt.a(cArr, i, 16);
    }

    public static final byte xor(byte b, byte b2) {
        return (byte) (b ^ b2);
    }
}
