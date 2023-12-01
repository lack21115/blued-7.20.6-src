package org.apache.harmony.security.asn1;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/BitString.class */
public final class BitString {
    public final byte[] bytes;
    public final int unusedBits;
    private static final byte[] SET_MASK = {Byte.MIN_VALUE, 64, 32, 16, 8, 4, 2, 1};
    private static final byte[] RESET_MASK = {Byte.MAX_VALUE, -65, -33, -17, -9, -5, -3, -2};

    public BitString(byte[] bArr, int i) {
        if (i < 0 || i > 7) {
            throw new IllegalArgumentException("Number of unused bits MUST be in range 0-7");
        }
        if (bArr.length == 0 && i != 0) {
            throw new IllegalArgumentException("For empty bit string unused bits MUST be 0");
        }
        this.bytes = bArr;
        this.unusedBits = i;
    }

    public BitString(boolean[] zArr) {
        this.unusedBits = zArr.length % 8;
        int length = zArr.length / 8;
        this.bytes = new byte[this.unusedBits != 0 ? length + 1 : length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= zArr.length) {
                return;
            }
            setBit(i2, zArr[i2]);
            i = i2 + 1;
        }
    }

    public boolean getBit(int i) {
        return (this.bytes[i / 8] & SET_MASK[i % 8]) != 0;
    }

    public void setBit(int i, boolean z) {
        int i2 = i % 8;
        int i3 = i / 8;
        if (z) {
            byte[] bArr = this.bytes;
            bArr[i3] = (byte) (bArr[i3] | SET_MASK[i2]);
            return;
        }
        byte[] bArr2 = this.bytes;
        bArr2[i3] = (byte) (bArr2[i3] & RESET_MASK[i2]);
    }

    public boolean[] toBooleanArray() {
        boolean[] zArr = new boolean[(this.bytes.length * 8) - this.unusedBits];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= zArr.length) {
                return zArr;
            }
            zArr[i2] = getBit(i2);
            i = i2 + 1;
        }
    }
}
