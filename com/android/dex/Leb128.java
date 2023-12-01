package com.android.dex;

import com.android.dex.util.ByteInput;
import com.android.dex.util.ByteOutput;

/* loaded from: source-2895416-dex2jar.jar:com/android/dex/Leb128.class */
public final class Leb128 {
    private Leb128() {
    }

    public static int readSignedLeb128(ByteInput byteInput) {
        int readByte;
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        do {
            readByte = byteInput.readByte() & 255;
            i = i4 | ((readByte & 127) << (i5 * 7));
            i2 = i6 << 7;
            i3 = i5 + 1;
            if ((readByte & 128) != 128) {
                break;
            }
            i5 = i3;
            i4 = i;
            i6 = i2;
        } while (i3 < 5);
        if ((readByte & 128) == 128) {
            throw new DexException("invalid LEB128 sequence");
        }
        int i7 = i;
        if (((i2 >> 1) & i) != 0) {
            i7 = i | i2;
        }
        return i7;
    }

    public static int readUnsignedLeb128(ByteInput byteInput) {
        int readByte;
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        do {
            readByte = byteInput.readByte() & 255;
            i = i3 | ((readByte & 127) << (i4 * 7));
            i2 = i4 + 1;
            if ((readByte & 128) != 128) {
                break;
            }
            i4 = i2;
            i3 = i;
        } while (i2 < 5);
        if ((readByte & 128) == 128) {
            throw new DexException("invalid LEB128 sequence");
        }
        return i;
    }

    public static int signedLeb128Size(int i) {
        int i2 = i >> 7;
        int i3 = 0;
        boolean z = true;
        int i4 = (Integer.MIN_VALUE & i) == 0 ? 0 : -1;
        while (z) {
            boolean z2 = (i2 == i4 && (i2 & 1) == ((i >> 6) & 1)) ? false : true;
            int i5 = i2;
            i2 >>= 7;
            i3++;
            z = z2;
            i = i5;
        }
        return i3;
    }

    public static int unsignedLeb128Size(int i) {
        int i2 = i >> 7;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 == 0) {
                return i4 + 1;
            }
            i2 >>= 7;
            i3 = i4 + 1;
        }
    }

    public static void writeSignedLeb128(ByteOutput byteOutput, int i) {
        int i2;
        int i3;
        int i4 = i >> 7;
        boolean z = true;
        if ((Integer.MIN_VALUE & i) == 0) {
            i2 = 0;
            i3 = i;
        } else {
            i2 = -1;
            i3 = i;
        }
        while (z) {
            boolean z2 = (i4 == i2 && (i4 & 1) == ((i3 >> 6) & 1)) ? false : true;
            byteOutput.writeByte((byte) ((z2 ? 128 : 0) | (i3 & 127)));
            i3 = i4;
            i4 >>= 7;
            z = z2;
        }
    }

    public static void writeUnsignedLeb128(ByteOutput byteOutput, int i) {
        int i2 = i;
        int i3 = i >>> 7;
        while (true) {
            int i4 = i3;
            if (i4 == 0) {
                byteOutput.writeByte((byte) (i2 & 127));
                return;
            }
            byteOutput.writeByte((byte) ((i2 & 127) | 128));
            i2 = i4;
            i3 = i4 >>> 7;
        }
    }
}
