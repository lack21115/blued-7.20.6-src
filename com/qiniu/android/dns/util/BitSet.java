package com.qiniu.android.dns.util;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/util/BitSet.class */
public final class BitSet {
    private int set = 0;

    public boolean allIsSet(int i) {
        return this.set + 1 == (1 << i);
    }

    public BitSet clear() {
        this.set = 0;
        return this;
    }

    public boolean isSet(int i) {
        return ((1 << i) & this.set) != 0;
    }

    public int leadingZeros() {
        int i = 16;
        int i2 = this.set >> 16;
        if (i2 != 0) {
            this.set = i2;
        } else {
            i = 32;
        }
        int i3 = this.set >> 8;
        int i4 = i;
        if (i3 != 0) {
            i4 = i - 8;
            this.set = i3;
        }
        int i5 = this.set >> 4;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 - 4;
            this.set = i5;
        }
        int i7 = this.set >> 2;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 - 2;
            this.set = i7;
        }
        int i9 = this.set;
        return (i9 >> 1) != 0 ? i8 - 2 : i8 - i9;
    }

    public boolean noneIsSet(int i) {
        return this.set == 0;
    }

    public BitSet set(int i) {
        this.set = (1 << i) | this.set;
        return this;
    }

    public int value() {
        return this.set;
    }
}
