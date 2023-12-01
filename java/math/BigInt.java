package java.math;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/math/BigInt.class */
public final class BigInt {
    transient long bignum = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInt addition(BigInt bigInt, BigInt bigInt2) {
        BigInt newBigInt = newBigInt();
        NativeBN.BN_add(newBigInt.bignum, bigInt.bignum, bigInt2.bignum);
        return newBigInt;
    }

    static BigInt bigExp(BigInt bigInt, BigInt bigInt2) {
        BigInt newBigInt = newBigInt();
        NativeBN.BN_exp(newBigInt.bignum, bigInt.bignum, bigInt2.bignum);
        return newBigInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int cmp(BigInt bigInt, BigInt bigInt2) {
        return NativeBN.BN_cmp(bigInt.bignum, bigInt2.bignum);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void division(BigInt bigInt, BigInt bigInt2, BigInt bigInt3, BigInt bigInt4) {
        long j;
        long j2;
        if (bigInt3 != null) {
            bigInt3.makeValid();
            j = bigInt3.bignum;
        } else {
            j = 0;
        }
        if (bigInt4 != null) {
            bigInt4.makeValid();
            j2 = bigInt4.bignum;
        } else {
            j2 = 0;
        }
        NativeBN.BN_div(j, j2, bigInt.bignum, bigInt2.bignum);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInt exp(BigInt bigInt, int i) {
        BigInt bigInt2 = new BigInt();
        bigInt2.putLongInt(i);
        return bigExp(bigInt, bigInt2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInt gcd(BigInt bigInt, BigInt bigInt2) {
        BigInt newBigInt = newBigInt();
        NativeBN.BN_gcd(newBigInt.bignum, bigInt.bignum, bigInt2.bignum);
        return newBigInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInt generatePrimeDefault(int i) {
        BigInt newBigInt = newBigInt();
        NativeBN.BN_generate_prime_ex(newBigInt.bignum, i, false, 0L, 0L, 0L);
        return newBigInt;
    }

    private NumberFormatException invalidBigInteger(String str) {
        throw new NumberFormatException("Invalid BigInteger: " + str);
    }

    private void makeValid() {
        if (this.bignum == 0) {
            this.bignum = NativeBN.BN_new();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInt modExp(BigInt bigInt, BigInt bigInt2, BigInt bigInt3) {
        BigInt newBigInt = newBigInt();
        NativeBN.BN_mod_exp(newBigInt.bignum, bigInt.bignum, bigInt2.bignum, bigInt3.bignum);
        return newBigInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInt modInverse(BigInt bigInt, BigInt bigInt2) {
        BigInt newBigInt = newBigInt();
        NativeBN.BN_mod_inverse(newBigInt.bignum, bigInt.bignum, bigInt2.bignum);
        return newBigInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInt modulus(BigInt bigInt, BigInt bigInt2) {
        BigInt newBigInt = newBigInt();
        NativeBN.BN_nnmod(newBigInt.bignum, bigInt.bignum, bigInt2.bignum);
        return newBigInt;
    }

    private static BigInt newBigInt() {
        BigInt bigInt = new BigInt();
        bigInt.bignum = NativeBN.BN_new();
        return bigInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInt product(BigInt bigInt, BigInt bigInt2) {
        BigInt newBigInt = newBigInt();
        NativeBN.BN_mul(newBigInt.bignum, bigInt.bignum, bigInt2.bignum);
        return newBigInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int remainderByPositiveInt(BigInt bigInt, int i) {
        return NativeBN.BN_mod_word(bigInt.bignum, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInt shift(BigInt bigInt, int i) {
        BigInt newBigInt = newBigInt();
        NativeBN.BN_shift(newBigInt.bignum, bigInt.bignum, i);
        return newBigInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInt subtraction(BigInt bigInt, BigInt bigInt2) {
        BigInt newBigInt = newBigInt();
        NativeBN.BN_sub(newBigInt.bignum, bigInt.bignum, bigInt2.bignum);
        return newBigInt;
    }

    private static String toAscii(String str, int i) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return sb.toString();
            }
            char charAt = str.charAt(i3);
            int digit = Character.digit(charAt, i);
            char c2 = charAt;
            if (digit >= 0) {
                c2 = charAt;
                if (digit <= 9) {
                    c2 = (char) (digit + 48);
                }
            }
            sb.append(c2);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(BigInt bigInt) {
        NativeBN.BN_add(this.bignum, this.bignum, bigInt.bignum);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPositiveInt(int i) {
        NativeBN.BN_add_word(this.bignum, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] bigEndianMagnitude() {
        return NativeBN.BN_bn2bin(this.bignum);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bitLength() {
        return NativeBN.bitLength(this.bignum);
    }

    String checkString(String str, int i) {
        if (str == null) {
            throw new NullPointerException("s == null");
        }
        int length = str.length();
        int i2 = length;
        int i3 = 0;
        String str2 = str;
        if (length > 0) {
            char charAt = str.charAt(0);
            if (charAt == '+') {
                str2 = str.substring(1);
                i2 = length - 1;
                i3 = 0;
            } else {
                i2 = length;
                i3 = 0;
                str2 = str;
                if (charAt == '-') {
                    i3 = 0 + 1;
                    i2 = length;
                    str2 = str;
                }
            }
        }
        if (i2 - i3 == 0) {
            throw invalidBigInteger(str2);
        }
        boolean z = false;
        while (i3 < i2) {
            char charAt2 = str2.charAt(i3);
            if (Character.digit(charAt2, i) == -1) {
                throw invalidBigInteger(str2);
            }
            if (charAt2 > 128) {
                z = true;
            }
            i3++;
        }
        String str3 = str2;
        if (z) {
            str3 = toAscii(str2, i);
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInt copy() {
        BigInt bigInt = new BigInt();
        bigInt.putCopy(this);
        return bigInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String decString() {
        return NativeBN.BN_bn2dec(this.bignum);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.bignum != 0) {
                NativeBN.BN_free(this.bignum);
                this.bignum = 0L;
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNativeBIGNUM() {
        return this.bignum;
    }

    String hexString() {
        return NativeBN.BN_bn2hex(this.bignum);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBitSet(int i) {
        return NativeBN.BN_is_bit_set(this.bignum, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPrime(int i) {
        return NativeBN.BN_is_prime_ex(this.bignum, i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] littleEndianIntsMagnitude() {
        return NativeBN.bn2litEndInts(this.bignum);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long longInt() {
        return NativeBN.longInt(this.bignum);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void multiplyByPositiveInt(int i) {
        NativeBN.BN_mul_word(this.bignum, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putBigEndian(byte[] bArr, boolean z) {
        makeValid();
        NativeBN.BN_bin2bn(bArr, bArr.length, z, this.bignum);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putBigEndianTwosComplement(byte[] bArr) {
        makeValid();
        NativeBN.twosComp2bn(bArr, bArr.length, this.bignum);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putCopy(BigInt bigInt) {
        makeValid();
        NativeBN.BN_copy(this.bignum, bigInt.bignum);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putDecString(String str) {
        String checkString = checkString(str, 10);
        makeValid();
        if (NativeBN.BN_dec2bn(this.bignum, checkString) < checkString.length()) {
            throw invalidBigInteger(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putHexString(String str) {
        String checkString = checkString(str, 16);
        makeValid();
        if (NativeBN.BN_hex2bn(this.bignum, checkString) < checkString.length()) {
            throw invalidBigInteger(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putLittleEndianInts(int[] iArr, boolean z) {
        makeValid();
        NativeBN.litEndInts2bn(iArr, iArr.length, z, this.bignum);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putLongInt(long j) {
        makeValid();
        NativeBN.putLongInt(this.bignum, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putULongInt(long j, boolean z) {
        makeValid();
        NativeBN.putULongInt(this.bignum, j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSign(int i) {
        if (i > 0) {
            NativeBN.BN_set_negative(this.bignum, 0);
        } else if (i < 0) {
            NativeBN.BN_set_negative(this.bignum, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void shift(int i) {
        NativeBN.BN_shift(this.bignum, this.bignum, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int sign() {
        return NativeBN.sign(this.bignum);
    }

    public String toString() {
        return decString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean twosCompFitsIntoBytes(int i) {
        return (NativeBN.bitLength(this.bignum) + 7) / 8 <= i;
    }
}
