package com.ishumei.l111l11111Il.l111l11111lIl;

import android.util.Pair;
import android.widget.ExpandableListView;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l11111lIl/l111l1111llIl.class */
final class l111l1111llIl {
    private static final int l1111l111111Il = 22;
    private static final int l111l11111I1l = 12;
    private static final int l111l11111Il = 16;
    private static final int l111l11111lIl = 101010256;
    private static final int l111l1111l1Il = 20;
    private static final int l111l1111lI1l = 1347094023;
    private static final int l111l1111lIl = 65535;
    private static final int l111l1111llIl = 20;

    l111l1111llIl() {
    }

    public static long l1111l111111Il(ByteBuffer byteBuffer) {
        l111l11111Il(byteBuffer);
        return l1111l111111Il(byteBuffer, byteBuffer.position() + 16);
    }

    private static long l1111l111111Il(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<ByteBuffer, Long> l1111l111111Il(RandomAccessFile randomAccessFile) {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> l1111l111111Il2 = l1111l111111Il(randomAccessFile, 0);
        return l1111l111111Il2 != null ? l1111l111111Il2 : l1111l111111Il(randomAccessFile, 65535);
    }

    private static Pair<ByteBuffer, Long> l1111l111111Il(RandomAccessFile randomAccessFile, int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: " + i);
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i, length - 22)) + 22);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long capacity = length - allocate.capacity();
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        int l111l11111I1l2 = l111l11111I1l(allocate);
        if (l111l11111I1l2 == -1) {
            return null;
        }
        allocate.position(l111l11111I1l2);
        ByteBuffer slice = allocate.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(slice, Long.valueOf(capacity + l111l11111I1l2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean l1111l111111Il(RandomAccessFile randomAccessFile, long j) {
        long j2 = j - 20;
        if (j2 < 0) {
            return false;
        }
        randomAccessFile.seek(j2);
        return randomAccessFile.readInt() == l111l1111lI1l;
    }

    private static int l111l11111I1l(ByteBuffer byteBuffer) {
        l111l11111Il(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i = capacity - 22;
        int min = Math.min(i, 65535);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 > min) {
                return -1;
            }
            int i4 = i - i3;
            if (byteBuffer.getInt(i4) == l111l11111lIl && (byteBuffer.getShort(i4 + 20) & 65535) == i3) {
                return i4;
            }
            i2 = i3 + 1;
        }
    }

    private static void l111l11111Il(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int l111l11111lIl(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & 65535;
    }

    public static long l111l11111lIl(ByteBuffer byteBuffer) {
        l111l11111Il(byteBuffer);
        return l1111l111111Il(byteBuffer, byteBuffer.position() + 12);
    }
}
