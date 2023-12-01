package okio.internal;

import android.widget.ExpandableListView;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio._JvmPlatformKt;
import okio._UtilKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/internal/_BufferKt.class */
public final class _BufferKt {
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(Buffer buffer) {
        Intrinsics.e(buffer, "<this>");
        buffer.skip(buffer.size());
    }

    public static final void commonClose(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.e(unsafeCursor, "<this>");
        if (!(unsafeCursor.buffer != null)) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        unsafeCursor.buffer = null;
        unsafeCursor.setSegment$okio(null);
        unsafeCursor.offset = -1L;
        unsafeCursor.data = null;
        unsafeCursor.start = -1;
        unsafeCursor.end = -1;
    }

    public static final long commonCompleteSegmentByteCount(Buffer buffer) {
        Intrinsics.e(buffer, "<this>");
        long size = buffer.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = buffer.head;
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

    public static final Buffer commonCopy(Buffer buffer) {
        Intrinsics.e(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        Intrinsics.a(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = buffer2.head;
        sharedCopy.next = sharedCopy.prev;
        Segment segment2 = segment.next;
        while (true) {
            Segment segment3 = segment2;
            if (segment3 == segment) {
                buffer2.setSize$okio(buffer.size());
                return buffer2;
            }
            Segment segment4 = sharedCopy.prev;
            Intrinsics.a(segment4);
            Intrinsics.a(segment3);
            segment4.push(segment3.sharedCopy());
            segment2 = segment3.next;
        }
    }

    public static final Buffer commonCopyTo(Buffer buffer, Buffer out, long j, long j2) {
        Segment segment;
        long j3;
        long j4;
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(out, "out");
        _UtilKt.checkOffsetAndCount(buffer.size(), j, j2);
        if (j2 == 0) {
            return buffer;
        }
        out.setSize$okio(out.size() + j2);
        Segment segment2 = buffer.head;
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
            if (out.head == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy.prev;
                out.head = sharedCopy.next;
            } else {
                Segment segment4 = out.head;
                Intrinsics.a(segment4);
                Segment segment5 = segment4.prev;
                Intrinsics.a(segment5);
                segment5.push(sharedCopy);
            }
            j4 -= sharedCopy.limit - sharedCopy.pos;
            segment = segment.next;
            j3 = 0;
        }
        return buffer;
    }

    public static final boolean commonEquals(Buffer buffer, Object obj) {
        Intrinsics.e(buffer, "<this>");
        if (buffer == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer2 = (Buffer) obj;
            if (buffer.size() != buffer2.size()) {
                return false;
            }
            if (buffer.size() == 0) {
                return true;
            }
            Segment segment = buffer.head;
            Intrinsics.a(segment);
            Segment segment2 = buffer2.head;
            Intrinsics.a(segment2);
            int i = segment.pos;
            int i2 = segment2.pos;
            long j = 0;
            while (j < buffer.size()) {
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

    public static final long commonExpandBuffer(Buffer.UnsafeCursor unsafeCursor, int i) {
        Intrinsics.e(unsafeCursor, "<this>");
        if (i > 0) {
            if (i <= 8192) {
                Buffer buffer = unsafeCursor.buffer;
                if (buffer != null) {
                    if (unsafeCursor.readWrite) {
                        long size = buffer.size();
                        Segment writableSegment$okio = buffer.writableSegment$okio(i);
                        int i2 = 8192 - writableSegment$okio.limit;
                        writableSegment$okio.limit = 8192;
                        long j = i2;
                        buffer.setSize$okio(size + j);
                        unsafeCursor.setSegment$okio(writableSegment$okio);
                        unsafeCursor.offset = size;
                        unsafeCursor.data = writableSegment$okio.data;
                        unsafeCursor.start = 8192 - i2;
                        unsafeCursor.end = 8192;
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

    public static final byte commonGet(Buffer buffer, long j) {
        Intrinsics.e(buffer, "<this>");
        _UtilKt.checkOffsetAndCount(buffer.size(), j, 1L);
        Segment segment = buffer.head;
        if (segment == null) {
            Segment segment2 = null;
            Intrinsics.a(segment2);
            return segment2.data[(int) (segment2.pos + j + 1)];
        } else if (buffer.size() - j < j) {
            long size = buffer.size();
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

    public static final int commonHashCode(Buffer buffer) {
        int i;
        Segment segment;
        Intrinsics.e(buffer, "<this>");
        Segment segment2 = buffer.head;
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
        } while (segment != buffer.head);
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x00fe, code lost:
        r11 = r11 + (r19.limit - r19.pos);
        r19 = r19.next;
        kotlin.jvm.internal.Intrinsics.a(r19);
        r9 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x019f, code lost:
        r11 = r11 + (r7.limit - r7.pos);
        r7 = r7.next;
        kotlin.jvm.internal.Intrinsics.a(r7);
        r9 = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonIndexOf(okio.Buffer r7, byte r8, long r9, long r11) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonIndexOf(okio.Buffer, byte, long, long):long");
    }

    public static final long commonIndexOf(Buffer buffer, ByteString bytes, long j) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(bytes, "bytes");
        if (bytes.size() > 0) {
            long j2 = 0;
            if (j >= 0) {
                Segment segment = buffer.head;
                if (segment == null) {
                    return -1L;
                }
                Segment segment2 = segment;
                if (buffer.size() - j < j) {
                    long size = buffer.size();
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
                    long size3 = (buffer.size() - size2) + 1;
                    Segment segment4 = segment3;
                    while (size < size3) {
                        byte[] bArr = segment4.data;
                        int min = (int) Math.min(segment4.limit, (segment4.pos + size3) - size);
                        int i = (int) ((segment4.pos + j) - size);
                        if (i < min) {
                            while (true) {
                                int i2 = i + 1;
                                if (bArr[i] == b && rangeEquals(segment4, i2, internalArray$okio, 1, size2)) {
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
                long size5 = (buffer.size() - size4) + 1;
                Segment segment5 = segment2;
                long j4 = j2;
                while (j4 < size5) {
                    byte[] bArr2 = segment5.data;
                    int min2 = (int) Math.min(segment5.limit, (segment5.pos + size5) - j4);
                    int i3 = (int) ((segment5.pos + j) - j4);
                    if (i3 < min2) {
                        while (true) {
                            int i4 = i3 + 1;
                            if (bArr2[i3] == b2 && rangeEquals(segment5, i4, internalArray$okio2, 1, size4)) {
                                return (i3 - segment5.pos) + j4;
                            }
                            if (i4 >= min2) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    j4 += segment5.limit - segment5.pos;
                    segment5 = segment5.next;
                    Intrinsics.a(segment5);
                    j = j4;
                }
                return -1L;
            }
            throw new IllegalArgumentException(Intrinsics.a("fromIndex < 0: ", (Object) Long.valueOf(j)).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    public static final long commonIndexOfElement(Buffer buffer, ByteString targetBytes, long j) {
        int i;
        long j2;
        Segment segment;
        int i2;
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(targetBytes, "targetBytes");
        long j3 = 0;
        if (j >= 0) {
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                return -1L;
            }
            Segment segment3 = segment2;
            if (buffer.size() - j < j) {
                j3 = buffer.size();
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
                    while (j3 < buffer.size()) {
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
                while (j3 < buffer.size()) {
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
                while (j3 < buffer.size()) {
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
            while (j3 < buffer.size()) {
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

    public static final int commonNext(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.e(unsafeCursor, "<this>");
        long j = unsafeCursor.offset;
        Buffer buffer = unsafeCursor.buffer;
        Intrinsics.a(buffer);
        if (j != buffer.size()) {
            return unsafeCursor.seek(unsafeCursor.offset == -1 ? 0L : unsafeCursor.offset + (unsafeCursor.end - unsafeCursor.start));
        }
        throw new IllegalStateException("no more bytes".toString());
    }

    public static final boolean commonRangeEquals(Buffer buffer, long j, ByteString bytes, int i, int i2) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(bytes, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || buffer.size() - j < i2 || bytes.size() - i < i2) {
            return false;
        }
        if (i2 <= 0) {
            return true;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            int i5 = i4 + 1;
            if (buffer.getByte(i4 + j) != bytes.getByte(i4 + i)) {
                return false;
            }
            if (i5 >= i2) {
                return true;
            }
            i3 = i5;
        }
    }

    public static final int commonRead(Buffer buffer, byte[] sink) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(sink, "sink");
        return buffer.read(sink, 0, sink.length);
    }

    public static final int commonRead(Buffer buffer, byte[] sink, int i, int i2) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(sink, "sink");
        _UtilKt.checkOffsetAndCount(sink.length, i, i2);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        ArraysKt.a(segment.data, sink, i, segment.pos, segment.pos + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - min);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public static final long commonRead(Buffer buffer, Buffer sink, long j) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(sink, "sink");
        if (j >= 0) {
            if (buffer.size() == 0) {
                return -1L;
            }
            long j2 = j;
            if (j > buffer.size()) {
                j2 = buffer.size();
            }
            sink.write(buffer, j2);
            return j2;
        }
        throw new IllegalArgumentException(Intrinsics.a("byteCount < 0: ", (Object) Long.valueOf(j)).toString());
    }

    public static final long commonReadAll(Buffer buffer, Sink sink) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = _UtilKt.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = true;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final byte commonReadByte(Buffer buffer) {
        Intrinsics.e(buffer, "<this>");
        if (buffer.size() != 0) {
            Segment segment = buffer.head;
            Intrinsics.a(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            byte[] bArr = segment.data;
            int i3 = i + 1;
            byte b = bArr[i];
            buffer.setSize$okio(buffer.size() - 1);
            if (i3 != i2) {
                segment.pos = i3;
                return b;
            }
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
            return b;
        }
        throw new EOFException();
    }

    public static final byte[] commonReadByteArray(Buffer buffer) {
        Intrinsics.e(buffer, "<this>");
        return buffer.readByteArray(buffer.size());
    }

    public static final byte[] commonReadByteArray(Buffer buffer, long j) {
        Intrinsics.e(buffer, "<this>");
        if (j >= 0 && j <= 2147483647L) {
            if (buffer.size() >= j) {
                byte[] bArr = new byte[(int) j];
                buffer.readFully(bArr);
                return bArr;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(Intrinsics.a("byteCount: ", (Object) Long.valueOf(j)).toString());
    }

    public static final ByteString commonReadByteString(Buffer buffer) {
        Intrinsics.e(buffer, "<this>");
        return buffer.readByteString(buffer.size());
    }

    public static final ByteString commonReadByteString(Buffer buffer, long j) {
        Intrinsics.e(buffer, "<this>");
        if (j >= 0 && j <= 2147483647L) {
            if (buffer.size() >= j) {
                if (j >= 4096) {
                    ByteString snapshot = buffer.snapshot((int) j);
                    buffer.skip(j);
                    return snapshot;
                }
                return new ByteString(buffer.readByteArray(j));
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(Intrinsics.a("byteCount: ", (Object) Long.valueOf(j)).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x00e4, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00eb, code lost:
        if (r10 != r0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00ee, code lost:
        r6.head = r0.pop();
        okio.SegmentPool.recycle(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00ff, code lost:
        r0.pos = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0108, code lost:
        if (r11 != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x010f, code lost:
        if (r6.head != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x011b, code lost:
        r6.setSize$okio(r6.size() - r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0127, code lost:
        if (r9 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x012a, code lost:
        r7 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x012f, code lost:
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0133, code lost:
        if (r8 >= r7) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x013c, code lost:
        if (r6.size() == 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0140, code lost:
        if (r9 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0143, code lost:
        r19 = "Expected a digit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x014b, code lost:
        r19 = "Expected a digit or '-'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0184, code lost:
        throw new java.lang.NumberFormatException(r19 + " but was 0x" + okio._UtilKt.toHexString(r6.getByte(0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x018c, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x018e, code lost:
        if (r9 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0193, code lost:
        return r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0197, code lost:
        return -r17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadDecimalLong(okio.Buffer r6) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(Buffer buffer, Buffer sink, long j) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(sink, "sink");
        if (buffer.size() >= j) {
            sink.write(buffer, j);
        } else {
            sink.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    public static final void commonReadFully(Buffer buffer, byte[] sink) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(sink, "sink");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sink.length) {
                return;
            }
            int read = buffer.read(sink, i2, sink.length - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i = i2 + read;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(Buffer buffer) {
        long j;
        int i;
        boolean z;
        byte b;
        int i2;
        Intrinsics.e(buffer, "<this>");
        if (buffer.size() != 0) {
            int i3 = 0;
            long j2 = 0;
            boolean z2 = false;
            do {
                Segment segment = buffer.head;
                Intrinsics.a(segment);
                byte[] bArr = segment.data;
                int i4 = segment.pos;
                int i5 = segment.limit;
                j = j2;
                int i6 = i3;
                while (true) {
                    i = i6;
                    z = z2;
                    if (i4 >= i5) {
                        break;
                    }
                    b = bArr[i4];
                    byte b2 = (byte) 48;
                    if (b < b2 || b > ((byte) 57)) {
                        byte b3 = (byte) 97;
                        if (b < b3 || b > ((byte) 102)) {
                            b3 = (byte) 65;
                            if (b < b3 || b > ((byte) 70)) {
                                break;
                            }
                        }
                        i2 = (b - b3) + 10;
                    } else {
                        i2 = b - b2;
                    }
                    if (((-1152921504606846976L) & j) != 0) {
                        throw new NumberFormatException(Intrinsics.a("Number too large: ", (Object) new Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b).readUtf8()));
                    }
                    j = (j << 4) | i2;
                    i4++;
                    i6 = i + 1;
                }
                if (i == 0) {
                    throw new NumberFormatException(Intrinsics.a("Expected leading [0-9a-fA-F] character but was 0x", (Object) _UtilKt.toHexString(b)));
                }
                z = true;
                if (i4 == i5) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i4;
                }
                if (z) {
                    break;
                }
                i3 = i;
                z2 = z;
                j2 = j;
            } while (buffer.head != null);
            buffer.setSize$okio(buffer.size() - i);
            return j;
        }
        throw new EOFException();
    }

    public static final int commonReadInt(Buffer buffer) {
        Intrinsics.e(buffer, "<this>");
        if (buffer.size() >= 4) {
            Segment segment = buffer.head;
            Intrinsics.a(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 4) {
                return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << 24) | ((buffer.readByte() & 255) << 16) | ((buffer.readByte() & 255) << 8);
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
            buffer.setSize$okio(buffer.size() - 4);
            if (i6 != i2) {
                segment.pos = i6;
                return i7;
            }
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
            return i7;
        }
        throw new EOFException();
    }

    public static final long commonReadLong(Buffer buffer) {
        Intrinsics.e(buffer, "<this>");
        if (buffer.size() >= 8) {
            Segment segment = buffer.head;
            Intrinsics.a(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 8) {
                return ((buffer.readInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL) << 32) | (ExpandableListView.PACKED_POSITION_VALUE_NULL & buffer.readInt());
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
            long j8 = ((j4 & 255) << 32) | ((j & 255) << 56) | ((j2 & 255) << 48) | ((j3 & 255) << 40) | ((j5 & 255) << 24) | ((j6 & 255) << 16) | ((j7 & 255) << 8) | (bArr[i9] & 255);
            buffer.setSize$okio(buffer.size() - 8);
            if (i10 != i2) {
                segment.pos = i10;
                return j8;
            }
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
            return j8;
        }
        throw new EOFException();
    }

    public static final short commonReadShort(Buffer buffer) {
        Intrinsics.e(buffer, "<this>");
        if (buffer.size() >= 2) {
            Segment segment = buffer.head;
            Intrinsics.a(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 2) {
                return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            byte b = bArr[i];
            int i4 = i3 + 1;
            byte b2 = bArr[i3];
            buffer.setSize$okio(buffer.size() - 2);
            if (i4 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return (short) (((b & 255) << 8) | (b2 & 255));
        }
        throw new EOFException();
    }

    public static final Buffer.UnsafeCursor commonReadUnsafe(Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = _UtilKt.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = false;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final String commonReadUtf8(Buffer buffer, long j) {
        Intrinsics.e(buffer, "<this>");
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0 && j <= 2147483647L) {
            if (buffer.size() >= j) {
                if (i == 0) {
                    return "";
                }
                Segment segment = buffer.head;
                Intrinsics.a(segment);
                if (segment.pos + j > segment.limit) {
                    return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j), 0, 0, 3, null);
                }
                byte[] bArr = segment.data;
                int i2 = segment.pos;
                int i3 = segment.pos;
                int i4 = (int) j;
                String commonToUtf8String = _Utf8Kt.commonToUtf8String(bArr, i2, i3 + i4);
                segment.pos += i4;
                buffer.setSize$okio(buffer.size() - j);
                if (segment.pos == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                return commonToUtf8String;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(Intrinsics.a("byteCount: ", (Object) Long.valueOf(j)).toString());
    }

    public static final int commonReadUtf8CodePoint(Buffer buffer) {
        int i;
        int i2;
        int i3;
        Intrinsics.e(buffer, "<this>");
        if (buffer.size() != 0) {
            byte b = buffer.getByte(0L);
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
                buffer.skip(1L);
                return 65533;
            } else {
                i = b & 7;
                i2 = 4;
                i3 = 65536;
            }
            long j = i2;
            if (buffer.size() < j) {
                throw new EOFException("size < " + i2 + ": " + buffer.size() + " (to read code point prefixed 0x" + _UtilKt.toHexString(b) + ')');
            }
            int i4 = i;
            if (1 < i2) {
                int i5 = 1;
                while (true) {
                    int i6 = i5;
                    int i7 = i6 + 1;
                    long j2 = i6;
                    byte b2 = buffer.getByte(j2);
                    if ((b2 & 192) != 128) {
                        buffer.skip(j2);
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
            buffer.skip(j);
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

    public static final String commonReadUtf8Line(Buffer buffer) {
        Intrinsics.e(buffer, "<this>");
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(Buffer buffer, long j) {
        Buffer buffer2;
        Intrinsics.e(buffer, "<this>");
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            byte b = (byte) 10;
            long indexOf = buffer.indexOf(b, 0L, j2);
            if (indexOf != -1) {
                return readUtf8Line(buffer, indexOf);
            }
            if (j2 < buffer.size() && buffer.getByte(j2 - 1) == ((byte) 13) && buffer.getByte(j2) == b) {
                return readUtf8Line(buffer, j2);
            }
            buffer.copyTo(new Buffer(), 0L, Math.min(32, buffer.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j) + " content=" + buffer2.readByteString().hex() + (char) 8230);
        }
        throw new IllegalArgumentException(Intrinsics.a("limit < 0: ", (Object) Long.valueOf(j)).toString());
    }

    public static final long commonResizeBuffer(Buffer.UnsafeCursor unsafeCursor, long j) {
        Intrinsics.e(unsafeCursor, "<this>");
        Buffer buffer = unsafeCursor.buffer;
        if (buffer != null) {
            if (unsafeCursor.readWrite) {
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
                    unsafeCursor.setSegment$okio(null);
                    unsafeCursor.offset = j;
                    unsafeCursor.data = null;
                    unsafeCursor.start = -1;
                    unsafeCursor.end = -1;
                } else if (i > 0) {
                    long j6 = j - size;
                    boolean z = true;
                    while (j6 > 0) {
                        Segment writableSegment$okio = buffer.writableSegment$okio(1);
                        int min = (int) Math.min(j6, 8192 - writableSegment$okio.limit);
                        writableSegment$okio.limit += min;
                        j6 -= min;
                        if (z) {
                            unsafeCursor.setSegment$okio(writableSegment$okio);
                            unsafeCursor.offset = size;
                            unsafeCursor.data = writableSegment$okio.data;
                            unsafeCursor.start = writableSegment$okio.limit - min;
                            unsafeCursor.end = writableSegment$okio.limit;
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

    public static final int commonSeek(Buffer.UnsafeCursor unsafeCursor, long j) {
        long j2;
        Segment segment;
        Segment segment$okio;
        Intrinsics.e(unsafeCursor, "<this>");
        Buffer buffer = unsafeCursor.buffer;
        if (buffer != null) {
            int i = (j > (-1L) ? 1 : (j == (-1L) ? 0 : -1));
            if (i < 0 || j > buffer.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + buffer.size());
            } else if (i == 0 || j == buffer.size()) {
                unsafeCursor.setSegment$okio(null);
                unsafeCursor.offset = j;
                unsafeCursor.data = null;
                unsafeCursor.start = -1;
                unsafeCursor.end = -1;
                return -1;
            } else {
                long size = buffer.size();
                Segment segment2 = buffer.head;
                Segment segment3 = buffer.head;
                long j3 = 0;
                long j4 = size;
                Segment segment4 = segment2;
                Segment segment5 = segment3;
                if (unsafeCursor.getSegment$okio() != null) {
                    long j5 = unsafeCursor.offset;
                    int i2 = unsafeCursor.start;
                    Intrinsics.a(unsafeCursor.getSegment$okio());
                    j3 = j5 - (i2 - segment$okio.pos);
                    if (j3 > j) {
                        segment5 = unsafeCursor.getSegment$okio();
                        j4 = j3;
                        j3 = 0;
                        segment4 = segment2;
                    } else {
                        segment4 = unsafeCursor.getSegment$okio();
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
                if (unsafeCursor.readWrite) {
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
                unsafeCursor.setSegment$okio(segment8);
                unsafeCursor.offset = j;
                Intrinsics.a(segment8);
                unsafeCursor.data = segment8.data;
                unsafeCursor.start = segment8.pos + ((int) (j - j2));
                unsafeCursor.end = segment8.limit;
                return unsafeCursor.end - unsafeCursor.start;
            }
        }
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final int commonSelect(Buffer buffer, Options options) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(options, "options");
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(Buffer buffer, long j) {
        Intrinsics.e(buffer, "<this>");
        while (j > 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = min;
            buffer.setSize$okio(buffer.size() - j2);
            long j3 = j - j2;
            segment.pos += min;
            j = j3;
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
                j = j3;
            }
        }
    }

    public static final ByteString commonSnapshot(Buffer buffer) {
        Intrinsics.e(buffer, "<this>");
        if (buffer.size() <= 2147483647L) {
            return buffer.snapshot((int) buffer.size());
        }
        throw new IllegalStateException(Intrinsics.a("size > Int.MAX_VALUE: ", (Object) Long.valueOf(buffer.size())).toString());
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [byte[], byte[][]] */
    public static final ByteString commonSnapshot(Buffer buffer, int i) {
        Intrinsics.e(buffer, "<this>");
        if (i == 0) {
            return ByteString.EMPTY;
        }
        _UtilKt.checkOffsetAndCount(buffer.size(), 0L, i);
        Segment segment = buffer.head;
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
        Segment segment2 = buffer.head;
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

    /* JADX WARN: Code restructure failed: missing block: B:40:0x005d, code lost:
        if (r0.owner == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final okio.Segment commonWritableSegment(okio.Buffer r4, int r5) {
        /*
            r0 = r4
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = 1
            r6 = r0
            r0 = r5
            r1 = 1
            if (r0 < r1) goto L17
            r0 = r5
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r0 > r1) goto L17
            goto L19
        L17:
            r0 = 0
            r6 = r0
        L19:
            r0 = r6
            if (r0 == 0) goto L6a
            r0 = r4
            okio.Segment r0 = r0.head
            if (r0 != 0) goto L39
            okio.Segment r0 = okio.SegmentPool.take()
            r7 = r0
            r0 = r4
            r1 = r7
            r0.head = r1
            r0 = r7
            r1 = r7
            r0.prev = r1
            r0 = r7
            r1 = r7
            r0.next = r1
            r0 = r7
            return r0
        L39:
            r0 = r4
            okio.Segment r0 = r0.head
            r4 = r0
            r0 = r4
            kotlin.jvm.internal.Intrinsics.a(r0)
            r0 = r4
            okio.Segment r0 = r0.prev
            r7 = r0
            r0 = r7
            kotlin.jvm.internal.Intrinsics.a(r0)
            r0 = r7
            int r0 = r0.limit
            r1 = r5
            int r0 = r0 + r1
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r0 > r1) goto L60
            r0 = r7
            r4 = r0
            r0 = r7
            boolean r0 = r0.owner
            if (r0 != 0) goto L68
        L60:
            r0 = r7
            okio.Segment r1 = okio.SegmentPool.take()
            okio.Segment r0 = r0.push(r1)
            r4 = r0
        L68:
            r0 = r4
            return r0
        L6a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "unexpected capacity"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.commonWritableSegment(okio.Buffer, int):okio.Segment");
    }

    public static final Buffer commonWrite(Buffer buffer, ByteString byteString, int i, int i2) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static final Buffer commonWrite(Buffer buffer, Source source, long j) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(source, "source");
        while (j > 0) {
            long read = source.read(buffer, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return buffer;
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] source) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(source, "source");
        return buffer.write(source, 0, source.length);
    }

    public static final Buffer commonWrite(Buffer buffer, byte[] source, int i, int i2) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(source, "source");
        long j = i2;
        _UtilKt.checkOffsetAndCount(source.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            byte[] bArr = writableSegment$okio.data;
            int i4 = writableSegment$okio.limit;
            int i5 = i + min;
            ArraysKt.a(source, bArr, i4, i, i5);
            writableSegment$okio.limit += min;
            i = i5;
        }
        buffer.setSize$okio(buffer.size() + j);
        return buffer;
    }

    public static final void commonWrite(Buffer buffer, Buffer source, long j) {
        Segment segment;
        Segment segment2;
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(source, "source");
        if (!(source != buffer)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        _UtilKt.checkOffsetAndCount(source.size(), 0L, j);
        while (j > 0) {
            Segment segment3 = source.head;
            Intrinsics.a(segment3);
            int i = segment3.limit;
            Intrinsics.a(source.head);
            if (j < i - segment.pos) {
                if (buffer.head != null) {
                    Segment segment4 = buffer.head;
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
                        buffer.setSize$okio(buffer.size() + j);
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
            if (buffer.head == null) {
                buffer.head = segment7;
                segment7.prev = segment7;
                segment7.next = segment7.prev;
            } else {
                Segment segment8 = buffer.head;
                Intrinsics.a(segment8);
                Segment segment9 = segment8.prev;
                Intrinsics.a(segment9);
                segment9.push(segment7).compact();
            }
            source.setSize$okio(source.size() - j2);
            buffer.setSize$okio(buffer.size() + j2);
            j -= j2;
        }
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer buffer, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.size();
        }
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static final long commonWriteAll(Buffer buffer, Source source) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(source, "source");
        long j = 0;
        while (true) {
            long j2 = j;
            long read = source.read(buffer, 8192L);
            if (read == -1) {
                return j2;
            }
            j = j2 + read;
        }
    }

    public static final Buffer commonWriteByte(Buffer buffer, int i) {
        Intrinsics.e(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    public static final Buffer commonWriteDecimalLong(Buffer buffer, long j) {
        Intrinsics.e(buffer, "<this>");
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            return buffer.writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        long j2 = j;
        if (i < 0) {
            j2 = -j;
            if (j2 < 0) {
                return buffer.writeUtf8("-9223372036854775808");
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
        Segment writableSegment$okio = buffer.writableSegment$okio(i3);
        byte[] bArr = writableSegment$okio.data;
        int i4 = writableSegment$okio.limit + i3;
        while (j2 != 0) {
            long j3 = 10;
            i4--;
            bArr[i4] = getHEX_DIGIT_BYTES()[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z) {
            bArr[i4 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i3;
        buffer.setSize$okio(buffer.size() + i3);
        return buffer;
    }

    public static final Buffer commonWriteHexadecimalUnsignedLong(Buffer buffer, long j) {
        Intrinsics.e(buffer, "<this>");
        if (j == 0) {
            return buffer.writeByte(48);
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
        Segment writableSegment$okio = buffer.writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (writableSegment$okio.limit + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        buffer.setSize$okio(buffer.size() + i);
        return buffer;
    }

    public static final Buffer commonWriteInt(Buffer buffer, int i) {
        Intrinsics.e(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
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
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    public static final Buffer commonWriteLong(Buffer buffer, long j) {
        Intrinsics.e(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
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
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    public static final Buffer commonWriteShort(Buffer buffer, int i) {
        Intrinsics.e(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment$okio.limit = i3 + 1;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    public static final Buffer commonWriteUtf8(Buffer buffer, String string, int i, int i2) {
        char charAt;
        Intrinsics.e(buffer, "<this>");
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
                    Segment writableSegment$okio = buffer.writableSegment$okio(1);
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
                    buffer.setSize$okio(buffer.size() + i5);
                } else {
                    if (charAt2 < 2048) {
                        Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                        writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((charAt2 >> 6) | 192);
                        writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) ((charAt2 & '?') | 128);
                        writableSegment$okio2.limit += 2;
                        buffer.setSize$okio(buffer.size() + 2);
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        Segment writableSegment$okio3 = buffer.writableSegment$okio(3);
                        writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((charAt2 >> '\f') | 224);
                        writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                        writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) ((charAt2 & '?') | 128);
                        writableSegment$okio3.limit += 3;
                        buffer.setSize$okio(buffer.size() + 3);
                    } else {
                        int i6 = i + 1;
                        char charAt3 = i6 < i2 ? string.charAt(i6) : (char) 0;
                        if (charAt2 <= 56319) {
                            if (56320 <= charAt3 && charAt3 <= 57343) {
                                int i7 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                                Segment writableSegment$okio4 = buffer.writableSegment$okio(4);
                                writableSegment$okio4.data[writableSegment$okio4.limit] = (byte) ((i7 >> 18) | 240);
                                writableSegment$okio4.data[writableSegment$okio4.limit + 1] = (byte) (((i7 >> 12) & 63) | 128);
                                writableSegment$okio4.data[writableSegment$okio4.limit + 2] = (byte) (((i7 >> 6) & 63) | 128);
                                writableSegment$okio4.data[writableSegment$okio4.limit + 3] = (byte) ((i7 & 63) | 128);
                                writableSegment$okio4.limit += 4;
                                buffer.setSize$okio(buffer.size() + 4);
                                i += 2;
                            }
                        }
                        buffer.writeByte(63);
                        i = i6;
                    }
                    i++;
                }
            }
            return buffer;
        }
        throw new IllegalArgumentException(Intrinsics.a("beginIndex < 0: ", (Object) Integer.valueOf(i)).toString());
    }

    public static final Buffer commonWriteUtf8CodePoint(Buffer buffer, int i) {
        Intrinsics.e(buffer, "<this>");
        if (i < 128) {
            buffer.writeByte(i);
            return buffer;
        } else if (i < 2048) {
            Segment writableSegment$okio = buffer.writableSegment$okio(2);
            writableSegment$okio.data[writableSegment$okio.limit] = (byte) ((i >> 6) | 192);
            writableSegment$okio.data[writableSegment$okio.limit + 1] = (byte) ((i & 63) | 128);
            writableSegment$okio.limit += 2;
            buffer.setSize$okio(buffer.size() + 2);
            return buffer;
        } else {
            boolean z = false;
            if (55296 <= i) {
                z = false;
                if (i <= 57343) {
                    z = true;
                }
            }
            if (z) {
                buffer.writeByte(63);
                return buffer;
            } else if (i < 65536) {
                Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
                writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((i >> 12) | 224);
                writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) (((i >> 6) & 63) | 128);
                writableSegment$okio2.data[writableSegment$okio2.limit + 2] = (byte) ((i & 63) | 128);
                writableSegment$okio2.limit += 3;
                buffer.setSize$okio(buffer.size() + 3);
                return buffer;
            } else if (i <= 1114111) {
                Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
                writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((i >> 18) | 240);
                writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) (((i >> 12) & 63) | 128);
                writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) (((i >> 6) & 63) | 128);
                writableSegment$okio3.data[writableSegment$okio3.limit + 3] = (byte) ((i & 63) | 128);
                writableSegment$okio3.limit += 4;
                buffer.setSize$okio(buffer.size() + 4);
                return buffer;
            } else {
                throw new IllegalArgumentException(Intrinsics.a("Unexpected code point: 0x", (Object) _UtilKt.toHexString(i)));
            }
        }
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static /* synthetic */ void getHEX_DIGIT_BYTES$annotations() {
    }

    public static final boolean rangeEquals(Segment segment, int i, byte[] bytes, int i2, int i3) {
        Intrinsics.e(segment, "segment");
        Intrinsics.e(bytes, "bytes");
        int i4 = segment.limit;
        byte[] bArr = segment.data;
        while (i2 < i3) {
            int i5 = i4;
            Segment segment2 = segment;
            int i6 = i;
            if (i == i4) {
                segment2 = segment.next;
                Intrinsics.a(segment2);
                byte[] bArr2 = segment2.data;
                i6 = segment2.pos;
                i5 = segment2.limit;
                bArr = bArr2;
            }
            if (bArr[i6] != bytes[i2]) {
                return false;
            }
            i = i6 + 1;
            i2++;
            i4 = i5;
            segment = segment2;
        }
        return true;
    }

    public static final String readUtf8Line(Buffer buffer, long j) {
        Intrinsics.e(buffer, "<this>");
        if (j > 0) {
            long j2 = j - 1;
            if (buffer.getByte(j2) == ((byte) 13)) {
                String readUtf8 = buffer.readUtf8(j2);
                buffer.skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j);
        buffer.skip(1L);
        return readUtf82;
    }

    public static final <T> T seek(Buffer buffer, long j, Function2<? super Segment, ? super Long, ? extends T> lambda) {
        Intrinsics.e(buffer, "<this>");
        Intrinsics.e(lambda, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return lambda.invoke(null, -1L);
        }
        if (buffer.size() - j < j) {
            long size = buffer.size();
            while (true) {
                long j2 = size;
                if (j2 <= j) {
                    return lambda.invoke(segment, Long.valueOf(j2));
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
                    return lambda.invoke(segment, Long.valueOf(j4));
                }
                segment = segment.next;
                Intrinsics.a(segment);
                j3 = j5;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x00e1, code lost:
        if (r7 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00e4, code lost:
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00e9, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int selectPrefix(okio.Buffer r5, okio.Options r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.selectPrefix(okio.Buffer, okio.Options, boolean):int");
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }
}
