package com.google.common.base;

import com.google.common.base.CharMatcher;
import java.util.BitSet;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/base/SmallCharMatcher.class */
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;
    static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    private SmallCharMatcher(char[] cArr, long j, boolean z, String str) {
        super(str);
        this.table = cArr;
        this.filter = j;
        this.containsZero = z;
    }

    private boolean checkFilter(int i) {
        return 1 == ((this.filter >> i) & 1);
    }

    static int chooseTableSize(int i) {
        if (i == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(i - 1);
        while (true) {
            int i2 = highestOneBit << 1;
            if (i2 * DESIRED_LOAD_FACTOR >= i) {
                return i2;
            }
            highestOneBit = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CharMatcher from(BitSet bitSet, String str) {
        int i;
        int cardinality = bitSet.cardinality();
        boolean z = bitSet.get(0);
        int chooseTableSize = chooseTableSize(cardinality);
        char[] cArr = new char[chooseTableSize];
        int nextSetBit = bitSet.nextSetBit(0);
        long j = 0;
        while (true) {
            long j2 = j;
            int i2 = nextSetBit;
            if (i2 == -1) {
                return new SmallCharMatcher(cArr, j2, z, str);
            }
            int smear = smear(i2);
            while (true) {
                i = smear & (chooseTableSize - 1);
                if (cArr[i] == 0) {
                    break;
                }
                smear = i + 1;
            }
            cArr[i] = (char) i2;
            nextSetBit = bitSet.nextSetBit(i2 + 1);
            j = (1 << i2) | j2;
        }
    }

    static int smear(int i) {
        return Integer.rotateLeft(i * C1, 15) * C2;
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char c2) {
        int i;
        if (c2 == 0) {
            return this.containsZero;
        }
        if (checkFilter(c2)) {
            int length = this.table.length - 1;
            int smear = smear(c2) & length;
            int i2 = smear;
            do {
                char[] cArr = this.table;
                if (cArr[i2] == 0) {
                    return false;
                }
                if (cArr[i2] == c2) {
                    return true;
                }
                i = (i2 + 1) & length;
                i2 = i;
            } while (i != smear);
            return false;
        }
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    void setBits(BitSet bitSet) {
        char[] cArr;
        if (this.containsZero) {
            bitSet.set(0);
        }
        for (char c2 : this.table) {
            if (c2 != 0) {
                bitSet.set(c2);
            }
        }
    }
}
