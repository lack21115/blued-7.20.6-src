package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._SegmentedByteStringKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/SegmentedByteString.class */
public final class SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(byte[][] segments, int[] directory) {
        super(ByteString.EMPTY.getData$okio());
        Intrinsics.e(segments, "segments");
        Intrinsics.e(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        return toByteString();
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.c(asReadOnlyBuffer, "wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public void copyInto(int i, byte[] target, int i2, int i3) {
        Intrinsics.e(target, "target");
        long j = i3;
        _UtilKt.checkOffsetAndCount(size(), i, j);
        _UtilKt.checkOffsetAndCount(target.length, i2, j);
        int i4 = i3 + i;
        int i5 = i2;
        int i6 = i;
        int segment = _SegmentedByteStringKt.segment(this, i);
        while (true) {
            int i7 = segment;
            if (i6 >= i4) {
                return;
            }
            int i8 = i7 == 0 ? 0 : getDirectory$okio()[i7 - 1];
            int i9 = getDirectory$okio()[i7];
            int i10 = getDirectory$okio()[getSegments$okio().length + i7];
            int min = Math.min(i4, (i9 - i8) + i8) - i6;
            int i11 = i10 + (i6 - i8);
            ArraysKt.a(getSegments$okio()[i7], target, i5, i11, i11 + min);
            i5 += min;
            i6 += min;
            segment = i7 + 1;
        }
    }

    @Override // okio.ByteString
    public ByteString digest$okio(String algorithm) {
        Intrinsics.e(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                byte[] digestBytes = messageDigest.digest();
                Intrinsics.c(digestBytes, "digestBytes");
                return new ByteString(digestBytes);
            }
            int i4 = getDirectory$okio()[length + i];
            int i5 = getDirectory$okio()[i];
            messageDigest.update(getSegments$okio()[i], i4, i5 - i3);
            i++;
            i2 = i5;
        }
    }

    @Override // okio.ByteString
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

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i >= length) {
                setHashCode$okio(i2);
                return i2;
            }
            int i5 = getDirectory$okio()[length + i];
            int i6 = getDirectory$okio()[i];
            byte[] bArr = getSegments$okio()[i];
            int i7 = i5;
            while (true) {
                int i8 = i7;
                if (i8 < (i6 - i4) + i5) {
                    i2 = (i2 * 31) + bArr[i8];
                    i7 = i8 + 1;
                }
            }
            i++;
            i3 = i6;
        }
    }

    @Override // okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public ByteString hmac$okio(String algorithm, ByteString key) {
        Intrinsics.e(algorithm, "algorithm");
        Intrinsics.e(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments$okio().length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= length) {
                    byte[] doFinal = mac.doFinal();
                    Intrinsics.c(doFinal, "mac.doFinal()");
                    return new ByteString(doFinal);
                }
                int i4 = getDirectory$okio()[length + i];
                int i5 = getDirectory$okio()[i];
                mac.update(getSegments$okio()[i], i4, i5 - i3);
                i++;
                i2 = i5;
            }
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // okio.ByteString
    public int indexOf(byte[] other, int i) {
        Intrinsics.e(other, "other");
        return toByteString().indexOf(other, i);
    }

    @Override // okio.ByteString
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int i) {
        _UtilKt.checkOffsetAndCount(getDirectory$okio()[getSegments$okio().length - 1], i, 1L);
        int segment = _SegmentedByteStringKt.segment(this, i);
        return getSegments$okio()[segment][(i - (segment == 0 ? 0 : getDirectory$okio()[segment - 1])) + getDirectory$okio()[getSegments$okio().length + segment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] other, int i) {
        Intrinsics.e(other, "other");
        return toByteString().lastIndexOf(other, i);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, ByteString other, int i2, int i3) {
        Intrinsics.e(other, "other");
        boolean z = false;
        if (i >= 0) {
            if (i <= size() - i3) {
                int i4 = i3 + i;
                int i5 = i2;
                int i6 = i;
                int segment = _SegmentedByteStringKt.segment(this, i);
                while (true) {
                    int i7 = segment;
                    if (i6 >= i4) {
                        z = true;
                        break;
                    }
                    int i8 = i7 == 0 ? 0 : getDirectory$okio()[i7 - 1];
                    int i9 = getDirectory$okio()[i7];
                    int i10 = getDirectory$okio()[getSegments$okio().length + i7];
                    int min = Math.min(i4, (i9 - i8) + i8) - i6;
                    if (!other.rangeEquals(i5, getSegments$okio()[i7], i10 + (i6 - i8), min)) {
                        return false;
                    }
                    i5 += min;
                    i6 += min;
                    segment = i7 + 1;
                }
            } else {
                return false;
            }
        }
        return z;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, byte[] other, int i2, int i3) {
        Intrinsics.e(other, "other");
        boolean z = false;
        if (i >= 0) {
            z = false;
            if (i <= size() - i3) {
                z = false;
                if (i2 >= 0) {
                    if (i2 <= other.length - i3) {
                        int i4 = i3 + i;
                        int i5 = i2;
                        int i6 = i;
                        int segment = _SegmentedByteStringKt.segment(this, i);
                        while (true) {
                            int i7 = segment;
                            if (i6 >= i4) {
                                z = true;
                                break;
                            }
                            int i8 = i7 == 0 ? 0 : getDirectory$okio()[i7 - 1];
                            int i9 = getDirectory$okio()[i7];
                            int i10 = getDirectory$okio()[getSegments$okio().length + i7];
                            int min = Math.min(i4, (i9 - i8) + i8) - i6;
                            if (!_UtilKt.arrayRangeEquals(getSegments$okio()[i7], i10 + (i6 - i8), other, i5, min)) {
                                return false;
                            }
                            i5 += min;
                            i6 += min;
                            segment = i7 + 1;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        Intrinsics.e(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    public ByteString substring(int i, int i2) {
        SegmentedByteString segmentedByteString = this;
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(segmentedByteString, i2);
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
        }
        if (!(resolveDefaultParameter <= size())) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + size() + ')').toString());
        }
        int i3 = resolveDefaultParameter - i;
        if (!(i3 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i).toString());
        } else if (i == 0 && resolveDefaultParameter == size()) {
            return segmentedByteString;
        } else {
            if (i == resolveDefaultParameter) {
                return ByteString.EMPTY;
            }
            int segment = _SegmentedByteStringKt.segment(this, i);
            int segment2 = _SegmentedByteStringKt.segment(this, resolveDefaultParameter - 1);
            byte[][] bArr = (byte[][]) ArraysKt.a(getSegments$okio(), segment, segment2 + 1);
            byte[][] bArr2 = bArr;
            int[] iArr = new int[bArr2.length * 2];
            if (segment <= segment2) {
                int i4 = segment;
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    iArr[i6] = Math.min(getDirectory$okio()[i4] - i, i3);
                    iArr[i6 + bArr2.length] = getDirectory$okio()[getSegments$okio().length + i4];
                    if (i4 == segment2) {
                        break;
                    }
                    i4++;
                    i5 = i6 + 1;
                }
            }
            int i7 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int length = bArr2.length;
            iArr[length] = iArr[length] + (i - i7);
            return new SegmentedByteString(bArr, iArr);
        }
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory$okio()[length + i];
            int i5 = getDirectory$okio()[i];
            int i6 = i5 - i2;
            ArraysKt.a(getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(OutputStream out) throws IOException {
        Intrinsics.e(out, "out");
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return;
            }
            int i4 = getDirectory$okio()[length + i];
            int i5 = getDirectory$okio()[i];
            out.write(getSegments$okio()[i], i4, i5 - i3);
            i++;
            i2 = i5;
        }
    }

    @Override // okio.ByteString
    public void write$okio(Buffer buffer, int i, int i2) {
        Intrinsics.e(buffer, "buffer");
        int i3 = i + i2;
        int i4 = i;
        int segment = _SegmentedByteStringKt.segment(this, i);
        while (true) {
            int i5 = segment;
            if (i4 >= i3) {
                buffer.setSize$okio(buffer.size() + i2);
                return;
            }
            int i6 = i5 == 0 ? 0 : getDirectory$okio()[i5 - 1];
            int i7 = getDirectory$okio()[i5];
            int i8 = getDirectory$okio()[getSegments$okio().length + i5];
            int min = Math.min(i3, (i7 - i6) + i6) - i4;
            int i9 = i8 + (i4 - i6);
            Segment segment2 = new Segment(getSegments$okio()[i5], i9, i9 + min, true, false);
            if (buffer.head == null) {
                segment2.prev = segment2;
                segment2.next = segment2.prev;
                buffer.head = segment2.next;
            } else {
                Segment segment3 = buffer.head;
                Intrinsics.a(segment3);
                Segment segment4 = segment3.prev;
                Intrinsics.a(segment4);
                segment4.push(segment2);
            }
            i4 += min;
            segment = i5 + 1;
        }
    }
}
