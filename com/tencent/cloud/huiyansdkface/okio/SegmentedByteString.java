package com.tencent.cloud.huiyansdkface.okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okio/SegmentedByteString.class */
public final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r1v4, types: [byte[], byte[][]] */
    public SegmentedByteString(Buffer buffer, int i) {
        super(null);
        Util.checkOffsetAndCount(buffer.size, 0L, i);
        Segment segment = buffer.head;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            if (segment.limit == segment.pos) {
                throw new AssertionError("s.limit == s.pos");
            }
            i2 += segment.limit - segment.pos;
            i3++;
            segment = segment.next;
        }
        this.segments = new byte[i3];
        this.directory = new int[i3 * 2];
        Segment segment2 = buffer.head;
        int i4 = 0;
        int i5 = 0;
        while (i5 < i) {
            this.segments[i4] = segment2.data;
            int i6 = i5 + (segment2.limit - segment2.pos);
            i5 = i6;
            if (i6 > i) {
                i5 = i;
            }
            int[] iArr = this.directory;
            iArr[i4] = i5;
            iArr[this.segments.length + i4] = segment2.pos;
            segment2.shared = true;
            i4++;
            segment2 = segment2.next;
        }
    }

    private int segment(int i) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch;
    }

    private ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private Object writeReplace() {
        return toByteString();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public String base64() {
        return toByteString().base64();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.size() == size() && rangeEquals(0, byteString, 0, size());
        }
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public byte getByte(int i) {
        Util.checkOffsetAndCount(this.directory[this.segments.length - 1], i, 1L);
        int segment = segment(i);
        int i2 = segment == 0 ? 0 : this.directory[segment - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[segment][(i - i2) + iArr[bArr.length + segment]];
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.segments[i2];
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = i5;
            while (true) {
                int i8 = i7;
                if (i8 < (i6 - i3) + i5) {
                    i4 = (i4 * 31) + bArr[i8];
                    i7 = i8 + 1;
                }
            }
            i2++;
            i3 = i6;
        }
        this.hashCode = i4;
        return i4;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public ByteString hmacSha1(ByteString byteString) {
        return toByteString().hmacSha1(byteString);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public ByteString hmacSha256(ByteString byteString) {
        return toByteString().hmacSha256(byteString);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public int indexOf(byte[] bArr, int i) {
        return toByteString().indexOf(bArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public byte[] internalArray() {
        return toByteArray();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public int lastIndexOf(byte[] bArr, int i) {
        return toByteString().lastIndexOf(bArr, i);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public ByteString md5() {
        return toByteString().md5();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int i4 = i;
        int segment = segment(i);
        while (true) {
            int i5 = segment;
            if (i3 <= 0) {
                return true;
            }
            int i6 = i5 == 0 ? 0 : this.directory[i5 - 1];
            int min = Math.min(i3, ((this.directory[i5] - i6) + i6) - i4);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i2, bArr[i5], (i4 - i6) + iArr[bArr.length + i5], min)) {
                return false;
            }
            i4 += min;
            i2 += min;
            i3 -= min;
            segment = i5 + 1;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i;
        int segment = segment(i);
        while (true) {
            int i5 = segment;
            if (i3 <= 0) {
                return true;
            }
            int i6 = i5 == 0 ? 0 : this.directory[i5 - 1];
            int min = Math.min(i3, ((this.directory[i5] - i6) + i6) - i4);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!Util.arrayRangeEquals(bArr2[i5], (i4 - i6) + iArr[bArr2.length + i5], bArr, i2, min)) {
                return false;
            }
            i4 += min;
            i2 += min;
            i3 -= min;
            segment = i5 + 1;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public ByteString sha1() {
        return toByteString().sha1();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public ByteString sha256() {
        return toByteString().sha256();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public String string(Charset charset) {
        return toByteString().string(charset);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public ByteString substring(int i) {
        return toByteString().substring(i);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public ByteString substring(int i, int i2) {
        return toByteString().substring(i, i2);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return bArr2;
            }
            int[] iArr2 = this.directory;
            int i4 = iArr2[length + i];
            int i5 = iArr2[i];
            System.arraycopy(this.segments[i], i4, bArr2, i3, i5 - i3);
            i++;
            i2 = i5;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public String utf8() {
        return toByteString().utf8();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public void write(Buffer buffer) {
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                buffer.size += i3;
                return;
            }
            int[] iArr = this.directory;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            Segment segment = new Segment(this.segments[i], i4, (i4 + i5) - i3, true, false);
            if (buffer.head == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                buffer.head.prev.push(segment);
            }
            i++;
            i2 = i5;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return;
            }
            int[] iArr = this.directory;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            outputStream.write(this.segments[i], i4, i5 - i3);
            i++;
            i2 = i5;
        }
    }
}
