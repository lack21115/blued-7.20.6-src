package java.math;

import com.blued.das.live.LiveProtos;
import com.huawei.hms.framework.common.ExceptionCode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/math/Multiplication.class */
public class Multiplication {
    static final int[] tenPows = {1, 10, 100, 1000, 10000, 100000, 1000000, ExceptionCode.CRASH_EXCEPTION, 100000000, 1000000000};
    static final int[] fivePows = {1, 5, 25, 125, LiveProtos.Event.LIVE_BATTLE_PASS_NOTICE_BASIC_SHOW_VALUE, 3125, 15625, 78125, 390625, 1953125, 9765625, 48828125, 244140625, 1220703125};
    static final BigInteger[] bigTenPows = new BigInteger[32];
    static final BigInteger[] bigFivePows = new BigInteger[32];

    static {
        int i;
        long j = 1;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i > 18) {
                break;
            }
            bigFivePows[i] = BigInteger.valueOf(j);
            bigTenPows[i] = BigInteger.valueOf(j << i);
            j *= 5;
            i2 = i + 1;
        }
        if (i < bigTenPows.length) {
            BigInteger[] bigIntegerArr = bigFivePows;
            BigInteger bigInteger = bigFivePows[i - 1];
            BigInteger bigInteger2 = bigFivePows[1];
            throw new VerifyError("bad dex opcode");
        }
    }

    private Multiplication() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger multiplyByFivePow(BigInteger bigInteger, int i) {
        return i < fivePows.length ? multiplyByPositiveInt(bigInteger, fivePows[i]) : i < bigFivePows.length ? bigInteger.multiply(bigFivePows[i]) : bigInteger.multiply(bigFivePows[1].pow(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger multiplyByPositiveInt(BigInteger bigInteger, int i) {
        BigInt copy = bigInteger.getBigInt().copy();
        copy.multiplyByPositiveInt(i);
        return new BigInteger(copy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger multiplyByTenPow(BigInteger bigInteger, long j) {
        return j < ((long) tenPows.length) ? multiplyByPositiveInt(bigInteger, tenPows[(int) j]) : bigInteger.multiply(powerOf10(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger powerOf10(long j) {
        int i = (int) j;
        if (j < bigTenPows.length) {
            return bigTenPows[i];
        }
        if (j <= 50) {
            return BigInteger.TEN.pow(i);
        }
        try {
            if (j <= 2147483647L) {
                return bigFivePows[1].pow(i).shiftLeft(i);
            }
            BigInteger pow = bigFivePows[1].pow(Integer.MAX_VALUE);
            BigInteger bigInteger = pow;
            int i2 = (int) (j % 2147483647L);
            for (long j2 = j - 2147483647L; j2 > 2147483647L; j2 -= 2147483647L) {
                bigInteger = bigInteger.multiply(pow);
            }
            BigInteger shiftLeft = bigInteger.multiply(bigFivePows[1].pow(i2)).shiftLeft(Integer.MAX_VALUE);
            long j3 = j;
            while (true) {
                long j4 = j3 - 2147483647L;
                if (j4 <= 2147483647L) {
                    return shiftLeft.shiftLeft(i2);
                }
                shiftLeft = shiftLeft.shiftLeft(Integer.MAX_VALUE);
                j3 = j4;
            }
        } catch (OutOfMemoryError e) {
            throw new ArithmeticException(e.getMessage());
        }
    }
}
