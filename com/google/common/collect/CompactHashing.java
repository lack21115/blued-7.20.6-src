package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/CompactHashing.class */
final class CompactHashing {
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 256;
    static final int DEFAULT_SIZE = 3;
    static final int HASH_TABLE_BITS_MASK = 31;
    private static final int HASH_TABLE_BITS_MAX_BITS = 5;
    static final int MAX_SIZE = 1073741823;
    private static final int MIN_HASH_TABLE_SIZE = 4;
    static final int MODIFICATION_COUNT_INCREMENT = 32;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 65536;
    static final byte UNSET = 0;

    private CompactHashing() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object createTable(int i) {
        if (i >= 2 && i <= 1073741824 && Integer.highestOneBit(i) == i) {
            return i <= 256 ? new byte[i] : i <= 65536 ? new short[i] : new int[i];
        }
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getHashPrefix(int i, int i2) {
        return i & i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getNext(int i, int i2) {
        return i & i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int maskCombine(int i, int i2, int i3) {
        return (i & i3) | (i2 & i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int newCapacity(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int remove(@NullableDecl Object obj, @NullableDecl Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, @NullableDecl Object[] objArr2) {
        int i2;
        int i3;
        int smearedHash = Hashing.smearedHash(obj);
        int i4 = smearedHash & i;
        int tableGet = tableGet(obj3, i4);
        if (tableGet == 0) {
            return -1;
        }
        int hashPrefix = getHashPrefix(smearedHash, i);
        int i5 = -1;
        while (true) {
            i2 = tableGet - 1;
            i3 = iArr[i2];
            if (getHashPrefix(i3, i) != hashPrefix || !Objects.equal(obj, objArr[i2]) || (objArr2 != null && !Objects.equal(obj2, objArr2[i2]))) {
                int next = getNext(i3, i);
                if (next == 0) {
                    return -1;
                }
                i5 = i2;
                tableGet = next;
            }
        }
        int next2 = getNext(i3, i);
        if (i5 == -1) {
            tableSet(obj3, i4, next2);
            return i2;
        }
        iArr[i5] = maskCombine(iArr[i5], next2, i);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tableClear(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int tableGet(Object obj, int i) {
        return obj instanceof byte[] ? ((byte[]) obj)[i] & 255 : obj instanceof short[] ? ((short[]) obj)[i] & 65535 : ((int[]) obj)[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tableSet(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int tableSize(int i) {
        return Math.max(4, Hashing.closedTableSize(i + 1, 1.0d));
    }
}
