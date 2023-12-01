package okio;

import android.widget.ExpandableListView;
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
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.internal._BufferKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/Buffer.class */
public final class Buffer implements Cloneable, ByteChannel, BufferedSink, BufferedSource {
    public Segment head;
    private long size;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:okio/Buffer$UnsafeCursor.class */
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
            if (!(this.buffer != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.buffer = null;
            setSegment$okio(null);
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i) {
            if (i > 0) {
                if (i <= 8192) {
                    Buffer buffer = this.buffer;
                    if (buffer != null) {
                        if (this.readWrite) {
                            long size = buffer.size();
                            Segment writableSegment$okio = buffer.writableSegment$okio(i);
                            int i2 = 8192 - writableSegment$okio.limit;
                            writableSegment$okio.limit = 8192;
                            long j = i2;
                            buffer.setSize$okio(size + j);
                            setSegment$okio(writableSegment$okio);
                            this.offset = size;
                            this.data = writableSegment$okio.data;
                            this.start = 8192 - i2;
                            this.end = 8192;
                            return j;
                        }
                        throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                    }
                    throw new IllegalStateException("not attached to a buffer".toString());
                }
                throw new IllegalArgumentException(Intrinsics.a("minByteCount > Segment.SIZE: ", (Object) Integer.valueOf(i)).toString());
            }
            throw new IllegalArgumentException(Intrinsics.a("minByteCount <= 0: ", (Object) Integer.valueOf(i)).toString());
        }

        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final int next() {
            long j = this.offset;
            Buffer buffer = this.buffer;
            Intrinsics.a(buffer);
            if (j != buffer.size()) {
                long j2 = this.offset;
                return seek(j2 == -1 ? 0L : j2 + (this.end - this.start));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final long resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer != null) {
                if (this.readWrite) {
                    long size = buffer.size();
                    int i = (j > size ? 1 : (j == size ? 0 : -1));
                    if (i <= 0) {
                        if (!(j >= 0)) {
                            throw new IllegalArgumentException(Intrinsics.a("newSize < 0: ", (Object) Long.valueOf(j)).toString());
                        }
                        long j2 = size;
                        long j3 = j;
                        while (true) {
                            long j4 = j2 - j3;
                            if (j4 <= 0) {
                                break;
                            }
                            Segment segment = buffer.head;
                            Intrinsics.a(segment);
                            Segment segment2 = segment.prev;
                            Intrinsics.a(segment2);
                            long j5 = segment2.limit - segment2.pos;
                            if (j5 > j4) {
                                segment2.limit -= (int) j4;
                                break;
                            }
                            buffer.head = segment2.pop();
                            SegmentPool.recycle(segment2);
                            j2 = j4;
                            j3 = j5;
                        }
                        setSegment$okio(null);
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else if (i > 0) {
                        long j6 = j - size;
                        boolean z = true;
                        while (j6 > 0) {
                            Segment writableSegment$okio = buffer.writableSegment$okio(1);
                            int min = (int) Math.min(j6, 8192 - writableSegment$okio.limit);
                            writableSegment$okio.limit += min;
                            j6 -= min;
                            if (z) {
                                setSegment$okio(writableSegment$okio);
                                this.offset = size;
                                this.data = writableSegment$okio.data;
                                this.start = writableSegment$okio.limit - min;
                                this.end = writableSegment$okio.limit;
                                z = false;
                            }
                        }
                    }
                    buffer.setSize$okio(j);
                    return size;
                }
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final int seek(long j) {
            long j2;
            Segment segment;
            Segment segment$okio;
            Buffer buffer = this.buffer;
            if (buffer != null) {
                int i = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
                if (i < 0 || j > buffer.size()) {
                    throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + buffer.size());
                } else if (i == 0 || j == buffer.size()) {
                    setSegment$okio(null);
                    this.offset = j;
                    this.data = null;
                    this.start = -1;
                    this.end = -1;
                    return -1;
                } else {
                    long size = buffer.size();
                    Segment segment2 = buffer.head;
                    Segment segment3 = buffer.head;
                    long j3 = 0;
                    long j4 = size;
                    Segment segment4 = segment2;
                    Segment segment5 = segment3;
                    if (getSegment$okio() != null) {
                        long j5 = this.offset;
                        int i2 = this.start;
                        Intrinsics.a(getSegment$okio());
                        j3 = j5 - (i2 - segment$okio.pos);
                        if (j3 > j) {
                            segment5 = getSegment$okio();
                            j4 = j3;
                            j3 = 0;
                            segment4 = segment2;
                        } else {
                            segment4 = getSegment$okio();
                            segment5 = segment3;
                            j4 = size;
                        }
                    }
                    long j6 = j4;
                    if (j4 - j > j - j3) {
                        Segment segment6 = segment4;
                        while (true) {
                            Segment segment7 = segment6;
                            Intrinsics.a(segment7);
                            j2 = j3;
                            segment = segment7;
                            if (j < (segment7.limit - segment7.pos) + j3) {
                                break;
                            }
                            j3 += segment7.limit - segment7.pos;
                            segment6 = segment7.next;
                        }
                    } else {
                        while (j6 > j) {
                            Intrinsics.a(segment5);
                            segment5 = segment5.prev;
                            Intrinsics.a(segment5);
                            j6 -= segment5.limit - segment5.pos;
                        }
                        j2 = j6;
                        segment = segment5;
                    }
                    Segment segment8 = segment;
                    if (this.readWrite) {
                        Intrinsics.a(segment);
                        segment8 = segment;
                        if (segment.shared) {
                            Segment unsharedCopy = segment.unsharedCopy();
                            if (buffer.head == segment) {
                                buffer.head = unsharedCopy;
                            }
                            segment8 = segment.push(unsharedCopy);
                            Segment segment9 = segment8.prev;
                            Intrinsics.a(segment9);
                            segment9.pop();
                        }
                    }
                    setSegment$okio(segment8);
                    this.offset = j;
                    Intrinsics.a(segment8);
                    this.data = segment8.data;
                    this.start = segment8.pos + ((int) (j - j2));
                    int i3 = segment8.limit;
                    this.end = i3;
                    return i3 - this.start;
                }
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final void setSegment$okio(Segment segment) {
            this.segment = segment;
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j, long j2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = 0;
        }
        if ((i & 4) != 0) {
            j2 = buffer.size - j;
        }
        return buffer.copyTo(outputStream, j, j2);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j, j2);
    }

    private final ByteString digest(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            messageDigest.update(segment.data, segment.pos, segment.limit - segment.pos);
            Segment segment2 = segment.next;
            Intrinsics.a(segment2);
            while (segment2 != segment) {
                messageDigest.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                segment2 = segment2.next;
                Intrinsics.a(segment2);
            }
        }
        byte[] digest = messageDigest.digest();
        Intrinsics.c(digest, "messageDigest.digest()");
        return new ByteString(digest);
    }

    private final ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                mac.update(segment.data, segment.pos, segment.limit - segment.pos);
                Segment segment2 = segment.next;
                Intrinsics.a(segment2);
                while (segment2 != segment) {
                    mac.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                    segment2 = segment2.next;
                    Intrinsics.a(segment2);
                }
            }
            byte[] doFinal = mac.doFinal();
            Intrinsics.c(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = _UtilKt.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    private final void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            Segment writableSegment$okio = writableSegment$okio(1);
            int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j, 8192 - writableSegment$okio.limit));
            if (read == -1) {
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    this.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                if (!z) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment$okio.limit += read;
            long j2 = read;
            this.size += j2;
            j -= j2;
        }
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = _UtilKt.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = buffer.size;
        }
        return buffer.writeTo(outputStream, j);
    }

    @Deprecated
    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m13274deprecated_getByte(long j) {
        return getByte(j);
    }

    @Deprecated
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final long m13275deprecated_size() {
        return this.size;
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        skip(size());
    }

    public Buffer clone() {
        return copy();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.head;
        Intrinsics.a(segment);
        Segment segment2 = segment.prev;
        Intrinsics.a(segment2);
        long j = size;
        if (segment2.limit < 8192) {
            j = size;
            if (segment2.owner) {
                j = size - (segment2.limit - segment2.pos);
            }
        }
        return j;
    }

    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() == 0) {
            return buffer;
        }
        Segment segment = this.head;
        Intrinsics.a(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy.prev;
        Segment segment2 = segment.next;
        while (true) {
            Segment segment3 = segment2;
            if (segment3 == segment) {
                buffer.setSize$okio(size());
                return buffer;
            }
            Segment segment4 = sharedCopy.prev;
            Intrinsics.a(segment4);
            Intrinsics.a(segment3);
            segment4.push(segment3.sharedCopy());
            segment2 = segment3.next;
        }
    }

    public final Buffer copyTo(OutputStream out) throws IOException {
        Intrinsics.e(out, "out");
        return copyTo$default(this, out, 0L, 0L, 6, (Object) null);
    }

    public final Buffer copyTo(OutputStream out, long j) throws IOException {
        Intrinsics.e(out, "out");
        return copyTo$default(this, out, j, 0L, 4, (Object) null);
    }

    public final Buffer copyTo(OutputStream out, long j, long j2) throws IOException {
        Segment segment;
        long j3;
        long j4;
        int i;
        Intrinsics.e(out, "out");
        _UtilKt.checkOffsetAndCount(this.size, j, j2);
        if (j2 == 0) {
            return this;
        }
        Segment segment2 = this.head;
        while (true) {
            Segment segment3 = segment2;
            Intrinsics.a(segment3);
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
            Intrinsics.a(segment);
            int min = (int) Math.min(segment.limit - i, j4);
            out.write(segment.data, (int) (segment.pos + j3), min);
            j4 -= min;
            segment = segment.next;
            j3 = 0;
        }
        return this;
    }

    public final Buffer copyTo(Buffer out, long j) {
        Intrinsics.e(out, "out");
        return copyTo(out, j, this.size - j);
    }

    public final Buffer copyTo(Buffer out, long j, long j2) {
        Segment segment;
        long j3;
        long j4;
        Intrinsics.e(out, "out");
        _UtilKt.checkOffsetAndCount(size(), j, j2);
        if (j2 == 0) {
            return this;
        }
        out.setSize$okio(out.size() + j2);
        Segment segment2 = this.head;
        while (true) {
            Segment segment3 = segment2;
            Intrinsics.a(segment3);
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
            Intrinsics.a(segment);
            Segment sharedCopy = segment.sharedCopy();
            sharedCopy.pos += (int) j3;
            sharedCopy.limit = Math.min(sharedCopy.pos + ((int) j4), sharedCopy.limit);
            Segment segment4 = out.head;
            if (segment4 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy.prev;
                out.head = sharedCopy.next;
            } else {
                Intrinsics.a(segment4);
                Segment segment5 = segment4.prev;
                Intrinsics.a(segment5);
                segment5.push(sharedCopy);
            }
            j4 -= sharedCopy.limit - sharedCopy.pos;
            segment = segment.next;
            j3 = 0;
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            if (size() != buffer.size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            Segment segment = this.head;
            Intrinsics.a(segment);
            Segment segment2 = buffer.head;
            Intrinsics.a(segment2);
            int i = segment.pos;
            int i2 = segment2.pos;
            long j = 0;
            while (j < size()) {
                long min = Math.min(segment.limit - i, segment2.limit - i2);
                int i3 = i;
                int i4 = i2;
                if (0 < min) {
                    long j2 = 0;
                    while (true) {
                        j2++;
                        int i5 = i + 1;
                        int i6 = i2 + 1;
                        if (segment.data[i] != segment2.data[i2]) {
                            return false;
                        }
                        if (j2 >= min) {
                            i3 = i5;
                            i4 = i6;
                            break;
                        }
                        i2 = i6;
                        i = i5;
                    }
                }
                Segment segment3 = segment;
                i = i3;
                if (i3 == segment.limit) {
                    segment3 = segment.next;
                    Intrinsics.a(segment3);
                    i = segment3.pos;
                }
                Segment segment4 = segment2;
                i2 = i4;
                if (i4 == segment2.limit) {
                    segment4 = segment2.next;
                    Intrinsics.a(segment4);
                    i2 = segment4.pos;
                }
                j += min;
                segment2 = segment4;
                segment = segment3;
            }
            return true;
        }
        return false;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j) {
        _UtilKt.checkOffsetAndCount(size(), j, 1L);
        Segment segment = this.head;
        if (segment == null) {
            Segment segment2 = null;
            Intrinsics.a(segment2);
            return segment2.data[(int) (segment2.pos + j + 1)];
        } else if (size() - j < j) {
            long size = size();
            while (true) {
                long j2 = size;
                if (j2 <= j) {
                    Intrinsics.a(segment);
                    return segment.data[(int) ((segment.pos + j) - j2)];
                }
                segment = segment.prev;
                Intrinsics.a(segment);
                size = j2 - (segment.limit - segment.pos);
            }
        } else {
            long j3 = 0;
            while (true) {
                long j4 = j3;
                long j5 = (segment.limit - segment.pos) + j4;
                if (j5 > j) {
                    Intrinsics.a(segment);
                    return segment.data[(int) ((segment.pos + j) - j4)];
                }
                segment = segment.next;
                Intrinsics.a(segment);
                j3 = j5;
            }
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
            Intrinsics.a(segment);
            segment2 = segment;
            i2 = i;
        } while (segment != this.head);
        return i;
    }

    public final ByteString hmacSha1(ByteString key) {
        Intrinsics.e(key, "key");
        return hmac("HmacSHA1", key);
    }

    public final ByteString hmacSha256(ByteString key) {
        Intrinsics.e(key, "key");
        return hmac("HmacSHA256", key);
    }

    public final ByteString hmacSha512(ByteString key) {
        Intrinsics.e(key, "key");
        return hmac("HmacSHA512", key);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ff, code lost:
        r11 = r11 + (r19.limit - r19.pos);
        r19 = r19.next;
        kotlin.jvm.internal.Intrinsics.a(r19);
        r9 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x019c, code lost:
        r11 = r11 + (r20.limit - r20.pos);
        r20 = r20.next;
        kotlin.jvm.internal.Intrinsics.a(r20);
        r9 = r11;
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long indexOf(byte r8, long r9, long r11) {
        /*
            Method dump skipped, instructions count: 550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.indexOf(byte, long, long):long");
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString bytes) throws IOException {
        Intrinsics.e(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString bytes, long j) throws IOException {
        Intrinsics.e(bytes, "bytes");
        if (bytes.size() > 0) {
            long j2 = 0;
            if (j >= 0) {
                Segment segment = this.head;
                if (segment == null) {
                    return -1L;
                }
                Segment segment2 = segment;
                if (size() - j < j) {
                    long size = size();
                    Segment segment3 = segment;
                    while (size > j) {
                        segment3 = segment3.prev;
                        Intrinsics.a(segment3);
                        size -= segment3.limit - segment3.pos;
                    }
                    if (segment3 == null) {
                        return -1L;
                    }
                    byte[] internalArray$okio = bytes.internalArray$okio();
                    byte b = internalArray$okio[0];
                    int size2 = bytes.size();
                    long size3 = (size() - size2) + 1;
                    Segment segment4 = segment3;
                    while (size < size3) {
                        byte[] bArr = segment4.data;
                        int min = (int) Math.min(segment4.limit, (segment4.pos + size3) - size);
                        int i = (int) ((segment4.pos + j) - size);
                        if (i < min) {
                            while (true) {
                                int i2 = i + 1;
                                if (bArr[i] == b && _BufferKt.rangeEquals(segment4, i2, internalArray$okio, 1, size2)) {
                                    return (i - segment4.pos) + size;
                                }
                                if (i2 >= min) {
                                    break;
                                }
                                i = i2;
                            }
                        }
                        size += segment4.limit - segment4.pos;
                        segment4 = segment4.next;
                        Intrinsics.a(segment4);
                        j = size;
                    }
                    return -1L;
                }
                while (true) {
                    long j3 = (segment2.limit - segment2.pos) + j2;
                    if (j3 > j) {
                        break;
                    }
                    segment2 = segment2.next;
                    Intrinsics.a(segment2);
                    j2 = j3;
                }
                if (segment2 == null) {
                    return -1L;
                }
                byte[] internalArray$okio2 = bytes.internalArray$okio();
                byte b2 = internalArray$okio2[0];
                int size4 = bytes.size();
                long size5 = (size() - size4) + 1;
                long j4 = j2;
                long j5 = j;
                while (j4 < size5) {
                    byte[] bArr2 = segment2.data;
                    int min2 = (int) Math.min(segment2.limit, (segment2.pos + size5) - j4);
                    int i3 = (int) ((segment2.pos + j5) - j4);
                    if (i3 < min2) {
                        while (true) {
                            int i4 = i3 + 1;
                            if (bArr2[i3] == b2 && _BufferKt.rangeEquals(segment2, i4, internalArray$okio2, 1, size4)) {
                                return (i3 - segment2.pos) + j4;
                            }
                            if (i4 >= min2) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    j4 += segment2.limit - segment2.pos;
                    segment2 = segment2.next;
                    Intrinsics.a(segment2);
                    j5 = j4;
                }
                return -1L;
            }
            throw new IllegalArgumentException(Intrinsics.a("fromIndex < 0: ", (Object) Long.valueOf(j)).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString targetBytes) {
        Intrinsics.e(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString targetBytes, long j) {
        int i;
        long j2;
        Segment segment;
        int i2;
        Intrinsics.e(targetBytes, "targetBytes");
        long j3 = 0;
        if (j >= 0) {
            Segment segment2 = this.head;
            if (segment2 == null) {
                return -1L;
            }
            Segment segment3 = segment2;
            if (size() - j < j) {
                j3 = size();
                segment3 = segment2;
                while (j3 > j) {
                    segment3 = segment3.prev;
                    Intrinsics.a(segment3);
                    j3 -= segment3.limit - segment3.pos;
                }
                if (segment3 == null) {
                    return -1L;
                }
                if (targetBytes.size() != 2) {
                    byte[] internalArray$okio = targetBytes.internalArray$okio();
                    while (j3 < size()) {
                        byte[] bArr = segment3.data;
                        i = (int) ((segment3.pos + j) - j3);
                        int i3 = segment3.limit;
                        while (i < i3) {
                            byte b = bArr[i];
                            int length = internalArray$okio.length;
                            int i4 = 0;
                            while (i4 < length) {
                                byte b2 = internalArray$okio[i4];
                                i4++;
                                if (b == b2) {
                                    i2 = segment3.pos;
                                    j2 = j3;
                                }
                            }
                            i++;
                        }
                        j3 += segment3.limit - segment3.pos;
                        segment3 = segment3.next;
                        Intrinsics.a(segment3);
                        j = j3;
                    }
                    return -1L;
                }
                byte b3 = targetBytes.getByte(0);
                byte b4 = targetBytes.getByte(1);
                while (j3 < size()) {
                    byte[] bArr2 = segment3.data;
                    int i5 = segment3.limit;
                    for (int i6 = (int) ((segment3.pos + j) - j3); i6 < i5; i6++) {
                        byte b5 = bArr2[i6];
                        j2 = j3;
                        segment = segment3;
                        i = i6;
                        if (b5 != b3) {
                            if (b5 == b4) {
                                j2 = j3;
                                segment = segment3;
                                i = i6;
                            }
                        }
                        i2 = segment.pos;
                    }
                    j3 += segment3.limit - segment3.pos;
                    segment3 = segment3.next;
                    Intrinsics.a(segment3);
                    j = j3;
                }
                return -1L;
            }
            while (true) {
                long j4 = (segment3.limit - segment3.pos) + j3;
                if (j4 > j) {
                    break;
                }
                segment3 = segment3.next;
                Intrinsics.a(segment3);
                j3 = j4;
            }
            if (segment3 == null) {
                return -1L;
            }
            if (targetBytes.size() != 2) {
                byte[] internalArray$okio2 = targetBytes.internalArray$okio();
                while (j3 < size()) {
                    byte[] bArr3 = segment3.data;
                    i = (int) ((segment3.pos + j) - j3);
                    int i7 = segment3.limit;
                    while (i < i7) {
                        byte b6 = bArr3[i];
                        int length2 = internalArray$okio2.length;
                        int i8 = 0;
                        while (i8 < length2) {
                            byte b7 = internalArray$okio2[i8];
                            i8++;
                            if (b6 == b7) {
                                i2 = segment3.pos;
                                j2 = j3;
                            }
                        }
                        i++;
                    }
                    j3 += segment3.limit - segment3.pos;
                    segment3 = segment3.next;
                    Intrinsics.a(segment3);
                    j = j3;
                }
                return -1L;
            }
            byte b8 = targetBytes.getByte(0);
            byte b9 = targetBytes.getByte(1);
            while (j3 < size()) {
                byte[] bArr4 = segment3.data;
                int i9 = segment3.limit;
                for (int i10 = (int) ((segment3.pos + j) - j3); i10 < i9; i10++) {
                    byte b10 = bArr4[i10];
                    j2 = j3;
                    segment = segment3;
                    i = i10;
                    if (b10 != b8) {
                        if (b10 == b9) {
                            j2 = j3;
                            segment = segment3;
                            i = i10;
                        }
                    }
                    i2 = segment.pos;
                }
                j3 += segment3.limit - segment3.pos;
                segment3 = segment3.next;
                Intrinsics.a(segment3);
                j = j3;
            }
            return -1L;
            return (i - i2) + j2;
        }
        throw new IllegalArgumentException(Intrinsics.a("fromIndex < 0: ", (Object) Long.valueOf(j)).toString());
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer$inputStream$1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size() > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] sink, int i, int i2) {
                Intrinsics.e(sink, "sink");
                return Buffer.this.read(sink, i, i2);
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

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer$outputStream$1
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
                Buffer.this.writeByte(i);
            }

            @Override // java.io.OutputStream
            public void write(byte[] data, int i, int i2) {
                Intrinsics.e(data, "data");
                Buffer.this.write(data, i, i2);
            }
        };
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString bytes) {
        Intrinsics.e(bytes, "bytes");
        return rangeEquals(j, bytes, 0, bytes.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString bytes, int i, int i2) {
        Intrinsics.e(bytes, "bytes");
        boolean z = false;
        if (j >= 0) {
            z = false;
            if (i >= 0) {
                z = false;
                if (i2 >= 0) {
                    z = false;
                    if (size() - j >= i2) {
                        if (bytes.size() - i < i2) {
                            return false;
                        }
                        if (i2 > 0) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                int i5 = i4 + 1;
                                if (getByte(i4 + j) != bytes.getByte(i4 + i)) {
                                    return false;
                                }
                                if (i5 >= i2) {
                                    break;
                                }
                                i3 = i5;
                            }
                        }
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) throws IOException {
        Intrinsics.e(sink, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(sink.remaining(), segment.limit - segment.pos);
        sink.put(segment.data, segment.pos, min);
        segment.pos += min;
        this.size -= min;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // okio.BufferedSource
    public int read(byte[] sink) {
        Intrinsics.e(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // okio.BufferedSource
    public int read(byte[] sink, int i, int i2) {
        Intrinsics.e(sink, "sink");
        _UtilKt.checkOffsetAndCount(sink.length, i, i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        ArraysKt.a(segment.data, sink, i, segment.pos, segment.pos + min);
        segment.pos += min;
        setSize$okio(size() - min);
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // okio.Source
    public long read(Buffer sink, long j) {
        Intrinsics.e(sink, "sink");
        if (j >= 0) {
            if (size() == 0) {
                return -1L;
            }
            long j2 = j;
            if (j > size()) {
                j2 = size();
            }
            sink.write(this, j2);
            return j2;
        }
        throw new IllegalArgumentException(Intrinsics.a("byteCount < 0: ", (Object) Long.valueOf(j)).toString());
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        Intrinsics.e(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.e(unsafeCursor, "unsafeCursor");
        return _BufferKt.commonReadAndWriteUnsafe(this, unsafeCursor);
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment = this.head;
            Intrinsics.a(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            byte[] bArr = segment.data;
            int i3 = i + 1;
            byte b = bArr[i];
            setSize$okio(size() - 1);
            if (i3 != i2) {
                segment.pos = i3;
                return b;
            }
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            return b;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        if (j >= 0 && j <= 2147483647L) {
            if (size() >= j) {
                byte[] bArr = new byte[(int) j];
                readFully(bArr);
                return bArr;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(Intrinsics.a("byteCount: ", (Object) Long.valueOf(j)).toString());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return readByteString(size());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        if (j >= 0 && j <= 2147483647L) {
            if (size() >= j) {
                if (j >= 4096) {
                    ByteString snapshot = snapshot((int) j);
                    skip(j);
                    return snapshot;
                }
                return new ByteString(readByteArray(j));
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(Intrinsics.a("byteCount: ", (Object) Long.valueOf(j)).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e1, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0118, code lost:
        setSize$okio(size() - r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0124, code lost:
        if (r9 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0127, code lost:
        r7 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012c, code lost:
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0130, code lost:
        if (r8 >= r7) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0139, code lost:
        if (size() == 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x013d, code lost:
        if (r9 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0140, code lost:
        r19 = "Expected a digit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0148, code lost:
        r19 = "Expected a digit or '-'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0181, code lost:
        throw new java.lang.NumberFormatException(r19 + " but was 0x" + okio._UtilKt.toHexString(getByte(0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0189, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x018b, code lost:
        if (r9 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0190, code lost:
        return r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0194, code lost:
        return -r17;
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream input) throws IOException {
        Intrinsics.e(input, "input");
        readFrom(input, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream input, long j) throws IOException {
        Intrinsics.e(input, "input");
        if (j >= 0) {
            readFrom(input, j, false);
            return this;
        }
        throw new IllegalArgumentException(Intrinsics.a("byteCount < 0: ", (Object) Long.valueOf(j)).toString());
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer sink, long j) throws EOFException {
        Intrinsics.e(sink, "sink");
        if (size() >= j) {
            sink.write(this, j);
        } else {
            sink.write(this, size());
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] sink) throws EOFException {
        Intrinsics.e(sink, "sink");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sink.length) {
                return;
            }
            int read = read(sink, i2, sink.length - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i = i2 + read;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00da, code lost:
        if (r10 == 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00dd, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f4, code lost:
        throw new java.lang.NumberFormatException(kotlin.jvm.internal.Intrinsics.a("Expected leading [0-9a-fA-F] character but was 0x", (java.lang.Object) okio._UtilKt.toHexString(r0)));
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment = this.head;
            Intrinsics.a(segment);
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
            byte b4 = bArr[i5];
            setSize$okio(size() - 4);
            if (i6 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i6;
            }
            return ((b & 255) << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        return _UtilKt.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() >= 8) {
            Segment segment = this.head;
            Intrinsics.a(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 8) {
                return ((readInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL) << 32) | (ExpandableListView.PACKED_POSITION_VALUE_NULL & readInt());
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
            long j8 = bArr[i9];
            setSize$okio(size() - 8);
            if (i10 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i10;
            }
            return ((j4 & 255) << 32) | ((j & 255) << 56) | ((j2 & 255) << 48) | ((j3 & 255) << 40) | ((j5 & 255) << 24) | ((j6 & 255) << 16) | ((j7 & 255) << 8) | (j8 & 255);
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return _UtilKt.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment = this.head;
            Intrinsics.a(segment);
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
            setSize$okio(size() - 2);
            if (i4 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return (short) (((b & 255) << 8) | (b2 & 255));
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        return _UtilKt.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) throws EOFException {
        Intrinsics.e(charset, "charset");
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0 && j <= 2147483647L) {
            if (this.size >= j) {
                if (i == 0) {
                    return "";
                }
                Segment segment = this.head;
                Intrinsics.a(segment);
                if (segment.pos + j > segment.limit) {
                    return new String(readByteArray(j), charset);
                }
                byte[] bArr = segment.data;
                int i2 = segment.pos;
                int i3 = (int) j;
                String str = new String(bArr, i2, i3, charset);
                segment.pos += i3;
                this.size -= j;
                if (segment.pos == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return str;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(Intrinsics.a("byteCount: ", (Object) Long.valueOf(j)).toString());
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        Intrinsics.e(charset, "charset");
        return readString(this.size, charset);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.e(unsafeCursor, "unsafeCursor");
        return _BufferKt.commonReadUnsafe(this, unsafeCursor);
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        return readString(this.size, Charsets.b);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) throws EOFException {
        return readString(j, Charsets.b);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (size() != 0) {
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
                return 65533;
            } else {
                i = b & 7;
                i2 = 4;
                i3 = 65536;
            }
            long j = i2;
            if (size() < j) {
                throw new EOFException("size < " + i2 + ": " + size() + " (to read code point prefixed 0x" + _UtilKt.toHexString(b) + ')');
            }
            int i4 = i;
            if (1 < i2) {
                int i5 = 1;
                while (true) {
                    int i6 = i5;
                    int i7 = i6 + 1;
                    long j2 = i6;
                    byte b2 = getByte(j2);
                    if ((b2 & 192) != 128) {
                        skip(j2);
                        return 65533;
                    }
                    i = (i << 6) | (b2 & 63);
                    if (i7 >= i2) {
                        i4 = i;
                        break;
                    }
                    i5 = i7;
                }
            }
            skip(j);
            if (i4 > 1114111) {
                return 65533;
            }
            boolean z = false;
            if (55296 <= i4) {
                z = false;
                if (i4 <= 57343) {
                    z = true;
                }
            }
            if (!z && i4 >= i3) {
                return i4;
            }
            return 65533;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return _BufferKt.readUtf8Line(this, indexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        Buffer buffer;
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            byte b = (byte) 10;
            long indexOf = indexOf(b, 0L, j2);
            if (indexOf != -1) {
                return _BufferKt.readUtf8Line(this, indexOf);
            }
            if (j2 < size() && getByte(j2 - 1) == ((byte) 13) && getByte(j2) == b) {
                return _BufferKt.readUtf8Line(this, j2);
            }
            copyTo(new Buffer(), 0L, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
        }
        throw new IllegalArgumentException(Intrinsics.a("limit < 0: ", (Object) Long.valueOf(j)).toString());
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) {
        Intrinsics.e(options, "options");
        int selectPrefix$default = _BufferKt.selectPrefix$default(this, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public final void setSize$okio(long j) {
        this.size = j;
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

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = min;
            setSize$okio(size() - j2);
            long j3 = j - j2;
            segment.pos += min;
            j = j3;
            if (segment.pos == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
                j = j3;
            }
        }
    }

    public final ByteString snapshot() {
        if (size() <= 2147483647L) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(Intrinsics.a("size > Int.MAX_VALUE: ", (Object) Long.valueOf(size())).toString());
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [byte[], byte[][]] */
    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        _UtilKt.checkOffsetAndCount(size(), 0L, i);
        Segment segment = this.head;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            Intrinsics.a(segment);
            if (segment.limit == segment.pos) {
                throw new AssertionError("s.limit == s.pos");
            }
            i2 += segment.limit - segment.pos;
            i3++;
            segment = segment.next;
        }
        ?? r0 = new byte[i3];
        int[] iArr = new int[i3 * 2];
        Segment segment2 = this.head;
        int i4 = 0;
        int i5 = 0;
        while (i5 < i) {
            Intrinsics.a(segment2);
            r0[i4] = segment2.data;
            i5 += segment2.limit - segment2.pos;
            iArr[i4] = Math.min(i5, i);
            iArr[((Object[]) r0).length + i4] = segment2.pos;
            segment2.shared = true;
            i4++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(r0, iArr);
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public final Segment writableSegment$okio(int i) {
        boolean z = true;
        if (i < 1 || i > 8192) {
            z = false;
        }
        if (z) {
            Segment segment = this.head;
            if (segment != null) {
                Intrinsics.a(segment);
                Segment segment2 = segment.prev;
                Intrinsics.a(segment2);
                return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
            }
            Segment take = SegmentPool.take();
            this.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) throws IOException {
        Intrinsics.e(source, "source");
        int remaining = source.remaining();
        int i = remaining;
        while (i > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i, 8192 - writableSegment$okio.limit);
            source.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            i -= min;
            writableSegment$okio.limit += min;
        }
        this.size += remaining;
        return remaining;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        Intrinsics.e(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString, int i, int i2) {
        Intrinsics.e(byteString, "byteString");
        byteString.write$okio(this, i, i2);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(Source source, long j) throws IOException {
        Intrinsics.e(source, "source");
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] source) {
        Intrinsics.e(source, "source");
        return write(source, 0, source.length);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] source, int i, int i2) {
        Intrinsics.e(source, "source");
        long j = i2;
        _UtilKt.checkOffsetAndCount(source.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            byte[] bArr = writableSegment$okio.data;
            int i4 = writableSegment$okio.limit;
            int i5 = i + min;
            ArraysKt.a(source, bArr, i4, i, i5);
            writableSegment$okio.limit += min;
            i = i5;
        }
        setSize$okio(size() + j);
        return this;
    }

    @Override // okio.Sink
    public void write(Buffer source, long j) {
        Segment segment;
        Segment segment2;
        Intrinsics.e(source, "source");
        if (!(source != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        _UtilKt.checkOffsetAndCount(source.size(), 0L, j);
        while (j > 0) {
            Segment segment3 = source.head;
            Intrinsics.a(segment3);
            int i = segment3.limit;
            Intrinsics.a(source.head);
            if (j < i - segment.pos) {
                Segment segment4 = this.head;
                if (segment4 != null) {
                    Intrinsics.a(segment4);
                    segment2 = segment4.prev;
                } else {
                    segment2 = null;
                }
                if (segment2 != null && segment2.owner) {
                    if ((segment2.limit + j) - (segment2.shared ? 0 : segment2.pos) <= 8192) {
                        Segment segment5 = source.head;
                        Intrinsics.a(segment5);
                        segment5.writeTo(segment2, (int) j);
                        source.setSize$okio(source.size() - j);
                        setSize$okio(size() + j);
                        return;
                    }
                }
                Segment segment6 = source.head;
                Intrinsics.a(segment6);
                source.head = segment6.split((int) j);
            }
            Segment segment7 = source.head;
            Intrinsics.a(segment7);
            long j2 = segment7.limit - segment7.pos;
            source.head = segment7.pop();
            Segment segment8 = this.head;
            if (segment8 == null) {
                this.head = segment7;
                segment7.prev = segment7;
                segment7.next = segment7.prev;
            } else {
                Intrinsics.a(segment8);
                Segment segment9 = segment8.prev;
                Intrinsics.a(segment9);
                segment9.push(segment7).compact();
            }
            source.setSize$okio(source.size() - j2);
            setSize$okio(size() + j2);
            j -= j2;
        }
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        Intrinsics.e(source, "source");
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

    @Override // okio.BufferedSink
    public Buffer writeByte(int i) {
        Segment writableSegment$okio = writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
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
        Segment writableSegment$okio = writableSegment$okio(i3);
        byte[] bArr = writableSegment$okio.data;
        int i4 = writableSegment$okio.limit + i3;
        while (j2 != 0) {
            long j3 = 10;
            i4--;
            bArr[i4] = _BufferKt.getHEX_DIGIT_BYTES()[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z) {
            bArr[i4 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i3;
        setSize$okio(size() + i3);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
        Segment writableSegment$okio = writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (writableSegment$okio.limit + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = _BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        setSize$okio(size() + i);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i) {
        Segment writableSegment$okio = writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment$okio.limit = i5 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i) {
        return writeInt(_UtilKt.reverseBytes(i));
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long j) {
        Segment writableSegment$okio = writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i = writableSegment$okio.limit;
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
        writableSegment$okio.limit = i8 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(_UtilKt.reverseBytes(j));
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i) {
        Segment writableSegment$okio = writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment$okio.limit = i3 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i) {
        return writeShort((int) _UtilKt.reverseBytes((short) i));
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String string, int i, int i2, Charset charset) {
        Intrinsics.e(string, "string");
        Intrinsics.e(charset, "charset");
        if (i >= 0) {
            if (!(i2 >= i)) {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
            }
            if (!(i2 <= string.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + string.length()).toString());
            } else if (Intrinsics.a(charset, Charsets.b)) {
                return writeUtf8(string, i, i2);
            } else {
                String substring = string.substring(i, i2);
                Intrinsics.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (substring != null) {
                    byte[] bytes = substring.getBytes(charset);
                    Intrinsics.c(bytes, "(this as java.lang.String).getBytes(charset)");
                    return write(bytes, 0, bytes.length);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        throw new IllegalArgumentException(Intrinsics.a("beginIndex < 0: ", (Object) Integer.valueOf(i)).toString());
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String string, Charset charset) {
        Intrinsics.e(string, "string");
        Intrinsics.e(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    public final Buffer writeTo(OutputStream out) throws IOException {
        Intrinsics.e(out, "out");
        return writeTo$default(this, out, 0L, 2, null);
    }

    public final Buffer writeTo(OutputStream out, long j) throws IOException {
        Intrinsics.e(out, "out");
        _UtilKt.checkOffsetAndCount(this.size, 0L, j);
        Segment segment = this.head;
        while (j > 0) {
            Intrinsics.a(segment);
            int min = (int) Math.min(j, segment.limit - segment.pos);
            out.write(segment.data, segment.pos, min);
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

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String string) {
        Intrinsics.e(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String string, int i, int i2) {
        char charAt;
        Intrinsics.e(string, "string");
        if (i >= 0) {
            if (!(i2 >= i)) {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
            }
            if (!(i2 <= string.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + string.length()).toString());
            }
            while (i < i2) {
                char charAt2 = string.charAt(i);
                if (charAt2 < 128) {
                    Segment writableSegment$okio = writableSegment$okio(1);
                    byte[] bArr = writableSegment$okio.data;
                    int i3 = writableSegment$okio.limit - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt2;
                    while (true) {
                        i = i4;
                        if (i >= min || (charAt = string.charAt(i)) >= 128) {
                            break;
                        }
                        i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                    }
                    int i5 = (i3 + i) - writableSegment$okio.limit;
                    writableSegment$okio.limit += i5;
                    setSize$okio(size() + i5);
                } else {
                    if (charAt2 < 2048) {
                        Segment writableSegment$okio2 = writableSegment$okio(2);
                        writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((charAt2 >> 6) | 192);
                        writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) ((charAt2 & '?') | 128);
                        writableSegment$okio2.limit += 2;
                        setSize$okio(size() + 2);
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        Segment writableSegment$okio3 = writableSegment$okio(3);
                        writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((charAt2 >> '\f') | 224);
                        writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                        writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) ((charAt2 & '?') | 128);
                        writableSegment$okio3.limit += 3;
                        setSize$okio(size() + 3);
                    } else {
                        int i6 = i + 1;
                        char charAt3 = i6 < i2 ? string.charAt(i6) : (char) 0;
                        if (charAt2 <= 56319) {
                            if (56320 <= charAt3 && charAt3 <= 57343) {
                                int i7 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                                Segment writableSegment$okio4 = writableSegment$okio(4);
                                writableSegment$okio4.data[writableSegment$okio4.limit] = (byte) ((i7 >> 18) | 240);
                                writableSegment$okio4.data[writableSegment$okio4.limit + 1] = (byte) (((i7 >> 12) & 63) | 128);
                                writableSegment$okio4.data[writableSegment$okio4.limit + 2] = (byte) (((i7 >> 6) & 63) | 128);
                                writableSegment$okio4.data[writableSegment$okio4.limit + 3] = (byte) ((i7 & 63) | 128);
                                writableSegment$okio4.limit += 4;
                                setSize$okio(size() + 4);
                                i += 2;
                            }
                        }
                        writeByte(63);
                        i = i6;
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(Intrinsics.a("beginIndex < 0: ", (Object) Integer.valueOf(i)).toString());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
            return this;
        } else if (i < 2048) {
            Segment writableSegment$okio = writableSegment$okio(2);
            writableSegment$okio.data[writableSegment$okio.limit] = (byte) ((i >> 6) | 192);
            writableSegment$okio.data[writableSegment$okio.limit + 1] = (byte) ((i & 63) | 128);
            writableSegment$okio.limit += 2;
            setSize$okio(size() + 2);
            return this;
        } else {
            boolean z = false;
            if (55296 <= i) {
                z = false;
                if (i <= 57343) {
                    z = true;
                }
            }
            if (z) {
                writeByte(63);
                return this;
            } else if (i < 65536) {
                Segment writableSegment$okio2 = writableSegment$okio(3);
                writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((i >> 12) | 224);
                writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) (((i >> 6) & 63) | 128);
                writableSegment$okio2.data[writableSegment$okio2.limit + 2] = (byte) ((i & 63) | 128);
                writableSegment$okio2.limit += 3;
                setSize$okio(size() + 3);
                return this;
            } else if (i <= 1114111) {
                Segment writableSegment$okio3 = writableSegment$okio(4);
                writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((i >> 18) | 240);
                writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) (((i >> 12) & 63) | 128);
                writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) (((i >> 6) & 63) | 128);
                writableSegment$okio3.data[writableSegment$okio3.limit + 3] = (byte) ((i & 63) | 128);
                writableSegment$okio3.limit += 4;
                setSize$okio(size() + 4);
                return this;
            } else {
                throw new IllegalArgumentException(Intrinsics.a("Unexpected code point: 0x", (Object) _UtilKt.toHexString(i)));
            }
        }
    }
}
