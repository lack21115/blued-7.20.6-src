package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Timeout;
import okio._UtilKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/internal/_RealBufferedSourceKt.class */
public final class _RealBufferedSourceKt {
    public static final void commonClose(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        if (realBufferedSource.closed) {
            return;
        }
        realBufferedSource.closed = true;
        realBufferedSource.source.close();
        realBufferedSource.bufferField.clear();
    }

    public static final boolean commonExhausted(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        if (!realBufferedSource.closed) {
            return realBufferedSource.bufferField.exhausted() && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(RealBufferedSource realBufferedSource, byte b, long j, long j2) {
        Intrinsics.e(realBufferedSource, "<this>");
        boolean z = true;
        if (!realBufferedSource.closed) {
            if (0 > j || j > j2) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
            }
            while (j < j2) {
                long indexOf = realBufferedSource.bufferField.indexOf(b, j, j2);
                if (indexOf != -1) {
                    return indexOf;
                }
                long size = realBufferedSource.bufferField.size();
                if (size >= j2 || realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                    return -1L;
                }
                j = Math.max(j, size);
            }
            return -1L;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(RealBufferedSource realBufferedSource, ByteString bytes, long j) {
        Intrinsics.e(realBufferedSource, "<this>");
        Intrinsics.e(bytes, "bytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOf = realBufferedSource.bufferField.indexOf(bytes, j);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, (size - bytes.size()) + 1);
        }
    }

    public static final long commonIndexOfElement(RealBufferedSource realBufferedSource, ByteString targetBytes, long j) {
        Intrinsics.e(realBufferedSource, "<this>");
        Intrinsics.e(targetBytes, "targetBytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOfElement = realBufferedSource.bufferField.indexOfElement(targetBytes, j);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, size);
        }
    }

    public static final BufferedSource commonPeek(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        return Okio.buffer(new PeekSource(realBufferedSource));
    }

    public static final boolean commonRangeEquals(RealBufferedSource realBufferedSource, long j, ByteString bytes, int i, int i2) {
        Intrinsics.e(realBufferedSource, "<this>");
        Intrinsics.e(bytes, "bytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j < 0 || i < 0 || i2 < 0 || bytes.size() - i < i2) {
            return false;
        }
        if (i2 <= 0) {
            return true;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            int i5 = i4 + 1;
            long j2 = i4 + j;
            if (!realBufferedSource.request(1 + j2) || realBufferedSource.bufferField.getByte(j2) != bytes.getByte(i4 + i)) {
                return false;
            }
            if (i5 >= i2) {
                return true;
            }
            i3 = i5;
        }
    }

    public static final int commonRead(RealBufferedSource realBufferedSource, byte[] sink, int i, int i2) {
        Intrinsics.e(realBufferedSource, "<this>");
        Intrinsics.e(sink, "sink");
        long j = i2;
        _UtilKt.checkOffsetAndCount(sink.length, i, j);
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
            return -1;
        }
        return realBufferedSource.bufferField.read(sink, i, (int) Math.min(j, realBufferedSource.bufferField.size()));
    }

    public static final long commonRead(RealBufferedSource realBufferedSource, Buffer sink, long j) {
        Intrinsics.e(realBufferedSource, "<this>");
        Intrinsics.e(sink, "sink");
        if (j >= 0) {
            if (true ^ realBufferedSource.closed) {
                if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                    return -1L;
                }
                return realBufferedSource.bufferField.read(sink, Math.min(j, realBufferedSource.bufferField.size()));
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(Intrinsics.a("byteCount < 0: ", (Object) Long.valueOf(j)).toString());
    }

    public static final long commonReadAll(RealBufferedSource realBufferedSource, Sink sink) {
        Intrinsics.e(realBufferedSource, "<this>");
        Intrinsics.e(sink, "sink");
        long j = 0;
        while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) != -1) {
            long completeSegmentByteCount = realBufferedSource.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j += completeSegmentByteCount;
                sink.write(realBufferedSource.bufferField, completeSegmentByteCount);
            }
        }
        long j2 = j;
        if (realBufferedSource.bufferField.size() > 0) {
            j2 = j + realBufferedSource.bufferField.size();
            sink.write(realBufferedSource.bufferField, realBufferedSource.bufferField.size());
        }
        return j2;
    }

    public static final byte commonReadByte(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        return realBufferedSource.bufferField.readByte();
    }

    public static final byte[] commonReadByteArray(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    public static final byte[] commonReadByteArray(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readByteArray(j);
    }

    public static final ByteString commonReadByteString(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    public static final ByteString commonReadByteString(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readByteString(j);
    }

    public static final long commonReadDecimalLong(RealBufferedSource realBufferedSource) {
        byte b;
        int i;
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        long j = 0;
        while (true) {
            long j2 = j;
            long j3 = j2 + 1;
            if (!realBufferedSource.request(j3)) {
                break;
            }
            b = realBufferedSource.bufferField.getByte(j2);
            if ((b < ((byte) 48) || b > ((byte) 57)) && !(j2 == 0 && b == ((byte) 45))) {
                break;
            }
            j = j3;
        }
        if (i == 0) {
            String num = Integer.toString(b, CharsKt.a(CharsKt.a(16)));
            Intrinsics.c(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            throw new NumberFormatException(Intrinsics.a("Expected a digit or '-' but was 0x", (Object) num));
        }
        return realBufferedSource.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(RealBufferedSource realBufferedSource, Buffer sink, long j) {
        Intrinsics.e(realBufferedSource, "<this>");
        Intrinsics.e(sink, "sink");
        try {
            realBufferedSource.require(j);
            realBufferedSource.bufferField.readFully(sink, j);
        } catch (EOFException e) {
            sink.writeAll(realBufferedSource.bufferField);
            throw e;
        }
    }

    public static final void commonReadFully(RealBufferedSource realBufferedSource, byte[] sink) {
        Intrinsics.e(realBufferedSource, "<this>");
        Intrinsics.e(sink, "sink");
        try {
            realBufferedSource.require(sink.length);
            realBufferedSource.bufferField.readFully(sink);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (realBufferedSource.bufferField.size() <= 0) {
                    throw e;
                }
                int read = realBufferedSource.bufferField.read(sink, i2, (int) realBufferedSource.bufferField.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                i = i2 + read;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
        if (r6 == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        r0 = java.lang.Integer.toString(r0, kotlin.text.CharsKt.a(kotlin.text.CharsKt.a(16)));
        kotlin.jvm.internal.Intrinsics.c(r0, "java.lang.Integer.toStri…(this, checkRadix(radix))");
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
        throw new java.lang.NumberFormatException(kotlin.jvm.internal.Intrinsics.a("Expected leading [0-9a-fA-F] character but was 0x", (java.lang.Object) r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadHexadecimalUnsignedLong(okio.RealBufferedSource r5) {
        /*
            r0 = r5
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r5
            r1 = 1
            r0.require(r1)
            r0 = 0
            r6 = r0
        Ld:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            r0 = r5
            r1 = r7
            long r1 = (long) r1
            boolean r0 = r0.request(r1)
            if (r0 == 0) goto L7f
            r0 = r5
            okio.Buffer r0 = r0.bufferField
            r1 = r6
            long r1 = (long) r1
            byte r0 = r0.getByte(r1)
            r8 = r0
            r0 = r8
            r1 = 48
            byte r1 = (byte) r1
            if (r0 < r1) goto L32
            r0 = r8
            r1 = 57
            byte r1 = (byte) r1
            if (r0 <= r1) goto L51
        L32:
            r0 = r8
            r1 = 97
            byte r1 = (byte) r1
            if (r0 < r1) goto L40
            r0 = r8
            r1 = 102(0x66, float:1.43E-43)
            byte r1 = (byte) r1
            if (r0 <= r1) goto L51
        L40:
            r0 = r8
            r1 = 65
            byte r1 = (byte) r1
            if (r0 < r1) goto L56
            r0 = r8
            r1 = 70
            byte r1 = (byte) r1
            if (r0 <= r1) goto L51
            goto L56
        L51:
            r0 = r7
            r6 = r0
            goto Ld
        L56:
            r0 = r6
            if (r0 == 0) goto L5d
            goto L7f
        L5d:
            r0 = r8
            r1 = 16
            int r1 = kotlin.text.CharsKt.a(r1)
            int r1 = kotlin.text.CharsKt.a(r1)
            java.lang.String r0 = java.lang.Integer.toString(r0, r1)
            r5 = r0
            r0 = r5
            java.lang.String r1 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = r0
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r3 = r5
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.a(r2, r3)
            r1.<init>(r2)
            throw r0
        L7f:
            r0 = r5
            okio.Buffer r0 = r0.bufferField
            long r0 = r0.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._RealBufferedSourceKt.commonReadHexadecimalUnsignedLong(okio.RealBufferedSource):long");
    }

    public static final int commonReadInt(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final short commonReadShort(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShortLe();
    }

    public static final String commonReadUtf8(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    public static final String commonReadUtf8(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readUtf8(j);
    }

    public static final int commonReadUtf8CodePoint(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        byte b = realBufferedSource.bufferField.getByte(0L);
        if ((b & 224) == 192) {
            realBufferedSource.require(2L);
        } else if ((b & 240) == 224) {
            realBufferedSource.require(3L);
        } else if ((b & 248) == 240) {
            realBufferedSource.require(4L);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    public static final String commonReadUtf8Line(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        long indexOf = realBufferedSource.indexOf((byte) 10);
        if (indexOf == -1) {
            if (realBufferedSource.bufferField.size() != 0) {
                return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
            }
            return null;
        }
        return _BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
    }

    public static final String commonReadUtf8LineStrict(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.e(realBufferedSource, "<this>");
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            byte b = (byte) 10;
            long indexOf = realBufferedSource.indexOf(b, 0L, j2);
            if (indexOf != -1) {
                return _BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
            }
            if (j2 < Long.MAX_VALUE && realBufferedSource.request(j2) && realBufferedSource.bufferField.getByte(j2 - 1) == ((byte) 13) && realBufferedSource.request(1 + j2) && realBufferedSource.bufferField.getByte(j2) == b) {
                return _BufferKt.readUtf8Line(realBufferedSource.bufferField, j2);
            }
            Buffer buffer = new Buffer();
            realBufferedSource.bufferField.copyTo(buffer, 0L, Math.min(32, realBufferedSource.bufferField.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(realBufferedSource.bufferField.size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
        }
        throw new IllegalArgumentException(Intrinsics.a("limit < 0: ", (Object) Long.valueOf(j)).toString());
    }

    public static final boolean commonRequest(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.e(realBufferedSource, "<this>");
        if (j >= 0) {
            if (!realBufferedSource.closed) {
                while (realBufferedSource.bufferField.size() < j) {
                    if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(Intrinsics.a("byteCount < 0: ", (Object) Long.valueOf(j)).toString());
    }

    public static final void commonRequire(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.e(realBufferedSource, "<this>");
        if (!realBufferedSource.request(j)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(RealBufferedSource realBufferedSource, Options options) {
        Intrinsics.e(realBufferedSource, "<this>");
        Intrinsics.e(options, "options");
        if (!realBufferedSource.closed) {
            do {
                int selectPrefix = _BufferKt.selectPrefix(realBufferedSource.bufferField, options, true);
                if (selectPrefix != -2) {
                    if (selectPrefix != -1) {
                        realBufferedSource.bufferField.skip(options.getByteStrings$okio()[selectPrefix].size());
                        return selectPrefix;
                    }
                    return -1;
                }
            } while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) != -1);
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonSkip(RealBufferedSource realBufferedSource, long j) {
        Intrinsics.e(realBufferedSource, "<this>");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j > 0) {
            if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, realBufferedSource.bufferField.size());
            realBufferedSource.bufferField.skip(min);
            j -= min;
        }
    }

    public static final Timeout commonTimeout(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        return realBufferedSource.source.timeout();
    }

    public static final String commonToString(RealBufferedSource realBufferedSource) {
        Intrinsics.e(realBufferedSource, "<this>");
        return "buffer(" + realBufferedSource.source + ')';
    }
}
