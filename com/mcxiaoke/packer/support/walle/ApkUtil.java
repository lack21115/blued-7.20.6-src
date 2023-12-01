package com.mcxiaoke.packer.support.walle;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/mcxiaoke/packer/support/walle/ApkUtil.class */
final class ApkUtil {
    private ApkUtil() {
    }

    public static long a(FileChannel fileChannel) throws IOException {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
        }
        long j = size - 22;
        long min = Math.min(j, 65535L);
        int i = 0;
        while (true) {
            int i2 = i;
            long j2 = i2;
            if (j2 > min) {
                throw new IOException("ZIP End of Central Directory (EOCD) record not found");
            }
            long j3 = j - j2;
            ByteBuffer allocate = ByteBuffer.allocate(4);
            fileChannel.position(j3);
            fileChannel.read(allocate);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            if (allocate.getInt(0) == 101010256) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j3 + 20);
                fileChannel.read(allocate2);
                allocate2.order(ByteOrder.LITTLE_ENDIAN);
                int i3 = allocate2.getShort(0);
                if (i3 == i2) {
                    return i3;
                }
            }
            i = i2 + 1;
        }
    }

    public static long a(FileChannel fileChannel, long j) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        fileChannel.position((fileChannel.size() - j) - 6);
        fileChannel.read(allocate);
        return allocate.getInt(0);
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i < 0) {
            throw new IllegalArgumentException("size: " + i);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        } else {
            int capacity = byteBuffer.capacity();
            if (i2 > byteBuffer.capacity()) {
                throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
            }
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            try {
                byteBuffer.position(0);
                byteBuffer.limit(i2);
                byteBuffer.position(i);
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                return slice;
            } finally {
                byteBuffer.position(0);
                byteBuffer.limit(limit);
                byteBuffer.position(position);
            }
        }
    }

    public static Map<Integer, ByteBuffer> a(ByteBuffer byteBuffer) throws IOException {
        b(byteBuffer);
        ByteBuffer a2 = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        while (a2.hasRemaining()) {
            i++;
            if (a2.remaining() < 8) {
                throw new IOException("Insufficient data to read size of APK Signing Block entry #" + i);
            }
            long j = a2.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new IOException("APK Signing Block entry #" + i + " size out of range: " + j);
            }
            int i2 = (int) j;
            int position = a2.position();
            if (i2 > a2.remaining()) {
                throw new IOException("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + a2.remaining());
            }
            linkedHashMap.put(Integer.valueOf(a2.getInt()), a(a2, i2 - 4));
            a2.position(position + i2);
        }
        return linkedHashMap;
    }

    public static long b(FileChannel fileChannel) throws IOException {
        return a(fileChannel, a(fileChannel));
    }

    public static Pair<ByteBuffer, Long> b(FileChannel fileChannel, long j) throws IOException {
        if (j < 32) {
            throw new IOException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j);
        }
        fileChannel.position(j - 24);
        ByteBuffer allocate = ByteBuffer.allocate(24);
        fileChannel.read(allocate);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
            long j2 = allocate.getLong(0);
            if (j2 < allocate.capacity() || j2 > 2147483639) {
                throw new IOException("APK Signing Block size out of range: " + j2);
            }
            int i = (int) (8 + j2);
            long j3 = j - i;
            if (j3 < 0) {
                throw new IOException("APK Signing Block offset out of range: " + j3);
            }
            fileChannel.position(j3);
            ByteBuffer allocate2 = ByteBuffer.allocate(i);
            fileChannel.read(allocate2);
            allocate2.order(ByteOrder.LITTLE_ENDIAN);
            long j4 = allocate2.getLong(0);
            if (j4 == j2) {
                return Pair.a(allocate2, Long.valueOf(j3));
            }
            throw new IOException("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        throw new IOException("No APK Signing Block before ZIP Central Directory");
    }

    private static void b(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static Pair<ByteBuffer, Long> c(FileChannel fileChannel) throws IOException {
        return b(fileChannel, b(fileChannel));
    }
}
