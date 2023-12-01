package com.google.common.hash;

import android.widget.ExpandableListView;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
@Immutable
/* loaded from: source-8110460-dex2jar.jar:com/google/common/hash/Murmur3_32HashFunction.class */
public final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    private static final long serialVersionUID = 0;
    private final int seed;
    static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.GOOD_FAST_HASH_SEED);

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/hash/Murmur3_32HashFunction$Murmur3_32Hasher.class */
    static final class Murmur3_32Hasher extends AbstractHasher {
        private long buffer;
        private int h1;
        private int shift;
        private int length = 0;
        private boolean isDone = false;

        Murmur3_32Hasher(int i) {
            this.h1 = i;
        }

        private void update(int i, long j) {
            long j2 = this.buffer;
            int i2 = this.shift;
            long j3 = ((j & ExpandableListView.PACKED_POSITION_VALUE_NULL) << i2) | j2;
            this.buffer = j3;
            int i3 = i2 + (i * 8);
            this.shift = i3;
            this.length += i;
            if (i3 >= 32) {
                this.h1 = Murmur3_32HashFunction.mixH1(this.h1, Murmur3_32HashFunction.mixK1((int) j3));
                this.buffer >>>= 32;
                this.shift -= 32;
            }
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            Preconditions.checkState(!this.isDone);
            this.isDone = true;
            int mixK1 = this.h1 ^ Murmur3_32HashFunction.mixK1((int) this.buffer);
            this.h1 = mixK1;
            return Murmur3_32HashFunction.fmix(mixK1, this.length);
        }

        @Override // com.google.common.hash.PrimitiveSink
        public Hasher putByte(byte b) {
            update(1, b & 255);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                putInt(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                putByte(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i5 = 0;
            while (true) {
                i3 = i5;
                int i6 = i3 + 4;
                if (i6 > i2) {
                    break;
                }
                update(4, Murmur3_32HashFunction.getIntLittleEndian(bArr, i3 + i));
                i5 = i6;
            }
            for (i4 = i3; i4 < i2; i4++) {
                putByte(bArr[i + i4]);
            }
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putChar(char c2) {
            update(2, c2);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putInt(int i) {
            update(4, i);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putLong(long j) {
            update(4, (int) j);
            update(4, j >>> 32);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putString(CharSequence charSequence, Charset charset) {
            int i;
            if (Charsets.UTF_8.equals(charset)) {
                int length = charSequence.length();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    int i4 = i3 + 4;
                    i = i3;
                    if (i4 > length) {
                        break;
                    }
                    char charAt = charSequence.charAt(i3);
                    char charAt2 = charSequence.charAt(i3 + 1);
                    char charAt3 = charSequence.charAt(i3 + 2);
                    char charAt4 = charSequence.charAt(i3 + 3);
                    i = i3;
                    if (charAt >= 128) {
                        break;
                    }
                    i = i3;
                    if (charAt2 >= 128) {
                        break;
                    }
                    i = i3;
                    if (charAt3 >= 128) {
                        break;
                    }
                    i = i3;
                    if (charAt4 >= 128) {
                        break;
                    }
                    update(4, (charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24));
                    i2 = i4;
                }
                while (i < length) {
                    char charAt5 = charSequence.charAt(i);
                    if (charAt5 < 128) {
                        update(1, charAt5);
                    } else if (charAt5 < 2048) {
                        update(2, Murmur3_32HashFunction.charToTwoUtf8Bytes(charAt5));
                    } else if (charAt5 < 55296 || charAt5 > 57343) {
                        update(3, Murmur3_32HashFunction.charToThreeUtf8Bytes(charAt5));
                    } else {
                        int codePointAt = Character.codePointAt(charSequence, i);
                        if (codePointAt == charAt5) {
                            putBytes(charSequence.subSequence(i, length).toString().getBytes(charset));
                            return this;
                        }
                        i++;
                        update(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(codePointAt));
                    }
                    i++;
                }
                return this;
            }
            return super.putString(charSequence, charset);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Murmur3_32HashFunction(int i) {
        this.seed = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToThreeUtf8Bytes(char c2) {
        return (((c2 & '?') | 128) << 16) | (((c2 >>> '\f') | 480) & 255) | ((((c2 >>> 6) & 63) | 128) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToTwoUtf8Bytes(char c2) {
        return (((c2 & '?') | 128) << 8) | (((c2 >>> 6) | 960) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long codePointToFourUtf8Bytes(int i) {
        return (((i >>> 18) | 240) & 255) | ((((i >>> 12) & 63) | 128) << 8) | ((((i >>> 6) & 63) | 128) << 16) | (((i & 63) | 128) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashCode fmix(int i, int i2) {
        int i3 = i ^ i2;
        int i4 = (i3 ^ (i3 >>> 16)) * (-2048144789);
        int i5 = (i4 ^ (i4 >>> 13)) * (-1028477387);
        return HashCode.fromInt(i5 ^ (i5 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getIntLittleEndian(byte[] bArr, int i) {
        return Ints.fromBytes(bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixH1(int i, int i2) {
        return (Integer.rotateLeft(i ^ i2, 13) * 5) - 430675100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixK1(int i) {
        return Integer.rotateLeft(i * C1, 15) * C2;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 32;
    }

    public boolean equals(@NullableDecl Object obj) {
        boolean z = false;
        if (obj instanceof Murmur3_32HashFunction) {
            z = false;
            if (this.seed == ((Murmur3_32HashFunction) obj).seed) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        int i3;
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        int i4 = this.seed;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i3 = i6;
            int i7 = i3 + 4;
            if (i7 > i2) {
                break;
            }
            i4 = mixH1(i4, mixK1(getIntLittleEndian(bArr, i3 + i)));
            i6 = i7;
        }
        int i8 = i3;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i8 >= i2) {
                return fmix(mixK1(i5) ^ i4, i2);
            }
            i5 ^= UnsignedBytes.toInt(bArr[i + i8]) << i10;
            i8++;
            i9 = i10 + 8;
        }
    }

    public int hashCode() {
        return getClass().hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashInt(int i) {
        return fmix(mixH1(this.seed, mixK1(i)), 4);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashLong(long j) {
        int i = (int) (j >>> 32);
        return fmix(mixH1(mixH1(this.seed, mixK1((int) j)), mixK1(i)), 8);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        long charToThreeUtf8Bytes;
        int i;
        if (!Charsets.UTF_8.equals(charset)) {
            return hashBytes(charSequence.toString().getBytes(charset));
        }
        int length = charSequence.length();
        int i2 = this.seed;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i4 + 4;
            if (i6 > length) {
                break;
            }
            char charAt = charSequence.charAt(i4);
            char charAt2 = charSequence.charAt(i4 + 1);
            char charAt3 = charSequence.charAt(i4 + 2);
            char charAt4 = charSequence.charAt(i4 + 3);
            if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                break;
            }
            i2 = mixH1(i2, mixK1((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
            i5 += 4;
            i4 = i6;
        }
        long j = 0;
        int i7 = i2;
        while (true) {
            int i8 = i7;
            if (i4 >= length) {
                return fmix(mixK1((int) j) ^ i8, i5);
            }
            char charAt5 = charSequence.charAt(i4);
            if (charAt5 < 128) {
                charToThreeUtf8Bytes = j | (charAt5 << i3);
                i = i3 + 8;
                i5++;
            } else if (charAt5 < 2048) {
                charToThreeUtf8Bytes = j | (charToTwoUtf8Bytes(charAt5) << i3);
                i = i3 + 16;
                i5 += 2;
            } else if (charAt5 < 55296 || charAt5 > 57343) {
                charToThreeUtf8Bytes = j | (charToThreeUtf8Bytes(charAt5) << i3);
                i = i3 + 24;
                i5 += 3;
            } else {
                int codePointAt = Character.codePointAt(charSequence, i4);
                if (codePointAt == charAt5) {
                    return hashBytes(charSequence.toString().getBytes(charset));
                }
                i4++;
                charToThreeUtf8Bytes = j | (codePointToFourUtf8Bytes(codePointAt) << i3);
                i5 += 4;
                i = i3;
            }
            int i9 = i8;
            i3 = i;
            j = charToThreeUtf8Bytes;
            if (i >= 32) {
                i9 = mixH1(i8, mixK1((int) charToThreeUtf8Bytes));
                j = charToThreeUtf8Bytes >>> 32;
                i3 = i - 32;
            }
            i4++;
            i7 = i9;
        }
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i = this.seed;
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 >= charSequence.length()) {
                break;
            }
            i = mixH1(i, mixK1(charSequence.charAt(i3 - 1) | (charSequence.charAt(i3) << 16)));
            i2 = i3 + 2;
        }
        int i4 = i;
        if ((charSequence.length() & 1) == 1) {
            i4 = i ^ mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(i4, charSequence.length() * 2);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + ")";
    }
}
