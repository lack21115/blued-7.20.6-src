package libcore.io;

import android.widget.ExpandableListView;
import java.nio.ByteOrder;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/Memory.class */
public final class Memory {
    private Memory() {
    }

    public static native void memmove(Object obj, int i, Object obj2, int i2, long j);

    public static native byte peekByte(long j);

    public static native void peekByteArray(long j, byte[] bArr, int i, int i2);

    public static native void peekCharArray(long j, char[] cArr, int i, int i2, boolean z);

    public static native void peekDoubleArray(long j, double[] dArr, int i, int i2, boolean z);

    public static native void peekFloatArray(long j, float[] fArr, int i, int i2, boolean z);

    public static int peekInt(long j, boolean z) {
        int peekIntNative = peekIntNative(j);
        int i = peekIntNative;
        if (z) {
            i = Integer.reverseBytes(peekIntNative);
        }
        return i;
    }

    public static int peekInt(byte[] bArr, int i, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            int i2 = i + 1;
            int i3 = i2 + 1;
            return ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8) | ((bArr[i3 + 1] & 255) << 0);
        }
        int i4 = i + 1;
        int i5 = i4 + 1;
        return ((bArr[i] & 255) << 0) | ((bArr[i4] & 255) << 8) | ((bArr[i5] & 255) << 16) | ((bArr[i5 + 1] & 255) << 24);
    }

    public static native void peekIntArray(long j, int[] iArr, int i, int i2, boolean z);

    private static native int peekIntNative(long j);

    public static long peekLong(long j, boolean z) {
        long peekLongNative = peekLongNative(j);
        long j2 = peekLongNative;
        if (z) {
            j2 = Long.reverseBytes(peekLongNative);
        }
        return j2;
    }

    public static long peekLong(byte[] bArr, int i, ByteOrder byteOrder) {
        if (byteOrder != ByteOrder.BIG_ENDIAN) {
            int i2 = i + 1;
            byte b = bArr[i];
            int i3 = i2 + 1;
            byte b2 = bArr[i2];
            int i4 = i3 + 1;
            byte b3 = bArr[i3];
            int i5 = i4 + 1;
            byte b4 = bArr[i4];
            int i6 = i5 + 1;
            byte b5 = bArr[i5];
            int i7 = i6 + 1;
            return ((((((b5 & 255) << 0) | ((bArr[i6] & 255) << 8)) | ((bArr[i7] & 255) << 16)) | ((bArr[i7 + 1] & 255) << 24)) << 32) | ((((b & 255) << 0) | ((b2 & 255) << 8) | ((b3 & 255) << 16) | ((b4 & 255) << 24)) & ExpandableListView.PACKED_POSITION_VALUE_NULL);
        }
        int i8 = i + 1;
        byte b6 = bArr[i];
        int i9 = i8 + 1;
        byte b7 = bArr[i8];
        int i10 = i9 + 1;
        byte b8 = bArr[i9];
        int i11 = i10 + 1;
        byte b9 = bArr[i10];
        int i12 = i11 + 1;
        byte b10 = bArr[i11];
        int i13 = i12 + 1;
        return ((((((b6 & 255) << 24) | ((b7 & 255) << 16)) | ((b8 & 255) << 8)) | ((b9 & 255) << 0)) << 32) | ((((b10 & 255) << 24) | ((bArr[i12] & 255) << 16) | ((bArr[i13] & 255) << 8) | ((bArr[i13 + 1] & 255) << 0)) & ExpandableListView.PACKED_POSITION_VALUE_NULL);
    }

    public static native void peekLongArray(long j, long[] jArr, int i, int i2, boolean z);

    private static native long peekLongNative(long j);

    public static short peekShort(long j, boolean z) {
        short peekShortNative = peekShortNative(j);
        short s = peekShortNative;
        if (z) {
            s = Short.reverseBytes(peekShortNative);
        }
        return s;
    }

    public static short peekShort(byte[] bArr, int i, ByteOrder byteOrder) {
        return byteOrder == ByteOrder.BIG_ENDIAN ? (short) ((bArr[i] << 8) | (bArr[i + 1] & 255)) : (short) ((bArr[i + 1] << 8) | (bArr[i] & 255));
    }

    public static native void peekShortArray(long j, short[] sArr, int i, int i2, boolean z);

    private static native short peekShortNative(long j);

    public static native void pokeByte(long j, byte b);

    public static native void pokeByteArray(long j, byte[] bArr, int i, int i2);

    public static native void pokeCharArray(long j, char[] cArr, int i, int i2, boolean z);

    public static native void pokeDoubleArray(long j, double[] dArr, int i, int i2, boolean z);

    public static native void pokeFloatArray(long j, float[] fArr, int i, int i2, boolean z);

    public static void pokeInt(long j, int i, boolean z) {
        int i2 = i;
        if (z) {
            i2 = Integer.reverseBytes(i);
        }
        pokeIntNative(j, i2);
    }

    public static void pokeInt(byte[] bArr, int i, int i2, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            int i3 = i + 1;
            bArr[i] = (byte) ((i2 >> 24) & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i2 >> 16) & 255);
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            bArr[i4 + 1] = (byte) ((i2 >> 0) & 255);
            return;
        }
        int i5 = i + 1;
        bArr[i] = (byte) ((i2 >> 0) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >> 8) & 255);
        bArr[i6] = (byte) ((i2 >> 16) & 255);
        bArr[i6 + 1] = (byte) ((i2 >> 24) & 255);
    }

    public static native void pokeIntArray(long j, int[] iArr, int i, int i2, boolean z);

    private static native void pokeIntNative(long j, int i);

    public static void pokeLong(long j, long j2, boolean z) {
        long j3 = j2;
        if (z) {
            j3 = Long.reverseBytes(j2);
        }
        pokeLongNative(j, j3);
    }

    public static void pokeLong(byte[] bArr, int i, long j, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            int i2 = (int) (j >> 32);
            int i3 = i + 1;
            bArr[i] = (byte) ((i2 >> 24) & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i2 >> 16) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((i2 >> 0) & 255);
            int i7 = (int) j;
            int i8 = i6 + 1;
            bArr[i6] = (byte) ((i7 >> 24) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((i7 >> 16) & 255);
            bArr[i9] = (byte) ((i7 >> 8) & 255);
            bArr[i9 + 1] = (byte) ((i7 >> 0) & 255);
            return;
        }
        int i10 = (int) j;
        int i11 = i + 1;
        bArr[i] = (byte) ((i10 >> 0) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >> 8) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >> 24) & 255);
        int i15 = (int) (j >> 32);
        int i16 = i14 + 1;
        bArr[i14] = (byte) ((i15 >> 0) & 255);
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((i15 >> 8) & 255);
        bArr[i17] = (byte) ((i15 >> 16) & 255);
        bArr[i17 + 1] = (byte) ((i15 >> 24) & 255);
    }

    public static native void pokeLongArray(long j, long[] jArr, int i, int i2, boolean z);

    private static native void pokeLongNative(long j, long j2);

    public static void pokeShort(long j, short s, boolean z) {
        short s2 = s;
        if (z) {
            s2 = Short.reverseBytes(s);
        }
        pokeShortNative(j, s2);
    }

    public static void pokeShort(byte[] bArr, int i, short s, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            bArr[i] = (byte) ((s >> 8) & 255);
            bArr[i + 1] = (byte) ((s >> 0) & 255);
            return;
        }
        bArr[i] = (byte) ((s >> 0) & 255);
        bArr[i + 1] = (byte) ((s >> 8) & 255);
    }

    public static native void pokeShortArray(long j, short[] sArr, int i, int i2, boolean z);

    private static native void pokeShortNative(long j, short s);

    public static native void unsafeBulkGet(Object obj, int i, int i2, byte[] bArr, int i3, int i4, boolean z);

    public static native void unsafeBulkPut(byte[] bArr, int i, int i2, Object obj, int i3, int i4, boolean z);
}
