package okio.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio._UtilKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/internal/_SegmentedByteStringKt.class */
public final class _SegmentedByteStringKt {
    public static final int binarySearch(int[] iArr, int i, int i2, int i3) {
        Intrinsics.e(iArr, "<this>");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else if (i6 <= i) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final void commonCopyInto(SegmentedByteString segmentedByteString, int i, byte[] target, int i2, int i3) {
        Intrinsics.e(segmentedByteString, "<this>");
        Intrinsics.e(target, "target");
        long j = i3;
        _UtilKt.checkOffsetAndCount(segmentedByteString.size(), i, j);
        _UtilKt.checkOffsetAndCount(target.length, i2, j);
        int i4 = i3 + i;
        int i5 = i2;
        int i6 = i;
        int segment = segment(segmentedByteString, i);
        while (true) {
            int i7 = segment;
            if (i6 >= i4) {
                return;
            }
            int i8 = i7 == 0 ? 0 : segmentedByteString.getDirectory$okio()[i7 - 1];
            int i9 = segmentedByteString.getDirectory$okio()[i7];
            int i10 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i7];
            int min = Math.min(i4, (i9 - i8) + i8) - i6;
            int i11 = i10 + (i6 - i8);
            ArraysKt.a(segmentedByteString.getSegments$okio()[i7], target, i5, i11, i11 + min);
            i5 += min;
            i6 += min;
            segment = i7 + 1;
        }
    }

    public static final boolean commonEquals(SegmentedByteString segmentedByteString, Object obj) {
        Intrinsics.e(segmentedByteString, "<this>");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size());
        }
        return false;
    }

    public static final int commonGetSize(SegmentedByteString segmentedByteString) {
        Intrinsics.e(segmentedByteString, "<this>");
        return segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(SegmentedByteString segmentedByteString) {
        Intrinsics.e(segmentedByteString, "<this>");
        int hashCode$okio = segmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        while (i < length) {
            int i4 = segmentedByteString.getDirectory$okio()[length + i];
            int i5 = segmentedByteString.getDirectory$okio()[i];
            byte[] bArr = segmentedByteString.getSegments$okio()[i];
            int i6 = i4;
            while (true) {
                int i7 = i6;
                if (i7 < (i5 - i2) + i4) {
                    i3 = (i3 * 31) + bArr[i7];
                    i6 = i7 + 1;
                }
            }
            i++;
            i2 = i5;
        }
        segmentedByteString.setHashCode$okio(i3);
        return i3;
    }

    public static final byte commonInternalGet(SegmentedByteString segmentedByteString, int i) {
        Intrinsics.e(segmentedByteString, "<this>");
        _UtilKt.checkOffsetAndCount(segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1], i, 1L);
        int segment = segment(segmentedByteString, i);
        return segmentedByteString.getSegments$okio()[segment][(i - (segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1])) + segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment]];
    }

    public static final boolean commonRangeEquals(SegmentedByteString segmentedByteString, int i, ByteString other, int i2, int i3) {
        Intrinsics.e(segmentedByteString, "<this>");
        Intrinsics.e(other, "other");
        if (i < 0 || i > segmentedByteString.size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int i5 = i2;
        int i6 = i;
        int segment = segment(segmentedByteString, i);
        while (true) {
            int i7 = segment;
            if (i6 >= i4) {
                return true;
            }
            int i8 = i7 == 0 ? 0 : segmentedByteString.getDirectory$okio()[i7 - 1];
            int i9 = segmentedByteString.getDirectory$okio()[i7];
            int i10 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i7];
            int min = Math.min(i4, (i9 - i8) + i8) - i6;
            if (!other.rangeEquals(i5, segmentedByteString.getSegments$okio()[i7], i10 + (i6 - i8), min)) {
                return false;
            }
            i5 += min;
            i6 += min;
            segment = i7 + 1;
        }
    }

    public static final boolean commonRangeEquals(SegmentedByteString segmentedByteString, int i, byte[] other, int i2, int i3) {
        Intrinsics.e(segmentedByteString, "<this>");
        Intrinsics.e(other, "other");
        if (i < 0 || i > segmentedByteString.size() - i3 || i2 < 0 || i2 > other.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int i5 = i2;
        int i6 = i;
        int segment = segment(segmentedByteString, i);
        while (true) {
            int i7 = segment;
            if (i6 >= i4) {
                return true;
            }
            int i8 = i7 == 0 ? 0 : segmentedByteString.getDirectory$okio()[i7 - 1];
            int i9 = segmentedByteString.getDirectory$okio()[i7];
            int i10 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i7];
            int min = Math.min(i4, (i9 - i8) + i8) - i6;
            if (!_UtilKt.arrayRangeEquals(segmentedByteString.getSegments$okio()[i7], i10 + (i6 - i8), other, i5, min)) {
                return false;
            }
            i5 += min;
            i6 += min;
            segment = i7 + 1;
        }
    }

    public static final ByteString commonSubstring(SegmentedByteString segmentedByteString, int i, int i2) {
        Intrinsics.e(segmentedByteString, "<this>");
        SegmentedByteString segmentedByteString2 = segmentedByteString;
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(segmentedByteString2, i2);
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
        }
        if (!(resolveDefaultParameter <= segmentedByteString.size())) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + segmentedByteString.size() + ')').toString());
        }
        int i3 = resolveDefaultParameter - i;
        if (!(i3 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i).toString());
        } else if (i == 0 && resolveDefaultParameter == segmentedByteString.size()) {
            return segmentedByteString2;
        } else {
            if (i == resolveDefaultParameter) {
                return ByteString.EMPTY;
            }
            int segment = segment(segmentedByteString, i);
            int segment2 = segment(segmentedByteString, resolveDefaultParameter - 1);
            byte[][] bArr = (byte[][]) ArraysKt.a(segmentedByteString.getSegments$okio(), segment, segment2 + 1);
            byte[][] bArr2 = bArr;
            int[] iArr = new int[bArr2.length * 2];
            if (segment <= segment2) {
                int i4 = segment;
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    iArr[i6] = Math.min(segmentedByteString.getDirectory$okio()[i4] - i, i3);
                    iArr[i6 + bArr2.length] = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i4];
                    if (i4 == segment2) {
                        break;
                    }
                    i4++;
                    i5 = i6 + 1;
                }
            }
            int i7 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int length = bArr2.length;
            iArr[length] = iArr[length] + (i - i7);
            return new SegmentedByteString(bArr, iArr);
        }
    }

    public static final byte[] commonToByteArray(SegmentedByteString segmentedByteString) {
        Intrinsics.e(segmentedByteString, "<this>");
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = segmentedByteString.getDirectory$okio()[length + i];
            int i5 = segmentedByteString.getDirectory$okio()[i];
            int i6 = i5 - i2;
            ArraysKt.a(segmentedByteString.getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public static final void commonWrite(SegmentedByteString segmentedByteString, Buffer buffer, int i, int i2) {
        Intrinsics.e(segmentedByteString, "<this>");
        Intrinsics.e(buffer, "buffer");
        int i3 = i + i2;
        int i4 = i;
        int segment = segment(segmentedByteString, i);
        while (true) {
            int i5 = segment;
            if (i4 >= i3) {
                buffer.setSize$okio(buffer.size() + i2);
                return;
            }
            int i6 = i5 == 0 ? 0 : segmentedByteString.getDirectory$okio()[i5 - 1];
            int i7 = segmentedByteString.getDirectory$okio()[i5];
            int i8 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i5];
            int min = Math.min(i3, (i7 - i6) + i6) - i4;
            int i9 = i8 + (i4 - i6);
            Segment segment2 = new Segment(segmentedByteString.getSegments$okio()[i5], i9, i9 + min, true, false);
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

    private static final void forEachSegment(SegmentedByteString segmentedByteString, int i, int i2, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int i3 = i;
        int segment = segment(segmentedByteString, i);
        while (true) {
            int i4 = segment;
            if (i3 >= i2) {
                return;
            }
            int i5 = i4 == 0 ? 0 : segmentedByteString.getDirectory$okio()[i4 - 1];
            int i6 = segmentedByteString.getDirectory$okio()[i4];
            int i7 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i4];
            int min = Math.min(i2, (i6 - i5) + i5) - i3;
            function3.a(segmentedByteString.getSegments$okio()[i4], Integer.valueOf(i7 + (i3 - i5)), Integer.valueOf(min));
            i3 += min;
            segment = i4 + 1;
        }
    }

    public static final void forEachSegment(SegmentedByteString segmentedByteString, Function3<? super byte[], ? super Integer, ? super Integer, Unit> action) {
        Intrinsics.e(segmentedByteString, "<this>");
        Intrinsics.e(action, "action");
        int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return;
            }
            int i4 = segmentedByteString.getDirectory$okio()[length + i];
            int i5 = segmentedByteString.getDirectory$okio()[i];
            action.a(segmentedByteString.getSegments$okio()[i], Integer.valueOf(i4), Integer.valueOf(i5 - i3));
            i++;
            i2 = i5;
        }
    }

    public static final int segment(SegmentedByteString segmentedByteString, int i) {
        Intrinsics.e(segmentedByteString, "<this>");
        int binarySearch = binarySearch(segmentedByteString.getDirectory$okio(), i + 1, 0, segmentedByteString.getSegments$okio().length);
        return binarySearch >= 0 ? binarySearch : binarySearch;
    }
}
