package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.util.ByteInput;
import com.tencent.tinker.android.dex.util.ByteOutput;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/Leb128.class */
public final class Leb128 {
    private Leb128() {
    }

    public static int readSignedLeb128(ByteInput byteInput) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        int i7 = -1;
        do {
            int readByte = byteInput.readByte() & 255;
            i = i5 | ((readByte & 127) << (i6 * 7));
            i2 = i7 << 7;
            i3 = i6 + 1;
            i4 = readByte & 128;
            if (i4 != 128) {
                break;
            }
            i5 = i;
            i6 = i3;
            i7 = i2;
        } while (i3 < 5);
        if (i4 != 128) {
            int i8 = i;
            if (((i2 >> 1) & i) != 0) {
                i8 = i | i2;
            }
            return i8;
        }
        throw new DexException("invalid LEB128 sequence");
    }

    public static int readUnsignedLeb128(ByteInput byteInput) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        do {
            int readByte = byteInput.readByte() & 255;
            i = i4 | ((readByte & 127) << (i5 * 7));
            i2 = i5 + 1;
            i3 = readByte & 128;
            if (i3 != 128) {
                break;
            }
            i4 = i;
            i5 = i2;
        } while (i2 < 5);
        if (i3 != 128) {
            return i;
        }
        throw new DexException("invalid LEB128 sequence");
    }

    public static int readUnsignedLeb128p1(ByteInput byteInput) {
        return readUnsignedLeb128(byteInput) - 1;
    }

    public static int signedLeb128Size(int i) {
        int i2 = i >> 7;
        int i3 = (Integer.MIN_VALUE & i) == 0 ? 0 : -1;
        boolean z = true;
        int i4 = 0;
        int i5 = i;
        int i6 = i2;
        while (true) {
            int i7 = i6;
            if (!z) {
                return i4;
            }
            i6 = i7 >> 7;
            i4++;
            z = (i7 == i3 && (i7 & 1) == ((i5 >> 6) & 1)) ? false : true;
            i5 = i7;
        }
    }

    public static int unsignedLeb128Size(int i) {
        int i2 = i >>> 7;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 == 0) {
                return i4 + 1;
            }
            i2 >>>= 7;
            i3 = i4 + 1;
        }
    }

    public static int unsignedLeb128p1Size(int i) {
        return unsignedLeb128Size(i + 1);
    }

    public static int writeSignedLeb128(ByteOutput byteOutput, int i) {
        int i2 = i >> 7;
        int i3 = (Integer.MIN_VALUE & i) == 0 ? 0 : -1;
        boolean z = true;
        int i4 = 0;
        while (true) {
            int i5 = i;
            int i6 = i2;
            if (!z) {
                return i4;
            }
            boolean z2 = (i6 == i3 && (i6 & 1) == ((i5 >> 6) & 1)) ? false : true;
            byteOutput.writeByte((byte) ((i5 & 127) | (z2 ? 128 : 0)));
            i4++;
            i2 = i6 >> 7;
            z = z2;
            i = i6;
        }
    }

    public static int writeUnsignedLeb128(ByteOutput byteOutput, int i) {
        int i2 = 0;
        int i3 = i;
        int i4 = i >>> 7;
        while (true) {
            int i5 = i4;
            int i6 = i3;
            i3 = i5;
            if (i3 == 0) {
                byteOutput.writeByte((byte) (i6 & 127));
                return i2 + 1;
            }
            byteOutput.writeByte((byte) ((i6 & 127) | 128));
            i2++;
            i4 = i3 >>> 7;
        }
    }

    public static int writeUnsignedLeb128p1(ByteOutput byteOutput, int i) {
        return writeUnsignedLeb128(byteOutput, i + 1);
    }
}
