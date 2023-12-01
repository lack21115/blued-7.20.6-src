package com.tencent.cloud.huiyansdkface.okio;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okio/Buffer.class */
public final class Buffer implements BufferedSink, BufferedSource, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    Segment head;
    long size;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okio/Buffer$UnsafeCursor.class */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i);
            } else if (i > 8192) {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i);
            } else {
                Buffer buffer = this.buffer;
                if (buffer != null) {
                    if (this.readWrite) {
                        long j = buffer.size;
                        Segment writableSegment = this.buffer.writableSegment(i);
                        int i2 = 8192 - writableSegment.limit;
                        writableSegment.limit = 8192;
                        long j2 = i2;
                        this.buffer.size = j + j2;
                        this.segment = writableSegment;
                        this.offset = j;
                        this.data = writableSegment.data;
                        this.start = 8192 - i2;
                        this.end = 8192;
                        return j2;
                    }
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
                throw new IllegalStateException("not attached to a buffer");
            }
        }

        public final int next() {
            if (this.offset != this.buffer.size) {
                long j = this.offset;
                return seek(j == -1 ? 0L : j + (this.end - this.start));
            }
            throw new IllegalStateException();
        }

        public final long resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer != null) {
                if (this.readWrite) {
                    long j2 = buffer.size;
                    int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i <= 0) {
                        if (j < 0) {
                            throw new IllegalArgumentException("newSize < 0: " + j);
                        }
                        long j3 = j2;
                        long j4 = j;
                        while (true) {
                            long j5 = j3 - j4;
                            if (j5 <= 0) {
                                break;
                            }
                            Segment segment = this.buffer.head.prev;
                            long j6 = segment.limit - segment.pos;
                            if (j6 > j5) {
                                segment.limit = (int) (segment.limit - j5);
                                break;
                            }
                            this.buffer.head = segment.pop();
                            SegmentPool.recycle(segment);
                            j3 = j5;
                            j4 = j6;
                        }
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else if (i > 0) {
                        long j7 = j - j2;
                        boolean z = true;
                        while (j7 > 0) {
                            Segment writableSegment = this.buffer.writableSegment(1);
                            int min = (int) Math.min(j7, 8192 - writableSegment.limit);
                            writableSegment.limit += min;
                            long j8 = j7 - min;
                            j7 = j8;
                            if (z) {
                                this.segment = writableSegment;
                                this.offset = j2;
                                this.data = writableSegment.data;
                                this.start = writableSegment.limit - min;
                                this.end = writableSegment.limit;
                                z = false;
                                j7 = j8;
                            }
                        }
                    }
                    this.buffer.size = j;
                    return j2;
                }
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            throw new IllegalStateException("not attached to a buffer");
        }

        public final int seek(long j) {
            Segment segment;
            long j2;
            Segment segment2;
            int i = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
            if (i < 0 || j > this.buffer.size) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.buffer.size)));
            }
            if (i == 0 || j == this.buffer.size) {
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long j3 = this.buffer.size;
            Segment segment3 = this.buffer.head;
            Segment segment4 = this.buffer.head;
            long j4 = 0;
            long j5 = j3;
            Segment segment5 = segment3;
            Segment segment6 = segment4;
            if (this.segment != null) {
                j4 = this.offset - (this.start - segment.pos);
                if (j4 > j) {
                    segment6 = this.segment;
                    j5 = j4;
                    j4 = 0;
                    segment5 = segment3;
                } else {
                    segment5 = this.segment;
                    segment6 = segment4;
                    j5 = j3;
                }
            }
            long j6 = j5;
            if (j5 - j > j - j4) {
                Segment segment7 = segment5;
                while (true) {
                    Segment segment8 = segment7;
                    j2 = j4;
                    segment2 = segment8;
                    if (j < (segment8.limit - segment8.pos) + j4) {
                        break;
                    }
                    j4 += segment8.limit - segment8.pos;
                    segment7 = segment8.next;
                }
            } else {
                while (j6 > j) {
                    segment6 = segment6.prev;
                    j6 -= segment6.limit - segment6.pos;
                }
                j2 = j6;
                segment2 = segment6;
            }
            Segment segment9 = segment2;
            if (this.readWrite) {
                segment9 = segment2;
                if (segment2.shared) {
                    Segment unsharedCopy = segment2.unsharedCopy();
                    if (this.buffer.head == segment2) {
                        this.buffer.head = unsharedCopy;
                    }
                    segment9 = segment2.push(unsharedCopy);
                    segment9.prev.pop();
                }
            }
            this.segment = segment9;
            this.offset = j;
            this.data = segment9.data;
            this.start = segment9.pos + ((int) (j - j2));
            int i2 = segment9.limit;
            this.end = i2;
            return i2 - this.start;
        }
    }

    private ByteString digest(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (this.head != null) {
                messageDigest.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
                Segment segment = this.head;
                while (true) {
                    segment = segment.next;
                    if (segment == this.head) {
                        break;
                    }
                    messageDigest.update(segment.data, segment.pos, segment.limit - segment.pos);
                }
            }
            return ByteString.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            if (this.head != null) {
                mac.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
                Segment segment = this.head;
                while (true) {
                    segment = segment.next;
                    if (segment == this.head) {
                        break;
                    }
                    mac.update(segment.data, segment.pos, segment.limit - segment.pos);
                }
            }
            return ByteString.of(mac.doFinal());
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError();
        }
    }

    private boolean rangeEquals(Segment segment, int i, ByteString byteString, int i2, int i3) {
        int i4 = segment.limit;
        byte[] bArr = segment.data;
        while (i2 < i3) {
            int i5 = i4;
            Segment segment2 = segment;
            int i6 = i;
            if (i == i4) {
                segment2 = segment.next;
                byte[] bArr2 = segment2.data;
                i6 = segment2.pos;
                i5 = segment2.limit;
                bArr = bArr2;
            }
            if (bArr[i6] != byteString.getByte(i2)) {
                return false;
            }
            i = i6 + 1;
            i2++;
            i4 = i5;
            segment = segment2;
        }
        return true;
    }

    private void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            Segment writableSegment = writableSegment(1);
            int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j, 8192 - writableSegment.limit));
            if (read == -1) {
                if (!z) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment.limit += read;
            long j2 = read;
            this.size += j2;
            j -= j2;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink, com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: clone */
    public Buffer m7090clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment sharedCopy = this.head.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment == this.head) {
                buffer.size = this.size;
                return buffer;
            }
            buffer.head.prev.push(segment.sharedCopy());
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.head.prev;
        long j2 = j;
        if (segment.limit < 8192) {
            j2 = j;
            if (segment.owner) {
                j2 = j - (segment.limit - segment.pos);
            }
        }
        return j2;
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        Segment segment;
        long j3;
        long j4;
        if (buffer != null) {
            Util.checkOffsetAndCount(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.size += j2;
            Segment segment2 = this.head;
            while (true) {
                Segment segment3 = segment2;
                segment = segment3;
                j3 = j;
                j4 = j2;
                if (j < segment3.limit - segment3.pos) {
                    break;
                }
                j -= segment3.limit - segment3.pos;
                segment2 = segment3.next;
            }
            while (j4 > 0) {
                Segment sharedCopy = segment.sharedCopy();
                sharedCopy.pos = (int) (sharedCopy.pos + j3);
                sharedCopy.limit = Math.min(sharedCopy.pos + ((int) j4), sharedCopy.limit);
                Segment segment4 = buffer.head;
                if (segment4 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    buffer.head = sharedCopy;
                } else {
                    segment4.prev.push(sharedCopy);
                }
                j4 -= sharedCopy.limit - sharedCopy.pos;
                segment = segment.next;
                j3 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0L, this.size);
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        Segment segment;
        long j3;
        long j4;
        int i;
        if (outputStream != null) {
            Util.checkOffsetAndCount(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            Segment segment2 = this.head;
            while (true) {
                Segment segment3 = segment2;
                segment = segment3;
                j3 = j;
                j4 = j2;
                if (j < segment3.limit - segment3.pos) {
                    break;
                }
                j -= segment3.limit - segment3.pos;
                segment2 = segment3.next;
            }
            while (j4 > 0) {
                int min = (int) Math.min(segment.limit - i, j4);
                outputStream.write(segment.data, (int) (segment.pos + j3), min);
                j4 -= min;
                segment = segment.next;
                j3 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            long j = this.size;
            if (j != buffer.size) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            Segment segment = this.head;
            Segment segment2 = buffer.head;
            int i = segment.pos;
            int i2 = segment2.pos;
            while (j2 < this.size) {
                long min = Math.min(segment.limit - i, segment2.limit - i2);
                int i3 = 0;
                while (i3 < min) {
                    if (segment.data[i] != segment2.data[i2]) {
                        return false;
                    }
                    i3++;
                    i++;
                    i2++;
                }
                Segment segment3 = segment;
                int i4 = i;
                if (i == segment.limit) {
                    segment3 = segment.next;
                    i4 = segment3.pos;
                }
                int i5 = i2;
                Segment segment4 = segment2;
                if (i2 == segment2.limit) {
                    segment4 = segment2.next;
                    i5 = segment4.pos;
                }
                j2 += min;
                segment = segment3;
                i = i4;
                i2 = i5;
                segment2 = segment4;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink, com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
    public void flush() {
    }

    public final byte getByte(long j) {
        Segment segment;
        long j2;
        Util.checkOffsetAndCount(this.size, j, 1L);
        long j3 = this.size;
        if (j3 - j <= j) {
            long j4 = j - j3;
            Segment segment2 = this.head;
            do {
                segment = segment2.prev;
                j2 = j4 + (segment.limit - segment.pos);
                segment2 = segment;
                j4 = j2;
            } while (j2 < 0);
            return segment.data[segment.pos + ((int) j2)];
        }
        Segment segment3 = this.head;
        while (true) {
            Segment segment4 = segment3;
            long j5 = segment4.limit - segment4.pos;
            if (j < j5) {
                return segment4.data[segment4.pos + ((int) j)];
            }
            j -= j5;
            segment3 = segment4.next;
        }
    }

    public int hashCode() {
        int i;
        Segment segment;
        Segment segment2 = this.head;
        if (segment2 == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = segment2.limit;
            i = i2;
            for (int i4 = segment2.pos; i4 < i3; i4++) {
                i = (i * 31) + segment2.data[i4];
            }
            segment = segment2.next;
            segment2 = segment;
            i2 = i;
        } while (segment != this.head);
        return i;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x010d, code lost:
        r13 = r13 + (r24.limit - r24.pos);
        r24 = r24.next;
        r11 = r13;
     */
    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long indexOf(byte r10, long r11, long r13) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.Buffer.indexOf(byte, long, long):long");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0114, code lost:
        r15 = r15 + (r19.limit - r19.pos);
        r19 = r19.next;
        r9 = r15;
     */
    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long indexOf(com.tencent.cloud.huiyansdkface.okio.ByteString r8, long r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.Buffer.indexOf(com.tencent.cloud.huiyansdkface.okio.ByteString, long):long");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0182, code lost:
        r9 = r9 + 1;
     */
    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long indexOfElement(com.tencent.cloud.huiyansdkface.okio.ByteString r6, long r7) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.Buffer.indexOfElement(com.tencent.cloud.huiyansdkface.okio.ByteString, long):long");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: com.tencent.cloud.huiyansdkface.okio.Buffer.2
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.read(bArr, i, i2);
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.tencent.cloud.huiyansdkface.okio.Buffer.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                Buffer.this.writeByte((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                Buffer.this.write(bArr, i, i2);
            }
        };
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.size - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return true;
            }
            if (getByte(i4 + j) != byteString.getByte(i + i4)) {
                return false;
            }
            i3 = i4 + 1;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        segment.pos += min;
        this.size -= min;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) {
        Util.checkOffsetAndCount(bArr.length, i, i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        System.arraycopy(segment.data, segment.pos, bArr, i, min);
        segment.pos += min;
        this.size -= min;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Source
    public long read(Buffer buffer, long j) {
        if (buffer != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            long j2 = this.size;
            if (j2 == 0) {
                return -1L;
            }
            long j3 = j;
            if (j > j2) {
                j3 = j2;
            }
            buffer.write(this, j3);
            return j3;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public byte readByte() {
        if (this.size != 0) {
            Segment segment = this.head;
            int i = segment.pos;
            int i2 = segment.limit;
            byte[] bArr = segment.data;
            int i3 = i + 1;
            byte b = bArr[i];
            this.size--;
            if (i3 != i2) {
                segment.pos = i3;
                return b;
            }
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        return new ByteString(readByteArray(j));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
        r0 = new com.tencent.cloud.huiyansdkface.okio.Buffer().writeDecimalLong(r15).writeByte((int) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a8, code lost:
        if (r10 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ab, code lost:
        r0.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00da, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r0.readUtf8());
     */
    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream inputStream, long j) throws IOException {
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public void readFully(Buffer buffer, long j) throws EOFException {
        long j2 = this.size;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return;
            }
            int read = read(bArr, i2, bArr.length - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i = i2 + read;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        long j;
        int i;
        boolean z;
        byte b;
        int i2;
        int i3;
        if (this.size != 0) {
            int i4 = 0;
            long j2 = 0;
            boolean z2 = false;
            do {
                Segment segment = this.head;
                byte[] bArr = segment.data;
                int i5 = segment.pos;
                int i6 = segment.limit;
                j = j2;
                int i7 = i4;
                while (true) {
                    i = i7;
                    z = z2;
                    if (i5 >= i6) {
                        break;
                    }
                    b = bArr[i5];
                    if (b < 48 || b > 57) {
                        if (b >= 97 && b <= 102) {
                            i2 = b - 97;
                        } else if (b < 65 || b > 70) {
                            break;
                        } else {
                            i2 = b - 65;
                        }
                        i3 = i2 + 10;
                    } else {
                        i3 = b - 48;
                    }
                    if (((-1152921504606846976L) & j) != 0) {
                        Buffer writeByte = new Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b);
                        throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
                    }
                    j = (j << 4) | i3;
                    i5++;
                    i7 = i + 1;
                }
                if (i == 0) {
                    throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                }
                z = true;
                if (i5 == i6) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i5;
                }
                if (z) {
                    break;
                }
                i4 = i;
                z2 = z;
                j2 = j;
            } while (this.head != null);
            this.size -= i;
            return j;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int readInt() {
        if (this.size < 4) {
            throw new IllegalStateException("size < 4: " + this.size);
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        byte b = bArr[i];
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        int i5 = i4 + 1;
        byte b3 = bArr[i4];
        int i6 = i5 + 1;
        int i7 = ((b & 255) << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (bArr[i5] & 255);
        this.size -= 4;
        if (i6 != i2) {
            segment.pos = i6;
            return i7;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return i7;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long readLong() {
        if (this.size < 8) {
            throw new IllegalStateException("size < 8: " + this.size);
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        long j = bArr[i];
        int i4 = i3 + 1;
        long j2 = bArr[i3];
        int i5 = i4 + 1;
        long j3 = bArr[i4];
        int i6 = i5 + 1;
        long j4 = bArr[i5];
        int i7 = i6 + 1;
        long j5 = bArr[i6];
        int i8 = i7 + 1;
        long j6 = bArr[i7];
        int i9 = i8 + 1;
        long j7 = bArr[i8];
        int i10 = i9 + 1;
        long j8 = (bArr[i9] & 255) | ((j & 255) << 56) | ((j2 & 255) << 48) | ((j3 & 255) << 40) | ((j4 & 255) << 32) | ((j5 & 255) << 24) | ((j6 & 255) << 16) | ((j7 & 255) << 8);
        this.size -= 8;
        if (i10 != i2) {
            segment.pos = i10;
            return j8;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return j8;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public short readShort() {
        if (this.size < 2) {
            throw new IllegalStateException("size < 2: " + this.size);
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        byte b = bArr[i];
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        this.size -= 2;
        if (i4 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return (short) (((b & 255) << 8) | (b2 & 255));
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readString(long j, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                Segment segment = this.head;
                if (segment.pos + j > segment.limit) {
                    return new String(readByteArray(j), charset);
                }
                String str = new String(segment.data, segment.pos, (int) j, charset);
                segment.pos = (int) (segment.pos + j);
                this.size -= j;
                if (segment.pos == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8(long j) throws EOFException {
        return readString(j, Util.UTF_8);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.size != 0) {
            byte b = getByte(0L);
            if ((b & 128) == 0) {
                i = b & Byte.MAX_VALUE;
                i2 = 1;
                i3 = 0;
            } else if ((b & 224) == 192) {
                i = b & 31;
                i2 = 2;
                i3 = 128;
            } else if ((b & 240) == 224) {
                i = b & 15;
                i2 = 3;
                i3 = 2048;
            } else if ((b & 248) != 240) {
                skip(1L);
                return REPLACEMENT_CHARACTER;
            } else {
                i = b & 7;
                i2 = 4;
                i3 = 65536;
            }
            long j = i2;
            if (this.size < j) {
                throw new EOFException("size < " + i2 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b) + ")");
            }
            for (int i4 = 1; i4 < i2; i4++) {
                long j2 = i4;
                byte b2 = getByte(j2);
                if ((b2 & 192) != 128) {
                    skip(j2);
                    return REPLACEMENT_CHARACTER;
                }
                i = (i << 6) | (b2 & 63);
            }
            skip(j);
            return i > 1114111 ? REPLACEMENT_CHARACTER : ((i < 55296 || i > 57343) && i >= i3) ? i : REPLACEMENT_CHARACTER;
        }
        throw new EOFException();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf == -1) {
            long j = this.size;
            if (j != 0) {
                return readUtf8(j);
            }
            return null;
        }
        return readUtf8Line(indexOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String readUtf8Line(long j) throws EOFException {
        String readUtf8;
        long j2;
        if (j > 0) {
            long j3 = j - 1;
            if (getByte(j3) == 13) {
                readUtf8 = readUtf8(j3);
                j2 = 2;
                skip(j2);
                return readUtf8;
            }
        }
        readUtf8 = readUtf8(j);
        j2 = 1;
        skip(j2);
        return readUtf8;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        Buffer buffer;
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = Long.MAX_VALUE;
        if (j != Long.MAX_VALUE) {
            j2 = j + 1;
        }
        long indexOf = indexOf((byte) 10, 0L, j2);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
            return readUtf8Line(j2);
        }
        copyTo(new Buffer(), 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.head.limit - this.head.pos));
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public int select(Options options) {
        int selectPrefix = selectPrefix(options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip(options.byteStrings[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException e) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int selectPrefix(Options options, boolean z) {
        int i;
        int i2;
        int i3;
        Segment segment = this.head;
        if (segment == null) {
            if (z) {
                return -2;
            }
            return options.indexOf(ByteString.EMPTY);
        }
        byte[] bArr = segment.data;
        int i4 = segment.pos;
        int i5 = segment.limit;
        int[] iArr = options.trie;
        Segment segment2 = segment;
        int i6 = 0;
        int i7 = -1;
        loop0: while (true) {
            int i8 = i6 + 1;
            int i9 = iArr[i6];
            int i10 = i8 + 1;
            int i11 = iArr[i8];
            if (i11 != -1) {
                i7 = i11;
            }
            if (segment2 == null) {
                break;
            }
            if (i9 < 0) {
                int i12 = i10;
                while (true) {
                    int i13 = i12;
                    int i14 = i4 + 1;
                    int i15 = i13 + 1;
                    if ((bArr[i4] & 255) != iArr[i13]) {
                        return i7;
                    }
                    boolean z2 = i15 == i10 + (i9 * (-1));
                    if (i14 == i5) {
                        segment2 = segment2.next;
                        i4 = segment2.pos;
                        bArr = segment2.data;
                        i5 = segment2.limit;
                        if (segment2 == segment) {
                            if (!z2) {
                                break loop0;
                            }
                            segment2 = null;
                        }
                    } else {
                        i4 = i14;
                    }
                    if (z2) {
                        i = i5;
                        i3 = i4;
                        i2 = iArr[i15];
                        break;
                    }
                    i12 = i15;
                }
            } else {
                int i16 = i4 + 1;
                byte b = bArr[i4];
                int i17 = i10;
                while (true) {
                    int i18 = i17;
                    if (i18 == i10 + i9) {
                        return i7;
                    }
                    if ((b & 255) == iArr[i18]) {
                        int i19 = iArr[i18 + i9];
                        if (i16 == i5) {
                            Segment segment3 = segment2.next;
                            int i20 = segment3.pos;
                            byte[] bArr2 = segment3.data;
                            int i21 = segment3.limit;
                            i3 = i20;
                            bArr = bArr2;
                            i2 = i19;
                            i = i21;
                            segment2 = segment3;
                            if (segment3 == segment) {
                                segment2 = null;
                                i3 = i20;
                                bArr = bArr2;
                                i2 = i19;
                                i = i21;
                            }
                        } else {
                            i = i5;
                            i2 = i19;
                            i3 = i16;
                        }
                    } else {
                        i17 = i18 + 1;
                    }
                }
            }
            if (i2 >= 0) {
                return i2;
            }
            int i22 = -i2;
            i4 = i3;
            i5 = i;
            i6 = i22;
        }
        if (z) {
            return -2;
        }
        return i7;
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSource
    public void skip(long j) throws EOFException {
        Segment segment;
        while (j > 0) {
            if (this.head == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, segment.limit - this.head.pos);
            long j2 = min;
            this.size -= j2;
            long j3 = j - j2;
            this.head.pos += min;
            j = j3;
            if (this.head.pos == this.head.limit) {
                Segment segment2 = this.head;
                this.head = segment2.pop();
                SegmentPool.recycle(segment2);
                j = j3;
            }
        }
    }

    public final ByteString snapshot() {
        long j = this.size;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public final ByteString snapshot(int i) {
        return i == 0 ? ByteString.EMPTY : new SegmentedByteString(this, i);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r0.owner == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.cloud.huiyansdkface.okio.Segment writableSegment(int r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = 1
            if (r0 < r1) goto L4e
            r0 = r4
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r0 > r1) goto L4e
            r0 = r3
            com.tencent.cloud.huiyansdkface.okio.Segment r0 = r0.head
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L2a
            com.tencent.cloud.huiyansdkface.okio.Segment r0 = com.tencent.cloud.huiyansdkface.okio.SegmentPool.take()
            r5 = r0
            r0 = r3
            r1 = r5
            r0.head = r1
            r0 = r5
            r1 = r5
            r0.prev = r1
            r0 = r5
            r1 = r5
            r0.next = r1
            r0 = r5
            return r0
        L2a:
            r0 = r5
            com.tencent.cloud.huiyansdkface.okio.Segment r0 = r0.prev
            r6 = r0
            r0 = r6
            int r0 = r0.limit
            r1 = r4
            int r0 = r0 + r1
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r0 > r1) goto L44
            r0 = r6
            r5 = r0
            r0 = r6
            boolean r0 = r0.owner
            if (r0 != 0) goto L4c
        L44:
            r0 = r6
            com.tencent.cloud.huiyansdkface.okio.Segment r1 = com.tencent.cloud.huiyansdkface.okio.SegmentPool.take()
            com.tencent.cloud.huiyansdkface.okio.Segment r0 = r0.push(r1)
            r5 = r0
        L4c:
            r0 = r5
            return r0
        L4e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r1.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okio.Buffer.writableSegment(int):com.tencent.cloud.huiyansdkface.okio.Segment");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i, 8192 - writableSegment.limit);
                byteBuffer.get(writableSegment.data, writableSegment.limit, min);
                i -= min;
                writableSegment.limit += min;
            }
            this.size += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            Util.checkOffsetAndCount(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i3 - i, 8192 - writableSegment.limit);
                System.arraycopy(bArr, i, writableSegment.data, writableSegment.limit, min);
                i += min;
                writableSegment.limit += min;
            }
            this.size += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Sink
    public void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(buffer.size, 0L, j);
        while (j > 0) {
            if (j < buffer.head.limit - buffer.head.pos) {
                Segment segment = this.head;
                Segment segment2 = segment != null ? segment.prev : null;
                if (segment2 != null && segment2.owner) {
                    if ((segment2.limit + j) - (segment2.shared ? 0 : segment2.pos) <= 8192) {
                        buffer.head.writeTo(segment2, (int) j);
                        buffer.size -= j;
                        this.size += j;
                        return;
                    }
                }
                buffer.head = buffer.head.split((int) j);
            }
            Segment segment3 = buffer.head;
            long j2 = segment3.limit - segment3.pos;
            buffer.head = segment3.pop();
            Segment segment4 = this.head;
            if (segment4 == null) {
                this.head = segment3;
                segment3.prev = segment3;
                segment3.next = segment3;
            } else {
                segment4.prev.push(segment3).compact();
            }
            buffer.size -= j2;
            this.size += j2;
            j -= j2;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = j;
            long read = source.read(this, 8192L);
            if (read == -1) {
                return j2;
            }
            j = j2 + read;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeByte(int i) {
        Segment writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        writableSegment.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        long j2 = j;
        if (i < 0) {
            j2 = -j;
            if (j2 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i2 = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i2 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i2 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i2 = 2;
        }
        int i3 = i2;
        if (z) {
            i3 = i2 + 1;
        }
        Segment writableSegment = writableSegment(i3);
        byte[] bArr = writableSegment.data;
        int i4 = writableSegment.limit + i3;
        while (j2 != 0) {
            i4--;
            bArr[i4] = DIGITS[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i4 - 1] = 45;
        }
        writableSegment.limit += i3;
        this.size += i3;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        for (int i2 = (writableSegment.limit + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment.limit += numberOfTrailingZeros;
        this.size += numberOfTrailingZeros;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeInt(int i) {
        Segment writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment.limit = i5 + 1;
        this.size += 4;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytesInt(i));
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeLong(long j) {
        Segment writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        writableSegment.limit = i8 + 1;
        this.size += 8;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(Util.reverseBytesLong(j));
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeShort(int i) {
        Segment writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment.limit = i3 + 1;
        this.size += 2;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeShortLe(int i) {
        return writeShort((int) Util.reverseBytesShort((short) i));
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeString(String str, int i, int i2, Charset charset) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalAccessError("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 <= str.length()) {
                if (charset != null) {
                    if (charset.equals(Util.UTF_8)) {
                        return writeUtf8(str, i, i2);
                    }
                    byte[] bytes = str.substring(i, i2).getBytes(charset);
                    return write(bytes, 0, bytes.length);
                }
                throw new IllegalArgumentException("charset == null");
            } else {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    public final Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        if (outputStream != null) {
            Util.checkOffsetAndCount(this.size, 0L, j);
            Segment segment = this.head;
            while (j > 0) {
                int min = (int) Math.min(j, segment.limit - segment.pos);
                outputStream.write(segment.data, segment.pos, min);
                segment.pos += min;
                long j2 = min;
                this.size -= j2;
                long j3 = j - j2;
                j = j3;
                if (segment.pos == segment.limit) {
                    Segment pop = segment.pop();
                    this.head = pop;
                    SegmentPool.recycle(segment);
                    segment = pop;
                    j = j3;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeUtf8(String str, int i, int i2) {
        char charAt;
        int i3;
        int i4;
        if (str != null) {
            if (i < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i);
            } else if (i2 < i) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            } else if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            } else {
                while (i < i2) {
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 128) {
                        Segment writableSegment = writableSegment(1);
                        byte[] bArr = writableSegment.data;
                        int i5 = writableSegment.limit - i;
                        int min = Math.min(i2, 8192 - i5);
                        bArr[i + i5] = (byte) charAt2;
                        int i6 = i + 1;
                        while (true) {
                            i = i6;
                            if (i >= min || (charAt = str.charAt(i)) >= 128) {
                                break;
                            }
                            bArr[i + i5] = (byte) charAt;
                            i6 = i + 1;
                        }
                        int i7 = (i5 + i) - writableSegment.limit;
                        writableSegment.limit += i7;
                        this.size += i7;
                    } else {
                        if (charAt2 < 2048) {
                            i3 = charAt2 >> 6;
                            i4 = 192;
                        } else if (charAt2 < 55296 || charAt2 > 57343) {
                            writeByte((charAt2 >> '\f') | 224);
                            i3 = (charAt2 >> 6) & 63;
                            i4 = 128;
                        } else {
                            int i8 = i + 1;
                            char charAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                            if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                                writeByte(63);
                                i = i8;
                            } else {
                                int i9 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                                writeByte((i9 >> 18) | 240);
                                writeByte(((i9 >> 12) & 63) | 128);
                                writeByte(((i9 >> 6) & 63) | 128);
                                writeByte((i9 & 63) | 128);
                                i += 2;
                            }
                        }
                        writeByte(i3 | i4);
                        writeByte((charAt2 & '?') | 128);
                        i++;
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i) {
        int i2;
        int i3;
        if (i >= 128) {
            if (i < 2048) {
                i3 = (i >> 6) | 192;
            } else {
                if (i < 65536) {
                    if (i >= 55296 && i <= 57343) {
                        writeByte(63);
                        return this;
                    }
                    i2 = (i >> 12) | 224;
                } else if (i > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                } else {
                    writeByte((i >> 18) | 240);
                    i2 = ((i >> 12) & 63) | 128;
                }
                writeByte(i2);
                i3 = ((i >> 6) & 63) | 128;
            }
            writeByte(i3);
            i = (i & 63) | 128;
        }
        writeByte(i);
        return this;
    }
}
