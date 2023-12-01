package com.android.dex;

import com.android.dex.util.ByteInput;
import com.android.dex.util.ByteOutput;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/EncodedValueCodec.class */
public final class EncodedValueCodec {
    private EncodedValueCodec() {
    }

    public static int readSignedInt(ByteInput byteInput, int i) {
        int i2 = 0;
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 < 0) {
                return i2 >> ((3 - i) * 8);
            }
            i2 = (i2 >>> 8) | ((byteInput.readByte() & 255) << 24);
            i3 = i4 - 1;
        }
    }

    public static long readSignedLong(ByteInput byteInput, int i) {
        long j = 0;
        int i2 = i;
        while (true) {
            int i3 = i2;
            if (i3 < 0) {
                return j >> ((7 - i) * 8);
            }
            j = (j >>> 8) | ((byteInput.readByte() & 255) << 56);
            i2 = i3 - 1;
        }
    }

    public static int readUnsignedInt(ByteInput byteInput, int i, boolean z) {
        int i2;
        int i3 = 0;
        if (z) {
            int i4 = i;
            int i5 = 0;
            while (true) {
                i2 = i5;
                if (i4 < 0) {
                    break;
                }
                i5 = (i5 >>> 8) | ((byteInput.readByte() & 255) << 24);
                i4--;
            }
        } else {
            int i6 = i;
            while (true) {
                int i7 = i6;
                if (i7 < 0) {
                    break;
                }
                i3 = (i3 >>> 8) | ((byteInput.readByte() & 255) << 24);
                i6 = i7 - 1;
            }
            i2 = i3 >>> ((3 - i) * 8);
        }
        return i2;
    }

    public static long readUnsignedLong(ByteInput byteInput, int i, boolean z) {
        long j;
        long j2 = 0;
        if (z) {
            while (true) {
                j = j2;
                if (i < 0) {
                    break;
                }
                j2 = (j2 >>> 8) | ((byteInput.readByte() & 255) << 56);
                i--;
            }
        } else {
            int i2 = i;
            while (true) {
                int i3 = i2;
                if (i3 < 0) {
                    break;
                }
                j2 = (j2 >>> 8) | ((byteInput.readByte() & 255) << 56);
                i2 = i3 - 1;
            }
            j = j2 >>> ((7 - i) * 8);
        }
        return j;
    }

    public static void writeRightZeroExtendedValue(ByteOutput byteOutput, int i, long j) {
        int numberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j);
        int i2 = numberOfTrailingZeros;
        if (numberOfTrailingZeros == 0) {
            i2 = 1;
        }
        int i3 = (i2 + 7) >> 3;
        long j2 = j >> (64 - (i3 * 8));
        byteOutput.writeByte(((i3 - 1) << 5) | i);
        int i4 = i3;
        while (true) {
            int i5 = i4;
            if (i5 <= 0) {
                return;
            }
            byteOutput.writeByte((byte) j2);
            j2 >>= 8;
            i4 = i5 - 1;
        }
    }

    public static void writeSignedIntegralValue(ByteOutput byteOutput, int i, long j) {
        int numberOfLeadingZeros = ((65 - Long.numberOfLeadingZeros((j >> 63) ^ j)) + 7) >> 3;
        byteOutput.writeByte(((numberOfLeadingZeros - 1) << 5) | i);
        int i2 = numberOfLeadingZeros;
        while (true) {
            int i3 = i2;
            if (i3 <= 0) {
                return;
            }
            byteOutput.writeByte((byte) j);
            j >>= 8;
            i2 = i3 - 1;
        }
    }

    public static void writeUnsignedIntegralValue(ByteOutput byteOutput, int i, long j) {
        int numberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j);
        int i2 = numberOfLeadingZeros;
        if (numberOfLeadingZeros == 0) {
            i2 = 1;
        }
        int i3 = (i2 + 7) >> 3;
        byteOutput.writeByte(((i3 - 1) << 5) | i);
        int i4 = i3;
        while (true) {
            int i5 = i4;
            if (i5 <= 0) {
                return;
            }
            byteOutput.writeByte((byte) j);
            j >>= 8;
            i4 = i5 - 1;
        }
    }
}
