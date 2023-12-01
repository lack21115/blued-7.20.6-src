package com.google.common.hash;

import com.google.common.base.Preconditions;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/hash/FarmHashFingerprint64.class */
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    static final HashFunction FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();
    private static final long K0 = -4348849565147123417L;
    private static final long K1 = -5435081209227447693L;
    private static final long K2 = -7286425919675154353L;

    FarmHashFingerprint64() {
    }

    static long fingerprint(byte[] bArr, int i, int i2) {
        return i2 <= 32 ? i2 <= 16 ? hashLength0to16(bArr, i, i2) : hashLength17to32(bArr, i, i2) : i2 <= 64 ? hashLength33To64(bArr, i, i2) : hashLength65Plus(bArr, i, i2);
    }

    private static long hashLength0to16(byte[] bArr, int i, int i2) {
        if (i2 >= 8) {
            long j = (i2 * 2) - 7286425919675154353L;
            long load64 = LittleEndianByteArray.load64(bArr, i) - 7286425919675154353L;
            long load642 = LittleEndianByteArray.load64(bArr, (i + i2) - 8);
            return hashLength16((Long.rotateRight(load642, 37) * j) + load64, (Long.rotateRight(load64, 25) + load642) * j, j);
        } else if (i2 >= 4) {
            return hashLength16(i2 + ((LittleEndianByteArray.load32(bArr, i) & 4294967295L) << 3), LittleEndianByteArray.load32(bArr, (i + i2) - 4) & 4294967295L, (i2 * 2) - 7286425919675154353L);
        } else if (i2 > 0) {
            return shiftMix((((bArr[i] & 255) + ((bArr[(i2 >> 1) + i] & 255) << 8)) * K2) ^ ((i2 + ((bArr[i + (i2 - 1)] & 255) << 2)) * K0)) * K2;
        } else {
            return K2;
        }
    }

    private static long hashLength16(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    private static long hashLength17to32(byte[] bArr, int i, int i2) {
        long j = (i2 * 2) - 7286425919675154353L;
        long load64 = LittleEndianByteArray.load64(bArr, i) * K1;
        long load642 = LittleEndianByteArray.load64(bArr, i + 8);
        int i3 = i + i2;
        long load643 = LittleEndianByteArray.load64(bArr, i3 - 8) * j;
        return hashLength16((LittleEndianByteArray.load64(bArr, i3 - 16) * K2) + Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30), load64 + Long.rotateRight(load642 - 7286425919675154353L, 18) + load643, j);
    }

    private static long hashLength33To64(byte[] bArr, int i, int i2) {
        long j = (i2 * 2) - 7286425919675154353L;
        long load64 = LittleEndianByteArray.load64(bArr, i) * K2;
        long load642 = LittleEndianByteArray.load64(bArr, i + 8);
        int i3 = i + i2;
        long load643 = LittleEndianByteArray.load64(bArr, i3 - 8) * j;
        long rotateRight = Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30) + (LittleEndianByteArray.load64(bArr, i3 - 16) * K2);
        long hashLength16 = hashLength16(rotateRight, load643 + Long.rotateRight(load642 - 7286425919675154353L, 18) + load64, j);
        long load644 = LittleEndianByteArray.load64(bArr, i + 16) * j;
        long load645 = LittleEndianByteArray.load64(bArr, i + 24);
        long load646 = (rotateRight + LittleEndianByteArray.load64(bArr, i3 - 32)) * j;
        return hashLength16(((hashLength16 + LittleEndianByteArray.load64(bArr, i3 - 24)) * j) + Long.rotateRight(load644 + load645, 43) + Long.rotateRight(load646, 30), load644 + Long.rotateRight(load645 + load64, 18) + load646, j);
    }

    private static long hashLength65Plus(byte[] bArr, int i, int i2) {
        long shiftMix = shiftMix(-7956866745689871395L) * K2;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long load64 = 95310865018149119L + LittleEndianByteArray.load64(bArr, i);
        int i3 = i2 - 1;
        int i4 = i + ((i3 / 64) * 64);
        int i5 = i3 & 63;
        int i6 = (i4 + i5) - 63;
        long j = 2480279821605975764L;
        while (true) {
            long rotateRight = Long.rotateRight(load64 + j + jArr[0] + LittleEndianByteArray.load64(bArr, i + 8), 37);
            long rotateRight2 = Long.rotateRight(j + jArr[1] + LittleEndianByteArray.load64(bArr, i + 48), 42);
            long j2 = (rotateRight * K1) ^ jArr2[1];
            long load642 = (rotateRight2 * K1) + jArr[0] + LittleEndianByteArray.load64(bArr, i + 40);
            long rotateRight3 = Long.rotateRight(shiftMix + jArr2[0], 33) * K1;
            weakHashLength32WithSeeds(bArr, i, jArr[1] * K1, j2 + jArr2[0], jArr);
            weakHashLength32WithSeeds(bArr, i + 32, rotateRight3 + jArr2[1], load642 + LittleEndianByteArray.load64(bArr, i + 16), jArr2);
            i += 64;
            if (i == i4) {
                long j3 = ((j2 & 255) << 1) - 5435081209227447693L;
                jArr2[0] = jArr2[0] + i5;
                jArr[0] = jArr[0] + jArr2[0];
                jArr2[0] = jArr2[0] + jArr[0];
                long rotateRight4 = Long.rotateRight(rotateRight3 + load642 + jArr[0] + LittleEndianByteArray.load64(bArr, i6 + 8), 37);
                long rotateRight5 = Long.rotateRight(load642 + jArr[1] + LittleEndianByteArray.load64(bArr, i6 + 48), 42);
                long j4 = (rotateRight4 * j3) ^ (jArr2[1] * 9);
                long load643 = (rotateRight5 * j3) + (jArr[0] * 9) + LittleEndianByteArray.load64(bArr, i6 + 40);
                long rotateRight6 = Long.rotateRight(j2 + jArr2[0], 33) * j3;
                weakHashLength32WithSeeds(bArr, i6, jArr[1] * j3, j4 + jArr2[0], jArr);
                weakHashLength32WithSeeds(bArr, i6 + 32, rotateRight6 + jArr2[1], LittleEndianByteArray.load64(bArr, i6 + 16) + load643, jArr2);
                return hashLength16(hashLength16(jArr[0], jArr2[0], j3) + (shiftMix(load643) * K0) + j4, hashLength16(jArr[1], jArr2[1], j3) + rotateRight6, j3);
            }
            shiftMix = j2;
            j = load642;
            load64 = rotateRight3;
        }
    }

    private static long shiftMix(long j) {
        return j ^ (j >>> 47);
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long load64 = LittleEndianByteArray.load64(bArr, i);
        long load642 = LittleEndianByteArray.load64(bArr, i + 8);
        long load643 = LittleEndianByteArray.load64(bArr, i + 16);
        long load644 = LittleEndianByteArray.load64(bArr, i + 24);
        long j3 = j + load64;
        long rotateRight = Long.rotateRight(j2 + j3 + load644, 21);
        long j4 = load642 + j3 + load643;
        long rotateRight2 = Long.rotateRight(j4, 44);
        jArr[0] = j4 + load644;
        jArr[1] = rotateRight + rotateRight2 + j3;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        return HashCode.fromLong(fingerprint(bArr, i, i2));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
