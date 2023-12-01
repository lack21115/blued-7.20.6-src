package com.ishumei.l111l11111Il.l111l11111lIl;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l11111lIl/l111l11111lIl.class */
public final class l111l11111lIl {
    private static final long l1111l111111Il = 3617552046287187010L;
    private static final int l111l11111I1l = 32;
    private static int l111l11111Il = 257;
    private static final long l111l11111lIl = 2334950737559900225L;
    private static int l111l1111l1Il = 258;
    private static int l111l1111lI1l = 260;
    private static int l111l1111lIl = 513;
    private static int l111l1111llIl = 259;
    private static int l11l1111I11l = 769;
    private static int l11l1111I1l = 1057;
    private static int l11l1111I1ll = 1059;
    private static int l11l1111Il = 1061;
    private static int l11l1111Il1l = 1;
    private static int l11l1111Ill = 2;
    private static int l11l1111lIIl = 514;
    private static int l11l11IlIIll = 3;

    l111l11111lIl() {
    }

    static int l1111l111111Il(int i) {
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    if (i == 1057 || i == 1059 || i == 1061) {
                        return 3;
                    }
                    switch (i) {
                        case 257:
                        case 259:
                            return 1;
                        case 258:
                        case 260:
                            return 2;
                        default:
                            throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i));
                    }
                }
                return 1;
            }
            return 2;
        }
        return 1;
    }

    private static long l1111l111111Il(ByteBuffer byteBuffer, long j) {
        long l1111l111111Il2 = l111l1111llIl.l1111l111111Il(byteBuffer);
        if (l1111l111111Il2 <= j) {
            if (l111l1111llIl.l111l11111lIl(byteBuffer) + l1111l111111Il2 == j) {
                return l1111l111111Il2;
            }
            throw new IOException("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new IOException("ZIP Central Directory offset out of range: " + l1111l111111Il2 + ". ZIP End of Central Directory offset: " + j);
    }

    private static Pair<ByteBuffer, Long> l1111l111111Il(RandomAccessFile randomAccessFile) {
        Pair<ByteBuffer, Long> l1111l111111Il2 = l111l1111llIl.l1111l111111Il(randomAccessFile);
        if (l1111l111111Il2 != null) {
            return l1111l111111Il2;
        }
        throw new IOException("Not an APK file: ZIP End of Central Directory record not found");
    }

    private static Pair<ByteBuffer, Long> l1111l111111Il(RandomAccessFile randomAccessFile, long j) {
        if (j < 32) {
            throw new IOException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j);
        }
        ByteBuffer allocate = ByteBuffer.allocate(24);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j - allocate.capacity());
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        if (allocate.getLong(8) == l111l11111lIl && allocate.getLong(16) == l1111l111111Il) {
            long j2 = allocate.getLong(0);
            if (j2 < allocate.capacity() || j2 > 2147483639) {
                throw new IOException("APK Signing Block size out of range: " + j2);
            }
            int i = (int) (8 + j2);
            long j3 = j - i;
            if (j3 < 0) {
                throw new IOException("APK Signing Block offset out of range: " + j3);
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(i);
            allocate2.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(j3);
            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
            long j4 = allocate2.getLong(0);
            if (j4 == j2) {
                return Pair.create(allocate2, Long.valueOf(j3));
            }
            throw new IOException("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        throw new IOException("No APK Signing Block before ZIP Central Directory");
    }

    static l1111l111111Il l1111l111111Il(RandomAccessFile randomAccessFile, int i) {
        Pair<ByteBuffer, Long> l1111l111111Il2 = l1111l111111Il(randomAccessFile);
        ByteBuffer byteBuffer = l1111l111111Il2.first;
        long longValue = l1111l111111Il2.second.longValue();
        if (l111l1111llIl.l1111l111111Il(randomAccessFile, longValue)) {
            throw new IOException("ZIP64 APK not supported");
        }
        long l1111l111111Il3 = l1111l111111Il(byteBuffer, longValue);
        Pair<ByteBuffer, Long> l1111l111111Il4 = l1111l111111Il(randomAccessFile, l1111l111111Il3);
        ByteBuffer byteBuffer2 = l1111l111111Il4.first;
        return new l1111l111111Il(l1111l111111Il(byteBuffer2, 1896449818), l1111l111111Il4.second.longValue(), l1111l111111Il3, longValue, byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer l1111l111111Il(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 4) {
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                return l111l11111lIl(byteBuffer, i);
            }
            throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
        }
        throw new IllegalArgumentException("Negative length");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer l1111l111111Il(ByteBuffer byteBuffer, int i) {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            ByteBuffer l1111l111111Il2 = l1111l111111Il(byteBuffer, 8, byteBuffer.capacity() - 24);
            int i2 = 0;
            while (l1111l111111Il2.hasRemaining()) {
                i2++;
                if (l1111l111111Il2.remaining() < 8) {
                    throw new IOException("Insufficient data to read size of APK Signing Block entry #" + i2);
                }
                long j = l1111l111111Il2.getLong();
                if (j < 4 || j > 2147483647L) {
                    throw new IOException("APK Signing Block entry #" + i2 + " size out of range: " + j);
                }
                int i3 = (int) j;
                int position = l1111l111111Il2.position();
                if (i3 > l1111l111111Il2.remaining()) {
                    throw new IOException("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + l1111l111111Il2.remaining());
                } else if (l1111l111111Il2.getInt() == i) {
                    return l111l11111lIl(l1111l111111Il2, i3 - 4);
                } else {
                    l1111l111111Il2.position(position + i3);
                }
            }
            throw new IOException("No block with ID " + i + " in APK Signing Block.");
        }
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    private static ByteBuffer l1111l111111Il(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 < 8) {
            throw new IllegalArgumentException("end < start: " + i2 + " < 8");
        }
        int capacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(8);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    static byte[] l1111l111111Il(byte[] bArr, long j, l1111l111111Il l1111l111111il) {
        if (bArr.length != 40) {
            throw new SecurityException("Verity digest size is wrong: " + bArr.length);
        }
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        order.position(32);
        if (order.getLong() == j - (l1111l111111il.l111l11111lIl - l1111l111111il.l1111l111111Il)) {
            return Arrays.copyOfRange(bArr, 0, 32);
        }
        throw new SecurityException("APK content size did not verify");
    }

    static Pair<String, ? extends AlgorithmParameterSpec> l111l11111I1l(int i) {
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    if (i != 1057) {
                        if (i != 1059) {
                            if (i != 1061) {
                                switch (i) {
                                    case 257:
                                        return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                    case 258:
                                        return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                    case 259:
                                        break;
                                    case 260:
                                        return Pair.create("SHA512withRSA", null);
                                    default:
                                        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i));
                                }
                            }
                        }
                    }
                    return Pair.create("SHA256withRSA", null);
                }
                return Pair.create("SHA256withDSA", null);
            }
            return Pair.create("SHA512withECDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    private static void l111l11111I1l(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    static String l111l11111lIl(int i) {
        if (i == 513 || i == 514) {
            return "EC";
        }
        if (i != 769) {
            if (i != 1057) {
                if (i != 1059) {
                    if (i != 1061) {
                        switch (i) {
                            case 257:
                            case 258:
                            case 259:
                            case 260:
                                return "RSA";
                            default:
                                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i));
                        }
                    }
                    return "DSA";
                }
                return "EC";
            }
            return "RSA";
        }
        return "DSA";
    }

    private static ByteBuffer l111l11111lIl(ByteBuffer byteBuffer, int i) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] l111l11111lIl(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }
}
