package com.tencent.tinker.ziputils.ziputil;

import android.widget.ExpandableListView;
import java.nio.ByteOrder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/ziputils/ziputil/Memory.class */
public final class Memory {
    private Memory() {
    }

    public static int peekInt(byte[] bArr, int i, ByteOrder byteOrder) {
        int i2;
        int i3;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            int i4 = i + 1;
            int i5 = i4 + 1;
            i2 = ((bArr[i] & 255) << 24) | ((bArr[i4] & 255) << 16) | ((bArr[i5] & 255) << 8);
            i3 = (bArr[i5 + 1] & 255) << 0;
        } else {
            int i6 = i + 1;
            int i7 = i6 + 1;
            i2 = ((bArr[i] & 255) << 0) | ((bArr[i6] & 255) << 8) | ((bArr[i7] & 255) << 16);
            i3 = (bArr[i7 + 1] & 255) << 24;
        }
        return i3 | i2;
    }

    public static long peekLong(byte[] bArr, int i, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
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
            byte b6 = bArr[i6];
            byte b7 = bArr[i7];
            return ((((((b & 255) << 24) | ((b2 & 255) << 16)) | ((b3 & 255) << 8)) | ((b4 & 255) << 0)) << 32) | ((((bArr[i7 + 1] & 255) << 0) | ((b6 & 255) << 16) | ((b5 & 255) << 24) | ((b7 & 255) << 8)) & ExpandableListView.PACKED_POSITION_VALUE_NULL);
        }
        int i8 = i + 1;
        byte b8 = bArr[i];
        int i9 = i8 + 1;
        byte b9 = bArr[i8];
        int i10 = i9 + 1;
        byte b10 = bArr[i9];
        int i11 = i10 + 1;
        byte b11 = bArr[i10];
        int i12 = i11 + 1;
        byte b12 = bArr[i11];
        int i13 = i12 + 1;
        return ((((b8 & 255) << 0) | ((b9 & 255) << 8) | ((b10 & 255) << 16) | ((b11 & 255) << 24)) & ExpandableListView.PACKED_POSITION_VALUE_NULL) | ((((bArr[i13 + 1] & 255) << 24) | ((((bArr[i12] & 255) << 8) | ((b12 & 255) << 0)) | ((bArr[i13] & 255) << 16))) << 32);
    }

    public static short peekShort(byte[] bArr, int i, ByteOrder byteOrder) {
        int i2;
        byte b;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            i2 = bArr[i] << 8;
            b = bArr[i + 1];
        } else {
            i2 = bArr[i + 1] << 8;
            b = bArr[i];
        }
        return (short) ((b & 255) | i2);
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

    public static void pokeShort(byte[] bArr, int i, short s, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            bArr[i] = (byte) ((s >> 8) & 255);
            bArr[i + 1] = (byte) ((s >> 0) & 255);
            return;
        }
        bArr[i] = (byte) ((s >> 0) & 255);
        bArr[i + 1] = (byte) ((s >> 8) & 255);
    }
}
