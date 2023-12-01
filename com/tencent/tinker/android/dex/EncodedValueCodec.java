package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.util.ByteInput;
import com.tencent.tinker.android.dex.util.ByteOutput;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/EncodedValueCodec.class */
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
        int i2 = 0;
        if (z) {
            for (int i3 = i; i3 >= 0; i3--) {
                i2 = ((byteInput.readByte() & 255) << 24) | (i2 >>> 8);
            }
            return i2;
        }
        int i4 = 0;
        for (int i5 = i; i5 >= 0; i5--) {
            i4 = (i4 >>> 8) | ((byteInput.readByte() & 255) << 24);
        }
        return i4 >>> ((3 - i) * 8);
    }

    public static long readUnsignedLong(ByteInput byteInput, int i, boolean z) {
        long j = 0;
        long j2 = 0;
        if (z) {
            for (int i2 = i; i2 >= 0; i2--) {
                j2 = (j2 >>> 8) | ((byteInput.readByte() & 255) << 56);
            }
            return j2;
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 < 0) {
                return j >>> ((7 - i) * 8);
            }
            j = (j >>> 8) | ((byteInput.readByte() & 255) << 56);
            i3 = i4 - 1;
        }
    }

    public static void writeRightZeroExtendedValue(ByteOutput byteOutput, int i, long j) {
        int numberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j);
        int i2 = numberOfTrailingZeros;
        if (numberOfTrailingZeros == 0) {
            i2 = 1;
        }
        int i3 = (i2 + 7) >> 3;
        long j2 = j >> (64 - (i3 * 8));
        byteOutput.writeByte(i | ((i3 - 1) << 5));
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
        byteOutput.writeByte(i | ((numberOfLeadingZeros - 1) << 5));
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
        byteOutput.writeByte(i | ((i3 - 1) << 5));
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
