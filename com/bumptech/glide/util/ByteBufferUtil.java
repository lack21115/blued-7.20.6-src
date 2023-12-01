package com.bumptech.glide.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/ByteBufferUtil.class */
public final class ByteBufferUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<byte[]> f21093a = new AtomicReference<>();

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/ByteBufferUtil$ByteBufferStream.class */
    static class ByteBufferStream extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f21094a;
        private int b = -1;

        ByteBufferStream(ByteBuffer byteBuffer) {
            this.f21094a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f21094a.remaining();
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            synchronized (this) {
                this.b = this.f21094a.position();
            }
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f21094a.hasRemaining()) {
                return this.f21094a.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.f21094a.hasRemaining()) {
                int min = Math.min(i2, available());
                this.f21094a.get(bArr, i, min);
                return min;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            synchronized (this) {
                if (this.b == -1) {
                    throw new IOException("Cannot reset to unset mark position");
                }
                this.f21094a.position(this.b);
            }
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            if (this.f21094a.hasRemaining()) {
                long min = Math.min(j, available());
                ByteBuffer byteBuffer = this.f21094a;
                byteBuffer.position((int) (byteBuffer.position() + min));
                return min;
            }
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/ByteBufferUtil$SafeArray.class */
    public static final class SafeArray {

        /* renamed from: a  reason: collision with root package name */
        final int f21095a;
        final int b;

        /* renamed from: c  reason: collision with root package name */
        final byte[] f21096c;

        SafeArray(byte[] bArr, int i, int i2) {
            this.f21096c = bArr;
            this.f21095a = i;
            this.b = i2;
        }
    }

    private ByteBufferUtil() {
    }

    public static ByteBuffer a(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                if (length != 0) {
                    randomAccessFile = new RandomAccessFile(file, "r");
                    FileChannel fileChannel2 = null;
                    try {
                        FileChannel channel = randomAccessFile.getChannel();
                        fileChannel2 = channel;
                        MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (IOException e) {
                            }
                        }
                        try {
                            randomAccessFile.close();
                            return load;
                        } catch (IOException e2) {
                            return load;
                        }
                    } catch (Throwable th) {
                        fileChannel = fileChannel2;
                        th = th;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                }
                throw new IOException("File unsuitable for memory mapping");
            }
            throw new IOException("File too large to map into memory");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static ByteBuffer a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = f21093a.getAndSet(null);
        byte[] bArr = andSet;
        if (andSet == null) {
            bArr = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                f21093a.set(bArr);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static void a(ByteBuffer byteBuffer, File file) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        FileChannel fileChannel;
        byteBuffer.position(0);
        FileChannel fileChannel2 = null;
        try {
            randomAccessFile2 = new RandomAccessFile(file, "rw");
            fileChannel = null;
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            FileChannel channel = randomAccessFile2.getChannel();
            channel.write(byteBuffer);
            channel.force(false);
            channel.close();
            fileChannel = channel;
            randomAccessFile2.close();
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                }
            }
            try {
                randomAccessFile2.close();
            } catch (IOException e2) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel2 = fileChannel;
            randomAccessFile = randomAccessFile2;
            if (fileChannel2 != null) {
                try {
                    fileChannel2.close();
                } catch (IOException e3) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        SafeArray c2 = c(byteBuffer);
        if (c2 != null && c2.f21095a == 0 && c2.b == c2.f21096c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static InputStream b(ByteBuffer byteBuffer) {
        return new ByteBufferStream(byteBuffer);
    }

    private static SafeArray c(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }
}
