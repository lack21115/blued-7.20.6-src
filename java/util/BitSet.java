package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;

/* loaded from: source-2895416-dex2jar.jar:java/util/BitSet.class */
public class BitSet implements Serializable, Cloneable {
    private static final long ALL_ONES = -1;
    private static final long serialVersionUID = 7997698588986878753L;
    private long[] bits;
    private transient int longCount;

    public BitSet() {
        this(new long[1]);
    }

    public BitSet(int i) {
        if (i < 0) {
            throw new NegativeArraySizeException(Integer.toString(i));
        }
        this.bits = arrayForBits(i);
        this.longCount = 0;
    }

    private BitSet(long[] jArr) {
        this.bits = jArr;
        this.longCount = jArr.length;
        shrinkSize();
    }

    private static long[] arrayForBits(int i) {
        return new long[(i + 63) / 64];
    }

    private void checkIndex(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("index < 0: " + i);
        }
    }

    private void checkRange(int i, int i2) {
        if ((i | i2) < 0 || i2 < i) {
            throw new IndexOutOfBoundsException("fromIndex=" + i + " toIndex=" + i2);
        }
    }

    private void ensureCapacity(int i) {
        if (i <= this.bits.length) {
            return;
        }
        long[] jArr = new long[Math.max(i, this.bits.length * 2)];
        System.arraycopy(this.bits, 0, jArr, 0, this.longCount);
        this.bits = jArr;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.longCount = this.bits.length;
        shrinkSize();
    }

    private void shrinkSize() {
        int i;
        int i2 = this.longCount;
        while (true) {
            i = i2 - 1;
            if (i < 0 || this.bits[i] != 0) {
                break;
            }
            i2 = i;
        }
        this.longCount = i + 1;
    }

    public static BitSet valueOf(ByteBuffer byteBuffer) {
        int i;
        ByteBuffer order = byteBuffer.slice().order(ByteOrder.LITTLE_ENDIAN);
        long[] arrayForBits = arrayForBits(order.remaining() * 8);
        int i2 = 0;
        while (true) {
            i = i2;
            if (order.remaining() < 8) {
                break;
            }
            arrayForBits[i] = order.getLong();
            i2 = i + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (!order.hasRemaining()) {
                return valueOf(arrayForBits);
            }
            arrayForBits[i] = arrayForBits[i] | ((order.get() & 255) << (i4 * 8));
            i3 = i4 + 1;
        }
    }

    public static BitSet valueOf(LongBuffer longBuffer) {
        long[] jArr = new long[longBuffer.remaining()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jArr.length) {
                return valueOf(jArr);
            }
            jArr[i2] = longBuffer.get(longBuffer.position() + i2);
            i = i2 + 1;
        }
    }

    public static BitSet valueOf(byte[] bArr) {
        return valueOf(ByteBuffer.wrap(bArr));
    }

    public static BitSet valueOf(long[] jArr) {
        return new BitSet((long[]) jArr.clone());
    }

    public void and(BitSet bitSet) {
        int min = Math.min(this.longCount, bitSet.longCount);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= min) {
                Arrays.fill(this.bits, min, this.longCount, 0L);
                shrinkSize();
                return;
            }
            long[] jArr = this.bits;
            jArr[i2] = jArr[i2] & bitSet.bits[i2];
            i = i2 + 1;
        }
    }

    public void andNot(BitSet bitSet) {
        int min = Math.min(this.longCount, bitSet.longCount);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= min) {
                shrinkSize();
                return;
            }
            long[] jArr = this.bits;
            jArr[i2] = jArr[i2] & (bitSet.bits[i2] ^ (-1));
            i = i2 + 1;
        }
    }

    public int cardinality() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.longCount) {
                return i;
            }
            i += Long.bitCount(this.bits[i3]);
            i2 = i3 + 1;
        }
    }

    public void clear() {
        Arrays.fill(this.bits, 0, this.longCount, 0L);
        this.longCount = 0;
    }

    public void clear(int i) {
        if (i < 0) {
            checkIndex(i);
        }
        int i2 = i / 64;
        if (i2 >= this.longCount) {
            return;
        }
        long[] jArr = this.bits;
        jArr[i2] = jArr[i2] & ((1 << i) ^ (-1));
        shrinkSize();
    }

    public void clear(int i, int i2) {
        int i3;
        checkRange(i, i2);
        if (i == i2 || this.longCount == 0 || i >= (i3 = this.longCount * 64)) {
            return;
        }
        int i4 = i2;
        if (i2 > i3) {
            i4 = i3;
        }
        int i5 = i / 64;
        int i6 = (i4 - 1) / 64;
        long j = (-1) << i;
        long j2 = (-1) >>> (-i4);
        if (i5 == i6) {
            long[] jArr = this.bits;
            jArr[i5] = jArr[i5] & ((j & j2) ^ (-1));
        } else {
            long[] jArr2 = this.bits;
            int i7 = i5 + 1;
            jArr2[i5] = jArr2[i5] & ((-1) ^ j);
            while (i7 < i6) {
                this.bits[i7] = 0;
                i7++;
            }
            long[] jArr3 = this.bits;
            jArr3[i7] = jArr3[i7] & ((-1) ^ j2);
        }
        shrinkSize();
    }

    public Object clone() {
        try {
            BitSet bitSet = (BitSet) super.clone();
            bitSet.bits = (long[]) this.bits.clone();
            bitSet.shrinkSize();
            return bitSet;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitSet)) {
            return false;
        }
        BitSet bitSet = (BitSet) obj;
        if (this.longCount != bitSet.longCount) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.longCount) {
                return true;
            }
            if (this.bits[i2] != bitSet.bits[i2]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public void flip(int i) {
        if (i < 0) {
            checkIndex(i);
        }
        int i2 = i / 64;
        if (i2 >= this.bits.length) {
            ensureCapacity(i2 + 1);
        }
        long[] jArr = this.bits;
        jArr[i2] = jArr[i2] ^ (1 << i);
        this.longCount = Math.max(this.longCount, i2 + 1);
        shrinkSize();
    }

    public void flip(int i, int i2) {
        checkRange(i, i2);
        if (i == i2) {
            return;
        }
        int i3 = i / 64;
        int i4 = (i2 - 1) / 64;
        if (i4 >= this.bits.length) {
            ensureCapacity(i4 + 1);
        }
        long j = (-1) << i;
        long j2 = (-1) >>> (-i2);
        if (i3 == i4) {
            long[] jArr = this.bits;
            jArr[i3] = jArr[i3] ^ (j & j2);
        } else {
            long[] jArr2 = this.bits;
            int i5 = i3 + 1;
            jArr2[i3] = jArr2[i3] ^ j;
            while (i5 < i4) {
                long[] jArr3 = this.bits;
                jArr3[i5] = jArr3[i5] ^ (-1);
                i5++;
            }
            long[] jArr4 = this.bits;
            jArr4[i5] = jArr4[i5] ^ j2;
        }
        this.longCount = Math.max(this.longCount, i4 + 1);
        shrinkSize();
    }

    public BitSet get(int i, int i2) {
        checkRange(i, i2);
        int i3 = this.longCount * 64;
        if (i >= i3 || i == i2) {
            return new BitSet(0);
        }
        int i4 = i2;
        if (i2 > i3) {
            i4 = i3;
        }
        int i5 = i / 64;
        int i6 = (i4 - 1) / 64;
        long j = (-1) << i;
        long j2 = (-1) >>> (-i4);
        if (i5 == i6) {
            long j3 = (this.bits[i5] & (j & j2)) >>> i;
            return j3 == 0 ? new BitSet(0) : new BitSet(new long[]{j3});
        }
        long[] jArr = new long[(i6 - i5) + 1];
        jArr[0] = this.bits[i5] & j;
        jArr[jArr.length - 1] = this.bits[i6] & j2;
        int i7 = 1;
        while (true) {
            int i8 = i7;
            if (i8 >= i6 - i5) {
                break;
            }
            jArr[i8] = this.bits[i5 + i8];
            i7 = i8 + 1;
        }
        int i9 = i % 64;
        int length = jArr.length;
        if (i9 != 0) {
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= jArr.length) {
                    break;
                }
                jArr[i11] = jArr[i11] >>> i9;
                if (i11 != jArr.length - 1) {
                    jArr[i11] = jArr[i11] | (jArr[i11 + 1] << (-i9));
                }
                if (jArr[i11] != 0) {
                }
                i10 = i11 + 1;
            }
        }
        return new BitSet(jArr);
    }

    public boolean get(int i) {
        if (i < 0) {
            checkIndex(i);
        }
        int i2 = i / 64;
        return i2 < this.longCount && (this.bits[i2] & (1 << i)) != 0;
    }

    public int hashCode() {
        long j = 1234;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.longCount) {
                return (int) ((j >> 32) ^ j);
            }
            j ^= this.bits[i2] * (i2 + 1);
            i = i2 + 1;
        }
    }

    public boolean intersects(BitSet bitSet) {
        long[] jArr = bitSet.bits;
        int min = Math.min(this.longCount, bitSet.longCount);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= min) {
                return false;
            }
            if ((this.bits[i2] & jArr[i2]) != 0) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public boolean isEmpty() {
        return this.longCount == 0;
    }

    public int length() {
        if (this.longCount == 0) {
            return 0;
        }
        return ((this.longCount - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.bits[this.longCount - 1]));
    }

    public int nextClearBit(int i) {
        int i2;
        checkIndex(i);
        int i3 = i / 64;
        if (i3 >= this.longCount) {
            return i;
        }
        long j = (-1) << i;
        int i4 = i3;
        if (((this.bits[i3] ^ (-1)) & j) != 0) {
            return (i3 * 64) + Long.numberOfTrailingZeros((this.bits[i3] ^ (-1)) & j);
        }
        do {
            i2 = i4 + 1;
            if (i2 >= this.longCount) {
                break;
            }
            i4 = i2;
        } while (this.bits[i2] == -1);
        return i2 == this.longCount ? this.longCount * 64 : (i2 * 64) + Long.numberOfTrailingZeros(this.bits[i2] ^ (-1));
    }

    public int nextSetBit(int i) {
        int i2;
        checkIndex(i);
        int i3 = i / 64;
        if (i3 >= this.longCount) {
            return -1;
        }
        long j = (-1) << i;
        int i4 = i3;
        if ((this.bits[i3] & j) != 0) {
            return (i3 * 64) + Long.numberOfTrailingZeros(this.bits[i3] & j);
        }
        do {
            i2 = i4 + 1;
            if (i2 >= this.longCount) {
                break;
            }
            i4 = i2;
        } while (this.bits[i2] == 0);
        if (i2 != this.longCount) {
            return (i2 * 64) + Long.numberOfTrailingZeros(this.bits[i2]);
        }
        return -1;
    }

    public void or(BitSet bitSet) {
        int min = Math.min(this.longCount, bitSet.longCount);
        int max = Math.max(this.longCount, bitSet.longCount);
        ensureCapacity(max);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= min) {
                break;
            }
            long[] jArr = this.bits;
            jArr[i2] = jArr[i2] | bitSet.bits[i2];
            i = i2 + 1;
        }
        if (bitSet.longCount > min) {
            System.arraycopy(bitSet.bits, min, this.bits, min, max - min);
        }
        this.longCount = max;
    }

    public int previousClearBit(int i) {
        int i2;
        if (i != -1) {
            checkIndex(i);
            while (i >= 0) {
                i2 = i;
                if (get(i)) {
                    i--;
                }
            }
            return -1;
        }
        i2 = -1;
        return i2;
    }

    public int previousSetBit(int i) {
        int i2;
        if (i != -1) {
            checkIndex(i);
            while (i >= 0) {
                i2 = i;
                if (!get(i)) {
                    i--;
                }
            }
            return -1;
        }
        i2 = -1;
        return i2;
    }

    public void set(int i) {
        if (i < 0) {
            checkIndex(i);
        }
        int i2 = i / 64;
        if (i2 >= this.bits.length) {
            ensureCapacity(i2 + 1);
        }
        long[] jArr = this.bits;
        jArr[i2] = jArr[i2] | (1 << i);
        this.longCount = Math.max(this.longCount, i2 + 1);
    }

    public void set(int i, int i2) {
        checkRange(i, i2);
        if (i == i2) {
            return;
        }
        int i3 = i / 64;
        int i4 = (i2 - 1) / 64;
        if (i4 >= this.bits.length) {
            ensureCapacity(i4 + 1);
        }
        long j = (-1) << i;
        long j2 = (-1) >>> (-i2);
        if (i3 == i4) {
            long[] jArr = this.bits;
            jArr[i3] = jArr[i3] | (j & j2);
        } else {
            long[] jArr2 = this.bits;
            int i5 = i3 + 1;
            jArr2[i3] = jArr2[i3] | j;
            while (i5 < i4) {
                long[] jArr3 = this.bits;
                jArr3[i5] = jArr3[i5] | (-1);
                i5++;
            }
            long[] jArr4 = this.bits;
            jArr4[i5] = jArr4[i5] | j2;
        }
        this.longCount = Math.max(this.longCount, i4 + 1);
    }

    public void set(int i, int i2, boolean z) {
        if (z) {
            set(i, i2);
        } else {
            clear(i, i2);
        }
    }

    public void set(int i, boolean z) {
        if (z) {
            set(i);
        } else {
            clear(i);
        }
    }

    public int size() {
        return this.bits.length * 64;
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[(length() + 7) / 8];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return bArr;
            }
            int i3 = i2 * 8;
            bArr[i2] = (byte) (this.bits[i3 / 64] >>> i3);
            i = i2 + 1;
        }
    }

    public long[] toLongArray() {
        return Arrays.copyOf(this.bits, this.longCount);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.longCount / 2);
        sb.append('{');
        boolean z = false;
        int i = 0;
        while (i < this.longCount) {
            boolean z2 = z;
            if (this.bits[i] != 0) {
                int i2 = 0;
                while (true) {
                    z2 = z;
                    if (i2 < 64) {
                        boolean z3 = z;
                        if ((this.bits[i] & (1 << i2)) != 0) {
                            if (z) {
                                sb.append(", ");
                            } else {
                                z = true;
                            }
                            sb.append((i * 64) + i2);
                            z3 = z;
                        }
                        i2++;
                        z = z3;
                    }
                }
            }
            i++;
            z = z2;
        }
        sb.append('}');
        return sb.toString();
    }

    public void xor(BitSet bitSet) {
        int min = Math.min(this.longCount, bitSet.longCount);
        int max = Math.max(this.longCount, bitSet.longCount);
        ensureCapacity(max);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= min) {
                break;
            }
            long[] jArr = this.bits;
            jArr[i2] = jArr[i2] ^ bitSet.bits[i2];
            i = i2 + 1;
        }
        if (bitSet.longCount > min) {
            System.arraycopy(bitSet.bits, min, this.bits, min, max - min);
        }
        this.longCount = max;
        shrinkSize();
    }
}
